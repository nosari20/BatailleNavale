/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import model.BatailleNavale;

/**
 *
 * @author nikolai
 */
public class JPanelWizard extends JPanel implements Observer{

    private final CardLayout cl ;
    private final JPanelPlacement jpanelPlacement ; 
    private final JPanelJouer jpanelJouer;
    private String currentPanel = null;
    
    public JPanelWizard(final BatailleNavale model){
        super();
        cl = new CardLayout();
        this.setLayout(cl);
        model.addObserver(this);
        jpanelPlacement= new JPanelPlacement(model,this);
        jpanelJouer = new JPanelJouer(model);
        add(new JPanelAcceuil(model,this),JPanelAcceuil.id);
        add(new JPanelCreer(model,this),JPanelCreer.id);
        add(jpanelJouer,JPanelJouer.id);
        add(new JPanelParties(model,this),JPanelParties.id);
        add(new JPanelScore(model,this),JPanelScore.id);
        add(jpanelPlacement,JPanelPlacement.id);
        currentPanel = JPanelAcceuil.id;
//        show(JPanelAcceuil.id);
        
    }
    
    public void show(String id){
        System.out.println("show : "+id);
        cl.show(this, id);
        currentPanel = id;
        GUI.getInstance().updateMenu();
    }
    
    @Override
    public void update(Observable o, Object o1) {
    }

    /**
     * @return the jpanelPlacement
     */
    public JPanelPlacement getJpanelPlacement() {
        return jpanelPlacement;
    }

    /**
     * @return the jpanelJouer
     */
    public JPanelJouer getJpanelJouer() {
        return jpanelJouer;
    }

    /**
     * @return the currentPanel
     */
    public String getCurrentPanel() {
        return currentPanel;
    }

    /**
     * @param currentPanel the currentPanel to set
     */
    public void setCurrentPanel(String currentPanel) {
        this.currentPanel = currentPanel;
    }
    
}
