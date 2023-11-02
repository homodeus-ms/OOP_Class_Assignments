package academy.pocu.comp2500.assignment3;

public enum UnitData {
    // unitType(Mark, sight, Aoe, ap, hp)
    MARINE('M', 2, 0, 6, 35, UnitType.GROUND),
    TANK('T', 3, 1, 8, 85, UnitType.GROUND),
    WRAITH('W', 4, 0, 6, 80, UnitType.AIR),
    TURRET('U', 2, 0, 7, 99, UnitType.GROUND),
    MINE('N', 0, 0, 10, 1, UnitType.BURROWED),
    SMART_MINE('A', 1, 1, 15, 1, UnitType.BURROWED);

    private final char mark;
    private final int sight;
    private final int aoe;
    private final int ap;
    private final int hp;
    private final UnitType unitType;


    UnitData(char mark, int sight, int aoe, int ap, int hp, UnitType unitType) {
        this.mark = mark;
        this.sight = sight;
        this.aoe = aoe;
        this.ap = ap;
        this.hp = hp;
        this.unitType = unitType;
    }

    public char getMark() {
        return mark;
    }

    public int getSight() {
        return sight;
    }

    public int getAoe() {
        return aoe;
    }

    public int getAp() {
        return ap;
    }

    public int getHp() {
        return hp;
    }

    public UnitType getUnitType() {
        return unitType;
    }
}
