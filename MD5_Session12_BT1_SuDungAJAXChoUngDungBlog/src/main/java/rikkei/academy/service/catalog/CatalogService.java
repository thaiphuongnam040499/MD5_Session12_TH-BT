package rikkei.academy.service.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.Catalog;
import rikkei.academy.repository.ICatalogRepository;

import java.util.Optional;
@Service
public class CatalogService implements ICatalogService{
    @Autowired
    private ICatalogRepository catalogRepository;
    @Override
    public Iterable<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Optional<Catalog> findById(Long aLong) {
        return catalogRepository.findById(aLong);
    }

    @Override
    public void save(Catalog catalog) {
        catalogRepository.save(catalog);
    }

    @Override
    public void remove(Long aLong) {
        catalogRepository.deleteById(aLong);
    }
}
