public class Midfielder extends Player {
    private int PASSING_POINT = 10 ;

    @Override
    protected float getPassing() {
        return super.getPassing() + PASSING_POINT;
    }

    @Override
    public String toString() {
        return String.format("Player Name=\'%s, JerseyNumber=%d Position %s %s SPEED=%.1f, , STAMINA=%.1f, , PASSING=%.1f",
                getName(), getJerseyNumber(), getPosition(), "Midfielder", getSpeed(), getStamina(), getPassing());
    }

    public Midfielder(String name, int jerseyNumber, int speed, int stamina, int passing){
        super(name, jerseyNumber, speed, stamina, passing);
    }
}
