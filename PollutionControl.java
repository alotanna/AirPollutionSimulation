package oopProject;

import java.awt.Image;

    import javax.swing.*;

    /**
     * Represents a pollution control entity in the GUI ecosystem.
     */
    public class PollutionControl extends JLabel {
        private String name; // Name of the pollution control entity
        protected double reductionrate; // Rate at which pollution is reduced
        private ImageIcon imageIcon; // Icon for the pollution control entity
        protected JPanel currentPanel; // Panel where the pollution control entity currently resides

        /**
         * Constructs a pollution control entity with the specified name.
         * @param name The name of the pollution control entity.
         */
        public PollutionControl(String name) {
            this.name = name;
            // Set the image icon and reduction rate based on the provided name
            if(name.equals("plant")) {
                this.imageIcon = new ImageIcon("Afforestation.png");
                this.reductionrate = 6;
            } else if(name.equals("catlytic converter")) {
                this.imageIcon = new ImageIcon("catalyst.png");
                this.reductionrate = 8;
            }else if(name.equals("ozone generator")) {
                this.imageIcon = new ImageIcon("Ozone.png");
                this.reductionrate = 8;
            }
            
            // Scale the image icon
            Image imageIc = this.imageIcon.getImage();
            Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            this.imageIcon = new ImageIcon(scaledImage);
            // Set the icon for the JLabel
            this.setIcon(imageIcon);
        }

        /**
         * Retrieves the reduction rate of pollution for this pollution control entity.
         * @return The reduction rate of pollution.
         */
        public double getreductionrate() {
            return this.reductionrate;
        }
    }
