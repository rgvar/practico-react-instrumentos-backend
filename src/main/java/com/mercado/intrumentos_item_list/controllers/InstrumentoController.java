package com.mercado.intrumentos_item_list.controllers;

import com.mercado.intrumentos_item_list.entities.Instrumento;
import com.mercado.intrumentos_item_list.services.InstrumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrumentos")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class InstrumentoController {

    @Autowired
    private InstrumentoService instrumentoService;


    @GetMapping
    public ResponseEntity<?> getAllInstrumentos() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.getAllInstrumentos());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstrumentoById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.getInstrumentoById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createInstrumento(@RequestBody List<Instrumento> instrumentos) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.saveInstrumentos(instrumentos));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstrumento(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.deleteInstrumento(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
