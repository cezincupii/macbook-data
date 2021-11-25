package ro.ase.ppoo.main;

import ro.ase.ppoo.classes.Folder;
import ro.ase.ppoo.classes.FolderCollection;
import ro.ase.ppoo.menu.Menu;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
	// write your code here
        File file = new File("input.txt");
        FolderCollection folderCollection = new FolderCollection();
        if (file.exists()) {
            folderCollection=FolderCollection.readFromFile("input.txt");
        } else {
            try {
                file.createNewFile();
                Set<Folder> list = new HashSet<Folder>();
                FolderCollection folderCollection1 = new FolderCollection("/Documents/",list);
                folderCollection1.writeInFile("input.txt");
                folderCollection=FolderCollection.readFromFile("input.txt");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Menu.openMenu(folderCollection);

    }
}
