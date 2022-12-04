/** ACS-3913-001 */

public class ClassSectionBuilder implements SectionBuilder{

    private Section content;

    public ClassSectionBuilder(){
        content = new Section();
    }
    
    public Section getResult(){
        return content;
    }

    public ClassSectionBuilder forSection(String dept, String courseNo, String sectionNo){
        content.setDept(dept);
        content.setCourseNo(courseNo);
        content.setSectionNo(sectionNo);
        return this;
    }
    
    public ClassSectionBuilder inRoom(String room){
        content.setRoom(room);
        return this;
    }
    
    public ClassSectionBuilder onDays(String days){
        content.setDays(days);
        return this;
    
    }
    public ClassSectionBuilder startingAt(String startTime){
        content.setStartTime(startTime);
        return this;
    }
    
    public ClassSectionBuilder endingAt(String endTime){
        content.setEndTime(endTime);
        return this;
    }
    
    public ClassSectionBuilder taughtBy(String instructor){
        content.setInstructor(instructor);
        return this;
    }
    
    public ClassSectionBuilder examOn(String examDate){
        content.setExamDate(examDate);
        return this;
    }
}
