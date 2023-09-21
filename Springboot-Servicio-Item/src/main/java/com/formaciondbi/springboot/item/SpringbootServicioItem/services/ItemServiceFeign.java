package com.formaciondbi.springboot.item.SpringbootServicioItem.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formaciondbi.springboot.item.SpringbootServicioItem.cliente.ProductoFeignClient;
import com.formaciondbi.springboot.item.SpringbootServicioItem.models.Item;
import com.formaciondbi.springboot.item.SpringbootServicioItem.models.Producto;

@Service
public class ItemServiceFeign {
    
    @Autowired
    private ProductoFeignClient productoFeignClient;

    public List<Item> findAll(){
        // Recuperamos los datos 
        List<Producto> productos = productoFeignClient.listar();
        // Creamos una lista de Item a traves de una lista de products
        return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
      
    }

    public Item getItemById(Long id, int cantidad){
        // Recuperamos los datos 
        Producto producto = productoFeignClient.detalle(id);
        // Retornamos el item
        return new Item(producto, cantidad);
    }
}
