
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HouseBuilder extends JPanel implements KeyListener, MouseListener {

    char tool = 'M';

    HouseBuilder() {
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);
        addKeyListener(this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.drawString("Press: [M] Wall | [W] Window | [D] Door", 20, 25);
        g.drawString("TOOL: " + tool, 480, 25);

        g.setColor(new Color(230, 190, 140));
        g.fillRect(110, 220, 365, 200);

        g.setColor(Color.WHITE);
        g.fillRect(195, 318, 38, 33);
        g.setColor(Color.BLACK);
        g.drawRect(195, 318, 38, 33);
        g.drawLine(214, 318, 214, 351);

        g.setColor(Color.WHITE);
        g.fillRect(395, 310, 38, 33);
        g.setColor(Color.BLACK);
        g.drawRect(395, 310, 38, 33);
        g.drawLine(414, 310, 414, 343);

        g.setColor(new Color(110, 60, 25));
        g.fillRect(285, 328, 37, 60);
    }

    public void keyPressed(KeyEvent e) {
        char key = Character.toUpperCase(e.getKeyChar());

        if (key == 'M' || key == 'W' || key == 'D') {
            tool = key;
            repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {
        Graphics g = getGraphics();

        if (tool == 'M') {
            g.setColor(new Color(230, 190, 140));
            g.fillRect(e.getX(), e.getY(), 80, 40);
        } else if (tool == 'W') {
            g.setColor(Color.WHITE);
            g.fillRect(e.getX(), e.getY(), 38, 33);
            g.setColor(Color.BLACK);
            g.drawRect(e.getX(), e.getY(), 38, 33);
            g.drawLine(e.getX() + 19, e.getY(),
                       e.getX() + 19, e.getY() + 33);
        } else if (tool == 'D') {
            g.setColor(new Color(110, 60, 25));
            g.fillRect(e.getX(), e.getY(), 37, 60);
        }

        requestFocusInWindow();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame f = new JFrame("House Builder");
        HouseBuilder panel = new HouseBuilder();

        f.add(panel);
        f.setSize(560, 480);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        panel.requestFocusInWindow();
    }
}
