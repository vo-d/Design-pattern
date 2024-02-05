public class BackupVisitor implements Visitor{
    public void visit(Folder folder){
        for(FileComponent fileComponent : folder.getFileComponent()){
            if (fileComponent instanceof File){
                System.out.println("Backing up file " + fileComponent.toString()+ "...");
            }
            else{
                System.out.println("Backing up folder " + fileComponent.toString()+ " content:");
                fileComponent.accept(this);
            }
        }
    }
    public void visit(File file){
        System.out.println("Backing up file " + file.toString() + "...");
    }
}
