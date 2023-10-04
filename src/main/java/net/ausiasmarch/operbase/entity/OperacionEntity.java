package net.ausiasmarch.operbase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "operacion")
public class OperacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    
    private String operacion;

    public OperacionEntity() {
    }

    public OperacionEntity(String operacion) {
        this.operacion = operacion;
    }

    public Long getId() {
        return id;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

}
