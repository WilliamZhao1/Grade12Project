/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Spatial;
import mygame.state.Main;

/**
 * all game objects that exist 
 * @author leoze
 */
public abstract class GameObject {
    public int x, y, z; // position of object 
    String name; // name of objct 
    public Spatial model;
    
    Main main;
   
    

    public GameObject(Main main, int x, int y, int z, String name){
        this.x = x;
        this.y = y;
        this.z = z; 
        this.name = name;
        
        this.main = main;
        
        
    }
    
    /**
     * init, create model and add to rootNode
     */
    abstract void init();
    
    /**
     * set position of object 
     */
    abstract void setPosition();
    
    /**
     * delete 
     */
    abstract void delete();
    
    
}
