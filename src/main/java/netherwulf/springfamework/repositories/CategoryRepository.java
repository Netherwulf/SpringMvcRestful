package netherwulf.springfamework.repositories;

import netherwulf.springfamework.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
