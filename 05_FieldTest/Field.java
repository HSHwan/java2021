import java.util.ArrayList;
import java.util.List;

public class Field {
    private List<Player> players = new ArrayList<>();
    public void add(Player player){
        players.add(player);
    }

    public void moveUp(int jerseyNumber){
        for (Player player : players){
            if (player.getJerseyNumber() == jerseyNumber){
                player.moveUp();
                break;
            }
        }
    }

    public void moveDown(int jerseyNumber){
        for (Player player : players){
            if (player.getJerseyNumber() == jerseyNumber){
                player.moveDown();
                break;
            }
        }
    }

    public void moveLeft(int jerseyNumber){
        for (Player player : players){
            if (player.getJerseyNumber() == jerseyNumber){
                player.moveLeft();
                break;
            }
        }
    }

    public void moveRight(int jerseyNumber){
        for (Player player : players){
            if (player.getJerseyNumber() == jerseyNumber){
                player.moveRight();
                break;
            }
        }
    }

    public void start(){
        for (Player player : players){
            player.setPositionX(34);
            if (player instanceof Forward)  player.setPositionY(25);
            else if (player instanceof Midfielder)  player.setPositionY(50);
            else if (player instanceof Defender)    player.setPositionY(75);
        }
    }

    public void info(){
        for (Player player : players)   System.out.println(player);
    }

    public void stop(){
        players = new ArrayList<>();
    }
}
