import java.awt.*;

public class PowerUp extends Tile {

    boolean enabled = false;

    public PowerUp(Image image, int x, int y){
        super(image, x, y);
    }

    public void paint(Graphics g, int camera){
        if(enabled){
            Graphics2D g2d = (Graphics2D)g;
            int modifiedX = camera + x;
            g2d.drawImage(image, modifiedX, y, null);
        }
    }

}
