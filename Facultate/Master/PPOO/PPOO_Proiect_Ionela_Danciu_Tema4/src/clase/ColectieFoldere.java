package clase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ColectieFoldere {

	private String denumire;
	private Set<Folder> listaFoldere = new HashSet<Folder>();

	public ColectieFoldere() {
		super();
	}

	public ColectieFoldere(String denumire, Set<Folder> listaFoldere) {
		super();
		this.denumire = denumire;
		this.listaFoldere = listaFoldere;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public Set<Folder> getListaFoldere() {
		return listaFoldere;
	}

	public void setListaFoldere(Set<Folder> listaFoldere) {
		this.listaFoldere = listaFoldere;
	}

	@Override
	public String toString() {

		String rez = "Denumire locatie: " + this.denumire + "\n";

		rez += "Foldere: " + "\n" + listaFoldere + "\n";

		return rez;
	}
	

	public void scriereInFisier(String numeFisier) {
		File f = new File(numeFisier);
		FileWriter fw = null;
		BufferedWriter bf = null;
		try {
			fw = new FileWriter(f);
			bf = new BufferedWriter(fw);
			bf.write(this.toStringScriereInFisierText());
			bf.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public String toStringScriereInFisierText() {
		StringBuffer lista = new StringBuffer();
		lista.append("\n" + this.listaFoldere.size() + "\n");
		int i = 0;
		for (Folder f : this.listaFoldere) {
			lista.append(f.toStringScriereInFisierText());
			if (i < this.listaFoldere.size() - 1) {
				lista.append("\n");
			}
			i++;
		}
		return this.denumire + lista.toString();

	}
	

	public static ColectieFoldere citireDinFisier(String numeFisier) {
		ColectieFoldere colectie = new ColectieFoldere();

		try {
			File f = new File(numeFisier);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			String rez[] = line.split(",");
			//System.out.println(rez[0]);
			colectie.setDenumire(rez[0]);
			int nrFoldere = Integer.parseInt(br.readLine());
			Set<Folder> listaFoldere = new HashSet<Folder>();
			for (int i = 0; i < nrFoldere; i++) {
				if ((line = br.readLine()) != null) {
					Folder folder = new Folder();
					String[] fold = line.split(",");
					folder.setDenumireFolder(fold[0]);
					int nrFisiere = Integer.parseInt(br.readLine());
					if (nrFisiere == 0) {
						folder.setDenumireFolder(fold[0]);
						folder.setListaFisiere(new ArrayList<Fisier>());
						listaFoldere.add(folder);
						line = br.readLine();
					} else {

						ArrayList<Fisier> listaF = new ArrayList<Fisier>();
						for (int j = 0; j < nrFisiere; j++) {
							if ((line = br.readLine()) != null) {
								String fis[] = line.split(",");
								Fisier a = new Fisier();
								a.setDenumire(fis[0]);
								String extensie = fis[1];
								switch (extensie) {
								case "mp3":
									a.setExtensie(TipFisier.mp3);
									break;
								case "mp4":
									a.setExtensie(TipFisier.mp4);
									break;
								case "jpg":
									a.setExtensie(TipFisier.jpg);
									break;
								case "png":
									a.setExtensie(TipFisier.png);
									break;
								default:
									System.out.println("Nu exista extensia data!Va rugam alegeti o extensie valabila!");
									break;

								}
								a.setLocatie(fis[2]);
								listaF.add(a);
							}
						}

						folder.setListaFisiere(listaF);
						listaFoldere.add(folder);

					}
				}

			}
			colectie.setListaFoldere(listaFoldere);
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return colectie;
	}

}
