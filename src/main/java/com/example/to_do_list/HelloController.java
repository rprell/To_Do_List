package com.example.to_do_list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class HelloController {
    public TextField textImput;
    public Button addButton;
    public ListView toDoList;
    public DatePicker datePicker;

    ObservableList<String> items;

    public void initialize() throws Exception {
        items = FXCollections.observableArrayList();
        toDoList.setItems(items);

        toDoList.setEditable(true);
        toDoList.setCellFactory(TextFieldListCell.forListView());

        restoreData();
    }



    public void saveData() throws Exception {
        FileOutputStream fileOut =
                new FileOutputStream("SavedToDo");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        ArrayList<String> temporaryList = new ArrayList<>(items);
        out.writeObject(temporaryList);
        out.close();
        fileOut.close();
    }

    public void restoreData() throws Exception{
        FileInputStream fileIn = new FileInputStream("SavedToDo");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<String> temporaryList = (ArrayList<String>) in.readObject();
        ObservableList temporaryObservableList = FXCollections.observableArrayList(temporaryList);
        toDoList.setItems(temporaryObservableList);
    }

    //code for onAction
    public void onHelloButtonClick() {
        String userToDo = textImput.getText();
        LocalDate toDoDate = datePicker.getValue();
        items.add(userToDo + " - " + toDoDate);
        textImput.clear();
        datePicker.setValue(null);

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