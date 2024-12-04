package pe.edu.certus.infrastructure.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ForQueryingRequest extends JpaRepository<RequestEntity, Long> {
    List<RequestEntity> findByCategory(String category);
    List<RequestEntity> findByStatus(Boolean status);
}
