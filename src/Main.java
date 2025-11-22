import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        String info;
        Scoreboard game = new Scoreboard("Red", "Blue");
        info = game.getScore();
        game.recordPlay(1);
        info = game.getScore();
        game.recordPlay(0);
        info = game.getScore();
        info = game.getScore();
        game.recordPlay(3);
        info = game.getScore();
        game.recordPlay(1);
        game.recordPlay(0);
        info = game.getScore();
        game.recordPlay(0);
        game.recordPlay(4);
        game.recordPlay(0);
        info = game.getScore();
        Scoreboard match = new Scoreboard("Lions", "Tigers");
        info = match.getScore();
        System.out.println(info);
        info = game.getScore();
        System.out.println(info);
        Game one = new Game();
        one.getLevel(1).reachGoal();
        one.getLevel(1).setPoints(200);
        one.getLevel(2).reachGoal();
        one.getLevel(2).setPoints(100);
        one.getLevel(3).reachGoal();
        one.getLevel(3).setPoints(500);
        one.makeBonus();
        System.out.println(one.getScore());
        Game two = new Game();
        two.getLevel(1).reachGoal();
        two.getLevel(1).setPoints(200);
        two.getLevel(2).reachGoal();
        two.getLevel(2).setPoints(100);
        two.getLevel(3).setPoints(500);
        System.out.println(two.getScore());
        Game three = new Game();
        three.getLevel(1).reachGoal();
        three.getLevel(1).setPoints(200);
        three.getLevel(2).setPoints(100);
        three.getLevel(3).reachGoal();
        three.getLevel(3).setPoints(500);
        three.makeBonus();
        System.out.println(three.getScore());
        Game four = new Game();
        four.getLevel(1).setPoints(200);
        four.getLevel(2).reachGoal();
        four.getLevel(2).setPoints(100);
        four.getLevel(3).reachGoal();
        four.getLevel(3).setPoints(500);
        System.out.println(four.getScore());
        Game five = new Game();
        System.out.println(five.playManyTimes(4));
         */
        File f = new File("Scoreboard.txt");
        Scanner s = new Scanner(f);
        String info;
        ArrayList<String> teams = new ArrayList<String>();
        ArrayList<Integer> games_won = new ArrayList<Integer>();
        while (s.hasNext()) {
            String input_str = read_next(s);
            String[] input = input_str.split(" ");
            String team1 = input[0];
            String team2 = input[1];

            // need to create team1 or team2
            boolean create_team1 = true;
            boolean create_team2 = true;
            for (String team : teams) {
                if (team1.equals(team)) {
                    create_team1 = false;
                }
                if (team2.equals(team)) {
                    create_team2 = false;
                }
            }

            //create team1
            if (create_team1) {
                teams.add(team1);
                games_won.add(0);
            }

            //create team2
            if (create_team2) {
                teams.add(team2);
                games_won.add(0);
            }

            Scoreboard new_game = new Scoreboard (team1, team2);
            int x = 2;
            while (x < input.length){
                int new_score = Integer.parseInt(input[x]);
                new_game.recordPlay(new_score);
                x++;
            }
            info = new_game.getScore();
            String winner = new_game.getWinningTeam();

            //determine who won - add to win total
            int idx = 0;
            for (String team : teams) {
                if (winner.equals(team)) {
                    games_won.set(idx, games_won.get(idx) + 1);
                    break;
                }
                idx++;
            }
        }
        System.out.println(teams);
        System.out.println(games_won);
    }
    public static String read_next(Scanner scanner) throws FileNotFoundException {
        String line;
        line = scanner.nextLine();
        return line;
    }
}
