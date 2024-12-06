package pe.edu.certus.services.repository.ports.drivers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.services.repository.entity.OperatorEntity;

@Repository
public interface ForQueryingOperator extends JpaRepository<OperatorEntity, Long> {
}
