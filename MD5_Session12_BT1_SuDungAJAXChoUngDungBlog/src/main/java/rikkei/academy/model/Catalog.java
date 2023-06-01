package rikkei.academy.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "catalogs")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cId;
    private String cName;
    @OneToMany(mappedBy = "catalog",targetEntity = Blog.class, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("catalog")
    private List<Blog> listBlog;

    public Catalog(Long cId, String cName, List<Blog> listBlog) {
        this.cId = cId;
        this.cName = cName;
        this.listBlog = listBlog;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }


    public List<Blog> getListBlog() {
        return listBlog;
    }

    public void setListBlog(List<Blog> listBlog) {
        this.listBlog = listBlog;
    }

    public Catalog() {
    }
}
