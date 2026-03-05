package com.milton.gestionar_usuario.controller;

import com.milton.gestionar_usuario.dto.OrderCreateDTO;
import com.milton.gestionar_usuario.dto.OrderDTO;
import com.milton.gestionar_usuario.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody OrderCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getByUser (@PathVariable Long userId){
        return ResponseEntity.ok(orderService.getOrdersByUser(userId));
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<OrderDTO>> getByDescriptionContaining(@PathVariable String description){
        return ResponseEntity.ok(orderService.getByDescriptionContaining(description));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
