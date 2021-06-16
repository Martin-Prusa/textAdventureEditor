package cz.martin.data;

import com.google.gson.Gson;
import cz.martin.logic.Room;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Data {
    private Gson gson;

    public Data() {
        this.gson = new Gson();
    }

    public void saveData(ArrayList<Room> list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("save.json"));
            String json = gson.toJson(list.toArray());
            bw.write(json);
            bw.close();
        } catch (IOException ignored) {}
    }

    public ArrayList<Room> readData() {
        ArrayList<Room> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("save.json"));
            String json = br.readLine();
            Room[] rooms = gson.fromJson(json, Room[].class);
            list = new ArrayList<>(Arrays.asList(rooms));
            br.close();
        } catch (IOException ignored) {}
        return list;
    }

    public void copyFile(File file) {
        try {
            Path from = Paths.get(file.toURI());
            String name = file.getName();
            File toF = new File("./../textovaHra/src/main/resources/img/"+name);
            Path to = Paths.get(toF.toURI());
            Files.copy(from, to);
        } catch (Exception ignored) {}
    }
}
