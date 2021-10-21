package Meteo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ayuda {
    public void filtrado() {
        Scanner userInput = new Scanner(System.in);
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "Datos" + File.separator + "calidad_aire_datos_mes.csv");;

        String fileData = "";
        try (Scanner reader = new Scanner(file);) {
            // Read the header line so we don't deal with it again
            fileData = reader.nextLine();

    /* Prompt User for input.
       - If nothing is entered for either the first name and the
         last name then all records are to be considered 'found'.

       - If nothing is provided for the first name and a last name
         is provided then all records containig that last name are
         considered as 'found'.

       - If the first name is provided but the last name is not
         provided then all records containing that first name are
         considered as 'found'.

       - If the first name is provided and the last name is provided
         then all records containing that first name and that last
         name are considered as 'found'.                        */
            System.out.print("Enter first name: --> ");
            String fName = userInput.nextLine().trim();
            System.out.print("Enter last name: --> ");
            String lName = userInput.nextLine().trim();

    /* Use an ArrayList or List Interface object to hold any
       found records. Use this because a List can grow dynamically  */
            List<String> foundRecords = new ArrayList<>();
            boolean found = false;
            while (reader.hasNextLine()) {
                fileData = reader.nextLine().trim();
                // Skip blank lines (if any).
                if (fileData.isEmpty()) {
                    continue;
                }

        /* The 'Regular Expression' (regex) to use in the String#split() method.
           This will handle any spacing around the comma delimiter when splitting.
           This eliminate the need to carry out array element trimming of leading
           or trailing whitespaces.                                            */
                String regex = "\\s*; \\s*";
                String[] lineParts = fileData.split(regex);
        /* Based on the header line information we know that First Name
           data is going to be in column index 0 and the Last Name data
           is going to be in column index 1.                  */
                found = (fName.isEmpty() && lName.isEmpty()) ||
                        (lineParts[5].equalsIgnoreCase(fName) && lName.isEmpty()) ||
                        (fName.isEmpty() && lineParts[2].equalsIgnoreCase(lName)) ||
                        (lineParts[5].equalsIgnoreCase(fName) && lineParts[2].equalsIgnoreCase(lName));
                if (found) {
                    foundRecords.add(fileData);
                    found = false;
                }
            }

            // Display found records (if any)
            System.out.println();
            System.out.println("Found Records:");
            System.out.println("======");
            if (foundRecords.isEmpty()) {
                System.out.println("         No Records Found!");
            } else {
                for (String str : foundRecords) {
                    System.out.println(str);
                }
            }
            System.out.println("======");
        } catch (FileNotFoundException ex) {
            Logger.getLogger("Method Has An Error!").log(Level.SEVERE, null, ex);
        }


    }
}
