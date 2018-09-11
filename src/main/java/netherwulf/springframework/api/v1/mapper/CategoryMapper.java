package netherwulf.springframework.api.v1.mapper;


import netherwulf.springframework.api.v1.model.CategoryDTO;
import netherwulf.springframework.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);
}
