import java.awt.*;
import java.util.function.ToLongBiFunction;

public class FinishLine extends Tile {

    public FinishLine(int x, int y){
        super(Toolkit.getDefaultToolkit().getImage("finish.png"), x, y);
    }
}
