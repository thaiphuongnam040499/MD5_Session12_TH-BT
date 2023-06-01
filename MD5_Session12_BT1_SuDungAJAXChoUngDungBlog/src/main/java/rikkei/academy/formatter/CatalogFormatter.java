package rikkei.academy.formatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import rikkei.academy.model.Catalog;
import rikkei.academy.service.catalog.ICatalogService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;
@Component
public class CatalogFormatter implements Formatter<Catalog> {
    @Autowired
    private ICatalogService catalogService;
    @Autowired
    public CatalogFormatter(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @Override
    public Catalog parse(String text, Locale locale) throws ParseException {
        Optional<Catalog> catalogOptional = catalogService.findById(Long.parseLong(text));
        return catalogOptional.orElse(null);
    }

    @Override
    public String print(Catalog object, Locale locale) {
        return "[" + object.getcId()+ ", " +object.getcName() + "]";
    }
}
