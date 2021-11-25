package ro.ase.ppoo.classes;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FolderCollection {

    private String name;
    private Set<Folder> folderList = new HashSet<Folder>();

    public FolderCollection() {
        super();
    }

    public FolderCollection(String name, Set<Folder> folderList) {
        this.name = name;
        this.folderList = folderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Folder> getFolderList() {
        return folderList;
    }

    public void setFolderList(Set<Folder> folderList) {
        this.folderList = folderList;
    }

    @Override
    public String toString() {
        return "FolderCollection: \n" +
                "nume: '" + name + "\n" +
                "Lista foldere: \n" + folderList+"\n";
    }

    public String toStringInFile() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n"+this.folderList.size()+"\n");
        int i=0;
        for (Folder f: this.folderList) {
            stringBuffer.append(f.toStringInFile());
            if(i<this.folderList.size()-1) {
                stringBuffer.append("\n");
            }
            i++;
        }
        return this.name+stringBuffer.toString();
    }

    public void writeInFile(String fileName) {
        File file = new File(fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter=new FileWriter(file);
            bufferedWriter= new BufferedWriter(fileWriter);
            bufferedWriter.write(this.toStringInFile());
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FolderCollection readFromFile(String fileName) {
        FolderCollection collection = new FolderCollection();

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            String line=bufferedReader.readLine();
            String result[]=line.split(",");
            collection.setName(result[0]);

            int foldersSize=Integer.parseInt(bufferedReader.readLine());
            Set<Folder> folderList=new HashSet<Folder>();
            for(int i=0;i<foldersSize;i++) {
                if((line=bufferedReader.readLine())!=null) {
                    Folder folder =new Folder();
                    String[] fld=line.split(",");
                    folder.setFolderName(fld[0]);
                    int fileSize=Integer.parseInt(bufferedReader.readLine());
                    if(fileSize==0) {
                        folder.setFolderName(fld[0]);
                        folder.setFileList(new ArrayList<FileP>());
                        folderList.add(folder);
                        line=bufferedReader.readLine();
                    }
                    else {
                        ArrayList<FileP> filePArrayList = new ArrayList<FileP>();
                        for (int ii=0;ii<fileSize;ii++) {
                            if((line=bufferedReader.readLine())!=null) {
                                String fil[]=line.split(",");
                                FileP fileP = new FileP();
                                fileP.setName(fil[0]);
                                String extension= fil[1];
                                switch (extension) {
                                    case "mp3":
                                        fileP.setExtension(FileType.mp3);
                                        break;
                                    case "png":
                                        fileP.setExtension(FileType.png);
                                        break;
                                    case "jpg":
                                        fileP.setExtension(FileType.jpg);
                                        break;
                                    case "wav":
                                        fileP.setExtension(FileType.wav);
                                        break;
                                    default:
                                        System.out.println(extension+"Extensie inexistenta!");
                                        break;
                                }
                                fileP.setLocation(fil[2]);
                                filePArrayList.add(fileP);
                            }
                        }

                        folder.setFileList(filePArrayList);
                        folderList.add(folder);
                    }
                }
            }
            collection.setFolderList(folderList);
            bufferedReader.close();
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return collection;
    }
}
