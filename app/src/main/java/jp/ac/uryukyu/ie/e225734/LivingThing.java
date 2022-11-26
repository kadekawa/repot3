package jp.ac.uryukyu.ie.e225734;
/**
 * HeroクラスとEnemyクラスのスーパークラス
 *  String name; //名前
 *  int hitPoint; //HP
 *  int attack; //攻撃力
 *  boolean dead; //生死状態。true=死亡。
 */

public class LivingThing{
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public void setName(String name){
        this.name = name;
    }
    public void setHP(int hp){
        this.hitPoint = hp;
    }
    public void setAttack(int att){
        this.attack = att;
    }
    public void setDead(boolean dead){
        this.dead = dead;
    }

    public String getName(){
        return this.name;
    }
    public int getHP(){
        return this.hitPoint;
    }
    public int getAttack(){
        return this.attack;
    }
    public boolean getDead(){
        return this.dead;
    }


    public LivingThing (String name, int maximumHP, int attack) {
        this.setName(name);
        this.setHP(maximumHP);
        this.setAttack(attack);
        this.setDead(false);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }


    public void attack(LivingThing e){
        if (this.dead == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, e.name, damage);
            e.wounded(damage);
        }

    }

    public void wounded(int damage){
        this.setHP(this.getHP()-damage);
        if( this.getHP() <= 0 ) {
            this.setDead(true);
            System.out.printf("%sは倒れた。\n", getName());
        }
    }
}