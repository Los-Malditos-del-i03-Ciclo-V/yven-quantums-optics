package org.yqo.persistence.entity.operador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yqo.model.operador.entity.OperadorEntity;

@Repository
public interface OperadorRepository extends JpaRepository <OperadorEntity, Integer> {
}
