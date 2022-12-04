/** ACS-3913-001 */

public class Section{
    private String dept, courseNo, sectionNo, days,
    room, startTime, endTime, instructor, examDate;

    public Section(){
        dept = "unknown";
        courseNo = "unknown";
        sectionNo = "unknown";
        room = "unknown";
        days = "unknown";
        startTime = "unknown";
        endTime = "unknown";
        instructor = "unknown";
        examDate = "unknown";
    }

    public void setDept(String dept){
        this.dept=dept;
    }

    public void setCourseNo(String courseNo){
        this.courseNo=courseNo;
    }

    public void setSectionNo(String sectionNo){
        this.sectionNo=sectionNo;
    }

    public void setRoom(String room){
        this.room=room;
    }

    public void setDays(String days){
        this.days=days;
    }

    public void setStartTime(String startTime){
        this.startTime=startTime;
    }

    public void setEndTime(String endTime){
        this.endTime=endTime;
    }

    public void setInstructor(String instructor){
        this.instructor=instructor;
    }

    public void setExamDate(String examDate){
        this.examDate=examDate;
    }

    public String toString(){
        return dept+"-"+courseNo+"-"+sectionNo
        +"\n\t\tin "+room
        +"\n\t\ton "+days
        +"\n\t\tfrom "+startTime+" to "+endTime
        +"\n\t\twith "+instructor
        +"\n\t\texam on "+examDate;
    }
}
