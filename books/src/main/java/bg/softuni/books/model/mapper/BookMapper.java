package bg.softuni.books.model.mapper;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO bookToBookDto(Book book);

    @Mapping(target = "author", ignore = true)
    Book bookDtoToBook(BookDTO bookDTO);
}
