package be.ultrabattle.soldier;

import be.ultrabattle.errorhandler.WeaponNotSuitableForSoldier;
import be.ultrabattle.weapon.Weapon;
import org.junit.Test;

import static be.ultrabattle.weapon.WeaponType.BAREFIST;
import static be.ultrabattle.weapon.WeaponType.RABIES;
import static org.assertj.core.api.Java6Assertions.*;

public class SoldierOnFootTest {

    @Test
    public void makeSoldierWithNonSuitableWeapon_shouldGiveWeaponNotSuitableForSoldierException() throws Exception {
        assertThatThrownBy(() -> new SoldierOnFoot(new Weapon(RABIES))).isInstanceOf(WeaponNotSuitableForSoldier.class).hasMessage("RABIES is not suitable for soldier on foot.");
    }

    @Test
    public void testOnGettersJustToSeeThatNoExceptionIsThrown() throws Exception {
        Weapon barefist = new Weapon(BAREFIST);
        Soldier sof = new SoldierOnFoot(barefist);

        assertThat(sof.getWeapon()).isEqualTo(barefist);
    }
}