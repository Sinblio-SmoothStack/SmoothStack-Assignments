package Demo_2.UI.Elements;

import java.util.List;

public class UIList implements UIElement{
    List<String> toList;

    public UIList (List<String> toList) {
        this.toList = toList;
    }

    @Override
    public void draw() {
        System.out.println();
        if (toList != null)
            for(int i = 0; i < toList.size(); i++)
                System.out.println("\t" + (i + 1) + ") " + toList.get(i));
    }

    public List<String> getToList() {
        return toList;
    }

    public void setToList(List<String> toList) {
        this.toList = toList;
    }
}
