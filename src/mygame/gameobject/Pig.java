/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import mygame.state.Main;

/**
 *
 * @author leoze
 */
public class Pig extends BasicEnemy{

    public Pig(Main main, Vector3f position, String name, int health){
        super(main, position, name, health);
        this.damage = 10;
        this.speed = 0.01;
        this.range = 10;
        this.detectionRange = 30;
        
        init();
        setPosition();

    }
    
    @Override
    void init() {
        
        Material mat = main.getAssetManager().loadMaterial("Materials/orange.j3m");
        // change to xml file with animation later 
        model = main.getAssetManager().loadModel("Models/pig/pig.j3o");
        
        model.setMaterial(mat);
        
        model.setShadowMode(RenderQueue.ShadowMode.Cast);
        
        main.getRootNode().attachChild(model);    

    }
    


    @Override
    void delete() {
        main.getRootNode().detachChild(model);
    }
    
    
}
