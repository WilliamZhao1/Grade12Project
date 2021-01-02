/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import mygame.state.Main;

/**
 *
 * @author leoze
 */
public class Sky extends Map{

    public Sky(Main main, int x, int y, int z, String name){
        super(main, x, y, z, name);
    }
    
    @Override
    void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    void delete() {
        main.getRootNode().detachChild(model);
    }   
}
