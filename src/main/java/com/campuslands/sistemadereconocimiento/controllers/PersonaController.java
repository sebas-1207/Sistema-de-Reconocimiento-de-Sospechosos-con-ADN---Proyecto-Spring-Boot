package com.campuslands.sistemadereconocimiento.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.sistemadereconocimiento.repositories.entities.Persona;
import com.campuslands.sistemadereconocimiento.services.PersonaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/persona")
@AllArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping("/")
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Persona findAllByString(@PathVariable Long id) {
        return personaService.findById(id);
    }

    @PostMapping("/")
    public Persona save(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/")
    public String update(@RequestBody Persona persona) {
        return personaService.update(persona);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personaService.delete(id);
    }

    @GetMapping("/encontrar-sospechoso/{cromosoma}")
    public String validCromosoma(@PathVariable String cromosoma) {
        return personaService.encontrarSospechoso(cromosoma);
    }

}
