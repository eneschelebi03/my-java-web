package bg.softuni.books.service;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.entity.Author;
import bg.softuni.books.model.mapper.AuthorMapper;
import bg.softuni.books.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }


    public void save(AuthorDTO authorDTO) {
        Optional<Author> byName = this.authorRepository.findByName(authorDTO.getName());

        if (byName.isEmpty()) {
            Author author = this.authorMapper.authorDtoToAuthor(authorDTO);

            this.authorRepository.save(author);
        }
    }

    public Author findByName(String name) {
        return this.authorRepository.findByName(name).get();
    }
}
