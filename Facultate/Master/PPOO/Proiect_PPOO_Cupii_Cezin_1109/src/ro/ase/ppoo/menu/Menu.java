package ro.ase.ppoo.menu;

import ro.ase.ppoo.classes.FileP;
import ro.ase.ppoo.classes.FileType;
import ro.ase.ppoo.classes.Folder;
import ro.ase.ppoo.classes.FolderCollection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {

    public static final String REGEX="[_a-zA-Z0-9\\-\\.]+";

    public static void openMenu(FolderCollection folderCollection) {
        System.out.println("Meniu");
        System.out.println("1. Vizualizare foldere");
        System.out.println("2. Iesire");
        System.out.println("8. Generare raport");
        Scanner input = new Scanner(System.in);
        boolean exit=false;
        String option="";
        option=input.next();

        while (!exit) {
            switch (option) {
                case "0":
                    System.out.println("Meniu");
                    System.out.println("1. Vizualizare foldere");
                    System.out.println("2. Iesire");
                    System.out.println("8. Generare raport");
                    option=input.next();
                    break;
                case "1":
                    System.out.println(folderCollection.toString());
                    System.out.println("3. Vizualizare folder");
                    System.out.println("4. Creare folder");
                    System.out.println("5. Stergere folder");
                    System.out.println("0. Meniu principal");
                    String folderOption=input.next();
                    switch (folderOption) {
                        case "3":
                            System.out.println("Nume folder:");
                            String folderName=input.next();
                            boolean found=false;
                            Folder foundFolder = new Folder();
                            for (Folder folder: folderCollection.getFolderList()) {
                                if(folder.getFolderName().equals(folderName)) {
                                    found=true;
                                    foundFolder=folder;
                                }
                            }
                            if(!found) {
                                System.out.println("Folder inexistent");
                            }
                            else {
                                System.out.println("Fisiere din cadrul folderului "+ folderName);
                                for(FileP fileP: foundFolder.getFileList()) {
                                    System.out.println(fileP.toString());
                                }
                                System.out.println("\n");
                                System.out.println("6.Adaugare fisier");
                                System.out.println("7.Stergere fisier");
                                String fileOption=input.next();
                                switch (fileOption) {
                                    case "6":
                                        FileP newFile = new FileP();
                                        System.out.println("Nume:");
                                        String newFileName=input.next();
                                        boolean foundName=false;
                                        boolean wrongName=false;
                                       for (FileP fileP: foundFolder.getFileList()) {
                                           if(fileP.getName().equals(newFileName)) {
                                               foundName=true;
                                               break;
                                           }
                                           else if (!newFileName.matches(REGEX)) {
                                               wrongName=true;
                                               break;
                                           }
                                       }
                                       if(foundName) {
                                           System.out.println("Fisier existent");
                                       } else if (wrongName) {
                                           System.out.println("Denumirea fisierului este incorecta. Se pot folosi doar litere, cifre si _,- si .");
                                       }
                                       else {
                                           newFile.setName(newFileName);
                                           System.out.println("Extensie (mp3,jpg,png,wav):");
                                           String fileType=input.next();
                                           String location="/"+foundFolder.getFolderName()+"/";
                                           switch (fileType) {
                                               case "mp3":
                                                   newFile.setExtension(FileType.mp3);
                                                   location+=newFile.getName()+"."+newFile.getExtension();
                                                   newFile.setLocation(location);
                                                   foundFolder.getFileList().add(newFile);
                                                   System.out.println("Fisier adaugat cu succes in locatia :"+location);
                                                   break;
                                               case "jpg":
                                                   newFile.setExtension(FileType.jpg);
                                                   location+=newFile.getName()+"."+newFile.getExtension();
                                                   newFile.setLocation(location);
                                                   foundFolder.getFileList().add(newFile);
                                                   System.out.println("Fisier adaugat cu succes in locatia :"+location);
                                                   break;
                                               case "png":
                                                   newFile.setExtension(FileType.png);
                                                   location+=newFile.getName()+"."+newFile.getExtension();
                                                   newFile.setLocation(location);
                                                   foundFolder.getFileList().add(newFile);
                                                   System.out.println("Fisier adaugat cu succes in locatia :"+location);
                                                   break;
                                               case "wav":
                                                   newFile.setExtension(FileType.wav);
                                                   location+=newFile.getName()+"."+newFile.getExtension();
                                                   newFile.setLocation(location);
                                                   foundFolder.getFileList().add(newFile);
                                                   System.out.println("Fisier adaugat cu succes in locatia :"+location);
                                                   break;
                                               default:
                                                   System.out.println("Extensie inexistenta");
                                                   break;
                                           }
                                       }
                                       break;
                                    case "7":
                                        System.out.println("Nume fisier:");
                                        for (FileP file: foundFolder.getFileList()) {
                                            System.out.println(file.toString());
                                        }
                                        String fileDeleted=input.next();
                                        for (FileP file : foundFolder.getFileList()) {
                                            if(file.getName().equals(fileDeleted)) {
                                                foundFolder.getFileList().remove(file);
                                                System.out.println("Fisierul "+file.getName()+" a fost sters");
                                                break;
                                            }
                                        }
                                        break;
                                }
                            }
                            break;

                        case "4":
                            System.out.println("Nume:");
                            String newName=input.next();

                            ArrayList<String> namesList= new ArrayList<String>();

                            Iterator<Folder> itr = folderCollection.getFolderList().iterator();
                            while (itr.hasNext()) {
                                namesList.add(itr.next().getFolderName());
                            }
                            System.out.println(namesList);

                            boolean foundName = false;
                            for (String name: namesList) {
                                if(name.equals(newName)) {
                                    foundName=true;
                                }
                            }
                            if(foundName) {
                                System.out.println("Nume existent!");
                            }
                            else {
                                Folder folder=new Folder();
                                folder.setFolderName(newName);
                                ArrayList<FileP> filePArrayList = new ArrayList<>();
                                folder.setFileList(filePArrayList);
                                folderCollection.getFolderList().add(folder);
                                System.out.println("Folder creat!");
                            }
                            break;
                        case "5":
                            for (Folder folder : folderCollection.getFolderList()) {
                                System.out.println(folder.toString());
                            }
                            System.out.println("Nume folder:");
                            String folderDeleted=input.next();
                            for (Folder folder: folderCollection.getFolderList()) {
                                if(folder.getFolderName().equals(folderDeleted)) {
                                    folderCollection.getFolderList().remove(folder);
                                    System.out.println("Folderul "+folder.getFolderName()+" a fost sters");
                                    break;
                                }
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
                    option = input.next();
                    break;
                case "2":
                    System.out.println("Aplicatie inchisa!");
                    folderCollection.writeInFile("input.txt");
                    exit=true;
                    break;
                case "8":
                    System.out.println("In "+folderCollection.getName()+" se afla "+folderCollection.getFolderList().size()+" foldere:");
                    for (Folder folder : folderCollection.getFolderList()) {
                        System.out.println("# "+folder.getFolderName());
                    }
                    System.out.println("Foldere au urmatoarele fisiere:");
                    for (Folder folder: folderCollection.getFolderList()) {
                        System.out.println("\n Folderul: "+folder.getFolderName()+" contine: "+folder.getFileList().size()+" fisiere");
                        for (FileP fileP:folder.getFileList()) {
                            System.out.println(" => Denumire:"+fileP.getName()+" Extensie: "+fileP.getExtension()+" Locatie: "+fileP.getLocation());
                        }
                    }

                    File file = new File("raportGeneral.txt");
                    FileWriter fw=null;
                    BufferedWriter bw =null;
                    try {
                        fw=new FileWriter(file);
                        bw = new BufferedWriter(fw);
                        bw.write("In "+folderCollection.getName()+" se afla "+folderCollection.getFolderList().size()+" foldere:");
                        for (Folder folder : folderCollection.getFolderList()) {
                            bw.write("# "+folder.getFolderName());
                        }
                        System.out.println("Foldere au urmatoarele fisiere:");
                        for (Folder folder: folderCollection.getFolderList()) {
                            bw.write("\n Folderul: "+folder.getFolderName()+" contine: "+folder.getFileList().size()+" fisiere");
                            for (FileP fileP:folder.getFileList()) {
                                bw.write(" => Denumire:"+fileP.getName()+" Extensie: "+fileP.getExtension()+" Locatie: "+fileP.getLocation());
                            }
                        }

                        bw.close();
                        fw.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    exit=true;
                    break;
                default:
                    exit=true;
                    System.out.println("Optiune inexistenta! Aplicatie inchisa!");
                    folderCollection.writeInFile("input.txt");
                    break;
            }
        }
    }
}
