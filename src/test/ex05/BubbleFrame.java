package test.ex05;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//main 스레드를 GUI 프로그램에서는 ui 스레드라고 부른다.
public class BubbleFrame extends JFrame {

    private JLabel backgroundMap;
    private Player player;

    public BubbleFrame() {
        initObject();
        initSetting();
        initListener();
        setVisible(true); // while

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
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (!player.isRight()) {
                        player.right();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (!player.isLeft()) {
                        player.left();
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (!player.isUp() && !player.isDown()) {
                        player.up();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyCode());

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
