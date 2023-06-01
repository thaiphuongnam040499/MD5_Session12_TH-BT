package rikkei.academy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cId")
    @JsonIgnoreProperties("listBlog")
    private Catalog catalog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Blog() {
    }

    public Blog(Long id, String title, String message, Catalog catalog) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.catalog = catalog;
    }

    public Blog(String title, String message, Catalog catalog) {
        this.title = title;
        this.message = message;
        this.catalog = catalog;
    }
}
