package bg.softuni.battleships.service;

import bg.softuni.battleships.model.Ship;
import bg.softuni.battleships.model.dto.BattleShipDTO;
import bg.softuni.battleships.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleService {

    private final ShipRepository shipRepository;

    public BattleService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public void attack(BattleShipDTO battleShipDTO) {

        Optional<Ship> attackerOpt = this.shipRepository.findById(battleShipDTO.getAttackerShipId());
        Optional<Ship> defenderOpt = this.shipRepository.findById(battleShipDTO.getDefenderShipId());

        if (attackerOpt.isEmpty() || defenderOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        Ship attacker = attackerOpt.get();
        Ship defender = defenderOpt.get();

        long defHealth = defender.getHealth() - attacker.getPower();

        if (defHealth <= 0) {
            this.shipRepository.delete(defender);
        } else {
            defender.setHealth(defHealth);
            this.shipRepository.save(defender);
        }
    }
}
