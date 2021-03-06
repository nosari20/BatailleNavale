/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.player;

import java.io.Serializable;
import model.StateCase;
import model.Flotte;
import model.OrdreTir;

/**
 *
 * @author Nikolai
 */
public class Human extends Player implements Serializable {

    public Human(String nom, int score, int nombrePartieJouees) {
        this.nom = nom;
        this.score = score;
        this.nombrePartieJouees = nombrePartieJouees;

    }

    @Override
    public StateCase fire(OrdreTir order, Flotte target) throws Exception {
        StateCase res = flotte.fire(target, order);
        return res;
    }

    @Override
    public void updateBattlefield(OrdreTir order,StateCase state) {
        map.setState(order.getCoordinate(), state);
    }

}
