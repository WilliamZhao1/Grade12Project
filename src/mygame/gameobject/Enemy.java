/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.math.Vector3f;
import mygame.state.Main;

/**
 *
 * @author leoze
 */
public abstract class Enemy extends Character{
    
    int damage;
    double speed;
    double range;
    double detectionRange;
    boolean detectedPlayer;
    
    public Enemy(Main main, Vector3f position, String name, int health){
        super(main, position, name, health);

    }
    
    
    public void behaviour(Player player){
        
        position = phy.getPhysicsLocation();
        
        
        
        detection(player);
        
        attack(player);
        
        moveTowardsPlayer(player);
        
        
    }
    
    void detection(Player player){
        
        double distance;
        
        double x = this.position.x;
        double x1 = player.position.x;
        double z = this.position.z;
        double z1 = player.position.z;
        
        distance = Math.sqrt(Math.pow(x1-x, 2) + Math.pow(z1-z, 2));
        
        if(distance < detectionRange){
            System.out.println("charge");
            detectedPlayer = true;
            
            if(distance < range){
                System.out.println("attack");
                detectedPlayer = false;
            }
        }
        
        else {
            System.out.println("far from player");
            detectedPlayer = false;         
        }
    }
    
    void attack(Player player){
        
        double distance;
        
        double x = this.position.x;
        double x1 = player.position.x;
        double z = this.position.z;
        double z1 = player.position.z;
        
        distance = Math.sqrt(Math.pow(x1-x, 2) + Math.pow(z1-z, 2));
        
        if(distance < range){
            System.out.println("attack");
        }
    }
    
    void moveTowardsPlayer(Player player){
        if(detectedPlayer){
            
            double xDiff = this.position.x - player.position.x;
            double zDiff = this.position.z - player.position.z;
            
            double normalizeNumber = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(zDiff, 2));
            
            xDiff = xDiff / normalizeNumber;
            zDiff = zDiff / normalizeNumber;
            
            this.position.x -= xDiff * speed;
            this.position.z -= zDiff * speed;
            
            phy.setPhysicsLocation(position);
            setPosition();
        }
    }
    
}
