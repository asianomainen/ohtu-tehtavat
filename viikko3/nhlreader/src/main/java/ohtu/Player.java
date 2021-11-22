
package ohtu;

public class Player {
    private String name;
    public String team;
    public int goals;
    public int assists;
    public int total;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getTotal() {
        return goals + assists;
    }

    @Override
    public String toString() {
        return String.format("%-25s %-6s %2d + %2d = %1d", name, team, goals, assists, total);
    }
}