package com.company;
/*
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.beans.value.ChangeListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javaFx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
*/
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main /*extends Application */{
    public static void main(String[] args){
        try {
            RandomNumbers test = new RandomNumbers(50, 0, 1);
            test.closeDataStreams();
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        //launch(args);
    }
/*
    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(400);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(browser);
        webEngine.getLoadWorker().stateProperty()
                .addListener(new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            stage.setTitle(webEngine.getLocation());
                        }
                    }
                });
        webEngine.load("https://www.youtube.com/watch?v=QHYwprmWMfY&feature=youtu.be");
        scene.setRoot(scrollPane);
        stage.setScene(scene);
        stage.show();
    }*/
}