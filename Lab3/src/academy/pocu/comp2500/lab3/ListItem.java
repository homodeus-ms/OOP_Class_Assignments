package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {


    private String text;
    private final ArrayList<ListItem> sublistItems;
    private char bulletStyle;

    public ListItem(String text) {
        this.text = text;
        this.sublistItems = new ArrayList<>();
        this.bulletStyle = '*';
    }
    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.sublistItems = new ArrayList<>();
        this.bulletStyle = bulletStyle;
    }
    public String getText() {
        return this.text;
    }
    public char getBulletStyle() {
        return this.bulletStyle;
    }
    public ListItem getSublistItem(int index) {
        return this.sublistItems.get(index);
    }

    public void setText(String newText) {
        this.text = newText;
    }
    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public void addSublistItem(ListItem item) {
        this.sublistItems.add(item);
    }

    public String toString() {
        if (this.text == null || this.text == "") {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.bulletStyle);
        sb.append(" ");
        sb.append(this.text);
        sb.append(System.lineSeparator());

        byte depth = 0;

        appendSubItemsRecursive(sb, depth, this.sublistItems);

        return sb.toString();
    }
    public void removeSublistItem(int index) {
        this.sublistItems.remove(index);
    }

    private void appendSubItemsRecursive(StringBuilder sb, byte depth, ArrayList<ListItem> items) {

        if (items.isEmpty()) {
            return;
        }

        ++depth;

        for (ListItem item : items) {
            for (byte i = 0; i < depth; ++i) {
                sb.append("    ");
            }

            sb.append(item.bulletStyle);
            sb.append(" ");
            sb.append(item.text);
            sb.append(System.lineSeparator());

            appendSubItemsRecursive(sb, depth, item.sublistItems);
        }
    }
}

