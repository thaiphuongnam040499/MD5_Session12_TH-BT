package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rikkei.academy.model.Catalog;
import rikkei.academy.service.catalog.ICatalogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {
    @Autowired
    ICatalogService catalogService;

    @GetMapping("")
    public ResponseEntity<Iterable<Catalog>> findAllCatalog() {
        List<Catalog> catalogs = (List<Catalog>) catalogService.findAll();
        if (catalogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(catalogs, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
public ResponseEntity<Catalog> findCatalogById(@PathVariable Long id){
        Optional<Catalog> catalogOptional= catalogService.findById(id);
        if (!catalogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(catalogOptional.get(),HttpStatus.OK);
    }
}
