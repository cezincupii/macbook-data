package ro.ase.ppoo.classes;

import ro.ase.ppoo.exceptions.CustomException;

import java.util.ArrayList;
import java.util.Scanner;

import static ro.ase.ppoo.menu.Menu.REGEX;

public class Folder {
    private String folderName;
    private ArrayList<FileP> fileList;

    public Folder() {
        super();
    }

    public Folder(String folderName, ArrayList<FileP> fileList) {
        this.folderName = folderName;
        this.fileList = fileList;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        try {
            if(folderName==null) {
                throw new CustomException("Introduceti un nume");
            }
            else if (!folderName.matches(REGEX)) {
                throw new CustomException("Denumirea fisierului este incorecta. Se pot folosi doar litere, cifre si _,- si .");
            }
            else {
                this.folderName = folderName;
            }
        } catch (CustomException e) {
            System.out.println("Nume incorect. Introduceti un nume corect");
            Scanner scanner = new Scanner(System.in);
            String newName=scanner.next();
            this.setFolderName(newName);
        }
    }

    public ArrayList<FileP> getFileList() {
        return fileList;
    }

    public void setFileList(ArrayList<FileP> fileList) {
        this.fileList = fileList;
    }

    @Override
    public String toString() {
        return "\n Folder:" +
                "nume='" + folderName + '\'' +
                "\n Lista fisiere=" + fileList;
    }

    public String toStringInFile() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n" + this.fileList.size() + "\n");
        int i = 0;
        for (FileP f : this.fileList) {
            stringBuffer.append(f.toStringFile());
            if (i < this.fileList.size() - 1) {
                stringBuffer.append("\n");
            }
            i++;
        }
        return this.folderName + stringBuffer.toString();
    }
}
