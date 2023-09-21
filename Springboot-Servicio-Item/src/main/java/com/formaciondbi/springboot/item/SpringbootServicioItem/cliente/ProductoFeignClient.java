package com.formaciondbi.springboot.item.SpringbootServicioItem.cliente;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formaciondbi.springboot.item.SpringbootServicioItem.models.Producto;

@FeignClient(name="servicio-productos", url = "http://localhost:8001")
public interface ProductoFeignClient {
    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);
}
