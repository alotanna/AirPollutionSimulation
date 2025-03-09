package oopProject;

import javax.swing.*;
import java.awt.*;
/**
 * Countries class represents a panel for displaying information about a country's ecosystem.
 */
public class Countries extends JPanel {
	private String cityName;
	private int maxpopulation;
	private int curentpopulation;
	
	private Color color;
	protected double airpollutionlevel;
	// Create a bold font
    Font boldFont = new Font("Congenial", Font.BOLD, 12);
    
    /**
     * Constructor for Countries class.
     * @param cityName The name of the city.
     * @param maxpopulation The maximum population of the city.
     * @param curentpopulation The current population of the city.
     * @param sick The number of sick individuals in the city.
     * @param currentplants The number of plants in the city.
     * @param currentbirds The number of birds in the city.
     * @param currentcars The number of cars in the city.
     * @param currentfactories The number of factories in the city.
     * @param currentmethane The number of cows (methane sources) in the city.
     * @param currentcatalyst The number of catalytic converters in the city.
     * @param curentplanting The number of pollution control (planting) activities in the city.
     */
	public Countries(String cityName, int maxpopulation, int curentpopulation,int sick,int currentplants, int currentbirds,
			int currentcars,int currentfactories,int currentmethane,int currentcatalyst, int curentplanting) {
		this.cityName = cityName;

		ImageIcon imageLabel = new ImageIcon();
		
		// Set image based on city name
		if (cityName.equalsIgnoreCase("Nigeria")) {
			imageLabel = new ImageIcon("Nigeria.jpeg");
		} else if (cityName.equalsIgnoreCase("Zimbabwe")) {
			imageLabel = new ImageIcon("Zimbabwe.jpeg");
		} else if (cityName.equalsIgnoreCase("Swaziland")) {
			imageLabel = new ImageIcon("Swaziland.jpeg");
		} else if (cityName.equalsIgnoreCase("Kenya")) {
			imageLabel = new ImageIcon("Kenya.jpeg");
		} else if (cityName.equalsIgnoreCase("Ghana")) {
			imageLabel = new ImageIcon("Ghana.jpeg");
		} else if (cityName.equalsIgnoreCase("SA")) {
			imageLabel = new ImageIcon("SA.jpeg");
		} else if (cityName.equalsIgnoreCase("Cameroon")) {
			imageLabel = new ImageIcon("Cameroon.jpeg");
		} else if (cityName.equalsIgnoreCase("Togo")) {
			imageLabel = new ImageIcon("Togo.jpeg");
		}

		Image imageIc = imageLabel.getImage();
		Image scaledImage = imageIc.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		imageLabel = new ImageIcon(scaledImage);
		JLabel label = new JLabel(imageLabel);

		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(label);
		
		// Add components to represent humans, plants, birds, pollution sources, and pollution controls in the city
		for(int i = 0; i< curentpopulation;i++) {
			this.add(new GUIHuman());
		}
		for(int i = 0; i< sick;i++) {
			this.add(new GUIHuman("sick"));
		}
		for(int i = 0; i< currentplants;i++) {
			this.add(new GUIPlants());
		}
		for(int i = 0; i< currentbirds;i++) {
			this.add(new GUIBirds());
		}
		for(int i = 0; i< currentcars;i++) {
			this.add(new PollutionSource("car"));
		}
		for(int i = 0; i< currentfactories;i++) {
			this.add(new PollutionSource("factory"));
		}
		for(int i = 0; i< currentmethane;i++) {
			this.add(new PollutionSource("cows"));
		}
		for(int i = 0; i< currentcatalyst;i++) {
			this.add(new PollutionControl("catlytic converter"));
		}
		for(int i = 0; i< curentplanting;i++) {
			this.add(new PollutionControl("plant"));
		}

		this.maxpopulation = maxpopulation;
		this.airpollutionlevel = 0;
		this.setPop(this);
		this.increasepollutionlevel(this);
		this.decreasepollutionlevel(this);


	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Determine color based on pollution level
		// Draw city background color and display city information
		if (airpollutionlevel >= 0 & airpollutionlevel < 50) {
			g.setColor(color.GREEN);
			g.fillRect(0, 0, getWidth(), getHeight());
		} else if (airpollutionlevel >= 50 & airpollutionlevel < 100) {
			g.setColor(color.yellow);
			g.fillRect(0, 0, getWidth(), getHeight());
		} else if (airpollutionlevel >= 100 & airpollutionlevel < 150) {
			g.setColor(color.orange);
			g.fillRect(0, 0, getWidth(), getHeight());
		} else if (airpollutionlevel >= 150) {
			g.setColor(color.red);
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		// Draw city name and population
		g.setColor(Color.black);
		g.setFont(boldFont);
		g.drawString(cityName, 10, 60);
		g.drawString("current Population: " + curentpopulation + "m", 10, 80);
		g.drawString("Pollution Level: " + airpollutionlevel, 10, 100);
		g.drawString("MAX Population: " + maxpopulation+ "m", 10, 120);

	}
	
	 /**
     * Get the current population of the city.
     * @return The current population.
     */
	public int getPopulation() {
		return getComponentCount();
	}
	
	 /**
     * Set the current population of the city.
     * @param city The city panel.
     */
	public void setPop(JPanel city) {
		this.curentpopulation = 0;
		Component[] components = city.getComponents(); // Use the captured index
        for (Component component : components) {
            if (component instanceof GUIHuman) {
            	
            	this.curentpopulation += 1;
            }
        }
		// Repaint the panel to reflect the changes
		this.repaint();

	}

	public double getpollutionlevel() {
		return airpollutionlevel;
	}
	

	/**
	 * Increase the pollution level of the city based on pollution sources.
	 * @param city The city panel.
	 */
	public void increasepollutionlevel(JPanel city) {
	    // Reset pollution level to 0
	    this.airpollutionlevel = 0;
	    
	    // Iterate through components in the city panel
	    Component[] components = city.getComponents();
	    for (Component component : components) {
	        // Check if the component is a PollutionSource
	        if (component instanceof PollutionSource) {
	            // Add the pollution rate of the source to the city's pollution level
	            this.airpollutionlevel += ((PollutionSource) component).getpollutionrate();
	        }
	    }
	    
	    // Repaint the panel to reflect the changes in pollution level
	    this.repaint();
	}

	/**
	 * Decrease the pollution level of the city based on pollution controls.
	 * @param city The city panel.
	 */
	public void decreasepollutionlevel(JPanel city) {
	    // Iterate through components in the city panel
	    Component[] components = city.getComponents();
	    for (Component component : components) {
	        // Check if the component is a PollutionControl
	        if (component instanceof PollutionControl) {
	            // Subtract the reduction rate of the control from the city's pollution level
	            this.airpollutionlevel -= ((PollutionControl) component).getreductionrate();
	        }
	    }
	    
	    // Ensure pollution level doesn't go below 0
	    if (this.airpollutionlevel < 0) {
	        this.airpollutionlevel = 0;
	    }
	    
	    // Repaint the panel to reflect the changes in pollution level
	    this.repaint();
	}

	
	/**
	 * Reacts to pollution by affecting the entities in the city based on pollution level.
	 * @param city The city panel.
	 */
	public void ReacttoPollution(Countries city) {
	    // Iterate through components in the city panel
	    Component[] components = city.getComponents();
	    for (Component component : components) {
	        // React to pollution for humans
	        if (component instanceof GUIHuman) {
	            // Check if pollution level is in a certain range and human is not dead
	            if (city.getpollutionlevel() > 50 && city.getpollutionlevel() < 100 && ((GUIHuman) component).immuneSystem != 0) {
	                ((GUIHuman) component).sick(); // Make the human sick
	            } else if (city.getpollutionlevel() < 50 && ((GUIHuman) component).immuneSystem != 0) {
	                ((GUIHuman) component).healed(); // Heal the human
	            } else if (((GUIHuman) component).maxtolernace < city.getpollutionlevel()) {
	                ((GUIHuman) component).die(); // Kill the human if pollution exceeds tolerance
	                ((GUIHuman) component).immuneSystem = 0; // Set immune system to 0
	            }
	        }
	        // React to pollution for plants
	        if (component instanceof GUIPlants) {
	            if (((GUIPlants) component).maxtolernace < city.getpollutionlevel()) {
	                ((GUIPlants) component).die(); // Die if pollution exceeds tolerance
	            } else if (city.getpollutionlevel() < 50) {
	                ((GUIPlants) component).regrow(); // Re-grow if pollution level is low
	            }
	        }
	        // React to pollution for birds
	        if (component instanceof GUIBirds) {
	            if (((GUIBirds) component).maxtolernace < city.getpollutionlevel()) {
	                ((GUIBirds) component).die(); // Die if pollution exceeds tolerance
	            }
	        }
	    }
	}

	/**
	 * Updates the background color of the city panel based on pollution level.
	 */
	public void updateColor() {
	    // Determine the color based on pollution level
	    Color color;
	    if (airpollutionlevel >= 0 && airpollutionlevel < 50) {
	        color = Color.GREEN;
	    } else if (airpollutionlevel >= 50 && airpollutionlevel < 100) {
	        color = Color.YELLOW;
	    } else if (airpollutionlevel >= 100 && airpollutionlevel < 150) {
	        color = new Color(255, 190, 0);
	    } else if (airpollutionlevel >= 150 && airpollutionlevel < 200) {
	        color = Color.ORANGE;
	    } else {
	        color = Color.RED; // Add more conditions as needed
	    }

	    // Set the background color of the city panel
	    setBackground(color);
	    repaint(); // Repaint the city panel to reflect the color change
	}
}