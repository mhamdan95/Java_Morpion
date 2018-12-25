//Frame.java
 
import javax.swing.JFrame;

public class Frame extends JFrame{
    public static mouseListener ml = new mouseListener();
    public static Panel panel = new Panel();
 
    static int victoryConds[][][] = new int[8][3][2];
 
    static int plate[][] = new int[3][3];
 
    static boolean perdre = false;
    static int gagner = 0;
 
    public Frame(){
        this.setVisible(true);
        this.setSize(300, 325);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        int c = 0;
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                victoryConds[c][b][0] = a;
                victoryConds[c][b][1] = b;
                victoryConds[c+1][b][0] = b;
                victoryConds[c+1][b][1] = a;
            }
            c+=2;
        }
        for (int a = 0; a < 3; a++) {
            victoryConds[6][a][0] = a;
            victoryConds[6][a][1] = a;
            victoryConds[7][a][0] = 2-a;
            victoryConds[7][a][1] = a;
        }
 
        this.setContentPane(panel);
        this.addMouseListener(ml);
    }
 
    public static void testWin() {
        for (int i = 0; i < 8; i++) {
            int c = 0;
            for (int j = 0; j < 3; j++) {
                if (plate[victoryConds[i][j][0]][victoryConds[i][j][1]] == 1) c+=1;
                else if (plate[victoryConds[i][j][0]][victoryConds[i][j][1]] == 2) c-=1;
            }
            if (c == 3) {
                perdre = true;
                gagner = 1;
                return;
            } else if (c == -3) {
                perdre = true;
                gagner = 2;
                return;
            }
        }
        boolean c = true;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (plate[x][y] == 0) c = false;
            }
        }
        if (c) perdre = true;
    }
 
    public static void IA() {
        if (!perdre) {
            int degre = 0;
            int pos = 0;
            for (int i = 0; i < 8; i++) {
                int e = 0;
                int a = 0;
                for (int j = 0; j < 3; j++) {
                    if (plate[victoryConds[i][j][0]][victoryConds[i][j][1]] == 1) e++;
                    else if (plate[victoryConds[i][j][0]][victoryConds[i][j][1]] == 2) a++;
                }
                int d = 0;
                if (e == 0 && a == 2) d = 5;
                else if (e == 2 && a == 0) d = 4;
                else if (e == 0 && a == 1) d = 3;
                else if (e == 1 && a == 0) d = 2;
                else if (e == 0 && a == 0) d = 1;
                if (d > degre) {
                    degre = d;
                    pos = i;
                } else if (d == degre) {
                    if (Math.random()*100 < 30) {
                        pos = i;
                    }
                }
            }
            if (degre == 5 || degre == 4 || degre == 0) {
                for (int j = 0; j < 3; j++) {
                    if (plate[victoryConds[pos][j][0]][victoryConds[pos][j][1]] == 0) {
                        plate[victoryConds[pos][j][0]][victoryConds[pos][j][1]] = 2;
                        return;
                    }
                }
            } else if (degre == 3 || degre == 2) {
                boolean passed = false;
                for (int j = 0; j < 3; j++) {
                    if (plate[victoryConds[pos][j][0]][victoryConds[pos][j][1]] == 0) {
                        if (!passed) {
                            if (Math.random()*100 < 50) {
                                plate[victoryConds[pos][j][0]][victoryConds[pos][j][1]] = 2;
                                return;
                            } else passed = true;
                        } else {
                            plate[victoryConds[pos][j][0]][victoryConds[pos][j][1]] = 2;
                            return;
                        }
                    }
                }
            }
            else{
                int passed = 0;
                for (int j = 0; j < 3; j++) {
                    if (plate[victoryConds[pos][j][0]][victoryConds[pos][j][1]] == 0) {
                        if (passed != 2) {
                            if (Math.random()*100 < 40) {
                                plate[victoryConds[pos][j][0]][victoryConds[pos][j][1]] = 2;
                                return;
                            } else passed++;
                        } else {
                            plate[victoryConds[pos][j][0]][victoryConds[pos][j][1]] = 2;
                            return;
                        }
                    }
                }
            }
        }
    }
}
