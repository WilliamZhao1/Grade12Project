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
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Spatial;
import mygame.state.Main;


/**
 *
 * @author leoze
 */
public class Tree extends Prop{
    
    private RigidBodyControl landscape;
    
    public Tree(Main main, int x, int y, int z, String name){
        super(main, x, y, z, name);
        init();
    }

    /**
     * init 
     * create model
     * add collision mesh to model
     * add model to rootNode
     * add mesh to bulletAppState for physics collision 
     */
    @Override
    void init() {
        
        Material mat = main.getAssetManager().loadMaterial("Materials/purple1.j3m");
        
        
        model = main.getAssetManager().loadModel("Models/tree/first drawing tree.glb");
        
        model.setMaterial(mat);
        
        
        model.setShadowMode(ShadowMode.Cast);
        
        setPosition(); // set position needs to be before creating collision mesh for some reason

        collisionMesh = CollisionShapeFactory.createMeshShape(model);
        landscape = new RigidBodyControl(collisionMesh, 0);
        model.addControl(landscape);
        
        
        
        main.getRootNode().attachChild(model);
        
        
        
        initPhysics();
        
        
        
    }
    
    void initPhysics(){
        main.gameState.bulletAppState.getPhysicsSpace().add(landscape);
    }

    @Override
    void setPosition() {
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        
        model.setLocalTranslation(x,y,z);
    }
    
}
