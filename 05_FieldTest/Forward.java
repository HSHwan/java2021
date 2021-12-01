public class Forward extends Player {
    private int ACCELERATION_POINT = 10 ;

    @Override
    protected float getSpeed() {
        return super.getSpeed() + ACCELERATION_POINT;
    }

    @Override
    public String toString() {
        return String.format("Player Name=\'%s, JerseyNumber=%d Position %s %s SPEED=%.1f, , STAMINA=%.1f, , PASSING=%.1f",
                getName(), getJerseyNumber(), getPosition(), "Forward", getSpeed(), getStamina(), getPassing());
    }

    public Forward(String name, int jerseyNumber, int speed, int stamina, int passing){
        super(name, jerseyNumber, speed, stamina, passing);
    }
}
