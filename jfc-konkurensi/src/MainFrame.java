import javax.swing.*;
import java.awt.*;
import java.util.List;



public class MainFrame {
    public static void main(String[] args) {
     SwingUtilities.invokeLater(()->{
        JFrame frame = new JFrame("Contoh konkurensi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());


        JLabel statusLabel = new JLabel("Tekan tombol untuk memulai tugas berat", JLabel.CENTER);
        JButton startButton = new JButton("Mulai");

        JProgressBar progressBar = new JProgressBar(0, 60);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        frame.add(statusLabel, BorderLayout.NORTH);
        frame.add(progressBar, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.SOUTH);

        startButton.addActionListener(e->{
            for (int i = 0; i <= 60; i++) {
                progressBar.setValue(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


     });
    }

}
