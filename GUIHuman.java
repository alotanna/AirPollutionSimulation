package oopProject;

import java.awt.Image;

import javax.swing.*;

/**
 * Represents a human entity in the ecosystem.
 */
class GUIHuman extends GUILivingThings {
    private ImageIcon imageIcon; // Icon for the human entity
    protected double immuneSystem; // Immune system strength of the human

    /**
     * Constructs a healthy human entity.
     */
    public GUIHuman() {
        super("Human", "HealthyHuman.png", 150);
        this.immuneSystem = 150;
    }

    /**
     * Constructs a sick human entity.
     * @param name  the state of the human.
     */
    public GUIHuman(String state) {
        super("Sick", "SickHuman.png", 100);
        this.immuneSystem = 150;
    }
    
    /**
     * Changes the image of the human to represent death.
     */
    public void die() {
        this.imageIcon = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\oopProject\\src\\oopProject\\DeadPerson.png");
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        this.setIcon(imageIcon);
    }

    /**
     * Changes the image of the human to represent sickness.
     */
    public void sick() {
        this.imageIcon = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\oopProject\\src\\oopProject\\SickHuman.png");
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        this.setIcon(imageIcon);
    }

    /**
     * Changes the image of the human to represent healing.
     */
    public void healed() {
        this.imageIcon = new ImageIcon("C:\\Users\\user\\eclipse-workspace\\oopProject\\src\\oopProject\\HealthyHuman.png");
        Image imageIc = this.imageIcon.getImage();
        Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(scaledImage);
        this.setIcon(imageIcon);
    }
}
