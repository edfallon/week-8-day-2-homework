import db.DBFolder;
import db.DBHelper;
import db.DBOwner;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner1 = new Owner("Barry", "Bazza123");
        DBHelper.save(owner1);

        Owner owner2 = new Owner("Jane", "userjane");
        DBHelper.save(owner2);

        Folder folder1 = new Folder("Primary", owner1);
        DBHelper.save(folder1);

        Folder folder2 = new Folder("Secondary", owner2);
        DBHelper.save(folder2);

        File file1 = new File("Top Secret", "txt", 100, folder1);
        DBHelper.save(file1);

        File file2 = new File("Mildly Secret", "txt", 20, folder1);
        DBHelper.save(file2);
        
        List<File> files = DBHelper.getAll(File.class);

        List<Folder> folders = DBHelper.getAll(Folder.class);

        List<Owner> owners = DBHelper.getAll(Owner.class);

        Owner foundOwner = DBHelper.find(Owner.class, owner1.getId());

        File foundFile = DBHelper.find(File.class, file2.getId());

        Folder foundFolder = DBHelper.find(Folder.class, folder1.getId());

        List<File> primaryFolderFiles = DBFolder.getFilesForFolder(foundFolder);

        List<File> foldersOfOwner = DBOwner.getFoldersForOwner(foundOwner);




    }
}
