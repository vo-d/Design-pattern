/**
 * ACS-3913-001 F2022 - Assignment 4
 */

public class File extends FileComponent{
    private String data;    // file contents
    private int size;       // file size

    public File(String name, String data, int size){
        this.name = name;
        this.data = data;
        this.size = size;
    }

    public String getData() {
        return data;
    }
    
    public int getSize(){
        return size;
    }

    public void display(String indent) {
        indent += "--";
        System.out.println(indent + "File: " + name);
    }  
    
    public String toString(){
        return name;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}