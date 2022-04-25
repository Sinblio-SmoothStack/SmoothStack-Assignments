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

public class UserRole implements DBTableObject{
    private int id;
    private String name;

    public UserRole() {
        this.id = 0;
        this.name = null;
    }

    public UserRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("UserRole: Role: %s Id: %d", name, id);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setString(1, name);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set name = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set name = " + name + " where id = " + id;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where id = " + id;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            String name = rset.getString("name");
            list.add(new UserRole(id, name));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "user_role";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        UserInput userInput = new UserInput("Enter role name:");
        userInput.draw();
        String newRoleName = in.next();

        return new UserRole(0, newRoleName);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit role name", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    UserInput userInput = new UserInput("Enter new role name:");
                    userInput.draw();
                    name = in.next();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }

    }
}
