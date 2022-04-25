package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;
import Demo_2.UI.Screens.SelectionMenu;
import Demo_2.UI.Screens.UserInput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AirplaneType implements DBTableObject{
    private int id;
    private int maxCapacityEconomy;
    private int maxCapacityBusiness;
    private int maxCapacityFirst;

    public AirplaneType() {
        this.id = 0;
        this.maxCapacityEconomy = 0;
        this.maxCapacityBusiness = 0;
        this.maxCapacityFirst = 0;
    }

    public AirplaneType(int id, int maxCapacityEconomy, int maxCapacityBusiness, int maxCapacityFirst) {
        this.id = id;
        this.maxCapacityEconomy = maxCapacityEconomy;
        this.maxCapacityBusiness = maxCapacityBusiness;
        this.maxCapacityFirst = maxCapacityFirst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxCapacityEconomy() {
        return maxCapacityEconomy;
    }

    public void setMaxCapacityEconomy(int maxCapacityEconomy) {
        this.maxCapacityEconomy = maxCapacityEconomy;
    }

    public int getMaxCapacityBusiness() {
        return maxCapacityBusiness;
    }

    public void setMaxCapacityBusiness(int maxCapacityBusiness) {
        this.maxCapacityBusiness = maxCapacityBusiness;
    }

    public int getMaxCapacityFirst() {
        return maxCapacityFirst;
    }

    public void setMaxCapacityFirst(int maxCapacityFirst) {
        this.maxCapacityFirst = maxCapacityFirst;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, economy seats: %d, business class seats: %d, first class seats: %d",
                id, maxCapacityEconomy, maxCapacityBusiness, maxCapacityFirst);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, maxCapacityEconomy);
            stmt.setInt(2, maxCapacityBusiness);
            stmt.setInt(3, maxCapacityFirst);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set maxCapacityEconomy = ?, maxCapacityBusiness = ?, maxCapacityFirst = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set maxCapacityEconomy = " + maxCapacityEconomy +
                ", maxCapacityBusiness = " + maxCapacityBusiness + ", maxCapacityFirst = ? " + maxCapacityFirst +
                " where id = " + id;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where id = " + id;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            int maxCapacityEconomy = rset.getInt("max_capacity_economy");
            int maxCapacityBusiness = rset.getInt("max_capacity_business");
            int maxCapacityFirst = rset.getInt("max_capacity_first");
            list.add(new AirplaneType(id, maxCapacityEconomy, maxCapacityBusiness, maxCapacityFirst));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "airplane_type";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        UserInput userInput = new UserInput("Enter # of economy seats:");
        userInput.draw();
        int economySeats = in.nextInt();

        userInput.updateMenuText("Enter # of business seats:");
        userInput.draw();
        int businessSeats = in.nextInt();

        userInput.updateMenuText("Enter # of first class seats:");
        userInput.draw();
        int firstSeats = in.nextInt();

        return new AirplaneType(0, economySeats, businessSeats, firstSeats);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit # of economy seats", "Edit # of business seats", "Edit # of first class seats", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    UserInput userInput = new UserInput("Enter # of economy seats:");
                    userInput.draw();
                    maxCapacityEconomy = in.nextInt();
                    toReturn = this;
                }
                case 2 -> {
                    UserInput userInput = new UserInput("Enter # of business seats:");
                    userInput.draw();
                    maxCapacityBusiness = in.nextInt();
                    toReturn = this;
                }
                case 3 -> {
                    UserInput userInput = new UserInput("Enter # of first class seats:");
                    userInput.draw();
                    maxCapacityFirst = in.nextInt();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }
}
