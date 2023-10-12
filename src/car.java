public class car {
    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class AnimatedCarApp extends JFrame {
        private int carX = 0;
        private Timer timer;

        public AnimatedCarApp() {
            setTitle("Animated Car with Wallpaper");
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setContentPane(new WallpaperPanel());
            setLayout(null);

            CarPanel carPanel = new CarPanel();
            add(carPanel);

            timer = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carX += 2;
                    carPanel.repaint();
                }
            });
            timer.start();
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    AnimatedCarApp app = new AnimatedCarApp();
                    app.setVisible(true);
                }
            });
        }

        private class CarPanel extends JPanel {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillRect(carX, 400, 100, 50);
            }
        }

        private class WallpaperPanel extends JPanel {
            private Image backgroundImage;

            public WallpaperPanel() {
                backgroundImage = new ImageIcon("background.jpg").getImage();
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

}
