package org.example;

public class Coche {

    private int id;
    private TipoMotor tipoMotor;
    private int potencia;
    private int velocidadMax;
    private String color;

    public Coche() {
    }

    public Coche(int id, TipoMotor tipoMotor, int potencia, int velocidadMax, String color) {
        this.id = id;
        this.tipoMotor = tipoMotor;
        this.potencia = potencia;
        this.velocidadMax = velocidadMax;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id + "\r\n" +
                "tipoMotor=" + tipoMotor + "\r\n" +
                "potencia=" + potencia + "\r\n" +
                "velocidadMax=" + velocidadMax + "\r\n" +
                "color='" + color + '\'' +
                '}';
    }
}

enum TipoMotor {
    COMBUSTION,
    ELECTRICO,
    HIBRIDO
}
