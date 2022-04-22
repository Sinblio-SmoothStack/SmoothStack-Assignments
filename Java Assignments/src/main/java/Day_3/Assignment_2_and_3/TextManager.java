package Day_3.Assignment_2_and_3;/*
 * Ben Schroeder
 *
 * An object that read, scan, and append a given file
 */

import java.io.*;

public class TextManager {

    private File myFile;

    /**
     * Constructor
     *
     * @param filePath the path of the file to be opened
     */
    public TextManager(String filePath) {
        myFile = new File(filePath);
    }

    /**
     * Reads the file stored in myFile and prints the contents to console
     */
    public void readFile() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(myFile));
            String input = in.readLine();

            while (input != null) {
                System.out.println(input);
                input = in.readLine();
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found @ " + myFile.getPath());
        } catch (IOException e) {
            System.out.println("IO exception occurred @ " + myFile.getPath());
        }
    }

    /**
     * The file is appended adding the text in toWrite to the end of and existing file
     *
     * @param toWrite the text to be added to the file
     */
    public void appendFile(String toWrite) {
        try {
            // Chose not to use buffered writer since everything is written at once
            FileWriter out = new FileWriter(myFile, true);
            out.write(toWrite);
            out.close();
        } catch (IOException e) {
            System.out.println("IO exception occurred @ " + myFile.getPath());
        }
    }

    /**
     * This file is overwritten replacing all text with the text that is contained within to write
     *
     * @param toWrite the text that will be written
     */
    public void writeFile(String toWrite) {
        try {
            // Chose not to use buffered writer since everything is written at once
            FileWriter out = new FileWriter(myFile);
            out.write(toWrite);
            out.close();
        } catch (IOException e) {
            System.out.println("IO exception occurred @ " + myFile.getPath());
        }
    }

    /**
     * scans the file counting the occurrences of key within the file
     *
     * @param key a provided char to search for
     * @return the number of occurrences of key within the file
     */
    public int scanOccurrences(char key) {
        int count = 0;
        try {
            BufferedReader in = new BufferedReader(new FileReader(myFile));
            String input = in.readLine();

            while (input != null) {
                count += input.chars().filter(ch -> ch == key).count();
                input = in.readLine();
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found @ " + myFile.getPath());
        } catch (IOException e) {
            System.out.println("IO exception occurred @ " + myFile.getPath());
        }

        return count;
    }


}
