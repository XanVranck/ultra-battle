package be.ultrabattle.soldier;

import be.ultrabattle.errorhandler.WeaponNotSuitableForSoldier;
import be.ultrabattle.weapon.Weapon;

import java.util.Arrays;

public class SoldierOnFoot implements Soldier {
    private Weapon weapon;
    private int rank;

    public SoldierOnFoot(Weapon weapon) {
        this.rank = 0;
        validateAndInitializeWeapon(weapon);
    }

    private void validateAndInitializeWeapon(Weapon weapon) {
        if(isWeaponSuitableForSOF(weapon)){
            this.weapon = weapon;
        }else{
            throw new WeaponNotSuitableForSoldier(weapon.getWeaponType(), this);
        }
    }

    private boolean isWeaponSuitableForSOF(Weapon weapon) {
        int[] rank = weapon.getWeaponType().getRank();
        return Arrays.stream(rank).anyMatch(r -> r == this.rank);
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoldierOnFoot that = (SoldierOnFoot) o;

        if (rank != that.rank) return false;
        return weapon != null ? weapon.equals(that.weapon) : that.weapon == null;
    }

    @Override
    public int hashCode() {
        int result = weapon != null ? weapon.hashCode() : 0;
        result = 31 * result + rank;
        return result;
    }

    @Override
    public String toString() {
        return "soldier on foot";
    }
}
