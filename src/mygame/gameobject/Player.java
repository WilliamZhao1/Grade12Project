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
 *
 * @author leoze
 */
public class Player implements ActionListener{
    
    public CharacterControl user; // object for controling player
    
    public Vector3f walkDirection = new Vector3f();
    public boolean left = false, right = false, up = false, down = false; // movement
    
    private Vector3f camDir = new Vector3f(); // camera direction / position
    private Vector3f camLeft = new Vector3f();
    
    Main main;
    
    public Player(Main main){
        this.main = main;
        init();
        
    }
    
    /**
     * init model, collision, position
     */
    
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
        user = new CharacterControl(capsuleShape, 0.05f);
        user.setJumpSpeed(20);
        user.setFallSpeed(30);
        
        main.bulletAppState.getPhysicsSpace().add(user);
        
        user.setGravity(new Vector3f(0,-30f,0));
        
       
    }
    
    /**
     * set position of player
     */
    void setPosition() {
        user.setPhysicsLocation(new Vector3f(10, 10, 0));
    }
    
    /**
     * set up binding for movement keys 
     * W = up
     * A = left 
     * S = down 
     * D = right 
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
                user.jump(new Vector3f(0, 20f, 0));
            }
        }
    }
    
    /**
     * update movement of player
     */
    public void updateMovement(){
        System.out.println(left);
        
        camDir.set(main.getCamera().getDirection()).multLocal(0.6f);
        camLeft.set(main.getCamera().getLeft()).multLocal(0.4f);
        walkDirection.set(0, 0, 0);
        if (left) {
            walkDirection.addLocal(camLeft);
        }
        if (right) {
            walkDirection.addLocal(camLeft.negate());
        }
        if (up) {
            walkDirection.addLocal(camDir);
        }
        if (down) {
            walkDirection.addLocal(camDir.negate());
        }
        
        user.setWalkDirection(walkDirection);
        main.getCamera().setLocation(user.getPhysicsLocation()); // update camera position to player position
    }
    
}
