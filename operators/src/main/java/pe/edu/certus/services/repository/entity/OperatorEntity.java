package pe.edu.certus.services.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "operators")
@Getter
@Setter
public class OperatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String cellphone;
    @Column (nullable = false)
    private Boolean status;
    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp timestamp;

}
