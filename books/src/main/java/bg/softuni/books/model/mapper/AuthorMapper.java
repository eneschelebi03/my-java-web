package bg.softuni.books.model.mapper;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author authorDtoToAuthor(AuthorDTO authorDTO);
}
