import java.awt.*;
import java.util.ArrayList;

public class Player {

    Image image;
    int x, y;

    public Player(int x, int y){
        image = Toolkit.getDefaultToolkit().getImage("player.png");
        this.x = x;
        this.y = y;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 40, 40);
    }

    public void checkCollision(ArrayList<Tile> tiles){
        for(Tile tile : tiles){
            if(getBounds().intersects(tile.getBounds())){
                if(tile instanceof Fire){
                    GameStates.end();
                    GameStates.DEAD = true;
                }else if(tile instanceof FinishLine){
                    GameStates.end();
                }

            }
        }
    }

    public void checkPowerups(ArrayList<PowerUp> powerUps, Board board){
        for(PowerUp powerUp : powerUps){
            if(getBounds().intersects(powerUp.getBounds()) && powerUp.enabled) {
                powerUp.enabled = false;
                if (powerUp instanceof PowerUp){
                    board.cameraSpeed += 1;
                }
            }
        }
    }

    public void move(int dx, int dy, ArrayList<Tile> tiles){
        Rectangle newRectangle = new Rectangle(x + dx, y + dy, 40, 40);
        boolean intersect = false;
        for(Tile tile : tiles){
            if(intersect){
                intersect = newRectangle.intersects(tile.getBounds())&& tile instanceof Bush;
            }
        }
        if(intersect){
            x+= dx;
            y+= dy;
        }
    }

    public void paint(Graphics g, int camera){
        Graphics2D g2d = (Graphics2D)g;
        int modifiedX = camera + x;
        g2d.drawImage(image, modifiedX, y, null);
    }
}
