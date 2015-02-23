package com.github.blacky0x0.numeralsystems.gui;

import com.github.blacky0x0.numeralsystems.IntegerUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * User: blacky
 * Date: 17.02.15
 */
public class IntegerUtilGuiConverter extends Application {

    public Parent createContent() {
        //Controls to be added to the HBox
        Label decimalLabel = new Label("Decimal number:");
        TextField decimalField = new TextField();
        Button decimalButton = new Button("OK");

        Label directCodeLabel = new Label("Direct code:");
        TextField directCodeField = new TextField();

        Label reverseCodeLabel = new Label("Reverse code:");
        TextField reverseCodeField = new TextField();

        Label additionalCodeLabel = new Label("Additional code:");
        TextField additionalCodeField = new TextField();

        Button clearButton = new Button("Clear");

        decimalField.setPromptText("42");
        directCodeField.setEditable(false);
        reverseCodeField.setEditable(false);
        additionalCodeField.setEditable(false);

        decimalLabel.setMinWidth(120);
        directCodeLabel.setMinWidth(120);
        reverseCodeLabel.setMinWidth(120);
        additionalCodeLabel.setMinWidth(120);

        directCodeField.setMinWidth(320);
        reverseCodeField.setMinWidth(320);
        additionalCodeField.setMinWidth(320);


        clearButton.setOnAction((ActionEvent event) -> {
            directCodeField.clear();
            reverseCodeField.clear();
            additionalCodeField.clear();
        });

        decimalButton.setOnAction((ActionEvent event) -> {
            String text = decimalField.getText();

            if (text == null || text.trim().isEmpty())
                return;

            int number;
            text = text.trim();

            try { number = Integer.parseInt(text); }
            catch ( NumberFormatException nfe ) { return; }

            directCodeField.setText(IntegerUtil.getFormattedCode(IntegerUtil.getDirectCode(number)));
            reverseCodeField.setText(IntegerUtil.getFormattedCode(IntegerUtil.getReverseCode(number)));
            additionalCodeField.setText(IntegerUtil.getFormattedCode(IntegerUtil.getAdditionalCode(number)));
        });

        //HBox with spacing = 5
        HBox hbox1 = new HBox(5);
        HBox hbox2 = new HBox(5);
        HBox hbox3 = new HBox(5);
        HBox hbox4 = new HBox(5);

        hbox1.getChildren().addAll(decimalLabel, decimalField, decimalButton);
        hbox2.getChildren().addAll(directCodeLabel, directCodeField);
        hbox3.getChildren().addAll(reverseCodeLabel, reverseCodeField);
        hbox4.getChildren().addAll(additionalCodeLabel, additionalCodeField);

        hbox1.setAlignment(Pos.TOP_LEFT);
        hbox2.setAlignment(Pos.TOP_LEFT);
        hbox3.setAlignment(Pos.TOP_LEFT);
        hbox4.setAlignment(Pos.TOP_LEFT);

        VBox vb = new VBox(10);
        vb.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, clearButton);

        return vb;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Decimal converter to a direct / reverse / additional code");
        primaryStage.setScene(new Scene(createContent(), 600, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
