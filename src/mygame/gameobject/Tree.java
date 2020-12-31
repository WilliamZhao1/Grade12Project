/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.scene.Spatial;
import mygame.Main;


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
        System.out.println(main.getAssetManager().loadModel("Models/first drawing tree/first drawing tree.glb"));
        model = main.getAssetManager().loadModel("Models/first drawing tree/first drawing tree.glb");

        CollisionShape sceneShape = CollisionShapeFactory.createMeshShape(model);
        landscape = new RigidBodyControl(sceneShape, 0);
        model.addControl(landscape);
        
        
        main.getRootNode().attachChild(model);
        setPosition();
        initPhysics();
        
    }
    
    void initPhysics(){
        main.bulletAppState.getPhysicsSpace().add(landscape);
    }

    @Override
    void setPosition() {
        model.setLocalTranslation(x,y,z);
    }
    
}
