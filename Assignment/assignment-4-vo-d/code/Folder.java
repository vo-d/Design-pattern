/**
 * ACS-3913-001 F2022 - Assignment 4
 */

import java.util.ArrayList;

public class Folder extends FileComponent {
    private ArrayList<FileComponent> contents;

    public Folder(String n){
        name = n;
        contents = new ArrayList<>();
    }
    
    public void addFileComponent(FileComponent fc){
        contents.add(fc);
        fc.setParent(this);
    }
    
    public void display(String indent) {
        indent += "--";
        System.out.println(indent + "Folder: "+name);
        for(FileComponent fileComponent: contents){
            fileComponent.display(indent);
        }
    }

    public String toString(){
        return name;
    }

    public int getSize(){
        int size = 0;
        for (FileComponent fc : contents){
            size += fc.getSize();
        }
        return size;
    }

    public ArrayList<FileComponent> getFileComponent(){
        return contents;
    }

    public void accept(Visitor v){
        v.visit(this);
    }

}