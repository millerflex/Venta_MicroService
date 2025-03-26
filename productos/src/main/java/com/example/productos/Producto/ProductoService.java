package com.example.productos.Producto;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {
    private final ProductoRepository productoRepo;

    public void createProducto(Producto producto) {
        productoRepo.save(producto);
    }

    public List<Producto> getAllProductos() {
        return productoRepo.findAll();
    }

    public Optional<Producto> getProductoById(Integer id) {
        return productoRepo.findById(id);
    }

    public void updateProducto(Producto producto) {
        productoRepo.save(producto);
    }

    public void deleteProducto(Integer id) {
        productoRepo.deleteById(id);
    }
}