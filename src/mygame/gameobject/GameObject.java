/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Spatial;
import mygame.state.Main;

/**
 * all game objects that exist 
 * @author leoze
 */
public abstract class GameObject {
    
    public Vector3f position; // position of object 
    String name; // name of objct 
    public Spatial model;
    
    Main main;
   
    public GameObject(Main main, Vector3f position, String name){
        
        this.position = position;
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
    public void setPosition(){
        model.setLocalTranslation(position);
    }
    
    /**
     * delete object when finished
     */
    abstract void delete();
    
    
}
