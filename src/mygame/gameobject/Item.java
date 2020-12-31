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
public abstract class Item extends GameObject{
    
    float pickUpRadius;
    
    public Item(Main main, int x, int y, int z, String name, float pickUpRadius){
        super(main, x, y, z, name);
        this.pickUpRadius = pickUpRadius;
    }
}
