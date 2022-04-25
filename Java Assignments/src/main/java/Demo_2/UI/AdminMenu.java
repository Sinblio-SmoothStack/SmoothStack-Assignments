package Demo_2.UI;

import Demo_2.Objects.*;

public class AdminMenu implements BasicScreen {

    public AdminMenu() {
        print();
    }

    @Override
    public BasicScreen update(String input) {
        try {
            int in = Integer.parseInt(input);
            Manager manager = new Manager();

            switch (in) {
                case 1 -> {
                    manager.crudOperation(new Flight());
                    return new AdminMenu();}
                case 2 -> {
                    manager.crudOperation(new FlightBooking());
                    return new AdminMenu();}
                case 3 -> {
                    manager.crudOperation(new Booking());
                    return new AdminMenu();}
                case 4 -> {
                    manager.crudOperation(new Airport());
                    return new AdminMenu();}
                case 5 -> {
                    manager.crudOperation(new Passenger());
                    return new AdminMenu();}
                case 6 -> {
                    manager.crudOperation(new User(), "role_id = 1");
                    return new AdminMenu();}
                case 7 -> {
                    manager.crudOperation(new Booking(), "is_active = 0");
                    return new AdminMenu(); }
                case 8 -> {
                    return new MainMenu(); }
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
                        Please select appropriate records to modify
                        
                            1) Add/Update/Delete/Read Flights
                            2) Add/Update/Delete/Read Seats
                            3) Add/Update/Delete/Read Tickets & Passengers
                            4) Add/Update/Delete/Read Airports
                            5) Add/Update/Delete/Read Travelers
                            6) Add/Update/Delete/Read Employees
                            7) Over-ride Trip Cancellation for a ticket
                            8) Quit to previous
                            
                        >"""
        );
    }
}
