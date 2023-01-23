package com.ob.args;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n**Number of args received**");
        getArgsLength(args);
        System.out.println("\n**Args positions**");
        getArgsPosition(args);
        System.out.println("\n**Arg value**");
        getArgValue(args);
        System.out.println("\n**Min and max ages**");
        getMinMaxAges(args);
    }

    public static void getArgsLength(String[] args) {
        System.out.println("args received: " + args.length);
    }

    public static void getArgsPosition(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("arg in position " + i + ": " + args[i]);
        }
    }

    public static void getArgValue(String[] args) {
        OptionsParser optionsParser = new OptionsParser(args);
        optionsParser.registerOption("minAge");
        optionsParser.registerOption("maxAge");
        optionsParser.parse();

        int minAge = optionsParser.getOption("minAge");
        System.out.printf("La edad mínima es: %s años\n", minAge);
    }

    public static void getMinMaxAges(String[] args) {
        int minAge = 0;
        int maxAge = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--minAge" -> {
                    minAge = Integer.parseInt(args[i + 1]);
                    i++;
                }
                case "--maxAge" -> {
                    maxAge = Integer.parseInt(args[i + 1]);
                    i++;
                }
            }
        }

        System.out.println("Edad mínima: " + minAge + "\nEdad máxima: " + maxAge);
    }
}
