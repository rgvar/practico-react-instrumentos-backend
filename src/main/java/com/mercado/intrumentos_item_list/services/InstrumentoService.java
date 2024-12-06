package com.mercado.intrumentos_item_list.services;

import com.mercado.intrumentos_item_list.entities.Instrumento;
import com.mercado.intrumentos_item_list.repositories.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InstrumentoService {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    public List<Instrumento> getAllInstrumentos() {
        return instrumentoRepository.findAll();
    }

    public Instrumento getInstrumentoById(Long id) {
        return instrumentoRepository.findById(id).orElse(null);
    }

    public List<Long> saveInstrumentos(List<Instrumento> instrumentos) {

        List<Long> idList = new java.util.ArrayList<>(List.of());
        for (Instrumento i : instrumentos) {

            idList.add(instrumentoRepository.save(i).getId());
        }

        return idList;
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
