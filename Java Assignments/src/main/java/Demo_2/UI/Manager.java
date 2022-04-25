package Demo_2.UI;

import Demo_2.Daos.TableDao;
import Demo_2.Objects.Airport;
import Demo_2.Objects.DBTableObject;
import Demo_2.UI.Elements.UIList;
import Demo_2.UI.Elements.UIPrompt;
import Demo_2.UI.Elements.UIText;
import Demo_2.UI.Screens.SelectionMenu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Manager {

    public DBTableObject select(DBTableObject tableType) {
        return select(tableType, null);
    }


    public DBTableObject select(DBTableObject tableType, String filter) {
        TableDao tableDao = new TableDao();
        List<DBTableObject> tableObjects;

        try {
            if (filter != null) {
                tableObjects = tableDao.getAllFiltered(tableType, filter);
            } else {
                tableObjects = tableDao.getAll(tableType);
            }

            List<String> listStrings = new ArrayList<>();

            if (tableObjects != null)
                for (DBTableObject tableObject: tableObjects)
                    listStrings.add(tableObject.toString());

            listStrings.add("Add New");

            listStrings.add("Back");

            SelectionMenu selectionMenu = new SelectionMenu("Select An Option", listStrings);
            selectionMenu.draw();

            Scanner in = new Scanner(System.in);

            int input = in.nextInt();

            if (tableObjects != null)
                if (input > 0 && input <= tableObjects.size())
                    return tableObjects.get(input - 1);

            if (input == listStrings.size() - 1) {
                DBTableObject created = tableType.createNew();
                tableDao.insert(created);
                return created;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void crudOperation(DBTableObject selectType) {
        crudOperation(selectType, null);
    }

    public void crudOperation(DBTableObject selectType, String filter) {
        DBTableObject selected = select(selectType, filter);

        if (selected != null) {

            List<String> menuOptions = Arrays.asList("View Details", "Update Entry", "Remove Entry", "Quit");

            SelectionMenu selectionMenu = new SelectionMenu("Select an option:", menuOptions);
            selectionMenu.draw();

            Scanner in = new Scanner(System.in);

            int input = in.nextInt();

            try {
                switch (input) {
                    case 1 -> viewDetails(selected);
                    case 2 -> {
                        TableDao tableDao = new TableDao();
                        DBTableObject updated = selected.updateThis();
                        if (updated != null)
                            tableDao.update(updated);
                    }
                    case 3 -> {
                        TableDao tableDao = new TableDao();
                        tableDao.delete(selected);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void viewDetails(DBTableObject tableObject) {
        UIText details = new UIText(tableObject.toString());
        UIList list = new UIList(Arrays.asList("Back"));
        UIPrompt prompt = new UIPrompt();

        details.draw();
        list.draw();
        prompt.draw();

        Scanner in = new Scanner(System.in);

        in.next();
    }

}
