package ro.ase.ppoo;

public class Credit {
    private String numeCredit;
    private float dobanda;
    private int perioadaDeTimp;

    public Credit(String numeCredit, float dobanda, int perioadaDeTimp) {
        super();
        this.numeCredit = numeCredit;
        this.dobanda = dobanda;
        this.perioadaDeTimp = perioadaDeTimp;
    }

    //constructor de copiere
    public Credit(Credit credit) {
        this.numeCredit =credit.numeCredit;
        this.dobanda = credit.dobanda;
        this.perioadaDeTimp = credit.perioadaDeTimp;
    }

    public String getNumeCredit() {
        return numeCredit;
    }

    public void setNumeCredit(String numeCredit) {
        this.numeCredit = numeCredit;
    }

    public float getDobanda() {
        return dobanda;
    }

    public void setDobanda(float dobanda) {
        this.dobanda = dobanda;
    }

    public int getPerioadaDeTimp() {
        return perioadaDeTimp;
    }

    public void setPerioadaDeTimp(int perioadaDeTimp) {
        this.perioadaDeTimp = perioadaDeTimp;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "numeCredit='" + numeCredit + '\'' +
                ", dobanda=" + dobanda +
                ", perioadaDeTimp=" + perioadaDeTimp +
                '}';
    }
}
