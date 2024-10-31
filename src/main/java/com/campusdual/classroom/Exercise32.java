package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercise32 {

    public static void main(String[] args) {
        String textToSave = generateStringToSave(null);
        try {
            printToFile(textToSave);
            System.out.println("Texto guardado en data.txt con éxito.");
        } catch (Exception e) {
            System.err.println("Error al guardar el texto en el archivo.");
            e.printStackTrace();
        }
    }



    public static String generateStringToSave(String string) {
        if (string == null) {
            return generateUserInputToSave();
        }
        return string;
    }

    private static String generateUserInputToSave() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while (!(string = Utils.string()).isEmpty()) {
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        File file = new File("src/main/resources/data.txt");
        file.getParentFile().mkdirs();
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            pw.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





