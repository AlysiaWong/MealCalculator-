package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Label label1 = new Label("Enter a name for the order: ");
        Label label2 = new Label("Select an entrée: ");
        Label label3 = new Label("Select a side: ");
        Label label4 = new Label("Select a drink: ");
        Label label5 = new Label("");
        Label label6 = new Label("Create Your Combo:");
        Button button = new Button("Order");
        TextField textField = new TextField();
        ChoiceBox<String> entreeChoiceBox = new ChoiceBox<>();
        ChoiceBox<String> sideChoiceBox = new ChoiceBox<>();
        ChoiceBox<String> drinkChoiceBox = new ChoiceBox<>();

        entreeChoiceBox.getItems().add("Hamburger");
        entreeChoiceBox.getItems().add("Cheeseburger");
        entreeChoiceBox.getItems().add("Chicken Sandwich");
        entreeChoiceBox.getItems().add("Veggie Burger");
        entreeChoiceBox.getItems().add("None");

        sideChoiceBox.getItems().add("Fries");
        sideChoiceBox.getItems().add("Salad");
        sideChoiceBox.getItems().add("None");

        drinkChoiceBox.getItems().add("Soda");
        drinkChoiceBox.getItems().add("Juice");
        drinkChoiceBox.getItems().add("Water");
        drinkChoiceBox.getItems().add("None");

        GridPane grid = new GridPane();
        grid.add(label2,0,0);
        grid.add(entreeChoiceBox,1,0);
        grid.add(label3,0,1);
        grid.add(sideChoiceBox,1,1);
        grid.add(label4, 0,2);
        grid.add(drinkChoiceBox,1,2);
        grid.add(label1, 0,3);
        grid.add(textField,1,3);

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        button.setOnAction(event ->
        {
            double price = 0;

                if (entreeChoiceBox.getValue().equals("Hamburger"))
                    price += 4.50;
                else if (entreeChoiceBox.getValue().equals("Cheeseburger"))
                    price += 5.25;
                else if (entreeChoiceBox.getValue().equals("Chicken Sandwich"))
                    price += 4.25;
                else if (entreeChoiceBox.getValue().equals("Veggie Burger"))
                    price += 4.99;

                if (sideChoiceBox.getValue().equals("Fries"))
                    price += 3.50;
                else if (sideChoiceBox.getValue().equals("Salad"))
                    price += 3.25;

                if (drinkChoiceBox.getValue().equals("Soda"))
                    price += 2.50;
                else if (drinkChoiceBox.getValue().equals("Juice"))
                    price += 2.99;
                else if (sideChoiceBox.getValue().equals("Water"))
                    price += 2.75;

                label5.setText(String.format("Order for " + textField.getText().trim() + "\n Total: $%.2f", price));

        });

        VBox vbox = new VBox(10, label6, grid, button, label5);
        vbox.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(vbox, 500,400);
        myScene.getStylesheets().add("mystyles.css");
        primaryStage.setScene(myScene);
        primaryStage.setTitle("Menu");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
