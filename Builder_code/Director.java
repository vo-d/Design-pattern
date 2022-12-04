/** ACS-3913-001 */

public class Director{
    public static void main(String[] args)    {
        SectionBuilder sb = new ClassSectionBuilder()
            .forSection("ACS", "3913", "001")
            .inRoom("3D01")
            .onDays("MW")
            .startingAt("1:00pm")
            .endingAt("2:15am")
            .taughtBy("Bautista")
            .examOn("December 10, 2022");
        System.out.println("Section: "+sb.getResult());
        SectionBuilder sb2 = new ClassSectionBuilder()
            .forSection("ACS", "3916", "050")
            .inRoom("4C60")
            .onDays("Tu")
            .startingAt("6:00pm")
            .endingAt("9:00pm");
        System.out.println("Section: "+sb2.getResult());
    
    }
}
