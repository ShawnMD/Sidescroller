import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Game extends JFrame {

    Board board;

    public Game(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("Fiery Fierce Dash");
        board = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(GameStates.isMENU()) {

                    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                        GameStates.start();
                        board.resetField();
                    }
                    if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        if(GameStates.getDISTANCE() == 4000) {
                            GameStates.setDISTANCE(8000);
                        } else if(GameStates.getDISTANCE() == 8000) {
                            GameStates.setDISTANCE(12000);
                        } else if(GameStates.getDISTANCE() == 12000) {
                            GameStates.setDISTANCE(4000);
                        }
                    }
                    if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                        if(GameStates.getDISTANCE() == 4000) {
                            GameStates.setDISTANCE(12000);
                        } else if(GameStates.getDISTANCE() == 8000) {
                            GameStates.setDISTANCE(4000);
                        } else if(GameStates.getDISTANCE() == 12000) {
                            GameStates.setDISTANCE(8000);
                        }
                    }

                } else if(GameStates.isPLAY()) {

                    if(e.getKeyCode() == KeyEvent.VK_P) {
                        GameStates.pause();
                    }

                    if(e.getKeyCode() == KeyEvent.VK_UP) {
                        board.dy = -5;
                    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                        board.dy = 5;
                    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                        board.dx = -5;
                    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        board.dx = 5;
                    }

                } else if(GameStates.isPAUSE()) {

                    if(e.getKeyCode() == KeyEvent.VK_P) {
                        GameStates.resume();
                    }

                } else if(GameStates.isEND()) {

                    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                        GameStates.restart();
                    }

                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(GameStates.isPLAY()) {

                    if(e.getKeyCode() == KeyEvent.VK_UP) {
                        board.dy = 0;
                    } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                        board.dy = 0;
                    } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                        board.dx = 0;
                    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        board.dx = 0;
                    }

                }
            }
        });
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.board.init();
    }

}
