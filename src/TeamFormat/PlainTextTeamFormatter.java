package TeamFormat;

import Members.Student;
import Members.Teacher;
import Members.Team;

import java.util.Iterator;

public class PlainTextTeamFormatter implements TeamFormatter{
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static PlainTextTeamFormatter singletonInstance = new PlainTextTeamFormatter();

    public static PlainTextTeamFormatter getSingletonInstance() {
        return singletonInstance;
    }

    private PlainTextTeamFormatter() {
    }

    public String formatTeam(Team team) {
        StringBuilder plainText = new StringBuilder("Team{" + NEW_LINE);
        plainText.append("\tteamId: " + team.getTeamId() + NEW_LINE);
        plainText.append("\tteamName: " + team.getTeamName() + NEW_LINE);
        plainText.append("\tdepartment: " + team.getDepartment() + NEW_LINE);

        Student creator = team.getCreator();
        plainText.append("\tcreator{" + NEW_LINE);
        plainText.append("\t\tid:" + creator.getId() + NEW_LINE);
        plainText.append("\t\tname:" + creator.getName() + NEW_LINE);
        plainText.append("\t\tphoneNo:" + creator.getPhoneNo() + NEW_LINE);
        plainText.append("\t\temail:" + creator.getEmail() + NEW_LINE);
        plainText.append("\t\tstudentNo:" + creator.getStudentNo() + NEW_LINE);
        plainText.append("\t\tgender:" + getGender(creator.getGender()) + NEW_LINE);
        plainText.append("\t\tgrade:" + creator.getGrade() + NEW_LINE);
        plainText.append("\t\tdepartment:" + creator.getDepartment() + NEW_LINE);
        plainText.append("\t}" + NEW_LINE);


        plainText.append("\tstudentList{" + NEW_LINE);
        Iterator studentItr = team.getStudentList().iterator();
        while (studentItr.hasNext()){
            Student student = (Student) studentItr.next();
            plainText.append("\t\tstudent{" + NEW_LINE);
            plainText.append("\t\t\tid:" + student.getId() + NEW_LINE);
            plainText.append("\t\t\tname:" + student.getName() + NEW_LINE);
            plainText.append("\t\t\tphoneNo:" + student.getPhoneNo() + NEW_LINE);
            plainText.append("\t\t\temail:" + student.getEmail() + NEW_LINE);
            plainText.append("\t\t\tstudentNo:" + student.getStudentNo() + NEW_LINE);
            plainText.append("\t\t\tgender:" + getGender(student.getGender()) + NEW_LINE);
            plainText.append("\t\t\tgrade:" + student.getGrade() + NEW_LINE);
            plainText.append("\t\t\tdepartment:" + student.getDepartment() + NEW_LINE);
            plainText.append("\t\t}" + NEW_LINE);
        }
        plainText.append("\t}" + NEW_LINE);


        plainText.append("\tteacherList{" + NEW_LINE);
        Iterator teacherItr = team.getTeacherList().iterator();
        while (teacherItr.hasNext()){
            Teacher teacher = (Teacher) teacherItr.next();
            plainText.append("\t\tteacher{" + NEW_LINE);
            plainText.append("\t\t\tid:" + teacher.getId() + NEW_LINE);
            plainText.append("\t\t\tname:" + teacher.getName() + NEW_LINE);
            plainText.append("\t\t\tphoneNo:" + teacher.getPhoneNo() + NEW_LINE);
            plainText.append("\t\t\temail:" + teacher.getEmail() + NEW_LINE);
            plainText.append("\t\t\tteacherNo:" + teacher.getTeacherNo() + NEW_LINE);
            plainText.append("\t\t\tdepartment:" + teacher.getDepartment() + NEW_LINE);
            plainText.append("\t\t}" + NEW_LINE);
        }
        plainText.append("\t}" + NEW_LINE);
        plainText.append("}");
        return plainText.toString();
    }

    private String getGender(boolean gender){
        if(gender)
            return "女";
        return "男";
    }
}
