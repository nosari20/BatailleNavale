/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.ship;

import model.Coordinate;

/**
 * @todo
 * @author Nikolai
 */
public class ShipFactory {
    /**
     * 
     * @param epoque
     * @param puissance
     * @param queue 
     * @param nez
     * @return 
     */
    public Ship buildShip(Epoque epoque, int puissance,Coordinate queue, Coordinate nez){
        return null;
        
    }
    
    /**
     * 
     * @param type
     * @param queue  
     * @param nez
     * @return 
     */
    public Ship buildShip(TypeShip type,Coordinate queue, Coordinate nez){
        return null;
    }
    
    /**
     * 
     * @return 
     */
    public static ShipFactory getInstance(){
        return null;
        
    }
}