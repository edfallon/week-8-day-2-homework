import db.DBFolder;
import db.DBHelper;
import models.File;
import models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder folder1 = new Folder("Primary");
        DBHelper.save(folder1);

        Folder folder2 = new Folder("Secondary");
        DBHelper.save(folder2);

        File file1 = new File("Top Secret", "txt", 100, folder1);
        DBHelper.save(file1);

        File file2 = new File("Mildly Secret", "txt", 20, folder1);
        DBHelper.save(file2);
        
        List<File> files = DBHelper.getAll(File.class);

        List<Folder> folders = DBHelper.getAll(Folder.class);

        File foundFile = DBHelper.find(File.class, file2.getId());

        Folder foundFolder = DBHelper.find(Folder.class, folder1.getId());

        List<File> primaryFolderFiles = DBFolder.getFilesForFolder(foundFolder);


    }
}
