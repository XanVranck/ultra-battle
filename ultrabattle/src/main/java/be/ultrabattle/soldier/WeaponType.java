package be.ultrabattle.soldier;

public enum WeaponType {
    BAREFIST(1);

    private int damage;

    WeaponType(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}