package be.ultrabattle.soldier;

import be.ultrabattle.weapon.Weapon;

public interface Soldier {
    Weapon getWeapon();
    void validateAndInitializeWeapon(Weapon weapon);
}
