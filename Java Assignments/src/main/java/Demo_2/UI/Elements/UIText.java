package Demo_2.UI.Elements;

public class UIText implements UIElement{

    private String text;

    public UIText(String text) {
        this.text = text;
    }

    @Override
    public void draw() {
        System.out.println();
        System.out.println(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
