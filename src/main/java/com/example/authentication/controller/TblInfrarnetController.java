package com.example.authentication.controller;

import com.example.authentication.model.TblInfrarnet;
import com.example.authentication.service.TblInfrarnetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tbl-infrarnet")
public class TblInfrarnetController {

    private final TblInfrarnetService service;

    public TblInfrarnetController(TblInfrarnetService service) {
        this.service = service;
    }

    // GET ALL: http://localhost:8080/api/tbl-infrarnet
    @GetMapping
    public List<TblInfrarnet> getAllData() {
        return service.getAll();
    }

    // GET BY ID: http://localhost:8080/api/tbl-infrarnet/{id}
    @GetMapping("/{id}")
    public ResponseEntity<TblInfrarnet> getDataById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CREATE: http://localhost:8080/api/tbl-infrarnet
    @PostMapping
    public TblInfrarnet createData(@RequestBody TblInfrarnet tblInfrarnet) {
        return service.create(tblInfrarnet);
    }

    // UPDATE: http://localhost:8080/api/tbl-infrarnet/{id}
    @PutMapping("/{id}")
    public ResponseEntity<TblInfrarnet> updateData(@PathVariable Integer id, @RequestBody TblInfrarnet tblInfrarnet) {
        try {
            return ResponseEntity.ok(service.update(id, tblInfrarnet));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: http://localhost:8080/api/tbl-infrarnet/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}