/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.scene.Spatial;
import mygame.Main;

import static mygame.Main.main;

/**
 *
 * @author leoze
 */
public class Tree extends Prop{
    
    public Tree(Main main, int x, int y, int z, String name){
        super(x, y, z, name);
        init(main);
    }

    @Override
    void init(Main main) {
        System.out.println(main.getAssetManager().loadModel("Models/first drawing tree/first drawing tree.glb"));
        model = main.getAssetManager().loadModel("Models/first drawing tree/first drawing tree.glb");
        main.getRootNode().attachChild(model);
        //setPosition(main);
    }

    @Override
    void setPosition(Main main) {
        model.setLocalTranslation(x,y,z);
    }
    
}
