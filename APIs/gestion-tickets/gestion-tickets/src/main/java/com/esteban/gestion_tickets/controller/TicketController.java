package com.esteban.gestion_tickets.controller;


import com.esteban.gestion_tickets.dto.StatusUpdateDTO;
import com.esteban.gestion_tickets.dto.TicketCreateDTO;
import com.esteban.gestion_tickets.dto.TicketDTO;
import com.esteban.gestion_tickets.dto.TicketUpdateDTO;
import com.esteban.gestion_tickets.enums.Priority;
import com.esteban.gestion_tickets.enums.Status;
import com.esteban.gestion_tickets.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    // ----------------------- create -----------------------

    @PostMapping
    public ResponseEntity<TicketDTO> create(@RequestBody TicketCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.create(dto));
    }

    // ----------------------- getById -----------------------

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(ticketService.getById(id));
    }

    // ----------------------- getAll -----------------------

    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAll(){
        return ResponseEntity.ok(ticketService.getAll());
    }

    // ----------------------- getByTitle -----------------------

    @GetMapping("/title/{title}")
    public ResponseEntity<List<TicketDTO>> getByTitleContainsIgnoreCase(@PathVariable String title){
        return ResponseEntity.ok(ticketService.getByTitleContainsIgnoreCase(title));
    }

    // ----------------------- getByStatus -----------------------

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TicketDTO>> getByStatus(@PathVariable Status status){
        return ResponseEntity.ok(ticketService.getByStatus(status));
    }

    // ----------------------- getByPriority -----------------------

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<TicketDTO>> getByPriority(@PathVariable Priority priority){
        return ResponseEntity.ok(ticketService.getByPriority(priority));
    }

    // ----------------------- getByAssigneeEmail -----------------------

    @GetMapping("/email/{email}")
    public ResponseEntity<List<TicketDTO>> getByAssigneeEmail(@PathVariable String email){
        return ResponseEntity.ok(ticketService.getByAssigneeEmail(email));
    }

    // ----------------------- patch un solo dato, = Actualizar un solo dato. -----------------------

    @PatchMapping("/{id}/status")
    public ResponseEntity<TicketDTO> updateStatus(@PathVariable Long id, @RequestBody StatusUpdateDTO dto){
        return ResponseEntity.ok(ticketService.updateStatus(id, dto))
    }

    // ----------------------- Update -----------------------

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> update(@PathVariable Long id, @RequestBody TicketUpdateDTO dto){
        return ResponseEntity.ok(ticketService.update(id, dto));
    }

    // ----------------------- Delete -----------------------

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        ticketService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
