package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    RadioButton droiteR3, gaucheR3, droiteR2, gaucheR2, droiteR1, gaucheR1;
    @FXML
    ComboBox<String> comboboxR3, comboboxR2, comboboxR1;
    String rotorDroite[]= {"+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8","+9", "+10", "+11", "+12", "+13", "+14", "+15", "+16", "+17", "+18", "+19", "+20", "+21", "+22", "+23", "+24", "+25", "+26"};
    String rotorGauche[]= {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8","-9", "-10", "-11", "-12", "-13", "-14", "-15", "-16", "-17", "-18", "-19", "-20", "-21", "-22", "-23", "-24", "-25", "-26"};

    @FXML
    // tout ce qui est initialiser avant que l'application est lancée
    private void initialize() {
        ObservableList obsListDroite = FXCollections.observableArrayList(rotorDroite);
        ObservableList obsListGauche = FXCollections.observableArrayList(rotorGauche);

        // ajouter les radios buttons droite/gauche au groupe
        ToggleGroup rotor3radioGroup = new ToggleGroup();
        droiteR3.setToggleGroup(rotor3radioGroup);
        gaucheR3.setToggleGroup(rotor3radioGroup);

        ToggleGroup rotor2radioGroup = new ToggleGroup();
        droiteR2.setToggleGroup(rotor2radioGroup);
        gaucheR2.setToggleGroup(rotor2radioGroup);

        ToggleGroup rotor1radioGroup = new ToggleGroup();
        droiteR1.setToggleGroup(rotor1radioGroup);
        gaucheR1.setToggleGroup(rotor1radioGroup);

        // TODO: make the code LESS DRY
        /* ajouter les choix dans les combobox selon si l'utilisateur sélectionne la clé
        * droite gauche et update le choix du combobox
        * */
        rotor3radioGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            droiteR3 = (RadioButton) rotor3radioGroup.getSelectedToggle();
            gaucheR3 = (RadioButton) rotor3radioGroup.getSelectedToggle();
            if(droiteR3.getId().equals("droiteR3")) {
                comboboxR3.setItems(obsListDroite);

            }
            if(gaucheR3.getId().equals("gaucheR3")){
                comboboxR3.setItems(obsListGauche);
            }
        });

        rotor2radioGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            droiteR2 = (RadioButton) rotor2radioGroup.getSelectedToggle();
            gaucheR2 = (RadioButton) rotor2radioGroup.getSelectedToggle();
            if(droiteR2.getId().equals("droiteR2")) {
                comboboxR2.setItems(obsListDroite);

            }
            if(gaucheR2.getId().equals("gaucheR2")){
                comboboxR2.setItems(obsListGauche);
            }
        });

        rotor1radioGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            droiteR1 = (RadioButton) rotor1radioGroup.getSelectedToggle();
            gaucheR1 = (RadioButton) rotor1radioGroup.getSelectedToggle();
            if(droiteR1.getId().equals("droiteR1")) {
                comboboxR1.setItems(obsListDroite);

            }
            if(gaucheR1.getId().equals("gaucheR1")){
                comboboxR1.setItems(obsListGauche);
            }
        });
    }

    @FXML
    public void configBtnClick() {
        System.out.println("config btn is clicked");
        // vérifier que tous les clés pour les rotors ont été configuré -> erreur
    }

    @FXML
    public void encrypterBtnClick() {
        System.out.println("encryper btn is clicked");
    }

    @FXML
    public void etapeSuivanteBtn() {
        System.out.println("etape suivante btn is clicked");
    }

    @FXML
    public void decrypterBtnClick() {
        System.out.println("decryper btn is clicked");
    }

    @FXML
    public void rotar3KeyAction(){
        System.out.println("Selected value rotor key 3: " + comboboxR3.getValue());
    }

    @FXML
    public void rotar2KeyAction(){
        System.out.println("Selected value rotor key 2: " + comboboxR2.getValue());
    }

    @FXML
    public void rotar1KeyAction(){
        System.out.println("Selected value rotor key 1: " + comboboxR1.getValue());
    }
}
