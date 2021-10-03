package Game;

public class Enemy {
    private double baseHP;
    private double currentHP;
    private double baseDMG;

    Enemy (Difficulty difficulty){
        switch (difficulty){
            case Easy:
                this.setBaseHP(8);
                this.setBaseDMG(2);
                break;
            case Medium:
                this.setBaseHP(9);
                this.setBaseDMG(3);
                break;
            case Hard:
                this.setBaseHP(10);
                this.setBaseDMG(4);
                break;
            case Impossible:
                this.setBaseHP(11);
                this.setBaseDMG(5);
                break;
        }

        this.setCurrentHP(this.getBaseHP());
    }

    public boolean isAlive() {
        return (this.currentHP > 0);
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

    public double getCurrentHP() {
        return currentHP;
    }
    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }
    public void resetCurrentHP() {
        this.currentHP = this.baseHP;
    }
    public void incCurrentHP() {
        if(this.currentHP + 0.5 <= this.baseHP)
            this.currentHP += 0.5;
        else
            this.currentHP = this.baseHP;
    }
}
