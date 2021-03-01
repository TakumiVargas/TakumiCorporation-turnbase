package mcm.edu.ph.Turnbasedgame_TakumiCorporations;

public class GameUnit {

    int level;
    String unitName;
    int baseHealth;
    int baseMana;
    int baseArmor;
    int minDMG;
    int maxDMG;

    public GameUnit(){}
    public GameUnit(String unitName, int baseHealth, int baseMana, int minDMG, int maxDMG){
        this.unitName =         unitName;
        this.baseHealth =       baseHealth;
        this.baseMana =         baseMana;
        this.minDMG =           minDMG;
        this.maxDMG =           maxDMG;
        level =                 0;
        baseArmor =             0;
    }

}
