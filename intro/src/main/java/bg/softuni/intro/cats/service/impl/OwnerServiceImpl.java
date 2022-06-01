package bg.softuni.intro.cats.service.impl;

import bg.softuni.intro.cats.models.dto.CreateOwnerDTO;
import bg.softuni.intro.cats.models.entity.Cat;
import bg.softuni.intro.cats.models.entity.Owner;
import bg.softuni.intro.cats.repository.OwnerRepository;
import bg.softuni.intro.cats.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void createOwner(CreateOwnerDTO createOwnerDTO) {
        Owner owner = new Owner()
                .setName(createOwnerDTO.getOwnerName());

        createOwnerDTO
                .getCatNames()
                .forEach(name -> {
                    Cat cat = new Cat()
                            .setName(name)
                            .setOwner(owner);

                    owner.addCat(cat);
                });

        ownerRepository.save(owner);

    }
}
