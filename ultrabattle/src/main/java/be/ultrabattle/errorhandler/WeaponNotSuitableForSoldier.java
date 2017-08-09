package be.ultrabattle.errorhandler;

import be.ultrabattle.soldier.Soldier;
import be.ultrabattle.weapon.WeaponType;

public class WeaponNotSuitableForSoldier extends RuntimeException {

    public WeaponNotSuitableForSoldier(WeaponType weaponType, Soldier soldier){
        super(weaponType.name() + " is not suitable for " + soldier.toString() + ".");
    }
}
