package com.example.registros.Registro;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroService {
    private final RegistroRepository registroRepository;
    private final RestTemplate restTemplate;

    public void registrarVenta(Registro registro) {
        // Verificar si el producto existe en el microservicio de productos
        String productoUrl = "http://localhost:8081/productos/" + registro.getProductoId();

        Producto producto = restTemplate.getForObject(productoUrl, Producto.class);

        if (producto != null) {
            registroRepository.save(registro);
        } else {
            throw new RuntimeException("El producto no existe");
        }
    }

    public List<Registro> obtenerRegistros() {
        return registroRepository.findAll();
    }

    public Registro obtenerRegistroPorId(Long id) {
        return registroRepository.findById(id).orElse(null);
    }

    public void actualizarRegistro(Registro registro) {
        registroRepository.save(registro);
    }

    public void eliminarRegistro(Long id) {
        registroRepository.deleteById(id);
    }
}