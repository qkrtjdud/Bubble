package test.ex06;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {
   private Player player;
   private BufferedImage image;

   public BackgroundPlayerService(Player player) {
      this.player = player;

      File file = new File("image\\backgroundMapService.png");
      try {
         image = ImageIO.read(file);
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   @Override
   public void run() {
      // 새로운 스레드의 생명줄
      while (true) {
         Color color1 = new Color(image.getRGB(player.getX(), player.getY()));
         Color color2 = new Color(image.getRGB(player.getX(), player.getY()));
         // System.out.println("보글이의 위치의 빨간색상: " + color.getRed());
         // System.out.println("보글이의 위치의 초록색상: " + color.getGreen());
         // System.out.println("보글이의 위치의 녹색색상: " + color.getBlue());
         System.out.println("보글이의 x값: " + player.getX());

         if (color1.getRed() == 255 && color1.getGreen() == 0 && color1.getBlue() == 0) {
            System.out.println("벽 충돌");
            player.setLeft(false);

            // player.setX(61);
         }
         if (color2.getRed() == 255 && color2.getGreen() == 0 && color2.getBlue() == 0) {
            System.out.println("벽충돌");
            player.setRight(false);
            // player.setX(890);
         }
         // if (player.getX() < 61) {
         // System.out.println("벽충돌");
         // player.setLeft(false);
         // player.setX(61);
         // } else if (player.getX() > 890) {
         // System.out.println("벽충돌");
         // player.setRight(false);
         // player.setX(890);
         // }

         try {
            Thread.sleep(10);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }
}
