package test.ex05_2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {

    private int x;
    private int y;

    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;

    private final int JUMPSPEED = 5;
    private final int SPEED = 10;

    private ImageIcon playerR, playerL;

    public Player() {
        initObject();
        initSetting();

    }

    private void initObject() {
        playerR = new ImageIcon("image\\playerR.png");
        playerL = new ImageIcon("image\\playerL.png");
    }

    private void initSetting() {
        x = 70;
        y = 535;

        right = false;
        left = false;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    public void right() {
        System.out.println("right");
        right = true;
        new Thread(() -> {
            while (right) {
                setIcon(playerR);
                x = x + SPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void left() {
        System.out.println("left");
        left = true;
        new Thread(() -> {
            while (left) {
                setIcon(playerL);
                x = x - SPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void up() {
        System.out.println("Jump");
        up = true;
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                y = y - JUMPSPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            down();

        }).start();

    }

    public void down() {
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                y = y + JUMPSPEED;
                setLocation(x, y);
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public ImageIcon getPlayerR() {
        return playerR;
    }

    public void setPlayerR(ImageIcon playerR) {
        this.playerR = playerR;
    }

    public ImageIcon getPlayerL() {
        return playerL;
    }

    public void setPlayerL(ImageIcon playerL) {
        this.playerL = playerL;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
