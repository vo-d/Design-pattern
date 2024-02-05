/** ACS-3913-001 */

public interface SectionBuilder{

    public Section getResult();

    public SectionBuilder forSection(String dept, String courseNo, String sectionNo);

    public SectionBuilder inRoom(String room);

    public SectionBuilder onDays(String days);

    public SectionBuilder startingAt(String startTime);

    public SectionBuilder endingAt(String endTime);

    public SectionBuilder taughtBy(String instructor);

    public SectionBuilder examOn(String examDate);
}