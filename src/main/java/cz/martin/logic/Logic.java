package cz.martin.logic;

import cz.martin.data.Data;

import java.io.File;
import java.util.ArrayList;

public class Logic {
    private Data data;
    private ArrayList<Room> rooms;

    public Logic() {
        this.data = new Data();
        this.rooms = data.readData();
    }

    public void saveData(int selected, String name, String description, String rb1, String rb2, String rb3, String img, String r1, String r2, String r3, String item, String reqItem) {
        if(selected == -1) {
            selected = this.getRooms().size();
            this.getRooms().add(null);
        } else if(!this.rooms.get(selected).getName().equals(name)) {
            this.renameRoom(this.rooms.get(selected).getName(), name);
        }
        Room mr = new Room(name, description, rb1, rb2, rb3, img);
        mr.setRooms(new Room(r1, null, null, null, null, null), new Room(r2, null, null, null, null, null), new Room(r3, null, null, null, null, null));
        mr.setRequiredItemId(reqItem);
        mr.setItem(item);
        this.getRooms().set(selected, mr);

        this.data.saveData(this.rooms);
    }

    private void renameRoom(String name, String name1) {
        for (Room room : this.rooms) {
            if(room.choose1().getName().equals(name)) room.choose1().setName(name1);
            if(room.choose2().getName().equals(name)) room.choose2().setName(name1);
            if(room.choose3().getName().equals(name)) room.choose3().setName(name1);
        }
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public void copyFile(File file) {
        data.copyFile(file);
    }
}
