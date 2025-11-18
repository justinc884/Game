public class Scoreboard {
    String team1;
    String team2;
    String active_team;
    int score_team1 = 0;
    int score_team2 = 0;
    public Scoreboard(String team1, String team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.active_team = team1;
    }
    public void recordPlay(int points_scored) {
        if (points_scored == 0) {
            if (active_team == team1) {
                active_team = team2;
            }
            else {
                active_team = team1;
            }
        }
        else {
            if (active_team == team1) {
                score_team1 += points_scored;
            }
            if (active_team == team2) {
                score_team2 += points_scored;
            }
        }
    }
    public String getScore() {
        return score_team1 + "-" + score_team2 + "-" + active_team;
    }
}
