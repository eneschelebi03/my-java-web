package bg.softuni.books.service;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.Author;
import bg.softuni.books.model.entity.Book;
import bg.softuni.books.model.mapper.BookMapper;
import bg.softuni.books.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, BookMapper bookMapper, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorService = authorService;
    }

    public List<BookDTO> getAllBooks() {
        return this.bookRepository.findAll()
                .stream()
                .map(bookMapper::bookToBookDto)
                .toList();
    }

    public void save(BookDTO bookDTO) {
        Book book = this.bookMapper.bookDtoToBook(bookDTO);

        Author author = this.authorService.findByName(bookDTO.getAuthor().getName());

        book.setAuthor(author);

        this.bookRepository.save(book);
    }
}
