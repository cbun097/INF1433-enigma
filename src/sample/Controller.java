package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    @FXML
    RadioButton droiteR3, gaucheR3, droiteR2, gaucheR2, droiteR1, gaucheR1;
    @FXML
    ComboBox<String> combobox1, combobox2, combobox3;
    @FXML
    TextField txtDecalage3, txtDecalage2, txtDecalage1;
    @FXML
    TextArea txtEncrypter, txtDecrypter;
    @FXML
    private FlowPane alphabetContainer, reflecteurContainer, rotor1ContainerP1, rotor1ContainerP2, rotor2ContainerP1, rotor2ContainerP2, rotor3ContainerP1, rotor3ContainerP2;
    @FXML
    Label lblRotor1, lblRotor2, lblRotor3;
    ToggleGroup rotor1radioGroup, rotor2radioGroup, rotor3radioGroup;
    private Rotor rotor1, rotor2, rotor3;
    private Reflecteur reflecteur;
    private List<Label> alphabetLabels, reflecteurLabels, rotor1P1Labels, rotor1P2Labels, rotor2P1Labels, rotor2P2Labels, rotor3P1Labels, rotor3P2Labels;
    String[] alphabetArray = {"A", "B", "C", "D", "E", "F", "G", "H","I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] comboboxChoicesArray = {"Rotor 1", "Rotor 2", "Rotor 3"};
    int compteur = 0;

    @FXML
    // tout ce qui est initialiser avant que l'application est lancée
    private void initialize() {
        ObservableList obstListCmb = FXCollections.observableArrayList(comboboxChoicesArray);

        rotor1 = new Rotor(Arrays.asList(10,21,5,-17,21,-4,12,16,6,-3,7,-7,4,2,5,-7,-11,-17,-9,-6,-9,-19,2,-3,-21,-4),
                Arrays.asList(17,4,19,21,7,11,3,-5,7,9,-10,9,17,6,-6,-2,-4,-7,-12,-5,3,4,-21,-16,-2,-21), "rotor1");
        rotor2 = new Rotor(Arrays.asList(3,17,22,18,16,7,5,1,-7,16,-3,8,2,9,2,-5,-1,-13,-12,-17,-11,-4,1,-10,-19,-25),
                Arrays.asList(25,7,17,-3,13,19,12,3,-1,11,5,-5,-7,10,-2,1,-2,4,-17,-8,-16,-18,-9,-1,-22,-16), "rotor2");
        rotor3 = new Rotor(Arrays.asList(1,16,5,17,20,8,-2,2,14,6,2,-5,-12,-10,9,10,5,-9,1,-14,-2,-10,-6,13,-10,-23),
                Arrays.asList(12,-1,23,10,2,14,5,-5,9,-2,-13,10,-2,-8,10,-6,6,-16,2,-1,-17,-5,-14,-9,-20,-10), "rotor3");
        reflecteur = new Reflecteur(Arrays.asList(25,23,21,19,17,15,13,11,9,7,5,3,1,-1,-3,-5,-7,-9,-11,-13,-15,-17,-19,-21,-23,-25));

        combobox1.setValue("Rotor 1");
        combobox2.setValue("Rotor 2");
        combobox3.setValue("Rotor 3");

        txtDecalage1.setText("1");
        txtDecalage2.setText("2");
        txtDecalage3.setText("3");

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

        // Initialiser et affiche la liste des reflecteurs
        configBtnClick();
    }

    @FXML
    public void configBtnClick() {
        try {
            // vérifier que tous les clés pour les rotors ont été configuré -> erreur
            int txt1Value = Integer.parseInt(txtDecalage1.getText());
            int txt2Value = Integer.parseInt(txtDecalage2.getText());
            int txt3Value = Integer.parseInt(txtDecalage3.getText());

            // combo box get the value
            String cb1Value = combobox1.getValue();
            String cb2Value = combobox2.getValue();
            String cb3Value = combobox3.getValue();

            if(cb1Value == cb2Value || cb2Value == cb3Value || cb1Value == cb3Value)
            {
                throw new Exception("Veuillez vous assurez qu'il y a pas 2 rotor pareil");
            }

            lblRotor1.setText(cb1Value);
            lblRotor2.setText(cb2Value);
            lblRotor3.setText(cb3Value);

            // radio button group
            Boolean radio1Value = convertDroiteGauche(((RadioButton) rotor1radioGroup.getSelectedToggle()).getText());
            Boolean radio2Value = convertDroiteGauche(((RadioButton) rotor2radioGroup.getSelectedToggle()).getText());
            Boolean radio3Value = convertDroiteGauche(((RadioButton) rotor3radioGroup.getSelectedToggle()).getText());

            System.out.println(String.format("Entree de l'utilisateur: %s - %s - %s - %s - %s - %s -%s - %s - %s",
                    cb1Value, cb2Value, cb3Value, radio1Value, radio2Value, radio3Value, txt1Value, txt2Value, txt3Value));

            // Set les directions selon le input de l'utilisateur
            rotor1.setDirection(radio1Value);
            rotor2.setDirection(radio2Value);
            rotor3.setDirection(radio3Value);
            rotor1.setDecalage(txt1Value);
            rotor2.setDecalage(txt2Value);
            rotor3.setDecalage(txt3Value);
            resetRotor();
            updateRotor();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    private Boolean convertDroiteGauche(String value) {
        if(value.equals("Gauche"))
            return false;
        else
            return true;
    }

    @FXML
    public void encrypterBtnClick() {
        String Sorti = "";
        System.out.println("entree utilisateur " + txtEncrypter.getText());
        for (; compteur < txtEncrypter.getText().length(); compteur++) {
            Sorti += EncrypterUneLettre(txtEncrypter.getText().toCharArray()[compteur]).toString();
        }
        txtDecrypter.appendText(Sorti);
    }

    @FXML
    public void etapeSuivanteBtn() {
        if(compteur < txtEncrypter.getText().length()) {
            Character sorti = EncrypterUneLettre(txtEncrypter.getText().toCharArray()[compteur]);
            txtDecrypter.appendText(sorti.toString());
            compteur++;
        }
    }

    @FXML
    public void decrypterBtnClick() {
        String Sorti = "";
        System.out.println("entree utilisateur " + txtDecrypter.getText());
        for (char ch: txtDecrypter.getText().toCharArray()) {
            Sorti += EncrypterUneLettre(ch).toString();
        }
        txtEncrypter.setText(Sorti);
    }

    public void updateRotor() {
        ArrayList<List<Label>> listOfRotorLabels;
        reflecteurLabels = new ArrayList<>();
        reflecteurContainer.getChildren().clear();
        for (Integer reflecteurElement : reflecteur.getReflecteur()) {
            Label label = new Label(Integer.toString(reflecteurElement));
            label.setPadding(new Insets(0, 5, 0, 5));
            label.setStyle("-fx-border-color: black;");
            reflecteurLabels.add(label);
            reflecteurContainer.getChildren().add(label);
        }

        // Affiche l'alphabet
        alphabetLabels = new ArrayList<>();
        alphabetContainer.getChildren().clear();
        for(String al: alphabetArray) {
            Label labelAlphabet = new Label(al);
            labelAlphabet.setPadding(new Insets(0,5,0,5));
            labelAlphabet.setStyle("-fx-border-color: black;");
            alphabetLabels.add(labelAlphabet);
            alphabetContainer.getChildren().add(labelAlphabet);
        }

        // Initialiser et affiche la liste du rotor 1
        if (combobox1.getValue() == "Rotor 3") {
            System.out.println("rotor 1");
            listOfRotorLabels = endUpdateRouter(rotor3, rotor1P1Labels, rotor1ContainerP1, rotor1P2Labels, rotor1ContainerP2);
            rotor1P1Labels = listOfRotorLabels.get(0);
            rotor1P2Labels = listOfRotorLabels.get(1);
        } else if (combobox1.getValue() == "Rotor 2") {
            System.out.println("rotor 2");
            listOfRotorLabels = endUpdateRouter(rotor2, rotor1P1Labels, rotor1ContainerP1, rotor1P2Labels, rotor1ContainerP2);
            rotor1P1Labels = listOfRotorLabels.get(0);
            rotor1P2Labels = listOfRotorLabels.get(1);
        } else {

            listOfRotorLabels = endUpdateRouter(rotor1, rotor1P1Labels, rotor1ContainerP1, rotor1P2Labels, rotor1ContainerP2);
            rotor1P1Labels = listOfRotorLabels.get(0);
            rotor1P2Labels = listOfRotorLabels.get(1);
        }

        // Initialiser et affiche la liste du rotor 2
        if (combobox2.getValue() == "Rotor 3") {
            listOfRotorLabels = endUpdateRouter(rotor3, rotor2P1Labels, rotor2ContainerP1, rotor2P2Labels, rotor2ContainerP2);
            rotor2P1Labels = listOfRotorLabels.get(0);
            rotor2P2Labels = listOfRotorLabels.get(1);
        } else if (combobox2.getValue() == "Rotor 1") {
            listOfRotorLabels = endUpdateRouter(rotor1, rotor2P1Labels, rotor2ContainerP1, rotor2P2Labels, rotor2ContainerP2);
            rotor2P1Labels = listOfRotorLabels.get(0);
            rotor2P2Labels = listOfRotorLabels.get(1);
        }
        else
        {
            listOfRotorLabels = endUpdateRouter(rotor2, rotor2P1Labels, rotor2ContainerP1, rotor2P2Labels, rotor2ContainerP2);
            rotor2P1Labels = listOfRotorLabels.get(0);
            rotor2P2Labels = listOfRotorLabels.get(1);
        }

        // Initialiser et affiche la liste du rotor 3
        if (combobox3.getValue() == "Rotor 1") {
            listOfRotorLabels = endUpdateRouter(rotor1, rotor3P1Labels, rotor3ContainerP1, rotor3P2Labels, rotor3ContainerP2);
            rotor3P1Labels = listOfRotorLabels.get(0);
            rotor3P2Labels = listOfRotorLabels.get(1);
        } else if (combobox3.getValue() == "Rotor 2") {
            listOfRotorLabels = endUpdateRouter(rotor2, rotor3P1Labels, rotor3ContainerP1, rotor3P2Labels, rotor3ContainerP2);
            rotor3P1Labels = listOfRotorLabels.get(0);
            rotor3P2Labels = listOfRotorLabels.get(1);
        }
        else
        {
            listOfRotorLabels = endUpdateRouter(rotor3, rotor3P1Labels, rotor3ContainerP1, rotor3P2Labels, rotor3ContainerP2);
            rotor3P1Labels = listOfRotorLabels.get(0);
            rotor3P2Labels = listOfRotorLabels.get(1);
        }

    }

    //rotor is the phisical rotor, rotorlabel is the list, rotorContainer is what position
    public ArrayList<List<Label>> endUpdateRouter(Rotor rotor, List<Label> RotorLabel1, FlowPane RotorContainer1,
                                List<Label> RotorLabel2, FlowPane RotorContainer2)
    {
        RotorLabel1 = new ArrayList<>();
        RotorContainer1.getChildren().clear();
        for(Integer rotorElement: rotor.getPasse1()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            RotorLabel1.add(label);
            RotorContainer1.getChildren().add(label);
        }

        RotorLabel2 = new ArrayList<>();
        RotorContainer2.getChildren().clear();
        for(Integer rotorElement: rotor.getPasse2()) {
            Label label = new Label(Integer.toString(rotorElement));
            label.setPadding(new Insets(0,5,0,5));
            label.setStyle("-fx-border-color: black;");
            RotorLabel2.add(label);
            RotorContainer2.getChildren().add(label);
        }
        ArrayList<List<Label>> listOfRotorLabels = new ArrayList<>();
        listOfRotorLabels.add(RotorLabel1);
        listOfRotorLabels.add(RotorLabel2);
        return listOfRotorLabels;
    }

    public Character EncrypterUneLettre(Character lettre)
    {
        updateRotor();
        int entree = 30;
        String entreeUtilisateur = lettre.toString().toUpperCase();
        System.out.println("lettre input" + lettre);
        for(int i = 0; i < alphabetArray.length; i++)
        {
            if(alphabetArray[i].equals(entreeUtilisateur))
            {
                entree = i;
                break;
            }
        }

        if(entree == 30)
        {
            return lettre;
        }
        updateCouleurRotors(rotor1P1Labels, entree, true);
        if(combobox1.getValue() == "Rotor 1") 
            entree = rotor1.PremierePasse(entree);
        else if(combobox1.getValue() == "Rotor 2")
            entree = rotor2.PremierePasse(entree);
        else
            entree = rotor3.PremierePasse(entree);

        updateCouleurRotors(rotor2P1Labels, entree, true);
        if(combobox2.getValue() == "Rotor 1")
            entree = rotor1.PremierePasse(entree);
        else if(combobox2.getValue() == "Rotor 2")
            entree = rotor2.PremierePasse(entree);
        else
            entree = rotor3.PremierePasse(entree);

        updateCouleurRotors(rotor3P1Labels, entree, true);
        if(combobox3.getValue() == "Rotor 1")
            entree = rotor1.PremierePasse(entree);
        else if(combobox3.getValue() == "Rotor 2")
            entree = rotor2.PremierePasse(entree);
        else
            entree = rotor3.PremierePasse(entree);

        entree = reflecteur.Reflection(entree);
        updateCouleurRotors(reflecteurLabels ,getInputRelecteur((entree)), true);
        updateCouleurRotors(reflecteurLabels ,(entree), false);

        updateCouleurRotors(rotor3P2Labels, entree, false);
        if(combobox3.getValue() == "Rotor 1")
            entree = rotor1.DeuxiemePasse(entree);
        else if(combobox3.getValue() == "Rotor 2")
            entree = rotor2.DeuxiemePasse(entree);
        else
            entree = rotor3.DeuxiemePasse(entree);

        updateCouleurRotors(rotor2P2Labels, entree, false);
        if(combobox2.getValue() == "Rotor 1")
            entree = rotor1.DeuxiemePasse(entree);
        else if(combobox2.getValue() == "Rotor 2")
            entree = rotor2.DeuxiemePasse(entree);
        else
            entree = rotor3.DeuxiemePasse(entree);


        updateCouleurRotors(rotor1P2Labels, entree, false);
        if(combobox1.getValue() == "Rotor 1")
            entree = rotor1.DeuxiemePasse(entree);
        else if(combobox1.getValue() == "Rotor 2")
            entree = rotor2.DeuxiemePasse(entree);
        else
            entree = rotor3.DeuxiemePasse(entree);

        rotor1.rotation();
        rotor2.rotation();
        rotor3.rotation();

        Character sortie = alphabetArray[entree].toCharArray()[0];
        updateCouleur(alphabetLabels, lettre, true);
        updateCouleur(alphabetLabels, sortie, false);


        return sortie;
    }

    // Prendre la positon oppose du reflecteur
    private int getInputRelecteur(int position) {
        int positionValue = 0;
        int resultPosition = 0 ;
        // prendre la valeur de la position du reflecteur
        for(int element: reflecteur.getReflecteur()) {
            if(reflecteur.getReflecteur().indexOf(element) == position) {
                positionValue = reflecteur.getReflecteur().get(position);
            }
        }
        // aller chercher la valeur de la position de reflecteur et prendre la position qui est retourner
        if(reflecteur.getReflecteur().contains(-positionValue)){
            resultPosition = reflecteur.getReflecteur().indexOf(-positionValue);
        }
        else if(reflecteur.getReflecteur().contains(positionValue)){
            resultPosition = reflecteur.getReflecteur().indexOf(positionValue);
        }
        return resultPosition;
    }

    // Methode qui permet de changer la couleur selon l'entree/sortie de la lettre
    private void updateCouleur(List<Label> labelsList, Character lettre, Boolean entree) {
        for (Label labelToUpdate : labelsList) {
            if (lettre.equals(labelToUpdate.getText().toCharArray()[0])) {
                if(entree){
                    System.out.println("entree input to update" + lettre);
                    labelToUpdate.setTextFill(Color.web("#CC0000"));
                    labelToUpdate.setStyle("-fx-border-color: black;-fx-font-weight: bold;");
                }
                else{
                    labelToUpdate.setTextFill(Color.web("#0000FF"));
                    labelToUpdate.setStyle("-fx-border-color: black;-fx-font-weight: bold");
                }
            }
        }
    }

    // Methode qui permet de changer la couleur des label selon l'entree/sortie du rotor
    private void updateCouleurRotors(List<Label> labelsList, int rotorPosition, Boolean entree) {
        for (Label labelToUpdate : labelsList) {
            if(labelsList.indexOf(labelToUpdate) == rotorPosition) {
                if(entree){
                    labelToUpdate.setTextFill(Color.web("#CC0000"));
                    labelToUpdate.setStyle("-fx-border-color: black;-fx-font-weight: bold;");
                }
                else{
                    labelToUpdate.setTextFill(Color.web("#0000FF"));
                    labelToUpdate.setStyle("-fx-border-color: black;-fx-font-weight: bold");
                }
            }
        }
    }

    private void updateCouleurReflecteur(List<Label> labelsList, int entree) {
        for (Label labelToUpdate : labelsList) {
            labelToUpdate.setTextFill(Color.web("#CC0000"));
            labelToUpdate.setStyle("-fx-border-color: black;-fx-font-weight: bold;");
        }
    }

    private void resetRotor()
    {
        rotor1.setRotor(Arrays.asList(10,21,5,-17,21,-4,12,16,6,-3,7,-7,4,2,5,-7,-11,-17,-9,-6,-9,-19,2,-3,-21,-4),
                Arrays.asList(17,4,19,21,7,11,3,-5,7,9,-10,9,17,6,-6,-2,-4,-7,-12,-5,3,4,-21,-16,-2,-21));
        rotor2.setRotor(Arrays.asList(3,17,22,18,16,7,5,1,-7,16,-3,8,2,9,2,-5,-1,-13,-12,-17,-11,-4,1,-10,-19,-25),
                Arrays.asList(25,7,17,-3,13,19,12,3,-1,11,5,-5,-7,10,-2,1,-2,4,-17,-8,-16,-18,-9,-1,-22,-16));
        rotor3.setRotor(Arrays.asList(1,16,5,17,20,8,-2,2,14,6,2,-5,-12,-10,9,10,5,-9,1,-14,-2,-10,-6,13,-10,-23),
                Arrays.asList(12,-1,23,10,2,14,5,-5,9,-2,-13,10,-2,-8,10,-6,6,-16,2,-1,-17,-5,-14,-9,-20,-10));
    }

    @FXML
    private void resetEncrypter()
    {
        txtEncrypter.setText("");
        resetRotor();
        compteur = 0;
    }

    @FXML
    private void resetDecrypter()
    {
        txtDecrypter.setText("");
        resetRotor();
        compteur = 0;
    }
}
