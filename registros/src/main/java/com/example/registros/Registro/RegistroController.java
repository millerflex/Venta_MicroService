package com.example.registros.Registro;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/registros")
@RequiredArgsConstructor
public class RegistroController {
    private final RegistroService registroService;
    private final RestTemplate restTemplate;

    @PostMapping    
    public void registrarVenta(@RequestBody Registro registro) {
        registroService.registrarVenta(registro);
    }

    @GetMapping
    public List<Registro> obtenerRegistros() {
        return registroService.obtenerRegistros();
    }

    @GetMapping("/{id}")
    public Registro obtenerRegistroPorId(@PathVariable Long id) {
        return registroService.obtenerRegistroPorId(id);
    }

    @PutMapping("/{id}")
    public void actualizarRegistro(@PathVariable Long id, @RequestBody Registro registro) {
        registro.setId(id);
        registroService.actualizarRegistro(registro);
    }

    @DeleteMapping("/{id}")
    public void eliminarRegistro(@PathVariable Long id) {
        registroService.eliminarRegistro(id);
    }

    // Endpoint de prueba para obtener datos del producto desde el otro microservicio
    @GetMapping("/producto/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        String productoUrl = "http://localhost:8081/producto/" + id;
        return restTemplate.getForObject(productoUrl, Producto.class);
    }

    // Nuevo endpoint para obtener todos los productos
    @GetMapping("/producto")
    public List<Producto> obtenerTodosLosProductos() {
        String productosUrl = "http://localhost:8081/producto";
        return restTemplate.getForObject(productosUrl, List.class);
    }
}