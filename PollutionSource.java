package oopProject;

import java.awt.Image;
import javax.swing.*;

/**
 * Represents a pollution source entity in the GUI ecosystem.
 */
public class PollutionSource extends JLabel {
    private String name; // Name of the pollution source entity
    protected double pollutionrate; // Rate at which pollution is emitted
    private ImageIcon imageIcon; // Icon for the pollution source entity
    protected JPanel currentPanel; // Panel where the pollution source entity currently resides

    /**
     * Constructs a pollution source entity with the specified name.
     * @param name The name of the pollution source entity.
     */
    public PollutionSource(String name) {
        this.name = name;
        // Set the image icon and pollution rate based on the provided name
        if(name.equalsIgnoreCase("car")) {
            this.imageIcon = new ImageIcon("cars.png");
            this.pollutionrate = 6;
        } else if(name.equalsIgnoreCase("factory")) {
            this.imageIcon = new ImageIcon("factories.png");
            this.pollutionrate = 8;
        } else if(name.equalsIgnoreCase("cows")) {
            this.imageIcon = new ImageIcon("cows.png");
            this.pollutionrate = 10;
        }
        // Scale the image icon
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        // Set the icon for the JLabel
        this.setIcon(imageIcon);
    }

    /**
     * Retrieves the pollution emission rate of this pollution source entity.
     * @return The pollution emission rate.
     */
    public double getpollutionrate() {
        return this.pollutionrate;
    }
}
