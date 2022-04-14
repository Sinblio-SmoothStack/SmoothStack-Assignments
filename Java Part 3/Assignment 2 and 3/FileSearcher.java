/*
 * Ben Schroeder
 *
 * Takes command line arguments being a file and char, then prints the occurrences of that char within that file.
 */

public class FileSearcher {
    public static void main(String[] args) {
        if (args.length >= 2) {
            String filename = args[0];
            char key = args[1].charAt(0);
            System.out.println(filename + " " + key);

            TextManager textManager = new TextManager(filename);
            textManager.readFile();
            int occurrences = textManager.scanOccurrences(key);
            System.out.println("'" + key + "' occurred " + occurrences + " times");
        } else {
            System.out.println("Unexpected number of arguments: provide file path and key.");
        }
    }
}
