package com.github.blacky0x0.charts.algebra.gui;

import com.github.blacky0x0.charts.algebra.model.Law;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * User: blacky
 * Date: 24.02.15
 */
public class LawsOfBooleanAlgebra extends Application {

    public Parent createContent() {
        final ObservableList<Law> data = FXCollections.observableArrayList(
                Law.COMMUNICATIVE,
                Law.ASSOCIATE,
                Law.DISTRIBUTIVE,
                Law.DE_MORGAN,
                Law.IDENTITY,
                Law.REDUNDANCE,
                Law.GLUING,
                Law.COMPLEMENT,
                Law.ANNULMENT,
                Law.DOUBLE_NEGATION
        );

        TableColumn<Law, String> nameCol = new TableColumn<>();
        nameCol.setText("Закон");
        nameCol.setMinWidth(200);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Law, String> orOperationCol = new TableColumn<>();
        orOperationCol.setText("ИЛИ");
        orOperationCol.setMinWidth(250);
        orOperationCol.setCellValueFactory(new PropertyValueFactory<>("orOperation"));

        TableColumn<Law, String> andOperationCol = new TableColumn<>();
        andOperationCol.setText("И");
        andOperationCol.setMinWidth(250);
        andOperationCol.setCellValueFactory(new PropertyValueFactory<>("andOperation"));

        TableView<Law> tableView = new TableView<>();
        tableView.setItems(data);
        tableView.getColumns().addAll(nameCol, orOperationCol, andOperationCol);

        return tableView;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}
