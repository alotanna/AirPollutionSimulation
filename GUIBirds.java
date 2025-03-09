package oopProject;

import java.awt.Image;

import javax.swing.*;

/**
 * Represents a bird entity in the GUI ecosystem.
 */
class GUIBirds extends GUILivingThings {
    private ImageIcon imageIcon; // Icon for the bird
   
    /**
     * Constructs a bird entity.
     */
    public GUIBirds() {
        super("Birds", "AliveBird.png", 130);
    }
    
    /**
     * Changes the image of the bird to represent death.
     */
    public void die() {
        // Update the icon for the JLabel to represent death
        this.imageIcon = new ImageIcon("DeadBird.png");
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        this.setIcon(imageIcon);
    }
}
