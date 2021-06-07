package cz.martin.logic;

public class Room {
    private String name;
    private String text;
    private String[] buttonTexts;
    private String img;
    private Room r1;
    private Room r2;
    private Room r3;
    private String item;
    private String requiredItemId;

    public Room(String title, String text, String btn1Text, String btn2Text, String btn3Text, String img) {
        this.text = text;
        this.name = title;
        this.buttonTexts = new String[]{btn1Text, btn2Text, btn3Text};
        this.img = img;
        this.item = null;
        this.requiredItemId = null;
    }

    public void setRooms(Room r1, Room r2, Room r3) {
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
    }

    public Room choose1() {
        return r1;
    }

    public Room choose2() {
        return r2;
    }

    public Room choose3() {
        return r3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getButtonTexts() {
        return buttonTexts;
    }

    public void setButtonTexts(String[] buttonTexts) {
        this.buttonTexts = buttonTexts;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setR1(Room r1) {
        this.r1 = r1;
    }

    public void setR2(Room r2) {
        this.r2 = r2;
    }

    public void setR3(Room r3) {
        this.r3 = r3;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getRequiredItemId() {
        return requiredItemId;
    }

    public void setRequiredItemId(String requiredItemId) {
        this.requiredItemId = requiredItemId;
    }
}
