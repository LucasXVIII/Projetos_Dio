package com.example.livros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
}
