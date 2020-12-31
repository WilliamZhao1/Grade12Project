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
public abstract class BasicEnemy extends Enemy{
    
    public BasicEnemy(Main main, int x, int y, int z, String name, int health){
        super(main, x, y, z, name, health);

    }
}
