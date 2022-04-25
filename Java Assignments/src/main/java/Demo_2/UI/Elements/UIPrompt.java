package Demo_2.UI.Elements;

public class UIPrompt implements UIElement{

    @Override
    public void draw() {
        System.out.println();
        System.out.print("> ");
    }
}
