/** Point d'entrée ajouté pour lancer le jeu hors de BlueJ (navigateur via CheerpJ, ou java -jar). */
public class Launcher {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() { public void run() { new Game(); } });
    }
}
