package be.ultrabattle.army;

import java.util.ArrayList;
import java.util.List;

public class Army {
    private List<Soldier> soldiers = new ArrayList<>();

    public Army() {
    }

    public void addSoldier(Soldier soldier) {
        soldiers.add(soldier);
    }

    public List<Soldier> getSoldiers() {
        return new ArrayList<>(soldiers);
    }

    public void removeSoldier(Soldier soldierOnFoot) {
        soldiers.remove(soldierOnFoot);
    }
}
