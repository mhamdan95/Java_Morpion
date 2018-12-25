import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
 
import javax.swing.JPanel;
 
 
public class Panel extends JPanel{
    public void paintComponent(Graphics g){
        int width = this.getWidth();
        int height = this.getHeight();
       
        g.setFont(new Font("Arial", Font.PLAIN, 30));
       
        g.setColor(new Color(70, 70, 70));
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f));
        g.fillRect(0, 0, width, height);
        g.setColor(new Color(100, 100, 100));
        g.drawLine(100, 10, 100, 290);
        g.drawLine(200, 10, 200, 290);
        g.drawLine(10, 100, 290, 100);
        g.drawLine(10, 200, 290, 200);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (Frame.plate[x][y] == 1) {
                    g.setColor(new Color(200, 0, 0));
                    g.drawLine(20+x*100, 20+y*100, 80+x*100, 80+y*100);
                    g.drawLine(20+x*100, 80+y*100, 80+x*100, 20+y*100);
                } else if (Frame.plate[x][y] == 2) {
                    g.setColor(new Color(0, 0, 200));
                    g.drawOval(50+x*100-30, 50+y*100-30, 60, 60);
                }
            }
        }
        if (Frame.perdre) {
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, width, height);
            if (Frame.gagner == 1) {
                g.setColor(new Color(255, 0, 0, 50));
                g.fillRect(0, 0, width, height);
                g.setColor(new Color(255, 0, 0));
                g.drawString("Vous avez gagner !", width/2-getFontMetrics(g.getFont()).stringWidth("Vous avez gagner !")/2, height/2+10);
            } else if (Frame.gagner == 2) {
                g.setColor(new Color(0, 0, 255, 50));
                g.fillRect(0, 0, width, height);
                g.setColor(new Color(0, 0, 255));
                g.drawString("perdu...", width/2-getFontMetrics(g.getFont()).stringWidth("perdu...")/2, height/2+10);
            } else {
                g.drawString("perone à gagner", width/2-getFontMetrics(g.getFont()).stringWidth("perone à gagner")/2, height/2+10);
            }
        }
    }
}