package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageBox {

    public static void display(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("No Notes");
        window.setMinWidth(250);
        window.setMinHeight(250);

        Label label = new Label();
        label.setText("No Notes Found");
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e-> window.close());


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #F8F8FF;");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

    public static void nothingSaved(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("No Notes");
        window.setMinWidth(400);
        window.setMinHeight(300);

        Label label = new Label();
        label.setText("Nothing saved. Must add Title, Date, and a Text Body.");
        Button closeButton2 = new Button("Close the window");
        closeButton2.setOnAction(e-> window.close());


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton2);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #F8F8FF;");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }


    public static void chooseList(Note n){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Note");
        window.setMinWidth(300);
        window.setMinHeight(250);

        Label label = new Label();
        label.setText(n.toString());

        Button closeButton2 = new Button("Close the window");
        closeButton2.setOnAction(e-> window.close());


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton2);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #F8F8FF;");

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }



}
