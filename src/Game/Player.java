package Game;

public class Player {
    private double baseHP;
    private double currentHP;
    private double dmg;
    private int score;

    Player () {
        this.baseHP = 10;
        this.currentHP = this.baseHP;
        this.dmg = 4;
        this.score = 0;
    }

    public boolean isAlive(){
        return (this.currentHP > 0);
    }
    public void upgrade() {
        if(this.getBaseHP() < 15 && this.getDmg() < 9) {
            this.setBaseHP(this.getBaseHP() + 1);
            this.setDmg(this.getDmg() + 1);
        }
    }

    public double getBaseHP() {
        return baseHP;
    }
    public void setBaseHP(double baseHP) {
        this.baseHP = baseHP;
    }

    public double getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }
    public void resetCurrentHP() {
        this.currentHP = this.baseHP;
    }
    public void incCurrentHP(){
        if(this.currentHP + 0.5 <= this.baseHP)
            this.currentHP += 0.5;
        else
            this.currentHP = this.baseHP;
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
    public void decScore() {
        if(this.score > 0)
            this.score --;
    }
    public void resetScore() {
        this.score = 0;
    }
}
