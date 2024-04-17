package com.calebeoliveira.spring5webapp.repositories;

import com.calebeoliveira.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
