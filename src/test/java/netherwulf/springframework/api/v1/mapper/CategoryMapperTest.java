package netherwulf.springframework.api.v1.mapper;

import netherwulf.springframework.api.v1.model.CategoryDTO;
import netherwulf.springframework.domain.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    public static final String NAME = "Joe";
    public static final long ID = 1L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() {

        //given
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDto = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(ID), categoryDto.getId());
        assertEquals(NAME, categoryDto.getName());
    }
}