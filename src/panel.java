import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class panel extends JPanel{

    mousein input;
    keyboard key;
    public gamingchair game;

    private BufferedImage back;
    String rock= "rock.png";

    public panel(gamingchair game){
        this.input = new mousein(this,game.player);
        this.key = new keyboard(game.levelManager,game.player);
        this.game = game;

        addKeyListener(key);
        addMouseListener(input);
        addMouseMotionListener(input);
        back = loadsave.GetSpriteAtlas(rock);
        winsize();
    }

    public void winsize(){
        Dimension dim = new Dimension(1280,720);
        setPreferredSize(dim);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(back ,0 ,0 , 1280, 720, null);
        game.render(g);

        Font newFont = new Font("Arial", Font.BOLD, 30);
        g.setFont(newFont);
        g.setColor(Color.BLACK);
        g.drawString("Score: "+(-game.levelManager.offset/10),1050 ,50);
    }
}
