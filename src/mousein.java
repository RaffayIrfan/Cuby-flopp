import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class mousein implements MouseListener, MouseMotionListener {
    panel panel;
    player player;
    public mousein(panel panel,player player){
        this.panel = panel;
        this.player= player;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        player.jump();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        player.jump=true;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        player.jump=false;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }
}
