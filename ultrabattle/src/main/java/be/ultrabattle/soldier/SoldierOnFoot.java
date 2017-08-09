package be.ultrabattle.soldier;

public class SoldierOnFoot implements Soldier {
    private Weapon weapon;

    public SoldierOnFoot(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public Weapon getWeapon() {
        return null;
    }

    @Override
    public String toString() {
        return "SoldierOnFoot{" +
                "weapon=" + weapon +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SoldierOnFoot that = (SoldierOnFoot) o;

        return weapon != null ? weapon.equals(that.weapon) : that.weapon == null;
    }

    @Override
    public int hashCode() {
        return weapon != null ? weapon.hashCode() : 0;
    }
}
