import java.awt.EventQueue;
import javax.swing.JFrame;

public class Executable extends JFrame {

    public Executable() {

        initUI();
    }
    
    private void initUI() {

        add(new Surface());

        setTitle("Graph");
        setSize(Surface.WIDTH, Surface.HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            	Executable ex = new Executable();
                ex.setVisible(true);
            }
        });
    }
}