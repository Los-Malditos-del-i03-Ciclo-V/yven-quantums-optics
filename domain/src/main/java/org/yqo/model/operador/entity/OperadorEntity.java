package org.yqo.model.operador.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Table(name = "operador")
@NamedQueries({
        @NamedQuery(name = "OperadorEntity.findAll", query = "SELECT o FROM OperadorEntity o"),
        @NamedQuery(name = "OperadorEntity.findById", query = "SELECT o FROM OperadorEntity o WHERE o.id = :id"),
        @NamedQuery(name = "OperadorEntity.findByNombre", query = "SELECT o FROM OperadorEntity o WHERE o.nombre = :nombre"),
        @NamedQuery(name = "OperadorEntity.findByCorreo", query = "SELECT o FROM OperadorEntity o WHERE o.correo = :correo"),
        @NamedQuery(name = "OperadorEntity.findByCelular", query = "SELECT o FROM OperadorEntity o WHERE o.celular = :celular"),
//        @NamedQuery(name = "OperadorEntity.findByFecha", query = "SELECT o FROM OperadorEntity o WHERE o.fecha = :fecha"),
        @NamedQuery(name = "OperadorEntity.findByEstado", query = "SELECT o FROM OperadorEntity o WHERE o.estado = :estado"),
        @NamedQuery(name = "OperadorEntity.findByRol", query = "SELECT o FROM OperadorEntity o WHERE o.rol = :rol")
})

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OperadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerate
    @Basic( optional = false )
    @Column( name = "id")
    private Integer id;
    
    @Column( name = "nombre")
    private String nombre;

    @Column( name = "correo")
    private String correo;

    @Column( name = "celular" )
    private Long celular;

//    @Column( name = "fecha" )
//    private String fecha;

    @Column( name = "estado" )
    private Boolean estado;

    @Column( name = "rol" )
    private String rol;

}
