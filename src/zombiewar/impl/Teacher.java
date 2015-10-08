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
public class Teacher extends Character implements ISurvivor{

	/**
	 * A soldier starts with 100 points of health
	 */
	public Teacher() {
		super(80, 15);
	}

	@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(this.getHit());
	}
	
	
}
