package com.github.blacky0x0.numeralsystems.gui;

import com.github.blacky0x0.numeralsystems.BinaryDecimalSystem;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * User: blacky
 * Date: 16.02.15
 */
public class BinaryDecimalGuiConverter extends Application {

    public Parent createContent() {
        //Controls to be added to the HBox
        Label decimalLabel = new Label("Input decimal number:");
        TextField decimalField = new TextField();
        Button decimalButton = new Button("Convert");

        Label binaryLabel = new Label("Input binary-decimal number:");
        TextField binaryField = new TextField();
        Button binaryButton = new Button("Convert");

        decimalField.setPromptText("42");
        binaryField.setPromptText("01000010");

        Button clearButton = new Button("Clear");

        //create a console for logging key events
        final ListView<String> console = new ListView<String>(FXCollections.<String>observableArrayList());
        // listen on the console items and remove old ones when we get over 20 items
        console.getItems().addListener((ListChangeListener.Change<? extends String> change) -> {
            while (change.next()) {
                if (change.getList().size() > 20.0) {
                    change.getList().remove(0);
                }
            }
        });
        console.setPrefHeight(150);
        console.setMaxHeight(ListView.USE_PREF_SIZE);

        clearButton.setOnAction((ActionEvent event) -> {
            console.getItems().clear();
        });

        decimalButton.setOnAction((ActionEvent event) -> {
            String text = decimalField.getText();

            if (text == null || text.trim().isEmpty())
                return;

            long number;
            text = text.trim();

            try { number = Integer.parseInt(text); }
            catch ( NumberFormatException nfe ) { return; }

            console.getItems().add(BinaryDecimalSystem.toBinaryDecimalNumber(number));
        });

        binaryButton.setOnAction((ActionEvent event) -> {
            String text = binaryField.getText();

            if (binaryField.getText() == null
                    || text.trim().isEmpty()
                    || text.trim().length() % 4 != 0)
                return;

            text = text.trim();

            for (char ch : text.toCharArray()) {
                if (!Character.isDigit(ch))
                    return;
                if (!(ch == '0' || ch == '1'))
                    return;
            }

            console.getItems().add(Long.toString(BinaryDecimalSystem.toDecimalNumber(text)));
        });


        //HBox with spacing = 5
        HBox hbox1 = new HBox(5);
        HBox hbox2 = new HBox(5);

        hbox1.getChildren().addAll(decimalLabel, decimalField, decimalButton);
        hbox2.getChildren().addAll(binaryLabel, binaryField, binaryButton);
        hbox1.setAlignment(Pos.TOP_LEFT);
        hbox2.setAlignment(Pos.TOP_LEFT);

        VBox vb = new VBox(10);
        vb.getChildren().addAll(hbox1, hbox2, console, clearButton);

        return vb;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Binary-decimal system converter");
        primaryStage.setScene(new Scene(createContent(), 500, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
