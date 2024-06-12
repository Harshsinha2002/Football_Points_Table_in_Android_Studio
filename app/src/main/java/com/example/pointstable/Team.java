package com.example.pointstable;

public class Team
{
    private String name;
    private int points;
    private int goalDifference;
    private int goalsFor;
    private int goalsAgainst;

    private int matchesPlayed;

    public Team(String name, int matchesPlayed, int points, int goalDifference, int goalsFor, int goalsAgainst) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.points = points;
        this.goalDifference = goalDifference;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    // Getters and setters
    public String getName() { return name; }
    public int getMatchesPlayed() { return matchesPlayed; }
    public int getPoints() { return points; }
    public int getGoalDifference() { return goalDifference; }
    public int getGoalsFor() { return goalsFor; }
    public int getGoalsAgainst() { return goalsAgainst; }
}
