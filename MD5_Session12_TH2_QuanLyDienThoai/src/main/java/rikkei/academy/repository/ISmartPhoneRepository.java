package rikkei.academy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.SmartPhone;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
    Iterable<SmartPhone> findAllByProducerContaining(String producer);
}
