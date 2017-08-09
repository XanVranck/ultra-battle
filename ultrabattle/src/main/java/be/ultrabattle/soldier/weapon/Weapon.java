package be.ultrabattle.soldier.weapon;

public class Weapon {
    private WeaponType weaponType;

    public Weapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponType=" + weaponType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weapon weapon = (Weapon) o;

        return weaponType == weapon.weaponType;
    }

    @Override
    public int hashCode() {
        return weaponType != null ? weaponType.hashCode() : 0;
    }
}
