package com.mercado.intrumentos_item_list.repositories;

import com.mercado.intrumentos_item_list.entities.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {

}
