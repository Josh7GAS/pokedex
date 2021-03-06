package com.josh7gas.pokedex.controller;

import com.josh7gas.pokedex.model.Pokemon;
import com.josh7gas.pokedex.repository.PokedexRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private PokedexRepository repository;
    public PokemonController(PokedexRepository repository){this.repository = repository;}

    @GetMapping
    public Flux<Pokemon> getAllPokemon(){return repository.findAll();}

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Pokemon>> getPokemon(@PathVariable String id){
        return repository.findById(id)
                .map(pokemon -> ResponseEntity.ok(pokemon))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Pokemon> savePokemon(@RequestBody Pokemon pokemon){
        return repository.save(pokemon);
    }
}
