import java.awt.*;
import java.awt.image.BufferedImage;

public class levelmanage {
    private gamingchair game;
    private BufferedImage[] levelSprite;
    private level levelOne;
    float offset;

    public levelmanage(gamingchair game){
        this.game = game;
        importOutsideSprites();
        levelOne = new level(loadsave.GetLevelData());
    }

    private void importOutsideSprites() {
        BufferedImage block = loadsave.GetSpriteAtlas(loadsave.block);
        BufferedImage trans = loadsave.GetSpriteAtlas("trans.png");

        levelSprite = new BufferedImage[2];
        levelSprite[0] = block;
        levelSprite[1] = trans;

    }

    public void movelevel(){
        offset-=2;
    }

    public void draw(Graphics g ) {
        for (int j = 0; j < 9; j++)
            for (int i = 0; i < levelOne.getLevelData()[0].length; i++) {
                int index = levelOne.getSpriteIndex(i, j);
                g.drawImage(levelSprite[index], (int) (80 * i+ offset), 80 * j, 80, 80, null);
            }
    }

    public void update() {
        movelevel();
    }

    public level getCurrentLevel() {
        return levelOne;
    }

}
