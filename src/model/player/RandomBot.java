/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.player;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Coordinate;
import model.Flotte;
import model.OrdreTir;
import model.VisionBattlefield;

/**
 * @author Nikolai
 */
public class RandomBot extends Bot implements Serializable{
    
    public RandomBot(){
        this.nom = "randomBot";
    }

    @Override
    public int autoFire(VisionBattlefield bf, Flotte target) {
        int x = (int)(Math.random());
        int y = (int)(Math.random());
        int l = (int)(Math.random());
        Coordinate c = new Coordinate(x ,y);
        OrdreTir o = new OrdreTir(c, l);
        if(bf != null)
            try {
                return target.fire(target, o);
        } catch (Exception ex) {
            Logger.getLogger(RandomBot.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }     
}