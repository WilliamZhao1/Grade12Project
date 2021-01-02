/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import mygame.state.Main;

/**
 * terrain / ground object 
 * @author leoze
 */
public class Terrain extends Map{
    
    private RigidBodyControl landscape;

    public Terrain(Main main, int x, int y, int z, String name){
        super(main, x, y, z, name);
        init();
    }
    
    /**
     * init 
     * create model, add model to rootNode 
     * add rigidBody for physics 
     */
    @Override
    void init() {
        
        
        model = main.getAssetManager().loadModel("Models/ground/ground.glb");
        
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
    void setPosition() {
        
    }
    
    @Override
    void delete() {
        main.getRootNode().detachChild(model);
    }
    
}
