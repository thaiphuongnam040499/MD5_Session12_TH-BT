package rikkei.academy.service.blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import rikkei.academy.model.Blog;
import rikkei.academy.service.IGenerateService;

import java.util.List;

public interface IBlogService extends IGenerateService<Blog,Long> {
   Page<Blog> findAll(Pageable pageable, Sort sort);
//   Iterable<Blog> searchBlog(String nameSearch);
}
