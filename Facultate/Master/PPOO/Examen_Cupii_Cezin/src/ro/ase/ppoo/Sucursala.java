package ro.ase.ppoo;

public abstract class Sucursala implements Comparable<Sucursala> {

    private String nume;
    private int idSucursala;
    private double nrAngajatiSucursala;

    public Sucursala(String nume, int idSucursala, double nrAngajatiSucursala) {
        this.nume = nume;
        this.idSucursala = idSucursala;
        this.nrAngajatiSucursala = nrAngajatiSucursala;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getIdSucursala() {
        return idSucursala;
    }

    public void setIdSucursala(int idSucursala) {
        this.idSucursala = idSucursala;
    }

    public double getNrAngajatiSucursala() {
        return nrAngajatiSucursala;
    }

    public void setNrAngajatiSucursala(double nrAngajatiSucursala) {
        this.nrAngajatiSucursala = nrAngajatiSucursala;
    }

    @Override
    public String toString() {
        return "Sucursala{" +
                "nume='" + nume + '\'' +
                ", idSucursala=" + idSucursala +
                ", nrAngajatiSucursala=" + nrAngajatiSucursala +
                '}';
    }

    abstract String genereazaDescriere();

    @Override
    public int compareTo(Sucursala sucursala) {
        int cmp = nume.compareTo(sucursala.nume);
        if (cmp==0)
            if(nrAngajatiSucursala < sucursala.nrAngajatiSucursala)
                return -1;
            else
            if(nrAngajatiSucursala> sucursala.nrAngajatiSucursala)
                return 1;
            else return 0;
        return cmp;
    }
}
