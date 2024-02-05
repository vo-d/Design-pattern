/**
 * ACS-3913-001 F2022 - Assignment 4
 */

public abstract class FileComponent {
    protected String name;
    protected FileComponent parent;
    
    public String getName(){
        return name;
    }

    public FileComponent getParent(){
        return parent;
    }
    
    public void setParent(FileComponent fc){
        parent = fc;
    }
    
    public void addFileComponent(FileComponent fc){
        throw new UnsupportedOperationException();
    }

    public void display(String indent){
        throw new UnsupportedOperationException();
    }

    public int getSize(){
        throw new UnsupportedOperationException();
    }

    public String getPath(){
        String path = "";
        if (this.getParent() != null){
            path += this.getParent().getPath() + "/" + this.toString();
        }
        else {
            path +=  this.toString();
        }
        return path;
    }
    
    public abstract void accept(Visitor v);
}