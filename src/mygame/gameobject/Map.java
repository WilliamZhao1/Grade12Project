/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.bullet.collision.shapes.CollisionShape;
import mygame.state.Main;

/**
 * map objects 
 * @author leoze
 */
public abstract class Map extends GameObject{
    
    CollisionShape collisionMesh;
    
    Map(Main main, int x, int y, int z, String name){
        super(main, x, y, z, name);
    }
    
}
