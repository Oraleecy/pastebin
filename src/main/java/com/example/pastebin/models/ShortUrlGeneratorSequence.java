package com.example.pastebin.models;


import jakarta.persistence.*;


@Entity
@SequenceGenerator(name = "url_generator_sequence",sequenceName = "url_generator_sequence",allocationSize = 1)
public class ShortUrlGeneratorSequence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "url_generator_sequence")
    private Long id;

    public Long getId() {
        return id;
    }
}
