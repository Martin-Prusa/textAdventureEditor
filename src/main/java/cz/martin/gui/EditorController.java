package cz.martin.gui;

import cz.martin.logic.Logic;
import cz.martin.logic.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class EditorController {
    private Logic logic;
    private int selected;

    @FXML
    private ListView<String> list;

    @FXML
    private TextField name;

    @FXML
    private TextField rb1;

    @FXML
    private TextField rb2;

    @FXML
    private TextField rb3;

    @FXML
    private ChoiceBox<String> r1;

    @FXML
    private ChoiceBox<String> r2;

    @FXML
    private ChoiceBox<String> r3;

    @FXML
    private TextArea description;

    @FXML
    private TextField image;

    @FXML
    private TextField item;

    @FXML
    private TextField reqItem;

    @FXML
    private Text text;

    @FXML
    public void initialize() {
        this.logic = new Logic();
        redraw();
    }

    @FXML
    public void clear(ActionEvent event) {
        this.selected = -1;
        this.name.setText("");
        this.description.setText("");
        this.rb1.setText("");
        this.rb2.setText("");
        this.rb3.setText("");
        this.r1.getSelectionModel().select(-1);
        this.r2.getSelectionModel().select(-1);
        this.r3.getSelectionModel().select(-1);
        this.text.setText("New Room");
        this.item.setText("");
        this.reqItem.setText("");
        this.image.setText("");
    }

    @FXML
    public void save(ActionEvent event) {
        this.logic.saveData(selected, this.name.getText(), this.description.getText(), this.rb1.getText(), this.rb2.getText(), this.rb3.getText(), this.image.getText(), this.r1.getValue(), this.r2.getValue(), this.r3.getValue(), this.item.getText(), this.reqItem.getText());
        this.clear(new ActionEvent());
        this.redraw();
    }

    @FXML
    public void select(ActionEvent event) {
        int selected = this.list.getSelectionModel().getSelectedIndex();
        if(selected == -1) return;
        Room room = this.logic.getRooms().get(selected);

        this.selected = this.list.getSelectionModel().getSelectedIndex();

        this.name.setText(room.getName());
        this.description.setText(room.getText());
        this.rb1.setText(room.getButtonTexts()[0]);
        this.rb2.setText(room.getButtonTexts()[1]);
        this.rb3.setText(room.getButtonTexts()[2]);
        this.r1.getSelectionModel().select(room.choose1().getName());
        this.r2.getSelectionModel().select(room.choose2().getName());
        this.r3.getSelectionModel().select(room.choose3().getName());
        this.item.setText(room.getItem());
        this.reqItem.setText(room.getRequiredItemId());
        this.image.setText(room.getImg());

        this.text.setText("Loaded room: "+this.name.getText());
    }

    public void redraw() {
        this.selected = -1;
        this.list.getItems().clear();
        this.r1.getItems().clear();
        this.r2.getItems().clear();
        this.r3.getItems().clear();
        for (Room room : this.logic.getRooms()) {
            this.list.getItems().add(room.getName());
            this.r1.getItems().add(room.getName());
            this.r2.getItems().add(room.getName());
            this.r3.getItems().add(room.getName());
        }
        this.clear(new ActionEvent());
    }

}
