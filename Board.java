import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener {

    int camera = 0;
    int cameraSpeed = 3;
    int dx, dy;

    ArrayList<Tile> tiles = new ArrayList<>();
    ArrayList<PowerUp> powerups = new ArrayList<>();
    Player player;
    Timer timer;

    public Board() {
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.GREEN);
        timer = new Timer(1000/60, this);
        timer.start();
    }

    public void init() {
        GameStates.menu();
    }

    public void resetField() {
        camera = 0;
        cameraSpeed = 3;
        tiles = new ArrayList<>();
        player = new Player(380, 380);
        dx = 0;
        dy = 0;
        for (int i = 0; i < GameStates.getDISTANCE() / 40 + 1; i++) {
            tiles.add(new Bush(i * 40, 0));
            tiles.add(new Bush(i * 40, 760));
        }
        for (int i = 1; i < 19; i++) {
            tiles.add(new Bush(0, i * 40));
            tiles.add(new FinishLine(GameStates.getDISTANCE(), i * 40));
        }
        for (int i = 15; i < GameStates.getDISTANCE() / 40; i++) {
            for (int j = 1; j < 19; j++) {
                if (Math.random() > .9) {
                    tiles.add(new Fire(i * 40, j * 40));

                }
            }
        }
    }
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(GameStates.isMENU()) {

            setBackground(Color.BLACK);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas", Font.BOLD, 48));
            printSimpleString("Sidescroller", getWidth(), 0, getHeight()/2, g);
            g.setFont(new Font("Consolas", Font.BOLD, 24));
            printSimpleString("Press enter to start", getWidth(), 0, getHeight()/2 + 50, g);
            printSimpleString(" < Distance: " + GameStates.getDISTANCE() + " >", getWidth(), 0, getHeight()/2 + 100, g);

        } else if(GameStates.isPLAY()) {

            camera -= cameraSpeed;
            player.move(dx, dy, tiles);

            setBackground(new Color(87, 59, 12));
            for(Tile tile : tiles) {
                tile.paint(g, camera);
            }
            for(PowerUp powerUp : powerups) {
                powerUp.paint(g, camera);
            }
            player.paint(g, camera);
            player.checkPowerups(powerups, this);
            player.checkCollision(tiles);

        } else if(GameStates.isEND()) {

            setBackground(Color.BLACK);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas", Font.BOLD, 48));
            String message = "You got to the end!";
            if(GameStates.DEAD) {
                message = "You died";
            }
            printSimpleString(message, getWidth(), 0, getHeight() / 2, g);
            g.setFont(new Font("Consolas", Font.BOLD, 24));
            printSimpleString("Press enter to start over", getWidth(), 0, getHeight()/2 + 50, g);

        }
    }

    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }

}

