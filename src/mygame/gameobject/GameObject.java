/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Spatial;
import mygame.Main;

/**
 *
 * @author leoze
 */
public abstract class GameObject {
    int x, y, z; // position of object 
    String name; // name of objct 
    Spatial model;
    
    Main main;
    
    //public AppStateManager appStateManager;
    
    
    abstract void init();
    abstract void setPosition();
    
    public GameObject(Main main, int x, int y, int z, String name){
        this.x = x;
        this.y = y;
        this.z = z; 
        this.name = name;
        
        this.main = main;
    }
    
}
