import java.awt.event.*;
import javax.swing.*;


/**
 * A custom component that acts as a simple stop-watch.  When the user clicks
 * on it, this componet starts timing.  When the user clicks again,
 * it displays the time between the two clicks.  Clicking a third time
 * starts another timer, etc.  While it is timing, the label just
 * displays the message "Timing....".
 */


public class StopWatchLabel extends JLabel implements Runnable {
   private volatile boolean running = false;
   private long startTime;

   public StopWatchLabel() {
      this.setHorizontalAlignment(SwingConstants.CENTER);
      this.reset();
   }

   public void reset() {
      this.setText("0:00:00.0");
   }

   public void start() {
      if (!running) {
         running = true;
         startTime = System.currentTimeMillis();
         new Thread(this).start();
      }
   }

   public void stop() {
      running = false;
   }

   @Override
   public void run() {
      while (running) {
         long currentTime = System.currentTimeMillis();
         long elapsedTime = currentTime - startTime;
         updateLabel(elapsedTime);
         try {
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   private void updateLabel(long elapsedTime) {
      int hours = (int) (elapsedTime / 3600000);
      int minutes = (int) ((elapsedTime % 3600000) / 60000);
      int seconds = (int) ((elapsedTime % 60000) / 1000);
      int tenths = (int) ((elapsedTime % 1000) / 100);

      String time = String.format("%d:%02d:%02d.%d", hours, minutes, seconds, tenths);
      SwingUtilities.invokeLater(() -> setText(time));
   }
}
