

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author BeyondTheLimit
 */
public class Looper implements Runnable {

    private AtomicBoolean keepRunning;
    private Robot robot;
    public Looper() throws AWTException {
        robot = new Robot();
        keepRunning = new AtomicBoolean(true);
    }
//    Looper(Robot robot) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public void stop() {
        keepRunning.set(false);
    }
    @Override
    public void run() {
        Rectangle area;
        BufferedImage bufImg;
        boolean runGame = true;
        while (keepRunning.get()) {
            //Pubg play button RGB = 255,199,0
            //Pubg exit button RGB = 255,255,255
            area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            bufImg = robot.createScreenCapture(area);
            if (runGame) {
                runGame = FarmPUBG.playBtnCheck(robot, bufImg,runGame);
            } else if (!runGame) {
                runGame = FarmPUBG.exitBtnCheck(robot, bufImg,runGame);
            }
        }
    }


}
