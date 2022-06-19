package bg.softuni.battleships.seeder;

import bg.softuni.battleships.model.Category;
import bg.softuni.battleships.model.enums.ShipType;
import bg.softuni.battleships.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategorySeed implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public CategorySeed(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(ShipType.values())
                    .map(Category::new)
                    .toList();

            categoryRepository.saveAll(categories);
        }
    }
}
