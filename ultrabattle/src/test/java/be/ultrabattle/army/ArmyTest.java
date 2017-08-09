package be.ultrabattle.army;

import be.ultrabattle.soldier.Soldier;
import be.ultrabattle.soldier.SoldierOnFoot;
import be.ultrabattle.soldier.Weapon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static be.ultrabattle.soldier.WeaponType.BAREFIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class ArmyTest {
    private List<Soldier> soldiers = new ArrayList<>();
    private Army army;

    @Before
    public void setUp() throws Exception {
        army = new Army();
        soldiers.add(new SoldierOnFoot(new Weapon(BAREFIST)));
    }

    @Test
    public void addSoldierOnFootToArmy_shouldWork() throws Exception {
        army.addSoldier(new SoldierOnFoot(new Weapon(BAREFIST)));
        List<Soldier> actual = army.getSoldiers();

        assertThat(actual.get(0)).isEqualToComparingFieldByField(this.soldiers.get(0));
        assertArrayEquals(actual.toArray(), soldiers.toArray());
    }

    @Test
    public void removeSoldierOnFoot_shouldWork() throws Exception {
        Soldier soldierOnFoot = new SoldierOnFoot(new Weapon(BAREFIST));
        army.addSoldier(soldierOnFoot);
        army.removeSoldier(soldierOnFoot);
        List<Soldier> actual = army.getSoldiers();

        assertThat(actual).isEmpty();
    }
}