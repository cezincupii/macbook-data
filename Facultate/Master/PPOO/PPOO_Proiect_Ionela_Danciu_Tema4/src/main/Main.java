package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import clase.ColectieFoldere;
import clase.Fisier;
import clase.Folder;
import clase.TipFisier;
import meniu.Meniu;

public class Main {
	public static void main(String[] args) {

//		Fisier f = new Fisier("test", TipFisier.mp3,"C:\\muzica\\test.mp3");
//		Fisier f1 = new Fisier("test2", TipFisier.mp3,"C:\\muzica\\test2.mp3");
//		ArrayList<Fisier>listaFisiere= new ArrayList<Fisier>();
//		listaFisiere.add(f);
//		listaFisiere.add(f1);
//		
//		Fisier img = new Fisier("img", TipFisier.jpg,"C:\\imagini\\img.jpg");
//		Fisier img1 = new Fisier("img2", TipFisier.png,"C:\\imagini\\img2.png");
//		ArrayList<Fisier>listaFisiere1= new ArrayList<Fisier>();
//		listaFisiere1.add(img);
//		listaFisiere1.add(img1);
//		
//		Folder folder = new Folder("muzica", listaFisiere);
//		Folder folder1 = new Folder("imagini",listaFisiere1);
//		Set<Folder>listaFoldere = new HashSet<Folder>();
//		listaFoldere.add(folder);
//		listaFoldere.add(folder1);
//		ColectieFoldere colectie = new ColectieFoldere("This PC", listaFoldere);
////		
//		colectie.scriereInFisier("date1.txt");
		File f = new File("date1.txt");
		ColectieFoldere col = new ColectieFoldere();
		if (f.exists()) {
			 col = ColectieFoldere.citireDinFisier("date1.txt");
		} else {
			try {
				f.createNewFile();
				Set<Folder>lista = new HashSet<Folder>();
				ColectieFoldere colectie = new ColectieFoldere("Local Disk(C:)",lista);
				colectie.scriereInFisier("date1.txt");
				 col = ColectieFoldere.citireDinFisier("date1.txt");
			//	col = ColectieFoldere.citireDinFisier("date1.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		Meniu.afisareMeniu(col);

	}

}
