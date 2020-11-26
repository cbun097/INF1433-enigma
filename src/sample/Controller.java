package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    @FXML
    RadioButton droiteR3, gaucheR3, droiteR2, gaucheR2, droiteR1, gaucheR1;
    @FXML
    ComboBox<String> combobox1, combobox2, combobox3;
    @FXML
    TextField txtField1, txtField2, txtField3;
    @FXML
    TextArea entreeEncryptionTxt1;
    @FXML
    private FlowPane alphabetContainer, reflecteurContainer, rotor1ContainerP1, rotor1ContainerP2, rotor2ContainerP1, rotor2ContainerP2, rotor3ContainerP1, rotor3ContainerP2;
    ToggleGroup rotor1radioGroup, rotor2radioGroup, rotor3radioGroup;
    private Rotor rotor1, rotor2, rotor3;
    private Reflecteur reflecteur;
    private List<Label> alphabetLabels, reflecteurLabels, rotor1P1Labels, rotor1P2Labels, rotor2P1Labels, rotor2P2Labels, rotor3P1Labels, rotor3P2Labels;

    String rotorDroite[]= {"+1", "+2", "+3", "+4", "+5", "+6", "+7", "+8","+9", "+10", "+11", "+12", "+13", "+14", "+15", "+16", "+17", "+18", "+19", "+20", "+21", "+22", "+23", "+24", "+25", "+26"};
    String rotorGauche[]= {"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8","-9", "-10", "-11", "-12", "-13", "-14", "-15", "-16", "-17", "-18", "-19", "-20", "-21", "-22", "-23", "-24", "-25", "-26"};
    String alphabetArray[]= {"A", "B", "C", "D", "E", "F", "G", "H","I", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String comboboxChoicesArray[] = {"Rotor 1", "Rotor 2", "Rotor 3"};

    @FXML
    // tout ce qui est initialiser avant que l'application est lancée
    private void initialize() {
        ObservableList obstListCmb = FXCollections.observableArrayList(comboboxChoicesArray);

        rotor1 = new Rotor(Arrays.asList(10,21,5,-17,21,-4,12,16,6,-3,7,-7,4,2,5,-6,-11,-17,-9,-6,-9,-19,2,-3,-21,-4),
                Arrays.asList(17,4,19,21,7,11,3,-5,7,9,-10,9,17,6,-6,-2,-4,-7,-12,-5,3,4,-21,-16,-2,-21));
        rotor2 = new Rotor(Arrays.asList(3,17,22,18,16,7,5,1,-7,16,-3,8,2,9,2,-5,-1,-13,-12,-17,-11,-4,1,-10,-19,-25),
                Arrays.asList(25,7,17,-3,13,19,12,3,-1,11,5,-5,-7,10,-2,1,-2,4,-17,-8,-16,-18,-9,-1,-22,-16));
        rotor3 = new Rotor(Arrays.asList(1,16,5,17,20,8,-2,2,14,6,2,-5,-12,-10,9,10,5,-9,1,-14,-2,-10,-6,13,-10,-23),
                Arrays.asList(12,-1,23,10,2,14,5,-5,9,-2,-13,10,-2,-8,10,-6,6,-16,2,-1,-17,-5,-14,-9,-20,-10));
        reflecteur = new Reflecteur(Arrays.asList(25,23,21,19,17,15,13,11,9,7,5,3,1,-1,-3,-5,-7,-9,-11,-13,-15,-17,-19,-21,-23,-25));

        // ajouter les radios buttons droite/gauche au groupe
        rotor3radioGroup = new ToggleGroup();
        droiteR3.setToggleGroup(rotor3radioGroup);
        gaucheR3.setToggleGroup(rotor3radioGroup);

        rotor2radioGroup = new ToggleGroup();
        droiteR2.setToggleGroup(rotor2radioGroup);
        gaucheR2.setToggleGroup(rotor2radioGroup);

        rotor1radioGroup = new ToggleGroup();
        droiteR1.setToggleGroup(rotor1radioGroup);
        gaucheR1.setToggleGroup(rotor1radioGroup);

        // set les valeurs dans les combobox pour l'ordre des rotors
        combobox1.setItems(obstListCmb);
        combobox2.setItems(obstListCmb);
        combobox3.setItems(obstListCmb);


        // Affiche l'alphabet
        alphabetLabels = new ArrayList<>();
        for(String al: alphabetArray) {
            Label label = new Label(al);
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            alphabetLabels.add(label);
            alphabetContainer.getChildren().add(label);
        }

        // Initialiser et affiche la liste des reflecteurs
        reflecteurLabels = new ArrayList<>();
        for(Integer reflecteurElement: reflecteur.getReflecteur()) {
            Label label = new Label(Integer.toString(reflecteurElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            reflecteurLabels.add(label);
            reflecteurContainer.getChildren().add(label);
        }

        // Initialiser et affiche la liste du rotor 1
        rotor1P1Labels = new ArrayList<>();
        for(Integer rotorElement: rotor1.getPasse1()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            rotor1P1Labels.add(label);
            rotor1ContainerP1.getChildren().add(label);
        }

        rotor1P2Labels = new ArrayList<>();
        for(Integer rotorElement: rotor1.getPasse2()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            rotor1P2Labels.add(label);
            rotor1ContainerP2.getChildren().add(label);
        }

        // Initialiser et affiche la liste du rotor 2
        rotor2P1Labels = new ArrayList<>();
        for(Integer rotorElement: rotor2.getPasse1()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            rotor2P1Labels.add(label);
            rotor2ContainerP1.getChildren().add(label);
        }

        rotor2P2Labels = new ArrayList<>();
        for(Integer rotorElement: rotor2.getPasse2()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            rotor2P2Labels.add(label);
            rotor2ContainerP2.getChildren().add(label);
        }

        // Initialiser et affiche la liste du rotor 3
        rotor3P1Labels = new ArrayList<>();
        for(Integer rotorElement: rotor3.getPasse1()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            rotor3P1Labels.add(label);
            rotor3ContainerP1.getChildren().add(label);
        }

        rotor3P2Labels = new ArrayList<>();
        for(Integer rotorElement: rotor3.getPasse2()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            rotor3P2Labels.add(label);
            rotor3ContainerP2.getChildren().add(label);
        }
    }

    @FXML
    public void configBtnClick() {
        // vérifier que tous les clés pour les rotors ont été configuré -> erreur
        String txt1Value = txtField1.getText();
        String txt2Value = txtField2.getText();
        String txt3Value = txtField3.getText();

        // combo box get the value
       String cb1Value = combobox1.getValue();
       String cb2Value = combobox2.getValue();
       String cb3Value = combobox3.getValue();

        // radio button group
        String radio1Value = ((RadioButton)rotor1radioGroup.getSelectedToggle()).getText();
        String radio2Value = ((RadioButton)rotor2radioGroup.getSelectedToggle()).getText();
        String radio3Value = ((RadioButton)rotor3radioGroup.getSelectedToggle()).getText();

        System.out.println(String.format("Entree de l'utilisateur: %s - %s - %s - %s - %s - %s -%s - %s - %s",
                cb1Value, cb2Value, cb3Value, radio1Value, radio2Value, radio3Value, txt1Value, txt2Value, txt3Value));

        // decalage method

        affichierNouvelleConfig();

    }

    public void affichierNouvelleConfig() {

    }

    @FXML
    public void encrypterBtnClick() {
        String entreeUtilisateur = entreeEncryptionTxt1.getText();
        System.out.println("encryper btn is clicked");
        System.out.println("entree utilisateur" + entreeUtilisateur);
    }

    @FXML
    public void etapeSuivanteBtn() {
        // afficher la nouvelle config
        // encrypter
        System.out.println("etape suivante btn is clicked");
        // set la lettre apres avoir ete encrypte
        entreeEncryptionTxt1.setText("");
    }

    @FXML
    public void decrypterBtnClick() {
        System.out.println("decryper btn is clicked");
    }
}
