package sample;

import java.util.List;

public class Rotor {
    private final List<Integer> passe1;
    private final List<Integer> passe2;
    private Integer Decalage;
    private Boolean Direction; //true = droite, false = gauche

    public Rotor(List<Integer> passe1, List<Integer> passe2) {
        this.passe1 = passe1;
        this.passe2 = passe2;
    }

    public void rotation(){
        //nombre de fois a decaler
        for(int i = 0; i<this.Decalage; i++)
        {
            if (Direction)
            {
                //met une varible temporaire pour tout deplacer
                Integer temp1 = this.passe1.get(25);
                Integer temp2 = this.passe2.get(25);
                //deplace les valeur a l'index 25 a l'index 1
                for (int a = 25; a>0; a--)
                {
                    this.passe1.set(a,this.passe1.get(a-1));
                    this.passe2.set(a,this.passe2.get(a-1));
                }
                //met la valeur temp au debut
                this.passe1.set(0,temp1);
                this.passe2.set(0,temp2);
            }
            else
            {
                //met une varible temporaire pour tout deplacer
                Integer temp1 = this.passe1.get(0);
                Integer temp2 = this.passe2.get(0);
                //deplace les valeur a l'index 0 a l'index 24
                for (int a = 0; a<25; a++)
                {
                    this.passe1.set(a,this.passe1.get(a+1));
                    this.passe2.set(a,this.passe2.get(a+1));
                }
                //met la valeur temp a la fin
                this.passe1.set(25,temp1);
                this.passe2.set(25,temp2);
            }
        }
    }

    public Integer PremierePasse(Integer Position)
    {
        System.out.println("Premiere " + Position + " + " + this.passe1.get(Position) + " = " + ((Position + this.passe1.get(Position) + 26) % 26));
        return ((Position + this.passe1.get(Position) + 26) % 26);
    }

    public Integer DeuxiemePasse(Integer Position)
    {
        System.out.println("DieuxiemePasse " + Position + " + " + this.passe2.get(Position) + " = " + ((Position + this.passe2.get(Position) + 26) % 26));
        return ((Position + this.passe2.get(Position) + 26) % 26);
    }

    public List<Integer> getPasse1() {
        return passe1;
    }

    public List<Integer> getPasse2() {
        return passe2;
    }

    public Boolean getDirection() {
        return Direction;
    }

    public Integer getDecalage() {
        return Decalage;
    }

    public void setDecalage(Integer decalage) {
        this.Decalage = decalage;
    }

    public void setDirection(Boolean direction) {
        this.Direction = direction;
    }
}



/*
//met une varible temporaire pour tout deplacer
                Integer temp1 = this.arraytest[0][25];
                Integer temp2 = this.arraytest[1][25];
                //deplace les valeur a l'index 25 a l'index 1
                for (int a = 25; a>0; a--)
                {
                    this.arraytest[0][a] = this.arraytest[0][a-1];
                    this.arraytest[1][a] = this.arraytest[1][a-1];
                }
                //met la valeur temp au debut
                this.arraytest[0][0] = temp1;
                this.arraytest[1][0] = temp2;

 */