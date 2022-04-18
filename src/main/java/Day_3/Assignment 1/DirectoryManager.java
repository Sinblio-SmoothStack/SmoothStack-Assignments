/*
 * Ben Schroeder
 *
 * An object that sores a file path and is able to print the contents of a directory and its sub-directories
 */

import java.io.File;

public class DirectoryManager {

    File myFile;

    /**
     * Constructor
     *
     * @param filePath the path to the file or directory to be stored
     */
    public DirectoryManager(String filePath) {
        myFile = new File(filePath);
    }

    /**
     * Prints the absolute path of the stored file then calls the recursive printInfo method
     */
    public void printInfo(){
        System.out.println("Printing files and directories within : " + myFile.getPath());
        printInfo(myFile, 0);
    }

    /**
     * A recursive method printing a given file and directory and its contents
     *
     * @param toPrint the file/directory to print the info of and its contents
     * @param depth the depth of the current object for correct tab indenting
     */
    private void printInfo(File toPrint, int depth) {
        if (toPrint.exists()) {
            if(toPrint.isDirectory()) {
                System.out.println("|\t".repeat(depth) + toPrint.getName());
                for(File f: toPrint.listFiles()) {
                    printInfo(f, depth + 1);
                }
            } else {
                System.out.println("|\t".repeat(depth) + toPrint.getName());
            }
        } else {
            System.out.println(toPrint.toPath() + " : File not found!.");
        }
    }
}
