package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.*;

public class Main extends Application {
    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Reflecteur reflecteur;
    @Override
    public void start(Stage primaryStage) throws Exception{
        rotor1 = new Rotor(Arrays.asList(10,21,5,-17,21,-4,12,16,6,-3,7,-7,4,2,5,-6,-11,-17,-9,-6,-9,-19,2,-3,-21,-4),
                Arrays.asList(17,4,19,21,7,11,3,-5,7,9,-10,9,17,6,-6,-2,-4,-7,-12,-5,3,4,-21,-16,-2,-21));
        rotor2 = new Rotor(Arrays.asList(3,17,22,18,16,7,5,1,-7,16,-3,8,2,9,2,-5,-1,-13,-12,-17,-11,-4,1,-10,-19,-25),
                Arrays.asList(25,7,17,-3,13,19,12,3,-1,11,5,-5,-7,10,-2,1,-2,4,-17,-8,-16,-18,-9,-1,-22,-16));
        rotor3 = new Rotor(Arrays.asList(1,16,5,17,20,8,-2,2,14,6,2,-5,-12,-10,9,10,5,-9,1,-14,-2,-10,-6,13,-10,-23),
                Arrays.asList(12,-1,23,10,2,14,5,-5,9,-2,-13,10,-2,-8,10,-6,6,-16,2,-1,-17,-5,-14,-9,-20,-10));
        reflecteur = new Reflecteur(Arrays.asList(25,23,21,19,17,15,13,11,9,7,5,3,1,-1,-3,-5,-7,-9,-11,-13,-15,-17,-19,-21,-23,-25));
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Enigma");
        primaryStage.setScene(new Scene(root, 650, 475));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
