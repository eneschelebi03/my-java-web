package bg.softuni.battleships.model.dto;

import javax.validation.constraints.Positive;

public class BattleShipDTO {

    @Positive
    private long attackerShipId;

    @Positive
    private long defenderShipId;

    public long getAttackerShipId() {
        return attackerShipId;
    }

    public BattleShipDTO setAttackerShipId(long attackerShipId) {
        this.attackerShipId = attackerShipId;
        return this;
    }

    public long getDefenderShipId() {
        return defenderShipId;
    }

    public BattleShipDTO setDefenderShipId(long defenderShipId) {
        this.defenderShipId = defenderShipId;
        return this;
    }
}
