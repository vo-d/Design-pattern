import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Configuration {
    private static Configuration uniqueInstance;
    private int numberOfOptions;
    private int height;
    private Configuration(){
        try{
            File file = new File("E:/University of Winnipeg/Fall-Winter 2022-2023/Software des/assignment-3-vo-d/part-a/RemoteConfig.txt");
            Scanner fileReader = new Scanner(file);
            this.numberOfOptions = fileReader.nextInt();
            this.height = fileReader.nextInt();
        }
        catch(FileNotFoundException e){
            System.out.println("Can not find file");
        }
    }
    public static Configuration getConfiguration(){
        if(uniqueInstance == null){
            System.out.println("Creating an instance of remote configuration");
            uniqueInstance = new Configuration();
        }
        System.out.println("Returning instance of remote configuration");
        return uniqueInstance;
    }
    public int getNumberOfOption(){
        return this.numberOfOptions;
    }
    public int getHeight(){
        return this.height;
    }
}
