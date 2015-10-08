/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * A soldier is one of the strongest survivor because he wears armor 
 * and carries a weapon.
 * 
 * @author thaoc
 */
public class Child extends Character implements ISurvivor{

	/**
	 * A soldier starts with 100 points of health
	 */
	public Child(String name) {
		super(name, 15, 5);
	}

	@Override
	public void attack(IZombie zombie) {
                Character z = (Character) zombie;
                System.out.println(this.getName() + " attacking " + z.getName());
		z.decreaseHealth(this.getHit());
	}
	
	
}
