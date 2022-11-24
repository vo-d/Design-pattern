 
public class HTMLVisitor implements Visitor { 
        
    public void visit(Menu m) {
        System.out.println("<h1>"+m.getName()+" "+m.getDescription()+"</h1>" );
        System.out.println("<ol>" );
        // iterate over children
        for (MenuComponent component: m.getMenuComponents()){
            component.accept(this);
        }
        System.out.println("</ol>" );
    }

    public void visit(MenuItem m) {
        System.out.println("<li>ITEM "+m.getName()+" "+m.getDescription()+" "+m.getPrice()+"</li>");
    }
}