package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Dictionary {

    private String from;

    private String to;

    private String comment;
}
