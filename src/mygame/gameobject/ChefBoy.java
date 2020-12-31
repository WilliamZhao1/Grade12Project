/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;
import mygame.Main;

/**
 * chef boy character 
 * @author leoze
 */
public class ChefBoy extends Character implements ActionListener{
    
    public CharacterControl player;
    public Vector3f walkDirection = new Vector3f();
    public boolean left = false, right = false, up = false, down = false; // movement
    
    public ChefBoy(Main main, int x, int y, int z, String name, int health, CharacterState state){
        super(main, x, y, z, name, health, state);
        
        init();
        
    }
    
    /**
     * init model, collision, position
     */
    @Override
    void init() {
        
        setKeys();
        initCollision();
        setPosition();
        
        
    }

    /**
     * create collision hit box
     * add gravity and physics to player 
     */
    void initCollision(){
        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
        player = new CharacterControl(capsuleShape, 0.05f);
        player.setJumpSpeed(20);
        player.setFallSpeed(30);
        
        main.bulletAppState.getPhysicsSpace().add(player);
        
        player.setGravity(new Vector3f(0,-30f,0));
        
       
    }
    
    /**
     * set position of player
     */
    @Override
    void setPosition() {
        player.setPhysicsLocation(new Vector3f(10, 10, 0));
    }
    
    /**
     * set up binding for movement keys 
     */
    void setKeys(){
        main.getInputManager().addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        main.getInputManager().addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        main.getInputManager().addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
        main.getInputManager().addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
        main.getInputManager().addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        main.getInputManager().addListener(this, "Left");
        main.getInputManager().addListener(this, "Right");
        main.getInputManager().addListener(this, "Up");
        main.getInputManager().addListener(this, "Down");
        main.getInputManager().addListener(this, "Jump");
    }



    /**
     * method from ActionListener 
     * if key is pressed, change to true
     * @param binding
     * @param isPressed
     * @param tpf 
     */
    @Override
    public void onAction(String binding, boolean isPressed, float tpf) {
        
        
        if (binding.equals("Left")) {
            left = isPressed;
        } else if (binding.equals("Right")) {
            right = isPressed;
        } else if (binding.equals("Up")) {
            up = isPressed;
        } else if (binding.equals("Down")) {
            down = isPressed;
        } else if (binding.equals("Jump")) {
            if (isPressed) {
                player.jump(new Vector3f(0, 20f, 0));
            }
        }
    }
   
}
