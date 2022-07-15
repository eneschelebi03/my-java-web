package bg.softuni.battleships.mapper;

import bg.softuni.battleships.model.Ship;
import bg.softuni.battleships.model.dto.AddShipDTO;
import bg.softuni.battleships.model.dto.ShipDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShipMapper {

    @Mapping(target = "category", ignore = true)
    Ship addShipDtoToShip(AddShipDTO addShipDTO);

    ShipDTO shipToShipDTO(Ship ship);
}
