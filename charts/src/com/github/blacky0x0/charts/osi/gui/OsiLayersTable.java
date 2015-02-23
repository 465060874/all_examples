package com.github.blacky0x0.charts.osi.gui;

import com.github.blacky0x0.charts.osi.model.Layer;
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
 * Date: 23.02.15
 */
public class OsiLayersTable extends Application {

    public Parent createContent() {
        final ObservableList<Layer> data = FXCollections.observableArrayList(
                Layer.APPLICATION,
                Layer.PRESENTATION,
                Layer.SESSION,
                Layer.TRANSPORT,
                Layer.NETWORK,
                Layer.DATA_LINK,
                Layer.PHYSICAL
        );

        TableColumn<Layer, String> nameCol = new TableColumn<>();
        nameCol.setText("Layer");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        //nameCol.setStyle("-fx-base: red;");

        TableColumn<Layer, String> dataUnitCol = new TableColumn<>();
        dataUnitCol.setText("Data unit");
        dataUnitCol.setCellValueFactory(new PropertyValueFactory<>("dataUnit"));

        TableColumn<Layer, String> layerFunctionCol = new TableColumn<>();
        layerFunctionCol.setText("Function");
        layerFunctionCol.setMinWidth(200);
        layerFunctionCol.setCellValueFactory(new PropertyValueFactory<>("layerFunction"));

        TableColumn<Layer, String> examplesCol = new TableColumn<>();
        examplesCol.setText("Examples");
        examplesCol.setMinWidth(200);
        examplesCol.setCellValueFactory(new PropertyValueFactory<>("examples"));

        TableView<Layer> tableView = new TableView<>();
        tableView.setItems(data);
        tableView.getColumns().addAll(nameCol, dataUnitCol, layerFunctionCol, examplesCol);

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