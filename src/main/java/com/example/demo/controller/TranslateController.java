package com.example.demo.controller;

import com.example.demo.repositories.WordsEngToRusRepository;
import com.example.demo.repositories.WordsRusToEngRepository;
import com.example.demo.services.DbService;
import com.example.demo.services.ParserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class TranslateController {

    private final WordsEngToRusRepository wordsEngToRusRepository;
    private final WordsRusToEngRepository wordsRusToEngRepository;
    private final DbService dbService;
    private final ParserService parserService;

    @GetMapping("/translate/eng/{word}")
    public String findTranslateFromEng(@PathVariable String word, Model model) {
        model.addAttribute("translates", wordsEngToRusRepository.findEngToRusEntityByEnglish(word));
        return "translate";
    }

    @GetMapping("/translate/rus/{word}")
    public String findTranslateFromRus(@PathVariable String word, Model model) {
        model.addAttribute("translates", wordsRusToEngRepository.findRusToEngEntityByRussian(word));
        return "translate";
    }
}
