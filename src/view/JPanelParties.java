/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.BatailleNavale;
import model.Game;

/**
 * @todo Nicolas
 * @author nikolai
 */
public class JPanelParties extends JPanel implements Observer {

    public static final String id = "jpanelparties";

    private JList list;

    public JPanelParties(final BatailleNavale model, final JPanelWizard wizard) {
        super(new BorderLayout());
        model.addObserver(this);

        add(new JLabel(id));
        list = new JList(model.getAdf().getInstanceDaoGame().find().toArray());
//        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));
        list.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Game game = (Game) list.getSelectedValue();
                System.out.println("game : " + game);
                int n = JOptionPane.showConfirmDialog(
                        GUI.getInstance(),
                        "Voulez vous charger cette partie ?",
                        "",
                        JOptionPane.YES_NO_OPTION);
                switch (n) {
                    case 0:
                        model.load(game);
                        wizard.getJpanelJouer().initialize();
                        wizard.show(JPanelJouer.id);
                        break;
                    case 1:
                        break;
                    default:
                    //todo exception
                }
            }
        });
        add(listScroller, BorderLayout.CENTER);
        add(new JButtonBackToAcceuil(wizard), BorderLayout.SOUTH);
    }

    @Override
    public void update(Observable o, Object o1) {
    }

}