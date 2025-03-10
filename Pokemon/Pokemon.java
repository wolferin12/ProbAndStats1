public class Pokemon extends Card {
    private int hp;
    private int attack;
    // private int spAttack;
    //private int spDefense;
    private int speed;
    private int defense;

    public int getHp() {
        return hp;
    }
    public void setHp(int userInputHP){
        hp=userInputHP;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int userAttack){
        attack=userAttack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int userSpeed) {speed= userSpeed;
    }
    public int getDefense(){
        return defense;
    }

    public void setDefense(int userDefense) {
        defense = userDefense;
    }
    public String toString() {
        return this.getClass().getSimpleName(); // + " (HP: " + hp + ")";
    }
}
