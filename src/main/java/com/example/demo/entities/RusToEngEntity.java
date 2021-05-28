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
public class RusToEngEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Lob
    private String english;
    @Lob
    private String russian;
    @Lob
    private String comment;

    public static RusToEngEntity of(Dictionary dictionary) {
        return RusToEngEntity.builder()
                .english(dictionary.getTo())
                .russian(dictionary.getFrom())
                .comment(dictionary.getComment())
                .build();
    }
}
