import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {
    /* 7-4
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello World", 100, 200);
    }
    */

    /* 7-5
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
    */

    /* 7-6
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int r = 40;
        int cx = 50;
        int cy = 100;
        int angle = 30;

        int dx = (int)(r * Math.cos(angle * Math.PI / 180));
        int dy = (int)(r * Math.sin(angle * Math.PI / 180));

        g.drawLine(cx, cy, cx + dx, cy + dy);
        g.drawLine(cx, cy, cx + dx, cy - dy);
        g.drawArc(cx - r, cy - r, 2 * r, 2 * r, angle, 360 - 2 * angle);

        Polygon p = new Polygon();

        cx = 150;
        int i;
        for(i = 0; i < 5; i++) {
            p.addPoint(
                    (int)(cx + r * Math.cos(i * 2 * Math.PI / 5)),
                    (int)(cy + r * Math.sin(i * 2 * Math.PI / 5))
            );
        }

        Polygon s = new Polygon();
        cx = 250;
        for(i = 0; i < 360; i++) {
            double t = i / 360.0;
            s.addPoint(
                    (int)(cx + r * t * Math.cos(8 * t * Math.PI)),
                    (int)(cy + r * t * Math.sin(8 * t * Math.PI))
            );
        }
        g.drawPolygon(s);

    }
    */

    /* 7-7
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.drawRect(10, 10, 80, 30);
        g.drawRoundRect(100, 10, 80, 30, 15, 15);

        int thickness = 4;

        for(int i = 0; i <= thickness; i++)
            g.draw3DRect(200 - i, 10 - i, 80 + 2 * i, 30 + 2 * i, true);

        for(int i = 0; i <= thickness; i++)
            g.draw3DRect(200 - i, 10 - i, 80 + 2 * i, 30 + 2 * i, false);

        g.drawOval(10, 100, 80, 30);


    }
    */

    /* 7-8
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(10, 10, 80, 30);
        g.drawRoundRect(100, 10, 80, 30, 15, 15);
        g.drawOval(10, 100, 80, 30);
        g.setColor(Color.red);
        g.fillRect(11, 11, 79, 29);
        g.fillRoundRect(101, 11, 79, 29, 15, 15);

        int thickness = 4;

        g.fill3DRect(200, 10, 80, 30, true);
        for(int i = 1; i <= thickness; i++)
            g.draw3DRect(200 - i, 10 - i, 80 + 2 * i - 1, 30 + 2 * i - 1, true);

        g.fill3DRect(200, 50, 80, 30, false);
        for(int i = 1; i <= thickness; i++)
            g.draw3DRect(200 - i, 10 - i, 80 + 2 * i - 1, 30 + 2 * i - 1, true);

        g.fillOval(10, 100, 80, 30);
    }
    */

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

        /* 7-3
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