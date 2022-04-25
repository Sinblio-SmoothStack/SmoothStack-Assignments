package Demo_2.UI;

public class Emp1 implements BasicScreen {

    public Emp1() {
        print();
    }

    @Override
    public BasicScreen update(String input) {
        try {
            int in = Integer.parseInt(input);

            if (in == 1)
                return null; //TODO
            if (in == 2)
                return new MainMenu();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Invalid entry please try again");
        return this;
    }

    private void print() {
        System.out.print(
                """
                            1) Enter Flights You Manage
                            2) Quit to previous
                            
                        >"""
        );
    }
}
