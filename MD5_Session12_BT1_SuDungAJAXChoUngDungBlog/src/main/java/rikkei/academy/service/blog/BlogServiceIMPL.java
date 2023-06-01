package rikkei.academy.service.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rikkei.academy.model.Blog;
import rikkei.academy.repository.IBlogRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceIMPL implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable, Sort sort) {
        pageable = PageRequest.of(pageable.getPageNumber(), 5,sort);
        return blogRepository.findAll(pageable);
    }

//    @Override
//    public Iterable<Blog> searchBlog(String nameSearch) {
//        return blogRepository.searchBlog(nameSearch);
//    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long aLong) {
        blogRepository.deleteById(aLong);
    }
}
