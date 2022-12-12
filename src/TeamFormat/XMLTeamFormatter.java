package TeamFormat;

import Members.Student;
import Members.Teacher;
import Members.Team;

import java.util.Iterator;

public class XMLTeamFormatter implements TeamFormatter {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static XMLTeamFormatter singletonInstance = new XMLTeamFormatter();

    public static XMLTeamFormatter getSingletonInstance() {
        return singletonInstance;
    }

    private XMLTeamFormatter() {
    }

    public String formatTeam(Team team) {
        StringBuilder readyXML = new StringBuilder();
        readyXML.append("<Team ");
        readyXML.append("teamId = \"" + team.getTeamId() + "\" ");
        readyXML.append("teamName = \"" + team.getTeamId() + "\" ");
        readyXML.append("department = \"" + team.getTeamId() + "\">" + NEW_LINE);

        readyXML.append("\t<Creator ");
        Student creator = team.getCreator();
        readyXML.append("id=\"" + creator.getId() + "\" ");
        readyXML.append("name=\"" + creator.getName() + "\" ");
        readyXML.append("phoneNo\"" + creator.getPhoneNo() + "\" ");
        readyXML.append("email=\"" + creator.getEmail() + "\" ");
        readyXML.append("studentNO=\"" + creator.getStudentNo() + "\" ");
        readyXML.append("gender=\"" + getGender(creator.getGender()) + "\" ");
        readyXML.append("grade=\"" + creator.getGrade() + "\" ");
        readyXML.append("department=\"" + creator.getDepartment() + "\"/>" + NEW_LINE);

        readyXML.append("\t<StudentList>" + NEW_LINE);
        Iterator studentItr = team.getStudentList().iterator();
        while (studentItr.hasNext()){
            Student student = (Student) studentItr.next();
            readyXML.append("\t\t<Student ");
            readyXML.append("id=\"" + student.getId() + "\" ");
            readyXML.append("name=\"" + student.getName() + "\" ");
            readyXML.append("phoneNo\"" + student.getPhoneNo() + "\" ");
            readyXML.append("email=\"" + student.getEmail() + "\" ");
            readyXML.append("studentNO=\"" + student.getStudentNo() + "\" ");
            readyXML.append("gender=\"" + getGender(student.getGender()) + "\" ");
            readyXML.append("grade=\"" + student.getGrade() + "\" ");
            readyXML.append("department=\"" + student.getDepartment() + "\"/>" + NEW_LINE);
        }
        readyXML.append("\t</StudentList>" + NEW_LINE);

        readyXML.append("\t<TeacherList" + NEW_LINE);
        Iterator teacherItr = team.getTeacherList().iterator();
        while (teacherItr.hasNext()){
            Teacher teacher = (Teacher) teacherItr.next();
            readyXML.append("\t\t<Teacher ");
            readyXML.append("id=\"" + teacher.getId() + "\" ");
            readyXML.append("name=\"" + teacher.getName() + "\" ");
            readyXML.append("phoneNo\"" + teacher.getPhoneNo() + "\" ");
            readyXML.append("email=\"" + teacher.getEmail() + "\" ");
            readyXML.append("teacherNO=\"" + teacher.getTeacherNo() + "\" ");
            readyXML.append("department=\"" + teacher.getDepartment() + "\"/>" + NEW_LINE);
        }
        readyXML.append("\t</TeacherList>" + NEW_LINE);

        readyXML.append("</Team>");
        return readyXML.toString();
    }

    private String getGender(boolean gender){
        if(gender)
            return "女";
        return "男";
    }
}

