package com.example.productos.Producto;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @PostMapping
    public void createProducto(@RequestBody Producto producto) {
        productoService.createProducto(producto);
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> getProductoById(@PathVariable Integer id) {
        return productoService.getProductoById(id);
    }

    @PutMapping("/{id}")
    public void updateProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        producto.setId(id);
        productoService.updateProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Integer id) {
        productoService.deleteProducto(id);
    }
}