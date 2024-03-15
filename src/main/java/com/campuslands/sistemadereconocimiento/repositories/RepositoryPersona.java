package com.campuslands.sistemadereconocimiento.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campuslands.sistemadereconocimiento.repositories.entities.Persona;

public interface RepositoryPersona extends CrudRepository<Persona, Long>{
    
}
