package com.formaciondbi.springboot.item.SpringbootServicioItem.controllers;

import com.formaciondbi.springboot.item.SpringbootServicioItem.models.Item;
import com.formaciondbi.springboot.item.SpringbootServicioItem.services.ItemServiceFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemServiceFeign.findAll();
    }

    @GetMapping("/ver/{id}/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemServiceFeign.getItemById(id, cantidad);
    }
}
