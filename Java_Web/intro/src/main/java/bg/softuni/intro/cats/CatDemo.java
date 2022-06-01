package bg.softuni.intro.cats;

import bg.softuni.intro.cats.models.dto.CreateOwnerDTO;
import bg.softuni.intro.cats.service.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatDemo implements CommandLineRunner {

    private final OwnerService ownerService;

    public CatDemo(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) {

        CreateOwnerDTO createOwnerDTO = new CreateOwnerDTO()
                .setOwnerName("Pehso")
                .setCatNames(List.of("Chinchila", "Gosho", "Tommy"));

        ownerService.createOwner(createOwnerDTO);
    }
}
