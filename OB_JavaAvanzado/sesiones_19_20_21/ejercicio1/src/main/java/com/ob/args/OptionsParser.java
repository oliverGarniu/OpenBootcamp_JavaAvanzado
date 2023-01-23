package com.ob.args;

import java.util.HashMap;

public class OptionsParser {

    /*
    Empleamos un HashMap para utilizar key (primer parámetro del HashMap) como nombre
    de la opción y value (segundo parámetro del HashMap) como valor de dicha opción,
    que los obtiene a partir de los args que hemos añadido al editar la configuración
    de la aplicación.
     */
    private final HashMap<String, Integer> options = new HashMap<>();

    //En este caso vamos a analizar los argumentos de entrada
    private String[] args;
    int value = 0;

    private OptionsParser() {
    }

    public OptionsParser(String[] args) {
        this.args = args;
    }

    public void registerOption(String optionName) {
        options.put(optionName, value);
    }

    public Integer getOption(String optionName) {
        return options.get(optionName);
    }

    public void setValue(String optionName, int value) {
        options.replace(optionName, value);
    }

    public void parse() {
        for (int i = 0; i < args.length; i++) {
            // extraemos los guiones de las opciones
            String optionName = args[i].replace("--", "");

            if (options.containsKey(optionName)) {
                setValue(optionName, Integer.parseInt(args[i + 1]));
            }
        }
    }
}
