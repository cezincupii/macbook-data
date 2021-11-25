package clase;

import java.util.ArrayList;
import java.util.Scanner;

import exceptii.ExceptieCustom;

public class Folder {

	private String denumireFolder;
	private ArrayList<Fisier> listaFisiere;

	public Folder() {
		super();
	}

	public Folder(String denumireFolder, ArrayList<Fisier> listaFisiere) {
		super();
		this.denumireFolder = denumireFolder;
		this.listaFisiere = listaFisiere;
	}

	public String getDenumireFolder() {
		return denumireFolder;
	}

	public void setDenumireFolder(String denumireFolder) {
		try {
			if (denumireFolder == null) {
				throw new ExceptieCustom("Numele nu poate fi null");
			} else if (denumireFolder.equals("//") || denumireFolder.equals("\\") || denumireFolder.equals(":") || denumireFolder.equals("?")
					|| denumireFolder.equals("*") || denumireFolder.contentEquals("<") || denumireFolder.contentEquals(">") || denumireFolder.equals("|")
					|| denumireFolder.contentEquals("\"")) {
				throw new ExceptieCustom("Denumirea este incorecta!");
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
				this.setDenumireFolder(denumireNoua);
			}
		}
		this.denumireFolder = denumireFolder;
	}

	public ArrayList<Fisier> getListaFisiere() {
		return listaFisiere;
	}

	public void setListaFisiere(ArrayList<Fisier> listaFisiere) {
		this.listaFisiere = listaFisiere;
	}

	@Override
	public String toString() {

		String rez = "\n{Denumire folder: " + this.denumireFolder + "\n";

		rez += "Folderul contine fisierele: " + "\n" + listaFisiere + "}\n";

		return rez;
	}

	public String toStringScriereInFisierText() {

		StringBuffer lista = new StringBuffer();
		lista.append("\n" + this.listaFisiere.size() + "\n");
		int i = 0;
		for (Fisier f : this.listaFisiere) {
			lista.append(f.toStringFisier());
			if (i < this.listaFisiere.size() - 1) {
				lista.append("\n");
			}
			i++;
		}
		return this.denumireFolder + lista.toString();
	}

}
