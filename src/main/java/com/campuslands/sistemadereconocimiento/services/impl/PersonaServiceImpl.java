package com.campuslands.sistemadereconocimiento.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.sistemadereconocimiento.repositories.RepositoryPersona;
import com.campuslands.sistemadereconocimiento.repositories.entities.Persona;
import com.campuslands.sistemadereconocimiento.services.PersonaService;

import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private RepositoryPersona repositoryPersona;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> findAll() {
        return (List<Persona>) repositoryPersona.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Long id) {
        return repositoryPersona.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    @Override
    @Transactional
    public Persona save(Persona persona) {
        return repositoryPersona.save(persona);
    }

    @Override
    @Transactional
    public String update(Persona persona) {
        Long id = persona.getId();
        Optional<Persona> personaOptinal=repositoryPersona.findById(id);
        if(personaOptinal.isPresent()){
            repositoryPersona.save(persona);
            return "Persona editada";
        }else{
            return "id no encontrado";
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Persona> personaOptinal = repositoryPersona.findById(id);
        if (personaOptinal.isPresent()) {
            repositoryPersona.delete(personaOptinal.get());
        }
    }

    @Override
    public String encontrarSospechoso(String cromosoma) {
        List<Persona> listPersonas = (List<Persona>) findAll();
        Persona sospechoso = null;
        double mayorCoincidencia = 0;
        double coincidencias;

        if (listPersonas.isEmpty()) {
            return "No hay datos de personas";
        } else {
            for (Persona persona : listPersonas) {
                coincidencias = 0;
                for (int i = 0; i < cromosoma.length(); i++) {
                    if (cromosoma.charAt(i) == persona.getCromosoma().charAt(i)) {
                        coincidencias++;
                    }
                }
                double porcentajeCoincidencia = (coincidencias / cromosoma.length()) * 100;
                if (porcentajeCoincidencia > mayorCoincidencia) {
                    mayorCoincidencia = porcentajeCoincidencia;
                    sospechoso = persona;
                }
            }
        }
        return "Sospechoso: " + sospechoso.getNombre() + " " + sospechoso.getApellido() +
                ", Porcentaje de parentezco: " + mayorCoincidencia + "%";
    }

}
