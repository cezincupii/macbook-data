package ro.ase.ppoo.classes;

import ro.ase.ppoo.exceptions.CustomException;

import java.util.Scanner;
import static ro.ase.ppoo.menu.Menu.REGEX;


public class FileP {


    private String name;
    private FileType extension;
    private String location;

    public FileP() {
        super();
    }

    public FileP(String name, FileType extension, String location) {
        this.name = name;
        this.extension = extension;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            if(name==null) {
                throw new CustomException("Introduceti un nume");
            }
            else if (!name.matches(REGEX)) {
                throw new CustomException("Denumirea fisierului este incorecta. Se pot folosi doar litere, cifre si _,- si .");
            }
            else {
                this.name = name;
            }
        } catch (CustomException e) {
            System.out.println("Nume incorect. Introduceti un nume corect");
            Scanner scanner = new Scanner(System.in);
            String newName=scanner.next();
            this.setName(newName);
        }

    }

    public FileType getExtension() {
        return extension;
    }

    public void setExtension(FileType extension) {
        this.extension = extension;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "\n\t Fisier:" +
                "nume:'" + name + '\'' +
                ", extensie:'" + extension + '\'' +
                ", locatie:'" + location + '\'' +
                '}';
    }

    public String toStringFile() {

        return this.name+","+this.extension+","+this.location;
    }
}
