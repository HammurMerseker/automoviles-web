package com.agencia.automovilesWeb;

import org.springframework.stereotype.Service;

@Service
public class AutomovilService {

    private final AutomovilRepository automovilRepository;

    public AutomovilService(AutomovilRepository automovilRepository) {
        this.automovilRepository = automovilRepository;
    }

    public void acelerar(Automovil auto, int incremento) {
        auto.acelerar(incremento);
        automovilRepository.save(auto);
    }

    public void frenar(Automovil auto) {
        auto.frenar();
        automovilRepository.save(auto);
    }

    public void girarIzquierda(Automovil auto) {
        auto.girarIzquierda();
        automovilRepository.save(auto);
    }

    public void girarDerecha(Automovil auto) {
        auto.girarDerecha();
        automovilRepository.save(auto);
    }
}
