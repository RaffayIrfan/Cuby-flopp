import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyboard implements KeyListener {
    player player;
    levelmanage level;
    public keyboard(levelmanage level,player player){
        this.level=level;
        this.player=player;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == keyEvent.VK_R) {
            level.offset=0;
            player.movelvl=true;
            //System.out.println("pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
