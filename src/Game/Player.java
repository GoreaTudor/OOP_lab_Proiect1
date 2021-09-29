package Game;

public class Player {
    private double hp;
    private double dmg;
    private int score;

    Player () {
        this.hp = 10;
        this.dmg = 4;
        this.score = 0;
    }

    public boolean isAlive(){
        return (this.hp > 0);
    }

    public double getHp() {
        return hp;
    }
    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getDmg() {
        return dmg;
    }
    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public int getScore() {
        return score;
    }
    public void incScore() {
        this.score ++;
    }
    public void resetScore() {
        this.score = 0;
    }
}
