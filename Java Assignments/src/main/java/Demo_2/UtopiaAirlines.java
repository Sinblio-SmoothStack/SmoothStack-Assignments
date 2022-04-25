package Demo_2;

import Demo_2.UI.MainMenu;
import Demo_2.UI.BasicScreen;

import java.util.Scanner;

public class UtopiaAirlines {
    public static void main(String[] args) {
        BasicScreen ui = new MainMenu();
        Scanner in = new Scanner(System.in);
        while (true) {
            ui = ui.update(in.next());
        }
    }
}
