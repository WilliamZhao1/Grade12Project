/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.collision.shapes.HullCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.math.Vector3f;
import mygame.state.Main;

/**
 * characters that can move and attack 
 * @author leoze
 */
public abstract class Character extends GameObject{
    
    int health;
    CharacterState state;
    public CharacterControl character;
    public Vector3f walkDirection = new Vector3f();
    
    public Character(Main main, Vector3f position, String name, int health){
        super(main, position, name);
        this.health = health;
        this.state = CharacterState.IDLE;
        
        
    }
    

    
}
