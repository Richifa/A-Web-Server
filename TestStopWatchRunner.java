 /*
       A trivial applet that tests the StopWatchTimer component.
       The applet just creates and shows a StopWatchTimer.
    */

    import java.awt.*;
    import java.applet.*;
    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

 public class TestStopWatchRunner {
     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> createAndShowGUI());
     }

     private static void createAndShowGUI() {
         JFrame frame = new JFrame("Stopwatch");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         StopWatchLabel stopWatch = new StopWatchLabel();
         JButton startButton = new JButton("Start");
         JButton stopButton = new JButton("Stop");

         startButton.addActionListener(e -> stopWatch.start());
         stopButton.addActionListener(e -> stopWatch.stop());

         JPanel buttonPanel = new JPanel();
         buttonPanel.add(startButton);
         buttonPanel.add(stopButton);

         frame.add(stopWatch, BorderLayout.CENTER);
         frame.add(buttonPanel, BorderLayout.SOUTH);

         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
     }
 }
