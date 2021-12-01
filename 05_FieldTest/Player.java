public abstract class Player {
    private String name;
    private int jerseyNumber;

    private int[] abilities = new int[3];
    final int SPEED = 0; final int STAMINA = 1; final int PASSING = 2;

    Position position;

    public class Position {
        public int x;
        public int y;
        public Position (int x, int y){ this.x = x; this.y = y; }

        @Override
        public String toString(){
            return String.format("(%d , %d)", x, y);
        }
    }

    public Position getPosition(){
        return new Position(position.x, position.y);
    }

    public void moveUp(){
        float move_delta = getMoveDelta();
        position.y = (int)(position.y - move_delta);
        descreaseStamina();
    }

    private void descreaseStamina(){
        abilities[STAMINA] = (int) (abilities[STAMINA] - 2);
    }

    private float getMoveDelta(){
        return 1 + getSpeed() / 100 * getStamina() / 100;
    }

    public void moveDown(){
        float move_delta = getMoveDelta();
        position.y = (int)(position.y + move_delta);
        descreaseStamina();
    }

    public void moveLeft(){
        float move_delta = getMoveDelta();
        position.x = (int)(position.x - move_delta);
        descreaseStamina();
    }

    public void moveRight(){
        float move_delta = getMoveDelta();
        position.x = (int)(position.x + move_delta);
        descreaseStamina();
    }

    public Player(String name, int jerseyNumber, int speed, int stamina, int passing){
        this.name = name; this.jerseyNumber = jerseyNumber;
        abilities[ SPEED ] = speed  ;
        abilities[STAMINA] = stamina;
        abilities[PASSING] = passing;
        position = new Position(0, 0);
    }

    @Override
    public String toString() {
        return String.format("Player Name=\'%s, JerseyNumber=%d Position %s %s SPEED=%.1f, , STAMINA=%.1f, , PASSING=%1.f",
                             name, jerseyNumber, position, "Player", getSpeed(), getStamina(), getPassing());
    }

    public void setPositionX(int x){
        position.x = x;
    }

    public void setPositionY(int y){
        position.y = y;
    }

    public String getName(){
        return name;
    }

    public int getJerseyNumber(){
        return jerseyNumber;
    }

    protected float getPassing(){
        return (float)abilities[PASSING];
    }

    protected float getStamina(){
        return (float)abilities[STAMINA];
    }

    protected float getSpeed(){
        return (float)abilities[SPEED];
    }
}
