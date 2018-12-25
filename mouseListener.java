//mouseListener.java
 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 
public class mouseListener implements MouseListener{
    public void mouseClicked(MouseEvent arg0) {
    }
    public void mouseEntered(MouseEvent arg0) {
    }
    public void mouseExited(MouseEvent arg0) {
    }
    public void mousePressed(MouseEvent arg0) {
        if(arg0.getButton() == 1) {
            if (!Frame.perdre) {
                int X = (int)((double)arg0.getX()/100);
                int Y = (int)((double)arg0.getY()/100);
                if (Frame.plate[X][Y] == 0) {
                    Frame.plate[X][Y] = 1;
                    Frame.testWin();
                    Frame.IA();
                    Frame.testWin();
                }
            } else {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        Frame.plate[x][y] = 0;
                    }
                }
                Frame.perdre = false;
                Frame.gagner = 0;
            }
            Frame.panel.repaint();
        }
    }
    public void mouseReleased(MouseEvent arg0) {
    }
}