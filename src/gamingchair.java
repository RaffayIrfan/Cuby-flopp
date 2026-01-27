import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class gamingchair implements Runnable {
    private window window;
    private panel panel;

    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    player player;
    levelmanage levelManager;

    JLabel score = new JLabel("Score;");

    public gamingchair(){

        initClasses();

        try {
            File soundFile = new File("src/res/audio.wav").getAbsoluteFile();
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            //clip.start();

        } catch (UnsupportedAudioFileException e) {
            System.err.println("The specified audio file is not supported.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading the audio file.");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.err.println("A sound line is unavailable.");
            e.printStackTrace();
        }

        this.panel=new panel(this);
        this.window=new window(panel);
        window.jframe.add(score);
        panel.requestFocus();

        startGameLoop();
    }

    private void initClasses(){
        levelManager = new levelmanage(this);
        player =new player(240,300);
        player.loadlvldata(levelManager.getCurrentLevel().getLevelData());
    }


    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void render(Graphics g) {
        player.render(g);
        levelManager.draw(g);
    }

    private void update() {
        player.update((int) levelManager.offset);
        if(player.movelvl){
            levelManager.update();
        }
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                panel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }
    }


}
