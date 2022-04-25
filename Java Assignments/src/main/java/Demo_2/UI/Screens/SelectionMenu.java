package Demo_2.UI.Screens;

import Demo_2.UI.Elements.UIList;
import Demo_2.UI.Elements.UIPrompt;
import Demo_2.UI.Elements.UIText;

import java.util.List;

public class SelectionMenu implements BasicScreen{
    UIText menuText;
    UIList menuList;
    UIPrompt menuPrompt;

    public SelectionMenu (String menuText, List<String> menuList) {
        this.menuText = new UIText(menuText);
        this.menuList = new UIList(menuList);
        this.menuPrompt = new UIPrompt();
    }

    void updateMenuText(String menuText) {
        this.menuText.setText(menuText);
    }

    void updateMenuList(List<String> menuList) {
        this.menuList.setToList(menuList);
    }

    @Override
    public void draw() {
        menuText.draw();
        menuList.draw();
        menuPrompt.draw();
    }
}
