package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rikkei.academy.model.Blog;
import rikkei.academy.model.Catalog;
import rikkei.academy.service.blog.IBlogService;
import rikkei.academy.service.catalog.ICatalogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
//@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    ICatalogService catalogService;
    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlog(){
        List<Blog> list = (List<Blog>) blogService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
//    @GetMapping("/search/{nameSearch}")
//    public ResponseEntity<Iterable<Blog>> searchTitle(@PathVariable("nameSearch") String nameSearch){
//        System.out.println("in");
//        List<Blog> list = (List<Blog>) blogService.searchBlog(nameSearch);
//        System.out.println(list);
//        if (list.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(list,HttpStatus.OK);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Long id){
        Optional<Blog> blogOptional = blogService.findById(id);
        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }
    @GetMapping("/create-blog")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("catalogs", catalogService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public String saveBlog(@ModelAttribute("blog") Blog blog, @ModelAttribute("catalogs") Catalog catalogs) {
        blogService.save(blog);
        return "redirect:/create-blog";
    }

    @GetMapping(value = {"/", "/blog"})
    public ModelAndView listCustomers(Pageable pageable, @RequestParam("sort") Optional<String> sort) {
        Sort sort1 = null;
        if (sort.isPresent()) {
            switch (sort.get()) {
                case "Title-ASC":
                    sort1 = Sort.by("title").ascending();
                    break;
                case "Title-DESC":
                    sort1 = Sort.by("title").descending();
                    break;
                default:
                    break;
            }
        } else {
            sort1 = Sort.by("title").ascending();
        }
        Page<Blog> blogs = blogService.findAll(pageable, sort1);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showFormEdit(@PathVariable("id") Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            return new ModelAndView("/blog/list");
        }
    }

    @PostMapping("/edit-blog")
    public String updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") Long id) {
        blogService.remove(id);
        return "redirect:/blog";
    }
}
