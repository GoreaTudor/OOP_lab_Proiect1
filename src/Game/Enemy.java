package Game;

public class Enemy {
    private double baseHP;
    private double currentHP;
    private double baseDMG;

    Enemy (Difficulty difficulty){
        switch (difficulty){
            case Easy:
                this.baseHP = 9;
                this.baseDMG = 3;
                break;
            case Medium:
                this.baseHP = 10;
                this.baseDMG = 4;
                break;
            case Hard:
                this.baseHP = 11;
                this.baseDMG = 4;
                break;
            case Impossible:
                this.baseHP = 12;
                this.baseDMG = 5;
                break;
        }
    }

    public boolean isAlive() {
        return (this.baseHP > 0);
    }

    public double getBaseHP() {
        return baseHP;
    }
    public void setBaseHP(double hp) {
        this.baseHP = hp;
    }

    public double getBaseDMG() {
        return baseDMG;
    }
    public void setBaseDMG(double baseDMG) {
        this.baseDMG = baseDMG;
    }
}
