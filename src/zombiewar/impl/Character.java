package zombiewar.impl;

import zombiewar.intf.ICharacter;
import zombiewar.intf.ISurvivor;

public abstract class Character implements ICharacter{
	
	public String name;
        public int health;
	public int maxHit;
	
	Character(String name, int health, int maxHit){
		this.name = name;
		this.health = health;
		this.maxHit = maxHit;
	}
        public String getName(){
            return this.name;
        }
        public int getHit(){
            //restrict the random ammount of the hit between 
            //50% and 100% of the max hit ammount
            double percent = Math.min(Math.random() + 0.5, 1);
            return (int) Math.floor(percent*this.maxHit);
        }
	@Override
	public void decreaseHealth(int increment) {
                System.out.println(this.getName() + " takes " + increment + " damage");
		health-=increment;
                System.out.println(this.getName() + "'s health is now " + health);
	}

	@Override
	public boolean isAlive() {
		return (health > 0);
	}
        
	
	
}
