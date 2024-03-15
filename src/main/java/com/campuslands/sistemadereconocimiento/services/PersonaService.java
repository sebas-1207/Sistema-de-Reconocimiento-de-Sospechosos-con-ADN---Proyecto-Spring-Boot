package com.campuslands.sistemadereconocimiento.services;

import java.util.List;

import com.campuslands.sistemadereconocimiento.repositories.entities.Persona;

public interface PersonaService {

    List<Persona> findAll();

    Persona findById(Long id);

    Persona save(Persona persona);

    String update(Persona persona);

    void delete(Long id);

    String encontrarSospechoso(String cromosoma);

}
