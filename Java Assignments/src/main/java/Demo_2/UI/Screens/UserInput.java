package Demo_2.UI.Screens;

import Demo_2.UI.Elements.UIPrompt;
import Demo_2.UI.Elements.UIText;

public class UserInput implements BasicScreen{
    UIText menuText;
    UIPrompt menuPrompt;

    public UserInput (String menuText) {
        this.menuText = new UIText(menuText);
        this.menuPrompt = new UIPrompt();
    }

    public void updateMenuText(String menuText) {
        this.menuText.setText(menuText);
    }

    @Override
    public void draw() {
        menuText.draw();
        menuPrompt.draw();
    }
}
