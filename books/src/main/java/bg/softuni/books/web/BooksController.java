package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.service.AuthorService;
import bg.softuni.books.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/books")
public class BooksController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BooksController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping(value = "/addBook")
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        this.authorService.save(bookDTO.getAuthor());
        this.bookService.save(bookDTO);

        return ResponseEntity.ok().build();
    }




}
