package zombiewar.impl;

import zombiewar.intf.ICharacter;

public abstract class Character implements ICharacter{
	
	public int health;
	public int maxHit;
	
	Character(int health, int maxHit){
		this.health = health;
		this.maxHit = maxHit;
	}
        public int getHit(){
            //restrict the random ammount of the hit between 
            //50% and 100% of the max hit ammount
            double percent = Math.min(Math.random() + 0.5, 1);
            return (int) Math.floor(percent*this.maxHit);
        }
	@Override
	public void decreaseHealth(int increment) {
		health-=increment;
	}

	@Override
	public boolean isAlive() {
		return (health > 0);
	}
	
	
}
