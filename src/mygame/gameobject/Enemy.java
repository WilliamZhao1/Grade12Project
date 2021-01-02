/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import mygame.state.Main;

/**
 *
 * @author leoze
 */
public abstract class Enemy extends Character{
    
    int damage;
    int speed;
    int range;
    int detectionRange;
    
    public Enemy(Main main, int x, int y, int z, String name, int health){
        super(main, x, y, z, name, health);

    }
    
    public void detection(Player player){
        
        double distance;
        
        double x1 = player.position.x;
        double z1 = player.position.z;
        
        distance = Math.sqrt(Math.pow(x1-x, 2) + Math.pow(z1-z, 2));
        
        if(distance < detectionRange){
            System.out.println("charge");
        }
    }
    
    public void attack(Player player){
        
        double distance;
        
        double x1 = player.position.x;
        double z1 = player.position.z;
        
        distance = Math.sqrt(Math.pow(x1-x, 2) + Math.pow(z1-z, 2));
        
        if(distance < range){
            System.out.println("attack");
        }
    }
}
