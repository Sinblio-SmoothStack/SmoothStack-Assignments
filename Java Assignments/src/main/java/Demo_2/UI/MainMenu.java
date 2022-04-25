package Demo_2.UI;

public class MainMenu implements BasicScreen {

    public MainMenu() {
        print();
    }

    @Override
    public BasicScreen update(String input) {
        try {
            int in = Integer.parseInt(input);

            switch (in) {
                case 1 -> { return new Emp1(); }
                case 2 -> { return new AdminMenu(); }
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("Invalid entry please enter an integer");
        return this;
    }

    private void print() {
        System.out.print(
                """
                        Welcome to the Utopia Airlines Management System. Which category of a user are you?
                        
                            1) Employee/Agent
                            2) Administrator
                            3) Traveler
                            
                        >"""
        );
    }
}
