package service;

import java.io.*;

public class FileWork {

    /**
     * Creates text from data file
     * @return String text variable
     */
    public static String readAsString(String filePath){
        String textFromFile = "";

        try (BufferedReader readFile = new BufferedReader(
                new FileReader(filePath))) {
            String stringBuff = "";
            while ((stringBuff = readFile.readLine()) != null) {
                textFromFile += stringBuff;
                textFromFile += "\n";
//                System.out.println(stringBuff);
            }
        }
        catch (IOException e){
            System.out.println("Error while reading file!");
            System.out.println(e.getStackTrace());
        }
        return textFromFile;
    }

}
