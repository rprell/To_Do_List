package com.example.to_do_list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class HelloController {
    public TextField textImput;
    public Button addButton;
    public ListView toDoList;
    public DatePicker datePicker;

    ObservableList<String> items;

    public void initialize() {
        items = FXCollections.observableArrayList();
        toDoList.setItems(items);
    }

    //code for onAction
    public void onHelloButtonClick() {
        String userToDo = textImput.getText();
        String toDoDate = datePicker.getId();
        items.add(toDoDate);
        items.add(userToDo);
        textImput.clear();
    }

    public void deleteKey( final KeyEvent keyEvent )
    {
        final Object selectedItem;
        selectedItem = toDoList.getSelectionModel().getSelectedItem();
        toDoList.getSelectionModel();

        if ( selectedItem != null ) {

            if ( keyEvent.getCode().equals( KeyCode.BACK_SPACE ) ) {
                System.out.println("Completed Task:");
                System.out.println(selectedItem);
                toDoList.getItems().remove(selectedItem);
                //text.clear
            }
        }
    }
}