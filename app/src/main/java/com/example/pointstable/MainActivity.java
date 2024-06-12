package com.example.pointstable;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            TableLayout tableLayout = findViewById(R.id.tableLayout);

            String playerName = "Harsh";
            int matchesPlayed = 3;
            int matchPoints = 45;
            int goalFor = 30;
            int goalAgainst = 10;
            int gd = goalFor - goalAgainst;


            List<Team> teams = new ArrayList<>();
            teams.clear();
            teams.add(new Team("Team A", 3,45, 20, 50, 30));
            teams.add(new Team("Team B",3, 48, 25, 60, 35));
            teams.add(new Team("Team C",3,48, 15, 55, 40));
            teams.add(new Team("Team D",3, 42, 10, 45, 35));
            teams.add(new Team("Team E", 3,45, 20, 50, 30));
            teams.add(new Team("Team F",3, 48, 25, 60, 35));
            teams.add(new Team("Team G",3,48, 15, 55, 40));
            teams.add(new Team(playerName, matchesPlayed, matchPoints, gd, goalFor, goalAgainst));


            // Sort by points, then by goal difference, then by goals for, then by goals against
            Collections.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team t1, Team t2) {
                    if (t2.getPoints() != t1.getPoints()) {
                        return t2.getPoints() - t1.getPoints();
                    } else if (t2.getGoalDifference() != t1.getGoalDifference()) {
                        return t2.getGoalDifference() - t1.getGoalDifference();
                    } else if (t2.getGoalsFor() != t1.getGoalsFor()) {
                        return t2.getGoalsFor() - t1.getGoalsFor();
                    } else {
                        return t2.getGoalsAgainst() - t1.getGoalsAgainst();
                    }
                }
            });

            // Populate the table with sorted data
            for (Team team : teams) {
                TableRow row = new TableRow(this);

                TextView name = new TextView(this);
                name.setText(team.getName());
                name.setWidth(100);
                name.setTextSize(20);
                name.setPadding(8, 8,8,8);
                name.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                TextView played = new TextView(this);
                played.setText(String.valueOf(team.getMatchesPlayed()));
                played.setWidth(100);
                played.setTextSize(20);
                played.setPadding(8, 8,8,8);
                played.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                TextView points = new TextView(this);
                points.setText(String.valueOf(team.getPoints()));
                points.setWidth(100);
                points.setTextSize(20);
                points.setPadding(8, 8,8,8);
                points.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                TextView goalDifference = new TextView(this);
                goalDifference.setText(String.valueOf(team.getGoalDifference()));
                goalDifference.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                goalDifference.setWidth(100);
                goalDifference.setTextSize(20);
                goalDifference.setPadding(8, 8,8,8);

                TextView goalsFor = new TextView(this);
                goalsFor.setText(String.valueOf(team.getGoalsFor()));
                goalsFor.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                goalsFor.setWidth(100);
                goalsFor.setTextSize(20);
                goalsFor.setPadding(8, 8,8,8);

                TextView goalsAgainst = new TextView(this);
                goalsAgainst.setText(String.valueOf(team.getGoalsAgainst()));
                goalsAgainst.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                goalsAgainst.setWidth(100);
                goalsAgainst.setTextSize(20);
                goalsAgainst.setPadding(8, 8,8,8);

                row.addView(name);
                row.addView(played);
                row.addView(points);
                row.addView(goalDifference);
                row.addView(goalsFor);
                row.addView(goalsAgainst);

                tableLayout.addView(row);
            }

            return insets;
        });
    }
}