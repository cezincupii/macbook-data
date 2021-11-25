package ro.ase.ppoo;

public class FirExecutie extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Se calculeaza un nou credit...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Banca banca : Main.listaBanci) {
                banca.calculeazaRata((int) (Math.random() * 50));
            }
        }
    }
}
