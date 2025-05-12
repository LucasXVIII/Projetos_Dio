package com.example.livros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping
    public List<Livro> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Livro adicionar(@RequestBody Livro livro) {
        return service.adicionar(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable int id, @RequestBody Livro livro) {
        return service.atualizar(id, livro);
    }

    @DeleteMapping("/{id}")
    public String remover(@PathVariable int id) {
        service.remover(id);
        return "Livro removido com sucesso";
    }
}
