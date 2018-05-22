import java.awt.*;


public class Tile {

    Image image;
    int x, y;

    public Tile(Image image, int x, int y){
        this.image = image;
        this.x = x;
        this.y = y;

    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 40, 40);

    }

    public void paint(Graphics g, int camera){
        Graphics2D g2d = (Graphics2D)g;
        int modifiedX = camera + x;
        g2d.drawImage(image, modifiedX, y, null);

    }
}
