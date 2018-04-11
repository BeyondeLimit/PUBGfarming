
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
//import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author BeyondTheLimit
 */
public class FarmPUBG {

    static boolean canStart = true;
    static Thread t = null;

    public static void playBtnCheck(Robot robot, BufferedImage bufImg) {
        int x, y, red, green, blue, clr;
        x = 200;
        y = 715;
        clr = bufImg.getRGB(x, y);      // separating rgb to red, green and blue
        red = (clr & 0x00ff0000) >> 16;
        green = (clr & 0x0000ff00) >> 8;
        blue = clr & 0x000000ff;
        if (red == 255) {
            if (green == 199) {
                if (blue == 0) {
                    robot.mouseMove(150, 715);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.delay(1000);// double click imitation
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                }
            }
        }
    }

    public static void exitBtnCheck(Robot robot, BufferedImage bufImg) {
        int x, y, red, green, blue, clr;
        x = 1297;
        y = 680;
        clr = bufImg.getRGB(x, y);      // separating rgb to red, green and blue
        red = (clr & 0x00ff0000) >> 16;
        green = (clr & 0x0000ff00) >> 8;
        blue = clr & 0x000000ff;
        if (red == 255) {
            if (green == 255) {
                if (blue == 255) {
                    robot.mouseMove(1225, 680);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.delay(1000);// double click imitation
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.delay(3000);//waiting for confirmation menu to apear
                    robot.mouseMove(600, 410);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.delay(1000);// double click imitation
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                }
            }
        }
    }

    public static void main(String[] args) throws AWTException, IOException, InterruptedException {

        JFrame f = new JFrame("PUBG farm trainer");
        String screenSizes[] = {"1152x720", "1280x720", "1280x768", "1360x768", "1366x768", "1932x1086"};
        JComboBox cb = new JComboBox(screenSizes);
        JButton b1 = new JButton("Click to start/resurme");
        JButton b2 = new JButton("Click to farming");
        JButton b3 = new JButton("Click to exit programm");
        JLabel label = new JLabel();
        label.setBounds(150, 10, 100, 100);
        label.setSize(400, 100);
        b1.setBounds(100, 100, 200, 30);//x,y,width,height
        b2.setBounds(100, 140, 200, 30);
        b3.setBounds(100, 180, 200, 30);
        cb.setBounds(50, 50, 90, 20);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(cb);
        f.add(label);
        f.setSize(400, 600);//widht,height
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        label.setText("Choose your screen resolution in game");// used to check condition check on different resolutions
        b1.addActionListener(new ActionListener() {// starts game for the first time pressed, and tryes to find play button
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cb.getSelectedIndex() == 4) {
//                    if (canStart) {
//                        try {
//                            Process p = Runtime.getRuntime().exec("cmd /c start steam://rungameid/578080"); // this can start the steam process and game it self
//                        } catch (IOException ex) {
//                            Logger.getLogger(FarmPUBG.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        canStart = false;
//                    }
                    
                    try {
                        t = new Thread(new Looper());// setting new thread
                    } catch (AWTException ex) {
                        Logger.getLogger(FarmPUBG.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    t.start();// start loop
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.stop();
            }
        
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }//main end
}//class end
