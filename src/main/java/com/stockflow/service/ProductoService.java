package com.stockflow.service;

import com.stockflow.model.Producto;
import com.stockflow.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    public Producto crear(Producto producto) {
        if (repository.existsBySku(producto.getSku())) {
            throw new RuntimeException("Ya existe un producto con el SKU: " + producto.getSku());
        }
        return repository.save(producto);
    }

    public Producto actualizar(Long id, Producto datos) {
        Producto producto = obtenerPorId(id);
        producto.setNombre(datos.getNombre());
        producto.setSku(datos.getSku());
        producto.setCategoria(datos.getCategoria());
        producto.setStock(datos.getStock());
        producto.setPrecio(datos.getPrecio());
        return repository.save(producto);
    }

    public void eliminar(Long id) {
        obtenerPorId(id);
        repository.deleteById(id);
    }

    public List<Producto> stockCritico() {
        return repository.findByStockLessThan(10);
    }
}