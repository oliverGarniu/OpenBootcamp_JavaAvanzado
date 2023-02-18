package com.ob.ejercicio4.entity;

public class CocheBuilder {

    private Coche coche = new Coche();

    // Constructor vacío "private" para obligarnos a añadir el parámetro id.
    private CocheBuilder() {
    }

    public CocheBuilder(int id) {
        /*
        En este caso no es necesario inicializar los parámetros.
        El programa se ejecuta sin problemas, he definido los casos
        "null" en los métodos que aparecen a continuación y en los
        casos de parámetros de tipo "int" no me da error por no tener
        en cuenta el "null".
         */
        /*
        coche.tipoMotor = TipoMotor.NODEFINIDO;
        coche.potencia = 0;
        coche.velocidadMax = 0;
        coche.color = "Sin color";
        */

        coche.setId(id);
    }

    public CocheBuilder conTipoMotor(TipoMotor tipoMotor) {
        coche.tipoMotor = tipoMotor == null ? TipoMotor.NODEFINIDO : tipoMotor;
        return this;
    }

    public CocheBuilder conPotencia(int potencia) {
        coche.potencia = potencia > 0 ? potencia : 0;
        return this;
    }

    public CocheBuilder conVelocidadMax(int velocidadMax) {
        coche.velocidadMax = velocidadMax > 0 ? velocidadMax : 0;
        return this;
    }

    public CocheBuilder conColor(String color) {
        coche.color = color == null ? "Sin color" : color;
        return this;
    }

    public Coche build() {
        return coche;
    }
}
