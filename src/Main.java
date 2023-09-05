import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {
    /*
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello World", 100, 200);
    }
    */

    public void setFonts(Graphics g) {
        if (f != null) return;
        f = new Font("SansSerif", Font.BOLD, 14);
        fi = new Font("SansSerif", Font.BOLD + Font.ITALIC, 14);
        fm = g.getFontMetrics(f);
        fim = g.getFontMetrics(fi);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setFonts(g);
        String s1 = "Aaa";
        String s2 = "Bbb";
        String s3 = "Ccc";
        int w1 = fm.stringWidth(s1);
        int w2 = fm.stringWidth(s2);
        int w3 = fm.stringWidth(s3);

        Dimension d = getSize();
        int cx = (d.width - w1 - w2 - w3) / 2;
        int cy = (d.height - fm.getHeight()) / 2 + fm.getAscent();

        g.setFont(f);

        g.drawString(s1, cx, cy);
        cx += w1;
        g.setFont(fi);
        g.drawString(s2, cx, cy);
        cx += w2;
        g.setFont(f);
        g.drawString(s3, cx, cy);
    }

    private Font f;
    private Font fi;
    private FontMetrics fm;
    private FontMetrics fim;
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

        /*
        Toolkit tk = Toolkit.getDefaultToolkit();
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