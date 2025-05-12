package com.example.livros;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final List<Livro> livros = new ArrayList<>();

    public List<Livro> listarTodos() {
        return livros;
    }

    public Livro adicionar(Livro livro) {
        Optional<Livro> existente = livros.stream()
            .filter(l -> l.getId() == livro.getId()).findFirst();
        if (existente.isPresent()) {
            throw new RuntimeException("Livro com ID já existe");
        }
        livros.add(livro);
        return livro;
    }

    public Livro atualizar(int id, Livro atualizado) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == id) {
                livros.set(i, atualizado);
                return atualizado;
            }
        }
        throw new RuntimeException("Livro não encontrado");
    }

    public void remover(int id) {
        livros.removeIf(l -> l.getId() == id);
    }
}
