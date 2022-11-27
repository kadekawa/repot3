package jp.ac.uryukyu.ie.e225734;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WarriorTest {
    @Test void attackWithWeponSkillTest(){
        Warrior hero = new Warrior("勇者", 10, 10);
        Enemy enemy = new Enemy("スライム", 1000, 3);
        for(var i=0; i<10; i++){
            hero.attackWithWeponSkill(enemy);
            if(i == 4){
                hero.setAttack(20);
            }
        }

    }

    
}
