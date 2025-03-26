package com.example.registros.Registro;

import lombok.Data;

@Data
public class Producto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stockActual;
    private Integer stockMinimo;
}