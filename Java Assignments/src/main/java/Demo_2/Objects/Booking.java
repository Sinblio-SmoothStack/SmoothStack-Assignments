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

public class Booking implements DBTableObject{
    private int id;
    private boolean isActive;
    private String confirmationCode;

    public Booking() {
        this.id = 0;
        this.isActive = false;
        this.confirmationCode = null;
    }

    public Booking(int id, boolean isActive, String confirmationCode) {
        this.id = id;
        this.isActive = isActive;
        this.confirmationCode = confirmationCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Override
    public String toString() {
        String status = "Cancelled";
        if (isActive) status = "Active";
        return String.format("Booking: id: %d, status: %s, confirmation code: %s", id, status, confirmationCode);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            int intIsActive = 0;
            if (isActive)
                intIsActive = 1;
            stmt.setInt(1, intIsActive);
            stmt.setString(2, confirmationCode);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set is_active = ?, confirmation_code = ?";
    }

    @Override
    public String updateQuery() {
        int intIsActive = 0;
        if (isActive)
            intIsActive = 1;
        return "update " + defaultTableName() + " set is_active = " + intIsActive + ", confirmation_code = " +
                confirmationCode + " where id = " + id;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where id = " + id;
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        UserInput userInput = new UserInput("Enter the Status (a for active, c for cancelled):");
        userInput.draw();
        boolean newStatus = in.next().equals("a");

        userInput.updateMenuText("Enter the confirmation code:");
        userInput.draw();
        String newConfirmationCode = in.next();

        return new Booking(0, newStatus, newConfirmationCode);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit status", "Edit confirmation code", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    UserInput userInput = new UserInput("Enter the new Status (a for active, c for cancelled):");
                    userInput.draw();
                    isActive = in.next().equals("a");
                    toReturn = this;
                }
                case 2 -> {
                    UserInput userInput = new UserInput("Enter the new confirmation code:");
                    userInput.draw();
                    confirmationCode = in.next();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            boolean isActive = rset.getInt("is_active") == 1;
            String confirmationCode = rset.getString("confirmation_code");
            list.add(new Booking(id, isActive, confirmationCode));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "booking";
    }
}
