package clase;

import java.util.Scanner;
import exceptii.ExceptieCustom;

public class Fisier {

	private String denumire;
	private TipFisier extensie;
	private String locatie;

	public Fisier() {
		super();
	}

	public Fisier(String denumire, TipFisier extensie, String locatie) {
		super();
		this.denumire = denumire;
		this.extensie = extensie;
		this.locatie = locatie;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		try {
			if (denumire == null) {
				throw new ExceptieCustom("Numele fisierului nu poate fi null");
			} else if (denumire.equals("//") || denumire.equals("\\") || denumire.equals(":") || denumire.equals("?")
					|| denumire.equals("*") || denumire.contentEquals("<") || denumire.contentEquals(">")
					|| denumire.equals("|") || denumire.contentEquals("\"")) {
				throw new ExceptieCustom("Denumirea este incorecta!");
			} else {
				this.denumire = denumire;

			}
		} catch (ExceptieCustom e) {
			System.out.println("Numele este incorect. Doriti sa introduceti un nume nou?");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1 - Da");
			System.out.println("2 - Nu");
			int raspuns = scanner.nextInt();
			if (raspuns == 1) {
				System.out.println("Denumire folder: ");
				String denumireNoua = scanner.next();
				this.setDenumire(denumireNoua);
			}else {
				System.out.println("\"Denumire incorecta! Va rugam sa respectati conventia, numele nu poate contine \\\\ // : ? < > * | \\\" \"");
				
			}
		}
	}

	public TipFisier getExtensie() {
		return extensie;
	}

	public void setExtensie(TipFisier extensie) {
		try {
			if (extensie == null) {
				throw new ExceptieCustom("Extensia fisierului nu exista");
			}
		} catch (ExceptieCustom e) {
			System.out.println("Extensia nu exista. Doriti sa introduceti o extensie corecta?");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1 - Da");
			System.out.println("2 - Nu");
			int raspuns = scanner.nextInt();
			if (raspuns == 1) {
				System.out.println("Extensie noua: ");
				String extensieNoua = scanner.next();
				switch (extensieNoua) {
				case "mp3":
					this.setExtensie(TipFisier.mp3);
					break;
				case "mp4":
					this.setExtensie(TipFisier.mp4);
					break;
				case "jpg":
					this.setExtensie(TipFisier.jpg);
					break;
				case "png":
					this.setExtensie(TipFisier.png);
					break;
				default:
					System.out.println("Nu exista extensia data!Va rugam alegeti o extensie valabila!");
					break;
				}
			}
		}
		this.extensie = extensie;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		try {
			if (locatie == null) {
				throw new ExceptieCustom("Locatia fisierului nu poate fi null");
			}
		} catch (ExceptieCustom e) {
			System.out.println("Locatia este incorecta. Doriti sa introduceti o locatie noua?");
			Scanner scanner = new Scanner(System.in);
			System.out.println("1 - Da");
			System.out.println("2 - Nu");
			int raspuns = scanner.nextInt();
			if (raspuns == 1) {
				System.out.println("Locatie noua: ");
				String locatieNoua = scanner.next();
				this.setDenumire(locatieNoua);
			}
		}
		this.locatie = locatie;
	}

	@Override
	public String toString() {

		return "[Denumire fisier: " + this.denumire + ", Extensia: " + this.extensie + ", Locatie: " + this.locatie;

	}

	public String toStringFisier() {

		return this.denumire + "," + this.extensie + "," + this.locatie;
	}

}
