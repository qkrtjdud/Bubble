package test.ex05_2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true);
    }

    private void initObject() {
        backgroundMap = new JLabel(new ImageIcon("image\\backgroundMap.png"));
        setContentPane(backgroundMap);

        player = new Player();
        add(player);
    }

    private void initSetting() {
        setSize(1000, 640);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initListener() {
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (!player.isRight()) {
                        player.right();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (!player.isLeft()) {
                        player.left();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (!player.isUp()) {
                        player.up();
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.setRight(false);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.setLeft(false);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    player.setUp(false);

                }
            }
        });
    }

    public static void main(String[] args) {
        new BubbleFrame();
    }

}
