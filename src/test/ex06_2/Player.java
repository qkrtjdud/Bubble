package test.ex06_2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel {
    // 위치 상태
    private int x;
    private int y;

    // 플레이어의 방향 상태
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    private ImageIcon playerR, playerL;

    // 플레이어의 스피드
    private final int SPEED = 5; // y축
    private final int JUMPSPEED = 5; // x축

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
        y = 540;

        left = false;
        right = false;
        up = false;
        left = false;

        setIcon(playerR);
        setSize(50, 50);
        setLocation(x, y);
    }

    public void up() {
        System.out.println("up 메서드 실행");
        up = true;
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                y = y - JUMPSPEED;
                setLocation(x, y);

                try {
                    Thread.sleep(6);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            down();
        }).start();

    }

    public void down() {
        System.out.println("down 메서드 실행");
        down = true;
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                y = y + JUMPSPEED;
                setLocation(x, y);

                try {
                    Thread.sleep(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            down = false;
        }).start();
    }

    public void right() {
        System.out.println("right 메서드 실행");
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
        System.out.println("left 메서드 실행");
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

    ///////////////// get,set////////////////////////////////
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

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
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

}
