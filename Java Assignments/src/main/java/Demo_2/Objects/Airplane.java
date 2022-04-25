package Demo_2.Objects;

import Demo_2.Daos.ResultSetFunction;
import Demo_2.Daos.StatementFunction;
import Demo_2.UI.Manager;
import Demo_2.UI.Screens.SelectionMenu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Airplane implements DBTableObject{
    private int id;
    private int type_id;

    public Airplane() {
        id = 0;
        type_id = 0;
    }

    public Airplane(int id, int type_id) {
        this.id = id;
        this.type_id = type_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return String.format("id: %d, type id: %d", id, type_id);
    }

    @Override
    public StatementFunction statementFunction() {
        StatementFunction statementFunction = (PreparedStatement stmt) -> {
            stmt.setInt(1, type_id);
        };
        return statementFunction;
    }

    @Override
    public String insertQuery() {
        return "insert into " + defaultTableName() + " set type_id = ?";
    }

    @Override
    public String updateQuery() {
        return "update " + defaultTableName() + " set type_id = " + type_id + " where id = " + id;
    }

    @Override
    public String deleteQuery() {
        return "delete from " + defaultTableName() + " where id = " + id;
    }

    @Override
    public DBTableObject createNew() {
        Scanner in = new Scanner(System.in);

        Manager manager = new Manager();
        AirplaneType airplaneType = (AirplaneType) manager.select(new AirplaneType());

        return new Airplane(0, airplaneType.getId());
    }

    @Override
    public DBTableObject updateThis() {
        DBTableObject toReturn = null;
        Scanner in = new Scanner(System.in);

        List<String> menuOptions = Arrays.asList("Edit Airplane Type", "Quit");

        SelectionMenu selectionMenu = new SelectionMenu("Please select a value to edit:", menuOptions);
        selectionMenu.draw();

        try {
            int selection = in.nextInt();

            switch (selection) {
                case 1 -> {
                    Manager manager = new Manager();
                    AirplaneType airplaneType = (AirplaneType) manager.select(new AirplaneType());
                    this.type_id = airplaneType.getId();
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
            int typeId = rset.getInt("type_id");
            list.add(new Airplane(id, typeId));
        };
        return resultSetFunction;
    }

    @Override
    public String defaultTableName() {
        return "airplane";
    }
}
