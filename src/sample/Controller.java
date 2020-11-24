package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    @FXML
    RadioButton droiteR3, gaucheR3, droiteR2, gaucheR2, droiteR1, gaucheR1;
    @FXML
    ComboBox<String> comboboxR3, comboboxR2, comboboxR1;
    @FXML
    private FlowPane labelContainer, alphabetContainer, reflecteurContainer, rotor1Container, rotor2Container, rotor3Container;

    private Rotor rotor1;
    private Rotor rotor2;
    private Rotor rotor3;
    private Reflecteur reflecteur;
    private List<Label> labels, alphabetLabels, reflecteurLabels, rotor1Labels, rotor2Labels, rotor3Labels;

    String rotorDroite[]= {"+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8","+9", "+10", "+11", "+12", "+13", "+14", "+15", "+16", "+17", "+18", "+19", "+20", "+21", "+22", "+23", "+24", "+25", "+26"};
    String rotorGauche[]= {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8","-9", "-10", "-11", "-12", "-13", "-14", "-15", "-16", "-17", "-18", "-19", "-20", "-21", "-22", "-23", "-24", "-25", "-26"};
    String alphabetArray[]= {"A", "B", "C", "D", "E", "F", "G", "H","I", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    @FXML
    // tout ce qui est initialiser avant que l'application est lancée
    private void initialize() {
        ObservableList obsListDroite = FXCollections.observableArrayList(rotorDroite);
        ObservableList obsListGauche = FXCollections.observableArrayList(rotorGauche);

        rotor1 = new Rotor(Arrays.asList(10,21,5,-17,21,-4,12,16,6,-3,7,-7,4,2,5,-6,-11,-17,-9,-6,-9,-19,2,-3,-21,-4),
                Arrays.asList(17,4,19,21,7,11,3,-5,7,9,-10,9,17,6,-6,-2,-4,-7,-12,-5,3,4,-21,-16,-2,-21));
        rotor2 = new Rotor(Arrays.asList(3,17,22,18,16,7,5,1,-7,16,-3,8,2,9,2,-5,-1,-13,-12,-17,-11,-4,1,-10,-19,-25),
                Arrays.asList(25,7,17,-3,13,19,12,3,-1,11,5,-5,-7,10,-2,1,-2,4,-17,-8,-16,-18,-9,-1,-22,-16));
        rotor3 = new Rotor(Arrays.asList(1,16,5,17,20,8,-2,2,14,6,2,-5,-12,-10,9,10,5,-9,1,-14,-2,-10,-6,13,-10,-23),
                Arrays.asList(12,-1,23,10,2,14,5,-5,9,-2,-13,10,-2,-8,10,-6,6,-16,2,-1,-17,-5,-14,-9,-20,-10));
        reflecteur = new Reflecteur(Arrays.asList(25,23,21,19,17,15,13,11,9,7,5,3,1,-1,-3,-5,-7,-9,-11,-13,-15,-17,-19,-21,-23,-25));

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

        // TODO: Make the change later
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

        // creation des labels
//        labels = new ArrayList<>();
//        for (int i = 1; i <= 100; i++) {
//            Label label = new Label("Label "+i);
//            labels.add(label);
//            labelContainer.getChildren().add(label);
//        }

        // Affiche l'alphabet
        alphabetLabels = new ArrayList<>();
        for(String al: alphabetArray) {
            Label label = new Label(al);
            label.setPadding(new Insets(0,5,0,5));
            // add style - border - not working
            // check https://www.callicoder.com/javafx-css-tutorial/
            //label.getStyleClass().clear();
            //label.getStyleClass().add("label-border");
            alphabetLabels.add(label);
            alphabetContainer.getChildren().add(label);
        }

        // Initialiser et affiche la liste des reflecteurs
        reflecteurLabels = new ArrayList<>();
        for(Integer reflecteurElement: reflecteur.getReflecteur()) {
            Label label = new Label(Integer.toString(reflecteurElement));
            label.setPadding(new Insets(0,5,0,5));
            // ajouter le style
            reflecteurLabels.add(label);
            reflecteurContainer.getChildren().add(label);
        }

        // Initialiser et affiche la liste du rotor 1
        // TODO ajouter passe2
        rotor1Labels = new ArrayList<>();
        for(Integer rotorElement: rotor1.getPasse1()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            // ajouter le style
            rotor1Labels.add(label);
            rotor1Container.getChildren().add(label);
        }

        // Initialiser et affiche la liste du rotor 2
        // TODO ajouter passe2
        rotor2Labels = new ArrayList<>();
        for(Integer rotorElement: rotor2.getPasse1()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            // ajouter le style
            rotor2Labels.add(label);
            rotor2Container.getChildren().add(label);
        }

        // Initialiser et affiche la liste du rotor 3
        // TODO ajouter passe2
        rotor3Labels = new ArrayList<>();
        for(Integer rotorElement: rotor3.getPasse1()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            // ajouter le style
            rotor3Labels.add(label);
            rotor3Container.getChildren().add(label);
        }
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
