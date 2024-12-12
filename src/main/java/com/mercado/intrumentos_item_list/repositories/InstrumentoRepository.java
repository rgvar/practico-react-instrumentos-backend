package com.mercado.intrumentos_item_list.repositories;

import com.mercado.intrumentos_item_list.entities.Instrumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {

}
