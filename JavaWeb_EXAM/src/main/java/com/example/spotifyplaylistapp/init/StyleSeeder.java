package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleType;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StyleSeeder implements CommandLineRunner {

    private StyleRepository styleRepository;

    public StyleSeeder(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.styleRepository.count() <= 0) {
            List<Style> styles = Arrays.stream(StyleType.values())
                    .map(Style::new)
                    .toList();

            this.styleRepository.saveAll(styles);
        }
    }
}
