/*
 * Ben Schroeder
 *
 * A tester class made to test TextManagers various functions
 */

public class TextManagerTester {
    public static void main(String[] args) {
        TextManager textManager = new TextManager("Test Files\\Part3Assignment2.txt");
        String write1 = """
                "Hello there,"
                "Are you reading this?"
                """;
        int numE = 5;
        textManager.writeFile(write1);

        assert numE == textManager.scanOccurrences('e');

        textManager.readFile();
        String write2 = """
                "I have been appended."
                """;
        numE += 5;

        textManager.appendFile(write2);
        textManager.readFile();

        assert numE == textManager.scanOccurrences('e');
    }
}
