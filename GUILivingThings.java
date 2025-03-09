package oopProject;

import java.awt.Image;
import javax.swing.*;

/**
 * Represents a living entity in the GUI ecosystem.
 */
abstract class GUILivingThings extends JLabel {
    private String name; // Name of the living entity
    protected int maxtolernace; // Maximum tolerance level of the living entity
    private ImageIcon imageIcon; // Icon for the living entity
    protected JPanel currentPanel; // Panel where the living entity currently resides

    /**
     * Constructs a living entity with the specified name, image path, and maximum tolerance level.
     * @param name The name of the living entity.
     * @param imagePath The path to the image representing the living entity.
     * @param maxtolernace The maximum tolerance level of the living entity.
     */
    public GUILivingThings(String name, String imagePath, int maxtolernace) {
        this.name = name;

        // Create and scale the image icon
        this.imageIcon = new ImageIcon(imagePath);
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);

        this.maxtolernace = maxtolernace;

        // Set the icon for the JLabel
        this.setIcon(imageIcon);
    }

    /**
     * Changes the image of the living entity to represent death.
     * @param imagePath The path to the image representing death.
     */
    public void die(String imagePath) {
        // Update the icon for the JLabel to represent death
        this.imageIcon = new ImageIcon(imagePath);
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        this.setIcon(imageIcon);
    }
}
