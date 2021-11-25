package ro.ase.ppoo;

import java.util.ArrayList;
import java.util.List;

public class Banca extends Sucursala implements ICalculeazaRata, Comparable<Sucursala> {

    private String denumireBanca;
    private int codBanca;
    private List<Credit> credite = new ArrayList<>();
    int suma;

    @Override
    public float calculeazaRata(String numeBanca) {
        float sumaBaniCeruta = 1.0f;
        int nrCont = 0;
        for(Credit c: credite)
            if(c.getNumeCredit().equals(numeBanca)) {
                sumaBaniCeruta = sumaBaniCeruta*c.getDobanda() + sumaBaniCeruta;
                nrCont++;
            }
        return sumaBaniCeruta;
    }

    @Override
    public int compareTo(Sucursala sucursala) {
        int cmp = denumireBanca.compareTo(sucursala.getNume());
        if (cmp==0)
            if(codBanca < sucursala.getNrAngajatiSucursala())
                return -1;
            else
            if(codBanca> sucursala.getNrAngajatiSucursala())
                return 1;
            else return 0;
        return cmp;
    }

    @Override
    String genereazaDescriere() {
        String descriere = "";
        for (Credit s : credite)
            descriere += s.getNumeCredit() + ", ";
        descriere += " - " + this.getNume() + ", ";
        descriere += this.calculeazaRata("Bucuresti");
        return descriere;
    }

    public Banca(String nume, int idSucursala, double nrAngajatiSucursala, String denumireBanca, int codBanca,
                 List<Credit> credite, int suma) {
        super(nume, idSucursala, nrAngajatiSucursala);
        this.denumireBanca = denumireBanca;
        this.codBanca = codBanca;
        this.credite = credite;
        this.suma=suma;
    }

    public void addCredit(Credit c) {
        credite.add(c);
    }

    public String getDenumireBanca() {
        return denumireBanca;
    }

    public void setDenumireBanca(String denumireBanca) {
        this.denumireBanca = denumireBanca;
    }

    public int getCodBanca() {
        return codBanca;
    }

    public void setCodBanca(int codBanca) {
        this.codBanca = codBanca;
    }

    public List<Credit> getCredite() {
        return credite;
    }

    public void setCredite(List<Credit> credite) {
        this.credite = credite;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        return "Banca{" +
                "denumireBanca='" + denumireBanca + '\'' +
                ", codBanca=" + codBanca +
                ", credite=" + credite +
                '}';
    }


    public synchronized void calculeazaRata(int suma)
    {

        if(suma<= this.suma)
        {
            System.out.println("Suma ceruta: "+suma);
            this.setSuma(this.getSuma());
            System.out.println("Imprumutul realizat este de: "+this.getSuma());
        }
        else
            System.out.println("Nu se poate realiza imprumutul");
    }
}