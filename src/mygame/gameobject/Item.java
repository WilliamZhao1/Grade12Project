/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.math.Vector3f;
import mygame.state.Main;

/**
 * all items that can be picked up 
 * @author leoze
 */
public abstract class Item extends GameObject{
    
    float pickUpRadius;
    
    public Item(Main main, Vector3f position, String name, float pickUpRadius){
        super(main, position, name);
        this.pickUpRadius = pickUpRadius;
    }
    void detection(Player player){
         double distance;
        
        double x = this.position.x;
        double x1 = player.position.x;
        double z = this.position.z;
        double z1 = player.position.z;
        distance = Math.sqrt(Math.pow(x1-x, 2) + Math.pow(z1-z, 2));
        
    } 
}
