package com.agencia.automovilesWeb;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AutomovilTest {

    @Mock
    private AutomovilRepository automovilRepository; // Simularemos el repositorio

    @InjectMocks
    private AutomovilService automovilService; // Simularemos el servicio

    @Test
    public void testAcelerar() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        when(automovilRepository.save(any(Automovil.class))).thenReturn(auto);
        automovilService.acelerar(auto, 100);
        assertEquals(100, auto.getVelocidad());
    }

    @Test
    public void testFrenar() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        auto.acelerar(100);
        when(automovilRepository.save(any(Automovil.class))).thenReturn(auto);
        automovilService.frenar(auto);
        assertEquals(0, auto.getVelocidad());
    }

    @Test
    public void testFrenarDetenido() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        when(automovilRepository.save(any(Automovil.class))).thenReturn(auto);
        automovilService.frenar(auto);
        assertEquals(0, auto.getVelocidad());
    }

    @Test
    public void testGirarIzquierda() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        automovilService.girarIzquierda(auto);
        // Assertions para verificar el comportamiento de girarIzquierda
    }

    @Test
    public void testGirarDerecha() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        automovilService.girarDerecha(auto);
        // Assertions para verificar el comportamiento de girarDerecha
    }
}
