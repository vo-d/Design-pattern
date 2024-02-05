
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
public class Logger{
    private static Logger uniqueInstance;
    private FileWriter logger;
    private Logger() throws IOException{
        File file = new File("E:/University of Winnipeg/Fall-Winter 2022-2023/Software des/assignment-3-vo-d/part-a/log.txt");
        this.logger = new FileWriter(file);
    }
    
    public static Logger getLogger(){ 
        try {
            if(uniqueInstance == null){
                System.out.println("Creating an instance of Logger");
                uniqueInstance = new Logger();    
            }
            System.out.println("Returning instance of Logger");
            return uniqueInstance;
        }
        catch(IOException e){
            System.out.println(e);
            return null;
        }
        
    }

    public void log(String string){
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now(); 
            logger.write(dtf.format(now) + " " + string + "\n");
            
        }
        catch(IOException e){
            System.out.println(e + "logerror");
        }
        
    }

    public void close() throws IOException{
        logger.close();
    }
}