import java.awt.*;

public abstract class entity {
    public float x,y;
    protected Rectangle hitbox;
    public entity(float x, float y){
        this.x = x;
        this.y = y;
        inithitbox();
    }

    private void inithitbox() {
        hitbox = new Rectangle((int)x,(int)y,64,64);
    }

    protected void drawhitbox(Graphics g){
        g.setColor(Color.CYAN);
        g.drawRect((int)x,(int)y,64,64);
    }

    protected void updatehitbox(){
        hitbox.x = (int) x;
        hitbox.y = (int) y;
    }

    public Rectangle gethitbox(){
        return hitbox;
    }

}
