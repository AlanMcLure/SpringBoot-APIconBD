package net.ausiasmarch.operbase.bean;

public class OperacionBean {
    private Double operando1;
    private Double operando2;
    private String operador;

    // Constructores, getters y setters

    public OperacionBean() {
        // Constructor vacío
    }

    public OperacionBean(Double operando1, Double operando2, String operador) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
    }

    public Double getOperando1() {
        return operando1;
    }

    public void setOperando1(Double operando1) {
        this.operando1 = operando1;
    }

    public Double getOperando2() {
        return operando2;
    }

    public void setOperando2(Double operando2) {
        this.operando2 = operando2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}

