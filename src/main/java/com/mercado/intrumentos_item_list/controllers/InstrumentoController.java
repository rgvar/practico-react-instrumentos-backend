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
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    public ResponseEntity<?> createInstrumento(@RequestBody Instrumento instrumento) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.saveInstrumentos(instrumento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstrumento(@PathVariable Long id, @RequestBody Instrumento instrumento) {
        try {
            instrumento.setId(id);
            return ResponseEntity.status(HttpStatus.OK).body(instrumentoService.updateInstrumento(id, instrumento));
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
