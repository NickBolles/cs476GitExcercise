
package zombiewar.impl;

import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
/**
 *
 * @author thaoc
 */
public class CharacterFactory implements ICharacterFactory{
  
  public static final ICharacterFactory instance = new CharacterFactory();
  
  private CharacterFactory(){
   
  }

  /**
   * Make the character.  To support more characters,
   * simply implement a type and then add a case statement
   * to this method.
   * 
   * @param type The type of character to make.
   * @return 
   */
  
  @Override
  public ICharacter make(String type, String name) {
    switch(type){
      case "soldier"  : return new Soldier(name);
      case "child"  : return new Child(name);
      case "student"  : return new Student(name);
      case "teacher"  : return new Teacher(name);
      case "common"  : return new CommonInfected(name);
      case "tank"     : return new Tank(name);          
      case "predator"  : return new Predator(name);
    }
    return null;
  }
  
}
