package Vista;

public class Test {
        public static void main(String[] args) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                                Vista vista = new Vista();
                                vista.setVisible(true);
                        }
                });
        }
}
