package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * The Tank is one of the biggest and meanness zombie in the game.
 * He has a lot of health and will take down multiple survivors.  
 * 
 * @author thaoc
 */
public class Predator extends Character implements IZombie{

	/**
	 * A tank starts with 150 points of health
	 */
	public Predator() {
		super(150, 15);
	}

	/**
	 * An attack from the tank decrease a survivor's health by 20 points.
	 * @param survivor 
	 */
	@Override
	public void attack(ISurvivor survivor) {
		survivor.decreaseHealth(this.getHit());
	}
	
}
