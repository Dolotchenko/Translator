package com.example.demo.repositories;

import com.example.demo.entities.RusToEngEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsRusToEngRepository extends CrudRepository<RusToEngEntity, Long> {
    List<RusToEngEntity> findRusToEngEntityByRussian(String word);
}
