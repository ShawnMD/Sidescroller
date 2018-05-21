import java.awt.*;


public class Tile {

    Image image;
    int x, y;

    public Tile(Image image, int x, int y){

    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 40, 40);

    }

    public void paint(Graphics g){

    }
}
