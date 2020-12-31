/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import java.util.ArrayList;
import java.util.Queue;
import mygame.gameobject.CharacterState;
import mygame.gameobject.ChefBoy;
import mygame.gameobject.GameObject;
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
    
    ArrayList inventory;
    Queue enemies;
    ArrayList<GameObject> props = new ArrayList<>();
    
    ChefBoy chefBoy;
    Player player;
    
    
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
        
        initLight();
        initCamera();
        initTerrain();
        initProp();
        initSky();
        initPlayer();
        initItem();
    }
    
    /**
     * create a directional light to represent sun 
     * 
     */
    void initLight(){
        
        // TODO can also use different types of light 
        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(new Vector3f(0f, -30f, 0f).normalizeLocal());
        main.getRootNode().addLight(dl);
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
        GameObject tree1 = new Tree(main, 10, 0, 20, "tree1");
        props.add(tree1);
    }
    
    /**
     * init chefBoy object 
     */
    void initPlayer(){
        this.player = new Player(main);
        //this.chefBoy = new ChefBoy(main, 0, 0, 0, "chefBoy", 100, CharacterState.IDLE);
    }
    
    /**
     * init all item objects 
     */
    void initItem(){
        
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
