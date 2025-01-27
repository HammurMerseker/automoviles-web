package com.agencia.automovilesWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/automoviles")
public class AutomovilController {

    @Autowired
    private AutomovilRepository repository;

    // Obtener todos los automóviles
    @GetMapping
    public List<Automovil> obtenerTodos() {
        return repository.findAll();
    }

    // Agregar un automóvil
    @PostMapping
    public Automovil agregarAutomovil(@RequestBody Automovil automovil) {
        return repository.save(automovil);
    }

    // Obtener un automóvil por ID
    @GetMapping("/{id}")
    public Automovil obtenerAutomovil(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Automóvil no encontrado"));
    }

    // Acelerar un automóvil
    @PostMapping("/acelerar")
    public String acelerarAutomovil(@RequestParam Integer id, @RequestParam int incremento) {
        Automovil automovil = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Automóvil no encontrado"));
        automovil.acelerar(incremento);
        repository.save(automovil);
        return "El automóvil aceleró. Velocidad actual: " + automovil.getVelocidad();
    }

    // Frenar un automóvil
    @PostMapping("/frenar")
    public String frenarAutomovil(@RequestParam Integer id) {
        Automovil automovil = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Automóvil no encontrado"));
        automovil.frenar();
        repository.save(automovil);
        return "El automóvil ha frenado. Velocidad actual: " + automovil.getVelocidad();
    }

    // Girar un automóvil
    @PostMapping("/girar")
    public String girarAutomovil(@RequestParam Integer id, @RequestParam String direccion) {
        Automovil automovil = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Automóvil no encontrado"));

        if (direccion.equalsIgnoreCase("izquierda")) {
            automovil.girarIzquierda();
        } else if (direccion.equalsIgnoreCase("derecha")) {
            automovil.girarDerecha();
        } else {
            return "Dirección inválida. Usa 'izquierda' o 'derecha'.";
        }

        return "El automóvil giró hacia: " + direccion;
    }
}
