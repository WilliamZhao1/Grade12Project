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
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import mygame.state.Main;

/**
 * terrain / ground object 
 * @author leoze
 */
public class Terrain extends Map{
    
    private RigidBodyControl landscape;

    public Terrain(Main main, Vector3f position, String name){
        super(main, position, name);
        init();
    }
    
    /**
     * init 
     * create model, add model to rootNode 
     * add rigidBody for physics 
     */
    @Override
    void init() {
        
        Material mat = main.getAssetManager().loadMaterial("Materials/ground dots test.j3m");
        
        model = main.getAssetManager().loadModel("Models/ground/floor.j3o");
        
        model.setMaterial(mat);
        
        model.setShadowMode(ShadowMode.Receive);

        collisionMesh = CollisionShapeFactory.createMeshShape(model);
        landscape = new RigidBodyControl(collisionMesh, 0);
        model.addControl(landscape);
        
        main.getRootNode().attachChild(model);
        setPosition();
        initPhysics();
    }
    
    /**
     * init physics 
     * add physics to bulletAppstate 
     */
    void initPhysics(){
        main.gameState.bulletAppState.getPhysicsSpace().add(landscape);
    }


    
    @Override
    void delete() {
        main.getRootNode().detachChild(model);
    }
    
}
