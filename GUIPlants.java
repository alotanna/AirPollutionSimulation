package oopProject;
import java.awt.Image;

import javax.swing.*;

/**
 * Represents a plant entity in the GUI ecosystem.
 */
class GUIPlants extends GUILivingThings {
    private ImageIcon imageIcon; // Icon for the plant
    /**
     * Constructs a plant entity.
     */
    public GUIPlants() {
        super("Plants", "AlivePlant.png", 80);
    }
    
    /**
     * Changes the image of the plant to represent death.
     */
    public void die() {
        // Update the icon for the JLabel to represent death
        this.imageIcon = new ImageIcon("DeadPlant.png");
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        this.setIcon(imageIcon);
    }
    
    /**
     * Restores the plant to its healthy state after regrowth.
     */
    public void regrow() {
        // Update the icon for the JLabel to represent regrowth
        this.imageIcon = new ImageIcon("AlivePlant.png");
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        this.setIcon(imageIcon);
    }
}
