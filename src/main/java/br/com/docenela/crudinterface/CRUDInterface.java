package br.com.docenela.crudinterface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CRUDInterface<T> {

    /**
     * Listar
     * @return
     */
    @GetMapping
    List<T> listar();

    /**
     * Busca especifica por id
     * @param id
     * @return
     */
   @GetMapping(path = {"/{id}"})
   ResponseEntity buscar(@PathVariable long id);


    /**
     * Remover
     * @param id
     * @return
     */
    @DeleteMapping(path ={"/{id}"})
    ResponseEntity<?> remover(@PathVariable long id);

    /**
     * Criar novo objeto do tipo T
     * @param objeto Objeto do tipo a ser incluido
     * @return
     */
    @PostMapping
    T criar(@RequestBody T objeto);


    /**
     * Atualizar o objeto do tipo T
     * @param id
     * @param objeto
     * @return
     */
   @PutMapping(value="/{id}")
   ResponseEntity atualizar(@PathVariable("id") long id, @RequestBody T objeto);
}
