package jp.ac.uryukyu.ie.e225734;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero {
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

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
     */
    public Hero (String name, int maximumHP, int attack) {
        this.setName(name);
        this.setHP(maximumHP);
        this.setAttack(attack);
        this.setDead(false);
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(Enemy e){
        int damage = (int)(Math.random() * this.getAttack());
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", this.getName(), e.getName(), damage);
        e.wounded(damage);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        this.setHP(this.getHP()-damage);
        if( this.getHP() <= 0 ) {
            this.setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", this.getName());
        }
    }
}