package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;
import Demo_2.UI.Screens.SelectionMenu;
import Demo_2.UI.Screens.UserInput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Airport implements DBTableObject{
    private String iataId;
    private String city;

    public Airport() {
        iataId = null;
        city = null;
    }

    public Airport(String iataId, String city) {
        this.iataId = iataId;
        this.city = city;
    }

    public String getIataId() {
        return iataId;
    }

    public void setIataId(String iataId) {
        this.iataId = iataId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", iataId, city);
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set iata_id = ?, city = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set city = '" + city + "' where iata_id = '" + iataId + "'";
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where iata_id = '" + iataId + "'";
    }

    @Override
    public String defaultTableName() {
        return "airport";
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setString(1, iataId);
            stmt.setString(2, city);
        };
        return statementFunction;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            String iataId = rset.getString("iata_id");
            String city = rset.getString("city");
            list.add(new Airport(iataId, city));
        };
        return resultSetFunction;
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        UserInput userInput = new UserInput("Enter the IATA ID:");
        userInput.draw();
        String newIATA = in.next();

        userInput.updateMenuText("Enter the city:");
        userInput.draw();
        String city = in.next();

        return new Airport(newIATA, city);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit IATA ID", "Edit city", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    UserInput userInput = new UserInput("Enter new IATA ID:");
                    userInput.draw();
                    iataId = in.next();
                    toReturn = this;
                }
                case 2 -> {
                    UserInput userInput = new UserInput("Enter new city:");
                    userInput.draw();
                    city = in.next();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }
}
