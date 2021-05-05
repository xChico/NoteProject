package sample;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main extends Application {
    Button save;
    Button searchTiBut;
    Button searchDaBut;
    Scene scene1, scene2;
    Notebook notebook;
    public static void main(String[] args){
        launch(args);
    }


    public void init () {
        System.out.println("Initializing components");
    }



    public void stop () {
        System.out.println("Closing everything");
    }

    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Note Taking App");
        GridPane root = new GridPane();
        root.setPadding(new Insets(10, 10,10,10));
        root.setVgap(8);
        root.setHgap(10);
        Label top = new Label("Add a note");
        GridPane.setConstraints(top, 1,0);
        //Title Body
        Label titleLabel = new Label("Title: ");
        GridPane.setConstraints(titleLabel, 1, 2 );
        TextField newTitle = new TextField();
        newTitle.setPromptText("Title");
        GridPane.setConstraints(newTitle, 1,3);
        //Date Body
        Label dateLabel = new Label("Date: ");
        GridPane.setConstraints(dateLabel, 1, 4);
        DatePicker newDate = new DatePicker();
        GridPane.setConstraints(newDate, 1,5);
        //Note Body
        Label bodyLabel = new Label("Body: ");
        GridPane.setConstraints(bodyLabel,1 , 6);
        TextArea newBody = new TextArea();
        newBody.setPromptText("Add your note");
        newBody.setPrefHeight(300);
        newBody.setPrefWidth(300);
        GridPane.setConstraints(newBody, 1, 7 );
        //Save
        save = new Button("Save Note");
        GridPane.setConstraints(save, 1,8);
        Label searchLabel = new Label("Search a note");
        GridPane.setConstraints(searchLabel, 20,0);
        //search title
        searchTiBut = new Button("Search by Title");
        GridPane.setConstraints(searchTiBut, 20,2);
        TextField searchTitle = new TextField();
        searchTitle.setPromptText("Title");
        GridPane.setConstraints(searchTitle, 20,3);
        //search date
        searchDaBut = new Button("Search by Date");
        GridPane.setConstraints(searchDaBut, 20,4);
        DatePicker searchDate = new DatePicker();
        GridPane.setConstraints(searchDate, 20,5);
        //
        StackPane layout2 = new StackPane();
        Button button2 = new Button("Note saved successfully. Click to add or search a note.");
        layout2.getChildren().add(button2);
        layout2.setStyle("-fx-background-color: #FDEEF4;");
        scene2 = new Scene(layout2,600,300);
        notebook= new Notebook();

        //saving notes
        save.setOnAction(e -> {
            String titles = newTitle.getText();
            LocalDate dates = newDate.getValue();
            String bodies = newBody.getText();
            if(titles.equals(null) || dates== null ||bodies.equals(null) || titles.equals("") || bodies.equals("")){
                MessageBox.nothingSaved();
            }
            else{
                notebook.addNote(titles, dates, bodies);
                newTitle.clear();
                newBody.clear();
                newDate.getEditor().clear();
                newTitle.setText("");
                newDate.setValue(null);
                newBody.setText("");
                primaryStage.setScene(scene2);
           }

        });
        //list view of notes
        ObservableList<Note> viewList = FXCollections.observableArrayList();
        ListView<Note> listNotes = new ListView<Note>(viewList);
        Label notesFound = new Label("Notes Found: ");
        GridPane.setConstraints(notesFound, 20, 6);
        root.add(listNotes, 20, 7);
        listNotes.setPrefHeight(300);
        listNotes.setPrefWidth(300);
        //Pop up
        //searching titles

        searchTiBut.setOnAction(e -> {
            //notebook.readT("C:/Users/Innocentius/Desktop/myNotes.txt");
            notebook.readT("./src/sample/myNotes.txt");
            viewList.clear();
            String titles = searchTitle.getText();
            if(titles.length()!= 0) {
                for (Note n : notebook.findTitle(titles)) {
                    viewList.add(n);
                }
            }
            if(viewList.size()==0 ){
               MessageBox.display();
            }
            searchTitle.clear();
            searchDate.getEditor().clear();

        }); //lambda

        //searching dates
        searchDaBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                viewList.clear();
                listNotes.getItems().clear();
                LocalDate date = searchDate.getValue();
                //notebook.readT("C:/Users/Innocentius/Desktop/myNotes.txt");
                notebook.readT("./src/sample/myNotes.txt");
                for(Note n : notebook.findDate(date)){
                    viewList.add(n);
                }
                if(viewList.size()==0 || notebook.findDate(date) ==null){
                    MessageBox.display();
                }
                searchTitle.clear();
                searchDate.getEditor().clear();
            }
        });

        Button view = new Button("View Note");
        GridPane.setConstraints(view, 20,8);
        //View note button is disabled if there is no notes list displayed

        view.disableProperty().bind(Bindings.size(viewList).isEqualTo(0));

        view.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Note choice = listNotes.getSelectionModel().getSelectedItem();
                MessageBox.chooseList(choice);
            }
        });  //inner class

        root.getChildren().addAll(top, titleLabel, newTitle, dateLabel, newDate, bodyLabel, newBody, searchLabel,  searchTitle,  searchDate, notesFound,  save, searchDaBut, searchTiBut, view);
        scene1 = new Scene(root, 835, 550);
        primaryStage.setScene(scene1);
        primaryStage.show();
        button2.setOnAction(e->primaryStage.setScene(scene1));
        root.setStyle("-fx-background-color: #FDEEF4;");
    }
}




