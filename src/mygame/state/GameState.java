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
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import java.util.ArrayList;
import java.util.Queue;
import mygame.gameobject.Enemy;
import mygame.gameobject.GameLight;
import mygame.gameobject.GameObject;
import mygame.gameobject.Ham;
import mygame.gameobject.Item;
import mygame.gameobject.Pig;
import mygame.gameobject.Player;
import mygame.gameobject.Terrain;
import mygame.gameobject.Tree;
import mygame.gameobject.Volcano;

/**
 * state for in game init all game objects update all game objects
 *
 * @author leoze
 */
public class GameState extends AbstractAppState {

    ArrayList inventory; // inventory of items 
    Queue enemyQueue; // queue to spawn enemies 
    ArrayList<Enemy> enemies = new ArrayList<>(); // list to store enemies 
    ArrayList<GameObject> props = new ArrayList<>(); // list of all props 
    GameLight gameLight; // lighting

    Player player; // player object 

    public BulletAppState bulletAppState; // controls physics 

    Main main; // main object, this is needed because Main extends SimpleApplication
                // SimpleApplication contains things like rootNode, camera, assetManager, etc
    
    Vector3f position = new Vector3f(0, 0, 0);


    /**
     * init all models, lighting, camera, physics, objects, and add them to game
     * world
     *
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
     * init lighting for game
     *
     */
    void initLight() {

        gameLight = new GameLight(main);
    }

    /**
     * change fly cam speed
     */
    void initCamera() {

        main.getFlyByCamera().setMoveSpeed(30);
    }

    /**
     * set sky color to light blue
     */
    void initSky() {
        
        main.getViewPort().setBackgroundColor(new ColorRGBA(1f, 0.7f, 0.8f, 1f));
    }

    /**
     * init ground terrain a flat square for now TODO change terrain to
     * different model
     */
    void initTerrain() {

        
        GameObject terrain = new Terrain(main, position, "terrain");
    }

    /**
     * init all props eg. trees
     */
    void initProp() {
        
    
        GameObject tree0 = new Tree(main, new Vector3f(5, 0, 20), "tree0");
        GameObject tree1 = new Tree(main, new Vector3f(10, 0, 20), "tree1");
        GameObject tree2 = new Tree(main, new Vector3f(15, 0, 20), "tree2");
        GameObject tree3 = new Tree(main, new Vector3f(20, 0, 20), "tree3");
        GameObject tree4 = new Tree(main, new Vector3f(25, 0, 20), "tree4");

        props.add(tree0);
        props.add(tree1);
        props.add(tree2);
        props.add(tree3);
        props.add(tree4);

        props.get(4).model.setLocalScale(2);
        
        GameObject volcano = new Volcano(main, new Vector3f(50, 0, 50), "volcano");
    }

    /**
     * init chefBoy object
     */
    void initPlayer() {

        this.player = new Player(main);
    }

    /**
     * init all item objects
     */
    void initItem() {
        Item ham = new Ham(main, new Vector3f(5, 0, 5), "ham", 10 );
    }

    void initEnemy() {
        
        Enemy pig0 = new Pig(main, new Vector3f(20, 20, 5), "pig1", 20);
        enemies.add(pig0);
    }

    /**
     * game updates update enemy behaviour, enemy position, chef boy etc
     *
     * @param tpf
     */
    @Override
    public void update(float tpf) {

        player.updateMovement();
        
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).behaviour(player);
            //((Pig)ememies.get(i)). 
        }
        
    }
}
