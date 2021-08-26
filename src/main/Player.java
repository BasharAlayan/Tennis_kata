package main;

/**
 *
 */
public class Player extends Person {

    private int point;
    private int set;
    private int tieBreakScore;

    public Player(int id, String firstName, String lastName, int point, int set) {
        super(id, firstName, lastName);
        this.point = point;
        this.set=set;
    }

    public Player(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
        this.point = 0;
        this.set=0;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public void winSet() {
        this.set++;
    }

    public void winPoint() {
        this.point++;
    }

    public int getTieBreakScore() {
        return tieBreakScore;
    }

    public void setTieBreakScore(int tieBreakScore) {
        this.tieBreakScore = tieBreakScore;
    }

    public void increaseTieBreakScore(){
        this.tieBreakScore++;
    }

    public String translateScore() {
        switch (point) {
            case 5:
                return "ADV";
            case 4:
                return "DEUCE";
            case 3:
                return "40";
            case 2:
                return "30";
            case 1:
                return "15";
        }
        return "0";
    }


}
