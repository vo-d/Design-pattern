public class SearchVisitor implements Visitor{
    public String item;

    public SearchVisitor(){}

    public void setItem(String item){
        this.item = item;
    }

    public void visit(Folder folder){
        for (FileComponent fileComponent : folder.getFileComponent()){
            if(fileComponent instanceof File){
                File file = (File)fileComponent;
                if(file.getData().toLowerCase().contains(item)){
                    System.out.println(file.getPath());
                }
            }
            else{
                fileComponent.accept(this);
            }
        }
    }
    public void visit(File file){
        if(file.getData().toLowerCase().contains(item)){
            System.out.println(file.getPath());
        }
    }
}
