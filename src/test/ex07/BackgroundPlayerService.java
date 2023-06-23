package test.ex07;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {
    private Player player;
    private BufferedImage image;

    public BackgroundPlayerService(Player player) {
        this.player = player;
        try {
            image = ImageIO.read(new File("image\\backgroundMapService.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        // 새로운 스레드의 생명줄
        while (true) {
            // 색상 확인
            Color leftColor = new Color(image.getRGB(player.getX() - 10, player.getY() + 25));
            Color rightColor = new Color(image.getRGB(player.getX() + 50 + 15, player.getY() + 25));
            // System.out.println("leftColor : "+leftColor);
            // System.out.println("rightColor : "+rightColor);

            if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
                System.out.println("왼쪽 벽에 충돌함");
                player.setLeftWallCrash(true);
                player.setLeft(false);

            } else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
                System.out.println("오른쪽 벽에 충돌함");
                player.setRightWallCrash(true);
                player.setRight(false);

            } else {
                player.setLeftWallCrash(false);
                player.setRightWallCrash(false);
            }

            try {

                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
