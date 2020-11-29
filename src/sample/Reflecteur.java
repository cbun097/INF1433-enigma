package sample;

import java.util.List;

public class Reflecteur {
    private final List<Integer> Reflecteur;
    public Reflecteur(List<Integer> Reflecteur)
    {
        this.Reflecteur = Reflecteur;
    }

    public Integer Reflection(Integer Position)
    {
        System.out.println(Position + " + " + this.Reflecteur.get(Position) + " = " + ((Position + this.Reflecteur.get(Position)) % 26));
        return ((Position + this.Reflecteur.get(Position)) % 26);
    }

    public List<Integer> getReflecteur() {
        return Reflecteur;
    }
}
