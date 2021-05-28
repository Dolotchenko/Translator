package com.example.demo.services;

import com.example.demo.entities.EngToRusEntity;
import com.example.demo.entities.RusToEngEntity;
import com.example.demo.repositories.WordsEngToRusRepository;
import com.example.demo.repositories.WordsRusToEngRepository;
import com.example.demo.dto.Dictionary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DbService {

    private final WordsEngToRusRepository wordsEngToRusRepository;

    private final WordsRusToEngRepository wordsRusToEngRepository;

    public void saveEngtoRus(List<Dictionary> obj) {
        wordsEngToRusRepository.saveAll(obj.stream()
        .map(EngToRusEntity::of)
        .collect(Collectors.toList()));
    }

    public void saveRusToEng(List<Dictionary> obj) {
        wordsRusToEngRepository.saveAll(obj.stream()
        .map(RusToEngEntity::of)
        .collect(Collectors.toList()));
    }
}
