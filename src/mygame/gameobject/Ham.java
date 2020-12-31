/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import mygame.Main;

/**
 *
 * @author leoze
 */
public class Ham extends Item{
    
    public Ham(int x, int y, int z, String name, float pickUpRadius){
        
        super(x, y, z, name, pickUpRadius);
        
    }


    @Override
    void init(Main arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setPosition(Main arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
