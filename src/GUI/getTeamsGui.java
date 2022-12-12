package GUI;

import Logic.TeamService;
import TeamFormat.HTMLTeamFormatter;
import TeamFormat.PlainTextTeamFormatter;
import TeamFormat.TeamFormatter;
import TeamFormat.XMLTeamFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class getTeamsGui extends Frame implements ActionListener{
    JTextArea text2;
    JButton plainTextButton;
    JButton XMlButton;
    JButton HTMlButton;
    JButton loadTeamsButton;
    JComboBox cb;
    String team;
    TeamFormatter teamFormatter;
    TeamService teamService;
    String[] teamsIds = {"empty"};

    public getTeamsGui(){
        init();
    }

    public static void main(String[] args) {
        getTeamsGui gui = new getTeamsGui();
    }

    public void init() {
        cb = new JComboBox(teamsIds);
        cb.setBounds(850, 100,90,20);

        loadTeamsButton = new JButton("Load teams");
        loadTeamsButton.setBounds(50, 100, 200, 30);
        plainTextButton = new JButton("Display team (Plain text)");
        plainTextButton.setBounds(400, 150, 200, 30);
        XMlButton = new JButton("Display team (XML)");
        XMlButton.setBounds(750, 150, 200, 30);
        HTMlButton = new JButton("Display team (HTML)");
        HTMlButton.setBounds(50, 150, 200, 30);

        plainTextButton.addActionListener((ActionListener) this);
        XMlButton.addActionListener((ActionListener) this);
        HTMlButton.addActionListener((ActionListener) this);
        loadTeamsButton.addActionListener((ActionListener) this);

        text2 = new JTextArea();
        text2.setBackground(Color.CYAN);
        text2.setBounds(50, 200, 900, 700);

        add(plainTextButton); add(XMlButton); add(HTMlButton); add(loadTeamsButton);
        add(text2);
        add(cb);

        setSize(1000,1000);
        setLayout(null);
        setVisible(true);
        teamService = new TeamService();
    }

    private void loadTeams(){
        teamService.loadTeams();
        teamsIds = teamService.getTeamsIds().toArray(new String[0]);
        System.out.println(teamsIds.toString());
        cb.removeAllItems();
        for(int i = teamsIds.length - 1; i >= 0; i--){
            cb.addItem(teamsIds[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        team = (String) cb.getItemAt(cb.getSelectedIndex());
        teamService.loadTeams();
        if(command.equals("Load teams")){
            loadTeams();
        } else if(command.equals("Display team (Plain text)")){
            teamFormatter = PlainTextTeamFormatter.getSingletonInstance();
            text2.setText(teamFormatter.formatTeam(teamService.getTeam(team)));
        }
        else if (command.equals("Display team (XML)")) {
            teamFormatter = XMLTeamFormatter.getSingletonInstance();
            text2.setText(teamFormatter.formatTeam(teamService.getTeam(team)));
        }
        else if (command.equals("Display team (HTML)")){
            teamFormatter = HTMLTeamFormatter.getSingletonInstance();
            text2.setText(teamFormatter.formatTeam(teamService.getTeam(team)));
        }
    }
}