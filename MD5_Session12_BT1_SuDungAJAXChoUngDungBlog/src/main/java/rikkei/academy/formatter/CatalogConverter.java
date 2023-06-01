package rikkei.academy.formatter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rikkei.academy.model.Catalog;
import rikkei.academy.service.catalog.ICatalogService;

import java.util.Optional;
@Component
public class CatalogConverter implements Converter<String, Catalog> {
    private ICatalogService catalogService;
    @Autowired
    public CatalogConverter(ICatalogService catalogService){
        this.catalogService = catalogService;
    }
    @Override
    public Catalog convert(String source) {
        Optional<Catalog> optionalCatalog = catalogService.findById(Long.valueOf(source));
        return optionalCatalog.orElse(null);
    }
}
