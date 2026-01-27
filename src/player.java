import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class player extends entity {

    BufferedImage img;
    String player = "cube_119.png";
    private int[][] lvldata;

    double acc =0f;
    float gravity= 0.003f;
    double downvel=0;
    boolean jump=false;
    boolean movelvl = true;
    int offset;
    JFrame win = new JFrame("win");

    public player(float x,float y){
        super(x,y);
        img = loadsave.GetSpriteAtlas(player);
    }

    public void update(int offset){
        holdjump(offset);
        gravity(offset);
        this.offset=offset;
        updatehitbox();
        if(x-offset<960){
            y=300;
            downvel=0;
        }
        if(offset==-26400){
            //System.out.println("wins");
            JOptionPane.showMessageDialog(win, "you win!", "Why did i make this.", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void jump(){

        if (helpcol.canmovehere(x-this.offset, (float) (y+downvel),lvldata)){
            this.downvel -=0.3;
            this.y += this.downvel;
        }
    }

    public void holdjump(int offset){
        if(jump) {
            this.downvel -= 0.01;
            if (helpcol.canmovehere(x-offset, (float) (y+downvel),lvldata)){
                this.y +=this.downvel;
            }
        }
    }

    public void gravity(int offset){
        if (helpcol.canmovehere(x-offset, (float) (y+downvel),lvldata)){
            if(!jump){
                this.acc=0.01;
                this.downvel +=this.acc;
                this.downvel *=0.999;
                this.y+= (float) this.downvel;
            }
        }
        else {
            downvel=0;
        }
        if(!helpcol.canmovehere(x-offset, y, lvldata)){
            movelvl=false;
        }
        if(this.y<0){
            this.y+=3;
        }
    }

    public void loadlvldata(int[][] lvldata){
        this.lvldata = lvldata;
    }

    public void render(Graphics g){
        g.drawImage(img, (int) x, (int) y, 64, 64, null);
        drawhitbox(g);
    }
}
