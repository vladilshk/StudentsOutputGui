package Logic;

import Members.Student;
import Members.Teacher;
import Members.Team;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TeamService {
    private Map<String , Team> teams = new LinkedHashMap<>();

    public void loadTeams() {
        String fileName = "team.dat";
        Path path = Paths.get(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (scanner.hasNextLine()){
            String teamDate = scanner.nextLine();
            Team team = getTeamFromString(teamDate);
            teams.put(team.getTeamId(), team);
            if (scanner.hasNextLine())
                scanner.nextLine();
        }
    }

    public Team getTeamFromString(String teamDate){
        String separator = "_";
        String[] subStr;
        subStr = teamDate.split(separator);
        Student creator = new Student(subStr[5],subStr[6], subStr[7], subStr[8], subStr[9], getGender(subStr[10]), subStr[11], subStr[12]);
        Team team = new Team(subStr[1], subStr[2], subStr[3], creator);
        int itr = 13;
        if(itr < subStr.length) {
            while (subStr[itr].equals("Student")) {
                itr++;
                Student student = new Student(subStr[itr++], subStr[itr++], subStr[itr++], subStr[itr++], subStr[itr++], getGender(subStr[itr++]), subStr[itr++], subStr[itr++]);
                team.addStudent(student);
                if (itr >= subStr.length)
                    break;
            }

            if(itr + 1 < subStr.length) {
                while (subStr[itr].equals("Teacher")) {
                    itr++;
                    Teacher teacher = new Teacher(subStr[itr++], subStr[itr++], subStr[itr++], subStr[itr++], subStr[itr++], subStr[itr++]);
                    team.addTeacher(teacher);
                    if (itr >= subStr.length)
                        break;
                }
            }
        }
        return team;

    }

    public Team getTeam(String id){
        return teams.get(id);
    }

    public List<String> getTeamsIds() {
        List<String> teamsIds = new ArrayList<>();
        int idx = 0;
        for(String id : teams.keySet()){
            teamsIds.add(idx, id);
        }
        return teamsIds;
    }

    public boolean getGender(String gender){
        if(gender.equals("女")){
            return true;
        }
        return false;

    }
}
