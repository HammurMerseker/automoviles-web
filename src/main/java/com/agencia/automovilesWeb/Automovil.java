package com.agencia.automovilesWeb;

import jakarta.persistence.*;

@Entity
public class Automovil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String modelo;
    private String color;
    private Integer velocidad;

    public Automovil() {} // Constructor vacío necesario para JPA

    public Automovil(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.velocidad = 0;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void acelerar(int incremento) { // Ahora acepta un argumento entero
        this.velocidad += incremento;
    }

    public void frenar() {
        // Lógica para frenar el automóvil
        this.velocidad = 0;
    }

    public void girarIzquierda() {
        // Lógica para girar a la izquierda
        System.out.println("El automóvil está girando a la izquierda.");
    }

    public void girarDerecha() {
        // Lógica para girar a la derecha
        System.out.println("El automóvil está girando a la derecha.");
    }
}

