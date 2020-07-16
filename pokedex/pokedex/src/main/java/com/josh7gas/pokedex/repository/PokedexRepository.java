package com.josh7gas.pokedex.repository;

import com.josh7gas.pokedex.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PokedexRepository extends ReactiveMongoRepository<Pokemon, String> {


}
