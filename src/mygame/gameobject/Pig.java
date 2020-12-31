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
import mygame.state.Main;

/**
 *
 * @author leoze
 */
public class Pig extends BasicEnemy{

    public Pig(Main main, int x, int y, int z, String name, int health){
        super(main, x, y, z, name, health);
        this.damage = 10;
        this.range = 1;
        this.detectionRange = 10;
        
        init();

    }
    
    @Override
    void init() {
        
        // change to xml file with animation later 
        model = main.getAssetManager().loadModel("Models/pig/pig.glb");
        
        model.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        
        main.getRootNode().attachChild(model);    
        setPosition();
    }

    @Override
    void setPosition() {
        model.setLocalTranslation(x,y,z);
    }
    
}
