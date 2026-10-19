
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class RectangleMove extends JPanel implements KeyListener, MouseListener {

    int x = 120, y = 120;
    ArrayList<Rectangle> rectangles = new ArrayList<>();

    RectangleMove() {
        setBackground(Color.LIGHT_GRAY);
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 33);

        g.setColor(Color.RED);
        for (Rectangle r : rectangles) {
            g.fillRect(r.x, r.y, 50, 33);
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                y += 10;
                break;
            case KeyEvent.VK_LEFT:
                x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                x += 10;
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public void mouseClicked(MouseEvent e) {
        rectangles.add(new Rectangle(e.getX(), e.getY(), 50, 33));
        repaint();
        requestFocusInWindow();
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame f = new JFrame("Move & Click Rectangles");
        RectangleMove panel = new RectangleMove();

        f.add(panel);
        f.setSize(450, 450);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        panel.requestFocusInWindow();
    }
}
