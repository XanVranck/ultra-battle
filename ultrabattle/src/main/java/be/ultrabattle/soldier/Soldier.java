package be.ultrabattle.soldier;

import be.ultrabattle.weapon.Weapon;

public interface Soldier {
    Weapon getWeapon();
    int getDamage();
    int getHealth();
    void validateAndInitializeWeapon(Weapon weapon);
}
