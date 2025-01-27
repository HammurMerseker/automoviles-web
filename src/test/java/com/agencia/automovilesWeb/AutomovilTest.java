package com.agencia.automovilesWeb;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class AutomovilTest {

    @Test
    public void testAcelerar() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        auto.acelerar(100);
        // Assertions para verificar el comportamiento de acelerar
    }

    @Test
    public void testFrenar() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        auto.acelerar(100);
        assertEquals(100, auto.getVelocidad());  // This is correct
        auto.frenar();
        // Here, the speed should be 50 after braking, not 0
        assertEquals(0, auto.getVelocidad()); // This might be failing
    }

    @Test
    public void testFrenarDetenido(){
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        auto.frenar();
        assertEquals(0, auto.getVelocidad());
    }


    @Test
    public void testGirarIzquierda() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        auto.girarIzquierda();
        // Assertions para verificar el comportamiento de girarIzquierda
    }

    @Test
    public void testGirarDerecha() {
        Automovil auto = new Automovil("Toyota", "Corolla", "Rojo");
        auto.girarDerecha();
        // Assertions para verificar el comportamiento de girarDerecha
    }
}


