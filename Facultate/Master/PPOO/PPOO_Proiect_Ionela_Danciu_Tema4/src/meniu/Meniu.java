package meniu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import clase.ColectieFoldere;
import clase.Fisier;
import clase.Folder;
import clase.TipFisier;

public class Meniu {

	public static void afisareMeniu(ColectieFoldere colectieFoldere) {
		System.out.println("--------------Meniu principal--------------");
		System.out.println("1 - Informatii despre foldere");
		System.out.println("2 - Generare raport. ");
		System.out.println("3 - Inchide aplicatia \n");
		System.out.println("-----------------------------------\n");
		Scanner input = new Scanner(System.in);
		boolean repeta = true;
		String optiune = "-1";
		optiune = input.next();

		while (repeta) {
			switch (optiune) {
			case "0":
				System.out.println("--------------Meniu principal--------------");
				System.out.println("1 - Informatii despre foldere");
				System.out.println("2 - Generare raport. ");
				System.out.println("3 - Inchide aplicatia \n");
				optiune = input.next();
				break;
			case "1":
				System.out.println(colectieFoldere.toString());
				Vector<TipFisier> vectorTipFisier = new Vector<TipFisier>();

				for (int i = 0; i < TipFisier.values().length; i++) {
					vectorTipFisier.add(TipFisier.values()[i]);
				}
				System.out.println("***Tipurile de fisiere din aplicatie sunt: ");
				System.out.println(vectorTipFisier + "\n");
				System.out.println("0 - Meniu principal");
				System.out.println("4 - Vizualizare folder specific");
				System.out.println("5 - Creare folder");
				String optiuneFoldere = input.next();
				switch (optiuneFoldere) {
				case "4":
					System.out.println("Introduceti denumirea folderului de vizualizat: ");
					String denumire = input.next();
					boolean cautat = false;
					Folder folderGasit = new Folder();
					for (Folder folder : colectieFoldere.getListaFoldere()) {
						if (folder.getDenumireFolder().equals(denumire)) {
							cautat = true;
							folderGasit = folder;
						}
					}
					if (cautat == false) {
						System.out.println("Folderul nu a fost gasit!");
					} else {
						System.out.println("6 - Lista fisiere");
						System.out.println("7 - Adaugare fisier nou");
						System.out.println("8 - Stergere fisier");
						String optiuneSelectata = input.next();
						switch (optiuneSelectata) {
						case "6":
							for (Fisier f : folderGasit.getListaFisiere()) {
								System.out.println(f.toString());
							}
							break;
						case "7":
							Fisier newFile = new Fisier();
							System.out.println("Denumire fisier: ");
							String denumireNewFile = input.next();
							boolean gasit = false;
							boolean gresit = false;
							for (Fisier fisier : folderGasit.getListaFisiere()) {
								if (fisier.getDenumire().equals(denumireNewFile)) {
									gasit = true;
									break;
								} else if (denumireNewFile.equals("//") || denumireNewFile.equals("\\")
										|| denumireNewFile.equals(":") || denumireNewFile.equals("?")
										|| denumireNewFile.equals("*") || denumireNewFile.equals("<")
										|| denumireNewFile.equals(">") || denumireNewFile.equals("|")
										|| denumireNewFile.equals("\"")) {
									gresit = true;
									break;
								}
							}
							if (gasit == true) {
								System.out.println("Exista deja un fisier cu aceasta denumire");
							} else if (gresit == true) {
								System.out.println(
										"Denumire incorecta! Va rugam sa respectati conventia, numele nu poate contine \\ // : ? < > * | \" ");
							} else {
								newFile.setDenumire(denumireNewFile);
								System.out.println("Extensie fisier (mp3, mp4, jpg, png): ");
								String tipFisier = input.next();
								String locatie = "C:\\";
								switch (tipFisier) {
								case "mp3":
									newFile.setExtensie(TipFisier.mp3);
									locatie += folderGasit.getDenumireFolder() + "\\" + newFile.getDenumire() + "."
											+ newFile.getExtensie();
									newFile.setLocatie(locatie);
									System.out.println("Locatie fisier: " + locatie);
									folderGasit.getListaFisiere().add(newFile);
									break;
								case "mp4":
									newFile.setExtensie(TipFisier.mp4);
									locatie += folderGasit.getDenumireFolder() + "\\" + newFile.getDenumire() + "."
											+ newFile.getExtensie();
									newFile.setLocatie(locatie);
									System.out.println("Locatie fisier: " + locatie);
									folderGasit.getListaFisiere().add(newFile);
									System.out.println("Fisierul a fost adaugat cu succes!\n");
									break;
								case "jpg":
									newFile.setExtensie(TipFisier.jpg);
									locatie += folderGasit.getDenumireFolder() + "\\" + newFile.getDenumire() + "."
											+ newFile.getExtensie();
									newFile.setLocatie(locatie);
									System.out.println("Locatie fisier: " + locatie);
									folderGasit.getListaFisiere().add(newFile);
									System.out.println("Fisierul a fost adaugat cu succes!\n");
									break;
								case "png":
									newFile.setExtensie(TipFisier.png);
									locatie += folderGasit.getDenumireFolder() + "\\" + newFile.getDenumire() + "."
											+ newFile.getExtensie();
									newFile.setLocatie(locatie);
									System.out.println("Locatie fisier: " + locatie);
									folderGasit.getListaFisiere().add(newFile);
									System.out.println("Fisierul a fost adaugat cu succes!\n");
									break;
								default:
									System.out.println("Nu exista extensia introdusa.");
									break;

								}

							}
							break;

						case "8":
							ArrayList<Fisier> files = new ArrayList<Fisier>();
							System.out.println("Introduceti numele fisierului de sters");
							for (Fisier f : folderGasit.getListaFisiere()) {
								System.out.println(f.toString());
							}
							String fisierDeSters = input.next();
							boolean sters = false;
							Fisier fisDeSters = new Fisier();
							for (Fisier f : folderGasit.getListaFisiere()) {
								if (f.getDenumire().equals(fisierDeSters)) {
									sters = true;
									fisDeSters = f;
									System.out.println("----\nFisierul: " + fisierDeSters);
									break;
								}
							}
							if (sters == true) {
								files.add(fisDeSters);
								System.out.println("-----" + files);
								folderGasit.getListaFisiere().remove(fisDeSters);
								System.out.println("Fisierul a fost sters");
							} else {
								System.out.println("Nu exista acest fisier");
							}
							break;
						default:
							System.out.println("Nu exista optiunea!");
							break;
						}

					}
					break;

				case "5":

					System.out.println("Introduceti denumirea folderului nou: ");
					String denumireNoua = input.next();

					ArrayList<String> listaDenumiri = new ArrayList<String>();

					Iterator<Folder> itr = colectieFoldere.getListaFoldere().iterator();
					while (itr.hasNext()) {
						listaDenumiri.add(itr.next().getDenumireFolder());
					}
					System.out.println((listaDenumiri));

					boolean gasitDenumire = false;
					for (String den : listaDenumiri) {
						if (den.equals(denumireNoua)) {
							gasitDenumire = true;
						}
					}
					if (gasitDenumire == true) {

						System.out.println("Exista deja un folder cu aceasta denumire");
					} else {
						Folder folder = new Folder();
						folder.setDenumireFolder(denumireNoua);
						ArrayList<Fisier> list = new ArrayList<Fisier>();
						folder.setListaFisiere(list); // lista goala ca n are fisiere
						colectieFoldere.getListaFoldere().add(folder);
						System.out.println("Folder creat cu succes!");
					}
					break;
				case "0":
					System.out.println("Va rugam alegeti optiunea: ");
					break;
				default:
					System.out.println("Nu exista aceasta optiune!");
					break;
				}

				System.out.println("0 - Meniu principal");
				System.out.println("1 - Inapoi");
				optiune = input.next();
				break;

			case "2":
				System.out.println("9 - Generare raport general");
				System.out.println("10 - Generare raport fisiere in functie de extensie");
				System.out.println("11 - Generare raport total fisiere pe extensii");
				String optiuneRaport = input.next();
				switch (optiuneRaport) {
				case "9":
					int nrFoldere = colectieFoldere.getListaFoldere().size();
					System.out.println(
							"In " + colectieFoldere.getDenumire() + " exista " + nrFoldere + " folder/foldere: ");
					for (Folder folder : colectieFoldere.getListaFoldere()) {
						System.out.println("# " + folder.getDenumireFolder());
					}
					System.out.println("Fiecare folder are urmatoarea structura: ");
					for (Folder fl : colectieFoldere.getListaFoldere()) {
						System.out.println("\nFolderul " + fl.getDenumireFolder() + " contine: "
								+ fl.getListaFisiere().size() + " fisier/fisiere");
						for (Fisier f : fl.getListaFisiere()) {
							System.out.println("--->  Denumire: " + f.getDenumire() + "  Extensie: " + f.getExtensie()
									+ "  Locatie: " + f.getLocatie());
						}
					}

					File f = new File("raportGeneral.txt");
					FileWriter fw = null;
					BufferedWriter bw = null;
					try {
						fw = new FileWriter(f);
						bw = new BufferedWriter(fw);

						bw.write("In " + colectieFoldere.getDenumire() + " exista "
								+ colectieFoldere.getListaFoldere().size() + " folder/foldere:");
						for (Folder folder : colectieFoldere.getListaFoldere()) {
							bw.write("# " + folder.getDenumireFolder());
						}
						bw.write("Fiecare folder are urmatoarea structura: ");
						for (Folder fol : colectieFoldere.getListaFoldere()) {
							bw.write("\nFolderul " + fol.getDenumireFolder() + " contine: "
									+ fol.getListaFisiere().size() + " fisier/fisiere");
							for (Fisier fis : fol.getListaFisiere()) {
								bw.write("--->  Denumire: " + fis.getDenumire() + "  Extensie: " + fis.getExtensie()
										+ "  Locatie: " + fis.getLocatie());
							}
						}

						bw.close();
						fw.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case "10":

					File f1 = new File("raportExtensii.txt");
					FileWriter fw1 = null;
					BufferedWriter bw1 = null;
					try {
						fw1 = new FileWriter(f1);
						bw1 = new BufferedWriter(fw1);

						bw1.write("============================= RAPORT FISIERE =============================");
						bw1.newLine();
						bw1.write(String.format("%-20s|", "Denumire fisier") + String.format("%-25s|", "Extensie")
								+ String.format("%-30s", "Locatie"));
						bw1.newLine();
						bw1.write(
								"---------------------------------------------------------------------------------------------");
						bw1.newLine();
						System.out.println("Introduceti extensia fisierelor pe care le cautati: ");
						String extensieCautata = input.next();
						for (Folder foll : colectieFoldere.getListaFoldere()) {
							for (Fisier fiss : foll.getListaFisiere()) {
								if (String.valueOf(fiss.getExtensie()).equals(extensieCautata)) {
									// System.out.println("aiiici");
									bw1.write(String.format("%-20s|", fiss.getDenumire())
											+ String.format("%-25s|", fiss.getExtensie())
											+ String.format("%-30s", fiss.getLocatie()));
									bw1.newLine();
								}
							}

						}
						bw1.write(
								"---------------------------------------------------------------------------------------------");

						System.out.println("Raportul a fost generat in fisierul raportExtensii.txt");
						bw1.close();
						fw1.close();

					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
				case "11":
					int[] numarFisierePeExtensii = new int[4];
					for (Folder folder : colectieFoldere.getListaFoldere()) {
						for (Fisier fil : folder.getListaFisiere()) {
							if (fil.getExtensie().equals(TipFisier.mp3)) {
								numarFisierePeExtensii[0]++;
							} else if (fil.getExtensie().equals(TipFisier.mp4)) {
								numarFisierePeExtensii[1]++;
							} else if (fil.getExtensie().equals(TipFisier.jpg)) {
								numarFisierePeExtensii[2]++;
							} else if (fil.getExtensie().equals(TipFisier.png)) {
								numarFisierePeExtensii[3]++;
							} else {
								System.out.println("Ceva nu e ok!");
							}
						}
					}

					System.out.println("Fisiere pe extensii");
					System.out.println("\n Fisiere mp3: " + numarFisierePeExtensii[0]);
					System.out.println("\n Fisiere mp4: " + numarFisierePeExtensii[1]);
					System.out.println("\n Fisiere jpg: " + numarFisierePeExtensii[2]);
					System.out.println("\n Fisiere png: " + numarFisierePeExtensii[3]);
					System.out.println("\nNumar fisiere ordonate crescator: ");

					int vectorSortat[] = new int[4];
					int temp;
					for (int i = 0; i < numarFisierePeExtensii.length; i++) {
						vectorSortat[i] = numarFisierePeExtensii[i];
					}
					for (int i = 0; i < vectorSortat.length; i++) {
						for (int j = i + 1; j < vectorSortat.length; j++) {
							if (vectorSortat[i] > vectorSortat[j]) {
								temp = vectorSortat[i];
								vectorSortat[i] = vectorSortat[j];
								vectorSortat[j] = temp;
							}
						}
					}

					for (int i = 0; i < vectorSortat.length; i++) {
						System.out.println(vectorSortat[i]);
					}

					File fl = new File("raportTotalExtensii.txt");
					FileWriter fwr = null;
					BufferedWriter bwr = null;
					try {
						fwr = new FileWriter(fl);
						bwr = new BufferedWriter(fwr);

						bwr.write("Total fisiere cu extensia mp3: " + numarFisierePeExtensii[0]);
						bwr.write("\nTotal fisiere cu extensia mp4: " + numarFisierePeExtensii[1]);
						bwr.write("\nTotal fisiere cu extensia jpg: " + numarFisierePeExtensii[2]);
						bwr.write("\nTotal fisiere cu extensia png: " + numarFisierePeExtensii[3]);
						bwr.write("\nNumar fisiere ordonate crescator:");
						for (int i = 0; i < vectorSortat.length; i++) {
							bwr.write("\n" + vectorSortat[i]);
						}

						System.out.println("\nRaportul a fost generat in fisierul raportTotalExtensii.txt");

						bwr.close();
						fwr.close();

					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
				default:
					System.out.println("Nu exista optiunea!");
					break;
				}
				System.out.println("\n0 - Meniu principal");
				optiune = input.next();
				break;
			case "3":
				System.out.println("Aplicatia s-a inchis! O zi frumoasa!");
				colectieFoldere.scriereInFisier("date1.txt");
				repeta = false;
				break;
			default:
				repeta = false;
				System.out.println("Nu exista optiunea!Aplicatia se inchide!");
				colectieFoldere.scriereInFisier("date1.txt");
				break;

			}
		}

	}

}
