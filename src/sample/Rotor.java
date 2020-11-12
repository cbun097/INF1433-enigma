package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rotor {
    private List<Character> alphabet;
    private int position;

    public Rotor() {
        this.alphabet = new ArrayList<>(Arrays.asList(
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        ));;
    }

    // methode qui fait le calcule des rotors avec la rotation
    // a revoir
    public void rotation(){
        this.position = (this.position + 1 ) % 26;
    }
}
