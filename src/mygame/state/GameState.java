/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.state;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.light.DirectionalLight;
import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.renderer.queue.RenderQueue.ShadowMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.shadow.DirectionalLightShadowFilter;
import com.jme3.shadow.DirectionalLightShadowRenderer;
import com.jme3.shadow.PointLightShadowRenderer;
import java.util.ArrayList;
import java.util.Queue;
import mygame.gameobject.CharacterState;
import mygame.gameobject.ChefBoy;
import mygame.gameobject.GameObject;
import mygame.gameobject.Pig;
import mygame.gameobject.Player;
import mygame.gameobject.Terrain;
import mygame.gameobject.Tree;

/**
 * state for in game 
 * init all game objects 
 * update all game objects 
 * @author leoze
 */
public class GameState extends AbstractAppState{
    
    ArrayList inventory; // inventory of items 
    Queue enemies; // queue to spawn enemies 
    ArrayList<GameObject> props = new ArrayList<>(); // list of all props 
    
    Player player; // player object 
    
    public BulletAppState bulletAppState; // controls physics 
    
    
    Main main; // main object, this is needed because Main extends SimpleApplication
                // SimpleApplication contains things like rootNode, camera, assetManager, etc
    
    private Vector3f camDir = new Vector3f(); // camera direction / position
    private Vector3f camLeft = new Vector3f();

    
    
    /**
     * init all models, lighting, camera, physics, objects, and add them to game world 
     * @param stateManager
     * @param app 
     */
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        
        this.main = (Main) app;
        
        bulletAppState = new BulletAppState(); // for physics 
        stateManager.attach(bulletAppState); // add bulletAppState into state manager
        
        initLight();
        initCamera();
        initTerrain();
        initProp();
        initSky();
        initPlayer();
        initItem();
        initEnemy();
    }
    
    /**
     * create a directional light to represent sun 
     * 
     */
    void initLight(){
        
        /*
        // TODO can also use different types of light 
        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(new Vector3f(0f, -30f, 0f).normalizeLocal());
        main.getRootNode().addLight(dl);
        */
        
        
        DirectionalLight sun = new DirectionalLight();
        sun.setColor(ColorRGBA.White);
        //sun.setDirection(main.getCamera().getDirection());
        sun.setDirection(new Vector3f(0f, -30f, 0f).normalizeLocal());
        main.getRootNode().addLight(sun);
        

        final int SHADOWMAP_SIZE=1024;
        DirectionalLightShadowRenderer dlsr = new DirectionalLightShadowRenderer(main.getAssetManager(), SHADOWMAP_SIZE, 3);
        dlsr.setLight(sun);
        main.getViewPort().addProcessor(dlsr);

        DirectionalLightShadowFilter dlsf = new DirectionalLightShadowFilter(main.getAssetManager(), SHADOWMAP_SIZE, 3);
        dlsf.setLight(sun);
        dlsf.setEnabled(true);
        FilterPostProcessor fpp = new FilterPostProcessor(main.getAssetManager());
        fpp.addFilter(dlsf);
        main.getViewPort().addProcessor(fpp);
        

    }
    

    
    /**
     * change fly cam speed 
     */
    void initCamera(){
        main.getFlyByCamera().setMoveSpeed(30);
    }
    

    
    /**
     * set sky color to light blue 
     */
    void initSky(){
        main.getViewPort().setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
    }
    
    /**
     * init ground terrain 
     * a flat square for now 
     * TODO change terrain to different model 
     */
    void initTerrain(){
        
        
        GameObject terrain = new Terrain(main, 0 ,0 ,0 , "terrain");
        

    }
    
    /**
     * init all props 
     * eg. trees 
     */
    void initProp(){
        GameObject tree0 = new Tree(main, 5, 0, 20, "tree0");
        GameObject tree1 = new Tree(main, 10, 0, 20, "tree1");
        GameObject tree2 = new Tree(main, 15, 0, 20, "tree2");
        GameObject tree3 = new Tree(main, 20, 0, 20, "tree3");
        GameObject tree4 = new Tree(main, 25, 0, 20, "tree4");
        
        props.add(tree0);
        props.add(tree1);
        props.add(tree2);
        props.add(tree3);
        props.add(tree4);
        
        props.get(4).model.setLocalScale(2);
        
        
        
    }
    
    /**
     * init chefBoy object 
     */
    void initPlayer(){
        
        this.player = new Player(main);
        
    }
    
    /**
     * init all item objects 
     */
    void initItem(){
        
    }
    
    void initEnemy(){
        GameObject pig0 = new Pig(main, 20, 5, 5, "pig1", 20);
    }
    
    /**
     * game updates 
     * update enemy behaviour, enemy position, chef boy 
     * etc 
     * @param tpf 
     */
    @Override
    public void update(float tpf){
        
        player.updateMovement();
        
        
    }

    

}
