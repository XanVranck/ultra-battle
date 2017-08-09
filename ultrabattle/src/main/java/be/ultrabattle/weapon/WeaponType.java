package be.ultrabattle.weapon;

public enum WeaponType {
    BAREFIST(1, 0),
    RABIES(2,1);

    private int damage;
    private int[] rank;

    WeaponType(int damage, int ... rank) {
        this.damage = damage;
        this.rank = rank;
    }

    public int getDamage() {
        return damage;
    }

    public int[] getRank() {
        return rank;
    }


}
