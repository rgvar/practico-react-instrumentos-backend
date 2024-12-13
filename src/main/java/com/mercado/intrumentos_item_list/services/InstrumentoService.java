package com.mercado.intrumentos_item_list.services;

import com.mercado.intrumentos_item_list.entities.Instrumento;
import com.mercado.intrumentos_item_list.repositories.CategoriaRepository;
import com.mercado.intrumentos_item_list.repositories.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InstrumentoService {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    private CategoriaRepository categoriaRepository;

    public List<Instrumento> getAllInstrumentos() {
        return instrumentoRepository.findAll();
    }

    public Instrumento getInstrumentoById(Long id) {
        return instrumentoRepository.findById(id).orElse(null);
    }

    public List<Instrumento> getInstrumentoByCategoriaId(Long idCategoria) {
        return instrumentoRepository.findByCategoriaId(idCategoria);

    }

    public List<Instrumento> searchInstrumento(String search) {
        return instrumentoRepository.findByAnything(search);
    }

    public Instrumento saveInstrumentos(Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }

    public Instrumento updateInstrumento(Long id, Instrumento instrumento) {
        Optional<Instrumento> existingInstrumento = instrumentoRepository.findById(id);
        if (existingInstrumento.isPresent()) {
            Instrumento newInstrumento = existingInstrumento.get();
            newInstrumento = instrumento;
            return instrumentoRepository.save(newInstrumento);
        } else {
            throw new RuntimeException("Instrumento no encontrado con el ID: " + instrumento.getId());
        }
    }

    public Boolean deleteInstrumento(Long id) throws Exception{
        try {
            Optional<Instrumento> autorOptional = instrumentoRepository.findById(id);
            if (autorOptional.isPresent()) {
                instrumentoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception("No se encontró instrumento con id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
