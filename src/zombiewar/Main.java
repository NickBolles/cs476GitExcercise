package zombiewar;

import java.util.ArrayList;
import zombiewar.impl.CharacterFactory;
import zombiewar.impl.Character;
import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 *
 * @author thaoc
 */
public class Main {
  
  private static final ICharacterFactory factory = CharacterFactory.instance;
  
  public static IZombie[] randomZombies() {
    int numZombies = (int) (Math.random() * 10) + 1;
    IZombie[] zombies = new IZombie[numZombies];
    for (int i = 0; i < zombies.length; i++) {
      String name = "Zombie " + i;
      int zombieType = (int) (Math.random() * 2);
      switch(zombieType){
        case 0: zombies[i] = (IZombie) factory.make("common",name); break;
        case 1: zombies[i] = (IZombie) factory.make("tank",name); break;
        case 2: zombies[i] = (IZombie) factory.make("predator",name); break;
      }
    }
    return zombies;
  }

  public static ISurvivor[] randomSurvivors() {
    int numZombies = (int) (Math.random() * 20) + 1;
    ISurvivor[] survivors = new ISurvivor[numZombies];
    for (int i = 0; i < survivors.length; i++) {
      int type = (int) (Math.random() * 3);
      String name = "Survivor " + i;
      switch(type){
        case 0: survivors[i] = (ISurvivor) factory.make("soldier", name); break;
        case 1: survivors[i] = (ISurvivor) factory.make("teacher", name); break;
        case 2: survivors[i] = (ISurvivor) factory.make("student", name); break;
        case 3: survivors[i] = (ISurvivor) factory.make("child", name); break;
      }
    }
    return survivors;
  }

  public static boolean allDead(ICharacter[] characters){
    boolean allDead = true;
    for(int i=0; i<characters.length; i++){
      allDead &= !characters[i].isAlive();
    }
    return allDead;
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    IZombie[] zombies = randomZombies();
    ISurvivor[] survivors = randomSurvivors();
    ArrayList<String> kills = new ArrayList<String>();

    System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
    System.out.println("But there are " + zombies.length + " zombies waiting for them.");
    
    //TODO: the survivors attack first.  One character attack each zombie.
    //      When all the survivors have done attacking, it's the zombies' 
    //      turn to attack.  For each zombie that is still alive, attack
    //      each suvivor that is still alive.  Repeat this cycle until
    //      all the zombies are all dead or all the survivors are all dead.
    
    for(ISurvivor survivor: survivors){
        System.out.println("-------------------------");
        int zombie = (int) Math.floor(Math.random()*zombies.length);
        survivor.attack(zombies[zombie]);
        if (!zombies[zombie].isAlive()){
            kills.add( ((Character) survivor).getName() + " killed " + ((Character) zombies[zombie]).getName() + "!");
        }
    }
    for(IZombie zombie: zombies){
        System.out.println("-------------------------");
        int survivor = (int) Math.floor(Math.random()*survivors.length);
        zombie.attack(survivors[survivor]);
        if (!survivors[survivor].isAlive()){
            kills.add( ((Character) zombie).getName() + " killed " + ((Character) survivors[survivor]).getName() + "!");
        }
    }
    
        System.out.println("==========================");
        //Print the deaths this round
        System.out.println("Deaths this round:");
        for (String kill: kills){
            System.out.println(kill);
        }
        System.out.println("----------------------------");
        
    if (allDead(survivors)) {
      System.out.println("None of the survivors made it.");
    } else {
      int count = 0;
      for(int i=0; i<survivors.length; i++) {
        if (survivors[i].isAlive()) count++;
      }
      System.out.println("It seems " + count + " have made it to safety.");
    }
    if (allDead(zombies)) {
      System.out.println("None of the zombies survived.");
    } else {
      int count = 0;
      for(int i=0; i<zombies.length; i++) {
        if (zombies[i].isAlive()) count++;
      }
      System.out.println("It seems " + count + " zombies are still alive.");
    }
    System.out.println("==========================");
  }

}
