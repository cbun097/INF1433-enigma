package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    RadioButton droiteR3, gaucheR3, droiteR2, gaucheR2, droiteR1, gaucheR1;
    ComboBox<String> comboboxR3, comboBoxR2, comboBoxR1;
    String rotorDroite[]= {"+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8","+9", "+10", "+11", "+12", "+13", "+14", "+15", "+16", "+17", "+18", "+19", "+20", "+21", "+22", "+23", "+24", "+25", "+26"};
    String rotorGauche[]= {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8","-9", "-10", "-11", "-12", "-13", "-14", "-15", "-16", "-17", "-18", "-19", "-20", "-21", "-22", "-23", "-24", "-25", "-26"};

    @FXML
    private void initialize() {

        ToggleGroup rotor3radio = new ToggleGroup();
        droiteR3.setToggleGroup(rotor3radio);
        gaucheR3.setToggleGroup(rotor3radio);

        ToggleGroup rotor2radio = new ToggleGroup();
        droiteR2.setToggleGroup(rotor2radio);
        gaucheR2.setToggleGroup(rotor2radio);

        ToggleGroup rotor1radio = new ToggleGroup();
        droiteR1.setToggleGroup(rotor1radio);
        gaucheR1.setToggleGroup(rotor1radio);

//        ObservableList obsListDroite = FXCollections.observableArrayList(rotorDroite);
//        comboboxR3.setItems(obsListDroite);
//        System.out.println(obsListDroite);
        //comboBoxR2 = new ComboBox(FXCollections.observableArrayList(rotorGauche));
    }

    @FXML
    public void configBtnClick() {
        System.out.println("config btn is clicked");
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
}
