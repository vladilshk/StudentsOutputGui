package TeamFormat;

import Members.Student;
import Members.Teacher;
import Members.Team;

import java.util.Iterator;

public class HTMLTeamFormatter implements TeamFormatter{
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static HTMLTeamFormatter singletonInstance = new HTMLTeamFormatter();

    public static HTMLTeamFormatter getSingletonInstance() {
        return singletonInstance;
    }

    private HTMLTeamFormatter() {

    }

    public String formatTeam(Team team) {
        StringBuilder readyHTML = new StringBuilder("<html>" + NEW_LINE + "\t<body>" + NEW_LINE);
        readyHTML.append("\t\t<center><h2>Team Information</h2></center>" + NEW_LINE);
        readyHTML.append("\t\t<" + team.getTeamId() + ">");
        readyHTML.append("<" + team.getTeamName() + ">");
        readyHTML.append("<" + team.getDepartment() + "><br>" + NEW_LINE);

        Student creator = team.getCreator();
        readyHTML.append("\t\tcreator[");
        readyHTML.append("<" + creator.getId() + ">");
        readyHTML.append("<" + creator.getName() + ">");
        readyHTML.append("<" + creator.getPhoneNo() + ">");
        readyHTML.append("<" + creator.getEmail() + ">");
        readyHTML.append("<" + creator.getStudentNo() + ">");
        readyHTML.append("<" + getGender(creator.getGender()) + ">");
        readyHTML.append("<" + creator.getGrade() + ">");
        readyHTML.append("<" + creator.getDepartment() + ">]<br>" + NEW_LINE);


        readyHTML.append("\t\t<h3>StudentList</h3>" + NEW_LINE);
        readyHTML.append("\t\t<blockquote>" + NEW_LINE);
        Iterator studentItr = team.getStudentList().iterator();
        while (studentItr.hasNext()){
            Student student = (Student) studentItr.next();
            readyHTML.append("\t\t\t<" + student.getId() + ">");
            readyHTML.append("<" + student.getName() + ">");
            readyHTML.append("<" + student.getPhoneNo() + ">");
            readyHTML.append("<" + student.getEmail() + ">");
            readyHTML.append("<" + student.getStudentNo() + ">");
            readyHTML.append("<" + getGender(student.getGender()) + ">");
            readyHTML.append("<" + student.getGrade() + ">");
            readyHTML.append("<" + student.getDepartment() + ">");
            readyHTML.append("<br>" + NEW_LINE);

        }
        readyHTML.append("\t\t</blockquote>" + NEW_LINE);

        readyHTML.append("\t\t<h3>TeacherList</h3>" + NEW_LINE);
        readyHTML.append("\t\t<blockquote>" + NEW_LINE);
        Iterator teacherItr = team.getTeacherList().iterator();
        while (teacherItr.hasNext()){
            Teacher teacher = (Teacher) teacherItr.next();
            readyHTML.append("\t\t\t<" + teacher.getId() + ">");
            readyHTML.append("<" + teacher.getName() + ">");
            readyHTML.append("<" + teacher.getPhoneNo() + ">");
            readyHTML.append("<" + teacher.getEmail() + ">");
            readyHTML.append("<" + teacher.getTeacherNo() + ">");
            readyHTML.append("<" + teacher.getDepartment() + ">");
            readyHTML.append("<br>" + NEW_LINE);
        }
        readyHTML.append("\t\t</blockquote>" + NEW_LINE);

        readyHTML.append("\t</body>" + NEW_LINE + "</html>");
        return readyHTML.toString();
    }

    private String getGender(boolean gender){
        if(gender)
            return "女";
        return "男";
    }
}
