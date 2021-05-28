package com.example.demo.entities;

import com.example.demo.dto.Dictionary;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EngToRusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 700)
    private String english;
    @Lob
    private String russian;
    @Lob
    private String comment;

    public static EngToRusEntity of(Dictionary dictionary) {
        return EngToRusEntity.builder()
                .english(dictionary.getFrom())
                .russian(dictionary.getTo())
                .comment(dictionary.getComment())
                .build();
    }
}
