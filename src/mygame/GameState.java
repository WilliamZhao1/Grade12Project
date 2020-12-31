/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import java.util.ArrayList;
import java.util.Queue;
import mygame.gameobject.GameObject;
import mygame.gameobject.Tree;

/**
 *
 * @author leoze
 */
public class GameState extends AbstractAppState{
    
    ArrayList inventory;
    Queue enemies;
    ArrayList<GameObject> props = new ArrayList<>();
    
    
    Main main;
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        
        this.main = (Main) app;
        
        initLight(main);
        initCamera(main);
        initTerrain();
        initProp();
        initSky();
        initChefBoy();
        initItem();
    }
    
    void initLight(Main main){
        
        DirectionalLight dl = new DirectionalLight();
        dl.setColor(ColorRGBA.White);
        dl.setDirection(new Vector3f(0f, -30f, 0f).normalizeLocal());
        main.getRootNode().addLight(dl);
    }
    
    void initCamera(Main main){
        main.getFlyByCamera().setMoveSpeed(30);
        
        main.getViewPort().setBackgroundColor(ColorRGBA.Cyan);
    }
    
    void initTerrain(){
        Box boxMesh = new Box(100f,0.1f,100f); 
        Geometry boxGeo = new Geometry("Colored Box", boxMesh); 
        
        Material boxMat = new Material(main.getAssetManager(), "Common/MatDefs/Light/Lighting.j3md"); 
        boxMat.setBoolean("UseMaterialColors", true); 
        boxMat.setColor("Ambient", ColorRGBA.Green); 
        boxMat.setColor("Diffuse", ColorRGBA.Green); 
        boxGeo.setMaterial(boxMat); 
        main.getRootNode().attachChild(boxGeo);
    }
    
    void initProp(){
        GameObject tree1 = new Tree(main, 10, 0, 20, "tree1");
        props.add(tree1);
    }
    
    void initSky(){
        
    }
    
    void initChefBoy(){
        
    }
    
    void initItem(){
        
    }
}
