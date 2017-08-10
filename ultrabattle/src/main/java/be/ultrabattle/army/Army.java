package be.ultrabattle.army;

import be.ultrabattle.soldier.Soldier;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Soldier> soldiers = new ArrayList<>();

    public Army() {
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public void removeSoldier(Soldier soldierOnFoot) {
        soldiers.remove(soldierOnFoot);
    }

    public Army fight(Army attackingArmy) {
        List<Soldier> soldiersDefendingArmy = this.getSoldiers();
        List<Soldier> soldiersAttackingArmy = attackingArmy.getSoldiers();
        int tempHealthDefender =  this.getSoldiers().get(0).getHealth();
        int tempHealthAttacker = attackingArmy.getSoldiers().get(0).getHealth();

        while (!soldiersDefendingArmy.isEmpty() && !soldiersAttackingArmy.isEmpty()) {
            tempHealthAttacker = defenderAttacks(tempHealthAttacker);
            tempHealthDefender = attackerAttacks(attackingArmy, tempHealthDefender);

            removeDeadSoldier(soldiersDefendingArmy, soldiersAttackingArmy, tempHealthDefender, tempHealthAttacker);
        }

        return soldiersAttackingArmy.isEmpty() ? this : attackingArmy;
    }

    private void removeDeadSoldier(List<Soldier> soldiersDefendingArmy, List<Soldier> soldiersAttackingArmy, int tempHealthDefender, int tempHealthAttacker) {
        if(tempHealthAttacker == 0){
            soldiersAttackingArmy.remove(0);
        }
        if(tempHealthDefender == 0){
            soldiersDefendingArmy.remove(0);
        }
    }

    private int attackerAttacks(Army attackingArmy, int healthDefender) {
        if (healthDefender == 0 || healthDefender < 0){
            healthDefender = this.getSoldiers().get(0).getHealth();
        }

        int attackingDamage = attackingArmy.soldiers.get(0).getDamage();
        healthDefender -= attackingDamage;

        return healthDefender <= 0 ? 0 : healthDefender;
    }

    private int defenderAttacks(int healthAttacker) {
        if (healthAttacker == 0 || healthAttacker < 0){
            healthAttacker = this.getSoldiers().get(0).getHealth();
        }

        int attackingDamage = soldiers.get(0).getDamage();
        healthAttacker -= attackingDamage;

        return healthAttacker <= 0 ? 0 : healthAttacker;
    }

    private Army defineLargestArmy(Army attackingArmy) {
        int defendingArmy = this.getSoldiers().size();
        int otherArmy = attackingArmy.getSoldiers().size();

        return defendingArmy >= otherArmy ? this : attackingArmy;
    }

    @Override
    public String toString() {
        return "Army{" +
                "soldiers=" + soldiers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Army army = (Army) o;

        return soldiers != null ? soldiers.equals(army.soldiers) : army.soldiers == null;
    }

    @Override
    public int hashCode() {
        return soldiers != null ? soldiers.hashCode() : 0;
    }
}
