package rikkei.academy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.Catalog;
@Repository
public interface ICatalogRepository extends PagingAndSortingRepository<Catalog,Long> {

}
