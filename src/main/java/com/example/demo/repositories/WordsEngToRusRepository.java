package com.example.demo.repositories;

import com.example.demo.entities.EngToRusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsEngToRusRepository extends CrudRepository<EngToRusEntity, Long>  {
    List<EngToRusEntity> findEngToRusEntityByEnglish(String word);
}