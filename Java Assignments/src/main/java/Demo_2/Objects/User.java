package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;
import Demo_2.UI.Manager;
import Demo_2.UI.Screens.SelectionMenu;
import Demo_2.UI.Screens.UserInput;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class User implements DBTableObject{
    private int id;
    private int roleId;
    private String givenName;
    private String familyName;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;

    public User() {
        this.id = 0;
        this.roleId = 0;
        this.givenName = null;
        this.familyName = null;
        this.userName = null;
        this.email = null;
        this.password = null;
        this.phoneNumber = null;
    }

    public User(int id, int roleId, String givenName, String familyName, String userName, String email, String password, String phoneNumber) {
        this.id = id;
        this.roleId = roleId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("User: id: %d, role id: %d, name: %s %s,\n" +
                "username: %s, email: %s, password %s, phone number %s",
                id, roleId, givenName, familyName, userName, email, password, phoneNumber);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, roleId);
            stmt.setString(2, givenName);
            stmt.setString(3, familyName);
            stmt.setString(4, userName);
            stmt.setString(5, email);
            stmt.setString(6, password);
            stmt.setString(7, phoneNumber);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set role_id = ?, given_name = ?, family_name = ?, " +
                "username = ?, email = ?, password = ?, phone = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set role_id = " + roleId + ", given_name = " + givenName +
                ", family_name = " + familyName + ", username = " + userName + ", email = " +email + ", password = " +
                password + ", phone = " + phoneNumber + " where id = " + id;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where id = " + id;
    }

    @Override
    public ResultSetFunction resultSetFunction() {
        ResultSetFunction resultSetFunction = (ResultSet rset, List<DBViewObject> list) -> {
            int id = rset.getInt("id");
            int roleId = rset.getInt("role_id");
            String givenName = rset.getString("given_name");
            String familyName = rset.getString("family_name");
            String username = rset.getString("username");
            String email = rset.getString("email");
            String password = rset.getString("password");
            String phone = rset.getString("phone");
            list.add(new User(id, roleId, givenName, familyName, username, email, password, phone));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "user";
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        UserRole userRole = (UserRole) manager.select(new UserRole());
        int newRoleId = userRole.getId();

        UserInput userInput = new UserInput("Enter given name:");
        userInput.draw();
        String newGivenName = in.next();

        userInput.updateMenuText("Enter family name:");
        userInput.draw();
        String newFamilyName = in.next();

        userInput.updateMenuText("Enter username:");
        userInput.draw();
        String newUserName = in.next();

        userInput.updateMenuText("Enter email:");
        userInput.draw();
        String newEmail = in.next();

        userInput.updateMenuText("Enter password:");
        userInput.draw();
        String newPassword = in.next();

        userInput.updateMenuText("Enter phone number:");
        userInput.draw();
        String newPhone = in.next();

        return new User(0, newRoleId, newFamilyName, newGivenName, newUserName, newEmail, newPassword, newPhone);
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit role", "Edit given name", "Edit family name",
                "Edit dob", "Edit Gender", "Edit Address", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    Manager manager = new Manager();
                    UserRole userRole = (UserRole) manager.select(new UserRole());
                    roleId = userRole.getId();
                    toReturn = this;
                }
                case 2 -> {
                    UserInput userInput = new UserInput("Enter new given name:");
                    userInput.draw();
                    givenName = in.next();
                    toReturn = this;
                }
                case 3 -> {
                    UserInput userInput = new UserInput("Enter new family name:");
                    userInput.draw();
                    familyName = in.next();
                    toReturn = this;
                }
                case 4 -> {
                    UserInput userInput = new UserInput("Enter new username:");
                    userInput.draw();
                    userName = in.next();
                    toReturn = this;
                }
                case 5 -> {
                    UserInput userInput = new UserInput("Enter new email:");
                    userInput.draw();
                    email = in.next();
                    toReturn = this;
                }
                case 6 -> {
                    UserInput userInput = new UserInput("Enter password:");
                    userInput.draw();
                    password = in.next();
                    toReturn = this;
                }
                case 7 -> {
                    UserInput userInput = new UserInput("Enter phone number:");
                    userInput.draw();
                    phoneNumber = in.next();
                    toReturn = this;
                }
            }
        } finally {
            return toReturn;
        }
    }
}
