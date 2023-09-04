import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello World", 100, 200);
    }
}

class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("MyFrame");
        setSize(720, 720);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        /*Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);

        Image img = tk.getImage("");
        setIconImage(img);
        */

        Container contentPane = getContentPane();
        contentPane.add(new MyPanel());
    }
}

public class Main {
    public static void main(String[] args) {
        JFrame Fr = new MyFrame();
        Fr.show();
    }
}