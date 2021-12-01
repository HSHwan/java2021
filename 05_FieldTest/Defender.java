public class Defender extends Player {
    private int STRENGTH_POINT = 10 ;

    @Override
    protected float getStamina() {
        return super.getStamina() + STRENGTH_POINT;
    }

    @Override
    public String toString() {
        return String.format("Player Name=\'%s, JerseyNumber=%d Position %s %s SPEED=%.1f, , STAMINA=%.1f, , PASSING=%.1f",
                getName(), getJerseyNumber(), getPosition(), "Defender", getSpeed(), getStamina(), getPassing());
    }

    public Defender(String name, int jerseyNumber, int speed, int stamina, int passing){
        super(name, jerseyNumber, speed, stamina, passing);
    }
}
