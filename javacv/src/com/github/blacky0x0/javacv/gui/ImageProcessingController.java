package com.github.blacky0x0.javacv.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageProcessingController {

    @FXML
    private Button loadImageButton;

    @FXML
    private Button clearImageButton;

    @FXML
    public ImageView loadedImageView;

    @FXML
    public ImageView processedImageView;

//    @FXML
//    private Image loadedImage;
//
//    @FXML
//    private Image processedImage;

    @FXML
    public void onClickLoadImageMethod(ActionEvent actionEvent) {
        // TODO: make the dialog to load images
        //String image = "file:///com/github/blacky0x0/javacv/shared-resources/tiger_picture_550x230.jpg";
        String image = "com/github/blacky0x0/javacv/shared-resources/tiger_picture_550x230.jpg";

        loadedImageView.setImage(new Image(image, false));
        loadedImageView.setFitWidth(loadedImageView.getFitWidth());
        loadedImageView.setPreserveRatio(true);
        loadedImageView.setCache(true);

        processedImageView.setImage(new Image(image, false));
        //processedImageView.setFitWidth(processedImageView.getFitWidth());
        processedImageView.setFitHeight(processedImageView.getFitHeight());
        processedImageView.setPreserveRatio(true);
        processedImageView.setCache(true);

    }

    @FXML
    public void onClickClearImageMethod(ActionEvent actionEvent) {
        String image = "com/github/blacky0x0/javacv/shared-resources/empty_image_338x338.jpg";

        processedImageView.setImage(new Image(image, false));
        //processedImageView.setFitWidth(processedImageView.getFitWidth());
        processedImageView.setFitHeight(processedImageView.getFitHeight());
        processedImageView.setPreserveRatio(true);
        processedImageView.setCache(true);
    }

}
