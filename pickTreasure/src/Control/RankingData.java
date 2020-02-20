package Control;

public class RankingData {
    private String name ;
    private int score ;
    private int ranking;

    public RankingData(){
        name = "待定";
        score = 0;
        ranking = 0;
    }

    public RankingData(String name, int score, int ranking) {
        this.name = name;
        this.score = score;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
