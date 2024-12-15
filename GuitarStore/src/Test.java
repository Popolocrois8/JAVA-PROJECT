import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("HTML in JFrame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Use HTML in JLabel
        JLabel label = new JLabel("<html>"
                + "<h1 style='color: blue;'>Welcome to Harmony Haven</h1>"
                + "<p>This is an <b>example</b> of using <i>HTML</i> in a JLabel.</p>"
                + "<ul>"
                + "  <li>Item 1</li>"
                + "  <li>Item 2</li>"
                + "  <li>Item 3</li>"
                + "</ul>"
                + "<p style='color: green;'>Thank you for visiting!</p>"
                + "</html>");

        // Add the label to the frame
        frame.add(label);

        // Make the frame visible
        frame.setVisible(true);
    }
}
