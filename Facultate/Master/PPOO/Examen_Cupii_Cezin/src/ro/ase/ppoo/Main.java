package ro.ase.ppoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static ArrayList<Banca> listaBanci=new ArrayList<>();

    static void scriereInFisier(String numeFisier, ArrayList<Banca> list) {
        File file = new File(numeFisier);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter=new FileWriter(file);
            bufferedWriter= new BufferedWriter(fileWriter);
            for(Banca banca:list) {
                bufferedWriter.write(banca.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<Credit> listaCredite=new ArrayList<>();
	Credit c1=new Credit("Bucuresti",15,3);
	Credit c2=new Credit("prima casa",5,30);
	Credit c3=new Credit("nevoie personale",12,3);
	listaCredite.add(c1);
	listaCredite.add(c2);
	listaCredite.add(c3);

    Banca b1=new Banca("banca",1,20,"ING",1,listaCredite,50000);
    b1.addCredit(c3);
    Banca b2=new Banca("banca",2,10,"BT",2,listaCredite,50000);
    Banca b3=new Banca("banca",3,50,"REVOLUT",3,listaCredite,50000);


    listaBanci.add(b1);
    listaBanci.add(b2);
    listaBanci.add(b3);

        Collections.sort(listaBanci);
        scriereInFisier("output.txt",listaBanci);


    }
}
