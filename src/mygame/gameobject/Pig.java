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
public class Pig extends BasicEnemy{

    public Pig(Main main, int x, int y, int z, String name, int health, CharacterState state){
        super(main, x, y, z, name, health, state);
        this.damage = 10;
        this.range = 1;
        this.detectionRange = 10;

    }
    
    @Override
    void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void setPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
