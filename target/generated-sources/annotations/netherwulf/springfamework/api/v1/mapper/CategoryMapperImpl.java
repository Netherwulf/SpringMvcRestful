package netherwulf.springfamework.api.v1.mapper;

import javax.annotation.Generated;
import netherwulf.springfamework.api.v1.model.CategoryDTO;
import netherwulf.springfamework.domain.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-09-11T23:22:58+0200",
    comments = "version: 1.2.0.CR2, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }
}
