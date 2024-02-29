package com.example.observer_;

import ClockComponents.ClockComponent;
import ClockComponents.ClockPaint;
import ImageComponent.ImagePane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import observerComponents.TimeServer;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public StackPane ImagePane;
    @FXML
    public BorderPane TimerText;
    @FXML
    TextField textField;
    @FXML
    public BorderPane MediaPage;
    private TimeServer timeServer;
    private ClockComponent clockComponent;
    private ImageComponent.ImagePane imageComponentPane;

    private ClockPaint clockPaint;
    @FXML
    ColorPicker color;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeServer = new TimeServer();
        clockPaint=new ClockPaint();
        imageComponentPane = new ImagePane("Привет", Color.MAROON);
        clockComponent = new ClockComponent();


        timeServer.attach(imageComponentPane);
        timeServer.attach(clockComponent);
        timeServer.attach(clockPaint);

        this.TimerText.setCenter(clockComponent.getClock());
        this.ImagePane.getChildren().add(imageComponentPane.buildMeme());
        this.MediaPage.setCenter(clockPaint.getPanel());
    }

}