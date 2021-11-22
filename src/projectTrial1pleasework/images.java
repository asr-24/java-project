package projectTrial1pleasework;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Gagandeep Bali
 * Date: 7/1/14
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class images {

    private MyPanel contentPane;

    private void displayGUI(String header, String filename) {
    	System.out.println("here");
        JFrame frame = new JFrame(header);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new MyPanel(filename);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    private class MyPanel extends JPanel {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private BufferedImage image;

        public MyPanel(String thisFile) {
        	System.out.println("here2");
            try {
                image = ImageIO.read(MyPanel.class.getResource("images\\" + thisFile));
            } catch (Exception e) {
                System.out.println("should've taken arts");
            	//ioe.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
        	System.out.println("here3");
            return image == null ? new Dimension(400, 300): new Dimension(image.getWidth(), image.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
        	System.out.println("here4");
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

    public void pictureTime(String header, String filename) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            	System.out.println(header + filename);
                new images().displayGUI(header, filename);
            }
        };
        EventQueue.invokeLater(runnable);
    }
}
