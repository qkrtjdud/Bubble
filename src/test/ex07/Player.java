package test.ex07;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Player extends JLabel {
    // 위치 상태
    private int x;
    private int y;

    // 플레이어의 방향 상태
    private boolean left;
    private boolean right;
    private boolean up;
    private boolean down;

    // 벽에 충돌
    private boolean leftWallCrash;
    private boolean rightWallCrash;

    private ImageIcon playerR, playerL;

    // 플레이어의 스피드
    private final int SPEED = 5; // y축
    private final int JUMPSPEED = 5; // x축

    public Player() {
        initObject();
        initSetting();
        new Thread(new BackgroundPlayerService(this)).start();
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

        leftWallCrash = false;
        rightWallCrash = false;

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
}
