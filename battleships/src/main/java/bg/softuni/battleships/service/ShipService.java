package bg.softuni.battleships.service;

import bg.softuni.battleships.mapper.ShipMapper;
import bg.softuni.battleships.model.Category;
import bg.softuni.battleships.model.Ship;
import bg.softuni.battleships.model.User;
import bg.softuni.battleships.model.dto.AddShipDTO;
import bg.softuni.battleships.model.dto.ShipDTO;
import bg.softuni.battleships.model.enums.ShipType;
import bg.softuni.battleships.repository.CategoryRepository;
import bg.softuni.battleships.repository.ShipRepository;
import bg.softuni.battleships.repository.UserRepository;
import bg.softuni.battleships.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipService {

    private final ShipMapper shipMapper;
    private final LoggedUser loggedUser;

    private final ShipRepository shipRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public ShipService(ShipRepository shipRepository,
                       ShipMapper shipMapper,
                       CategoryRepository categoryRepository,
                       LoggedUser loggedUser,
                       UserRepository userRepository) {
        this.shipMapper = shipMapper;
        this.loggedUser = loggedUser;

        this.shipRepository = shipRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public boolean addShip(AddShipDTO addShipDTO) {

        Optional<Ship> byName = this.shipRepository.findByName(addShipDTO.getName());

        if (byName.isPresent()) {
            return false;
        }

        Ship ship = this.shipMapper.addShipDtoToShip(addShipDTO);

        Category category = this.categoryRepository
                .findByName(ShipType.valueOf(addShipDTO.getCategory()));
        ship.setCategory(category);

        Optional<User> owner = this.userRepository.findById(loggedUser.getId());
        ship.setUser(owner.get());

        this.shipRepository.save(ship);

        return true;
    }

    public List<ShipDTO> getOwnedShips() {

        List<Ship> ownedShips = this.shipRepository
                .findByUserId(loggedUser.getId());

        return ownedShips
                .stream()
                .map(shipMapper::shipToShipDTO)
                .collect(Collectors.toList());
    }

    public List<ShipDTO> getEnemyShips() {

        List<Ship> enemyShips = this.shipRepository
                .findByUserIdNot(loggedUser.getId());

        return enemyShips
                .stream()
                .map(shipMapper::shipToShipDTO)
                .collect(Collectors.toList());
    }

    public List<ShipDTO> getAllSortedShips() {
        List<Ship> allSortedShips = this.shipRepository
                .findAllByOrderByNameAscHealthAscPowerAsc();

        return allSortedShips
                .stream()
                .map(shipMapper::shipToShipDTO)
                .collect(Collectors.toList());
    }
}
