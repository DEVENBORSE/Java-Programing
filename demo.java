import java.awt.*;
import javax.swing.*;
public class demo extends JPanel {
@Override
protected void paintComponent(Graphics g) {
super.paintComponent(g);
// Draw flower petals
g.setColor(Color.PINK);
g.fillOval(50, 20, 50, 50); // Top petal
g.fillOval(20, 50, 50, 50); // Left petal
g.fillOval(80, 50, 50, 50); // Right petal
g.fillOval(50, 80, 50, 50); // Bottom petal
// Draw flower center
g.setColor(Color.YELLOW);
g.fillOval(50, 50, 50, 50); // Center of the flower
// Draw stem
g.setColor(Color.GREEN);
g.fillRect(70, 100, 10, 50); // Stem
}
public static void main(String[] args) {
JFrame frame = new JFrame("Flower Dra wing");
demo panel = new demo();
frame.add(panel);
frame.setSize(200, 200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}