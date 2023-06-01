package rikkei.academy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.Blog;

import java.util.List;
@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {
    Page<Blog> findAll(Pageable pageable);
//    @Query(value = "select * from blogs where title like %:nameSearch%", nativeQuery = true)
//    Iterable<Blog> searchBlog(@Param("nameSearch") String nameSearch);
}
