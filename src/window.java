import javax.swing.*;

public class window {
    JFrame jframe = new JFrame("Cuby flopp");

    public window(panel panel){

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setResizable(false);
        jframe.add(panel);

        jframe.pack();
        jframe.setVisible(true);
    }
}
