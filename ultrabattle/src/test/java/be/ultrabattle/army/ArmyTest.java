package be.ultrabattle.army;

import be.ultrabattle.soldier.Soldier;
import be.ultrabattle.soldier.SoldierOnFoot;
import be.ultrabattle.weapon.Weapon;
import org.junit.*;

import java.util.*;

import static be.ultrabattle.weapon.WeaponType.BAREFIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertArrayEquals;

public class ArmyTest {
    private List<Soldier> soldiersArmyOne = new ArrayList<>();
    private List<Soldier> soldiersArmyTwo = new ArrayList<>();
    private Army armyOne;
    private Army armyTwo;
    private SoldierOnFoot sof;

    @Before
    public void setUp() throws Exception {
        armyOne = new Army();
        armyTwo = new Army();

        sof = new SoldierOnFoot(new Weapon(BAREFIST));
    }

    @Test
    public void addSoldierOnFootToArmy_shouldWork() throws Exception {
        armyOne.addSoldier(new SoldierOnFoot(new Weapon(BAREFIST)));
        soldiersArmyOne.add(sof);

        List<Soldier> actual = armyOne.getSoldiers();

        assertArrayEquals(actual.toArray(), soldiersArmyOne.toArray());
    }

    @Test
    public void removeSoldierOnFoot_shouldWork() throws Exception {
        Soldier soldierOnFoot = new SoldierOnFoot(new Weapon(BAREFIST));
        armyOne.addSoldier(soldierOnFoot);
        armyOne.removeSoldier(soldierOnFoot);
        List<Soldier> actual = armyOne.getSoldiers();

        assertThat(actual).isEmpty();
    }

    @Test
    public void fight_ArmyOneShouldWin() throws Exception {
        armyOne.addSoldier(sof);
        armyOne.addSoldier(sof);
        armyOne.addSoldier(sof);
        armyTwo.addSoldier(sof);
        Army winner = armyOne.fight(armyTwo);

        assertThat(winner).isEqualTo(armyOne);
        assertThat(winner.getSoldiers()).hasSize(2);
    }
}