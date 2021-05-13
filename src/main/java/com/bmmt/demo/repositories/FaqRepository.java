package com.bmmt.demo.repositories;

import com.bmmt.demo.entities.Faq;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends CrudRepository<Faq,Long> {
}
