import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class loadsave {
    public static final String PLAYER = "cube_119.png";
    public static final String LEVEL= "rock.png";
    public static final String LEVEL_DATA = "res/lev.png";
    public static final String block = "block.jpeg";

    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = new BufferedImage(1,1,1);
        InputStream is = loadsave.class.getResourceAsStream("/res/" + fileName);
        try {
            img = ImageIO.read(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static int[][] GetLevelData() {
        BufferedImage img = GetSpriteAtlas(LEVEL_DATA);
        int[][] lvlData = new int[img.getHeight()][img.getWidth()];

        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if (value >= 90)
                    value = 0;
                else {
                    value=1;
                }
                lvlData[j][i] = value;
            }
        return lvlData;

    }
}
