package oopProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Creating objects of all the classes needed for the ecosystem
public class GUIEcosystem {
	
	 JFrame frame; // Main window frame
	 JPanel currentPanel, SourcesPanel, ControlPanel, Humanspanel, PlantsBirdsPanel; // Panels for different components
	 Countries[] country = new Countries[8]; // Array to hold country objects
	 GUIHuman[] people = new GUIHuman[2000]; // Array to hold human objects
	 GUIBirds[] birds = new GUIBirds[1000]; // Array to hold bird objects
	 GUIPlants[] plants = new GUIPlants[1000]; // Array to hold plant objects
	 PollutionControl[] control = new PollutionControl[1000]; // Array to hold pollution control objects
	 PollutionSource[] source = new PollutionSource[1000]; // Array to hold pollution source objects
	 JLabel selectedObject, placeholder; // Labels for selected objects and placeholder
	 int i = 0; // Counter variable

 // Constructor where all the initialization of all component occurs
	 
 GUIEcosystem() {
     // Initialize the main frame
     frame = new JFrame("Umoya Air Quality Control");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.getContentPane().setBackground(Color.getHSBColor(110, 223, 221)); // Set background color
     frame.setSize(600, 630); // Set frame size
     frame.setLayout(new GridLayout(6, 4, 10, 10)); // Set layout

     // Creating panels for different components

     // Panel for pollution sources
     SourcesPanel = new JPanel();
     SourcesPanel.setBackground(Color.cyan);
     JLabel textLabel = new JLabel("Pollution Sources");
     SourcesPanel.add(textLabel);
     SourcesPanel.addMouseListener(new PanelMouseListener()); // Add mouse listener
     addMouseandKeyboard(SourcesPanel); // Add keyboard listener

     // Panel for humans
     Humanspanel = new JPanel();
     Humanspanel.setBackground(Color.cyan);
     JLabel textLabel2 = new JLabel("Humans");
     Humanspanel.add(textLabel2);
     Humanspanel.addMouseListener(new PanelMouseListener()); // Add mouse listener
     addMouseandKeyboard(Humanspanel); // Add keyboard listener

     // Panel for pollution control objects
     ControlPanel = new JPanel();
     ControlPanel.setBackground(Color.cyan);
     JLabel textLabel3 = new JLabel("Pollution Control");
     ControlPanel.add(textLabel3);
     ControlPanel.addMouseListener(new PanelMouseListener()); // Add mouse listener
     addMouseandKeyboard(ControlPanel); // Add keyboard listener

     // Panel for birds and plants
     PlantsBirdsPanel = new JPanel();
     PlantsBirdsPanel.setBackground(Color.cyan);
     JLabel textLabel4 = new JLabel("Plants and Birds");
     PlantsBirdsPanel.add(textLabel4);
     PlantsBirdsPanel.addMouseListener(new PanelMouseListener()); // Add mouse listener
     addMouseandKeyboard(PlantsBirdsPanel); // Add keyboard listener

     // Initialize country objects with predefined values
     country[0] = new Countries("NIGERIA", 120, 3, 3, 3, 3, 2, 3, 3, 0, 2);
     country[1] = new Countries("TOGO", 100, 2, 1, 2, 2, 2, 1, 1, 0, 2);
     country[2] = new Countries("GHANA", 50, 3, 1, 2, 2, 2, 2, 2, 0, 2);
     country[3] = new Countries("ZIMBABWE", 60, 3, 1, 3, 3, 2, 2, 3, 0, 2);
     country[4] = new Countries("SWAZILAND", 20, 1, 0, 2, 3, 1, 2, 3, 1, 2);
     country[5] = new Countries("SA", 50, 4, 2, 1, 3, 2, 3, 2, 2, 2);
     country[6] = new Countries("KENYA", 60, 2, 1, 1, 3, 2, 4, 2, 0, 2);
     country[7] = new Countries("CAMEROON", 20, 2, 1, 1, 3, 2, 2, 3, 0, 2);

     // Adding country panels to the frame
     for (i = 0; i < 8; i++) {
         country[i].setFocusable(true); // Ensure panel can receive keyboard events
         country[i].requestFocusInWindow(); // Set focus to the panel so it can receive keyboard events
         country[i].addMouseListener(new PanelMouseListener()); // Add mouse listener
         addMouseandKeyboard(country[i]); // Add keyboard listener
         frame.add(country[i]); // Add the countries to the frame
     }

     // Calling methods to create various elements in the ecosystem
     createHumans();
     createBirds();
     createPlants();
     createPollutionSources();
     createPollutionControl();

     // Add panels to the frame
     frame.add(SourcesPanel);
     frame.add(ControlPanel);
     frame.add(Humanspanel);
     frame.add(PlantsBirdsPanel);

     // Set frame visibility
     frame.setVisible(true);
 }

    // Methods for creating various elements in the ecosystem
    
    
 // Methods for creating humans in the ecosystem
    public void createHumans() {
        
        // Prompt user for the number of healthy humans
        String command1 = JOptionPane.showInputDialog("How many healthy humnas do you want to create? (Max: 150)");
        int healthyHumans = Integer.parseInt(command1);
        
        // Prompt user for the number of sick humans
        String command2 = JOptionPane.showInputDialog("How many sick humnas do you want to create? (Max: 150)");
        int sickHumans = Integer.parseInt(command2);
        
        // Create healthy humans
        for(int i = 0; i < healthyHumans; i++) {
            people[i] = new GUIHuman();
            Humanspanel.add(people[i]);
        }
        
        // Create sick humans
        for(int i = 0; i < sickHumans; i++) {
            people[healthyHumans + i] = new GUIHuman("sick");
            Humanspanel.add(people[healthyHumans + i]);
        }
    }

    // Methods for creating birds in the ecosystem
    public void createBirds() {
        // Prompt user for the total number of birds
        String command = JOptionPane.showInputDialog("How many birds would there be in total? (Max: 50)");
        int totalBirds = Integer.parseInt(command);
        
        // Create birds
        for(int i = 0; i < totalBirds; i++) {
            birds[i] = new GUIBirds();
            PlantsBirdsPanel.add(birds[i]);
        }
    }

    // Methods for creating plants in the ecosystem
    public void createPlants() {
        // Prompt user for the total number of plants
        String command = JOptionPane.showInputDialog("How many plants would there be in total? (Max: 50)");
        int totalPlants = Integer.parseInt(command);
        
        // Create plants
        for(int i = 0; i < totalPlants; i++) {
            plants[i] = new GUIPlants();
            PlantsBirdsPanel.add(plants[i]);
        }
    }
        
 // Methods for creating pollution sources in the ecosystem
    public void createPollutionSources() {
        
        // Prompt user for the number of cars
        String command1 = JOptionPane.showInputDialog("How many pollution source objects of cars will you create? (Max: 50)");
        int cars = Integer.parseInt(command1);
        
        // Prompt user for the number of factories
        String command2 = JOptionPane.showInputDialog("How many pollution source objects of factories will you create? (Max: 50)");
        int factories = Integer.parseInt(command2);
        
        // Prompt user for the number of cows (methane)
        String command3 = JOptionPane.showInputDialog("How many pollution source objects of cow(methane) will you create? (Max: 50)");
        int cows = Integer.parseInt(command3);
        
        // Create cars
        for(int i = 0; i < cars; i++) {
            source[i] = new PollutionSource("car");
            SourcesPanel.add(source[i]);
        }
        
        // Create factories
        for(int i = 0; i < factories; i++) {
            source[cars + i] = new PollutionSource("factory");
            SourcesPanel.add(source[cars + i]);
        }
        
        // Create cows (methane)
        for(int i = 0; i < cows; i++) {
            source[cars + factories + i] = new PollutionSource("cows");
            SourcesPanel.add(source[cars + factories + i]);
        }
    }

    // Methods for creating pollution control in the ecosystem
    public void createPollutionControl() {
        
        // Prompt user for the number of planting devices
        String command1 = JOptionPane.showInputDialog("How many pollution control objects of planting will you create? (Max: 50)");
        int plantingDevices = Integer.parseInt(command1);
        
        // Prompt user for the number of catalytic converters
        String command2 = JOptionPane.showInputDialog("How many pollution control objects of catalytic converters will you create? (Max: 50)");
        int catalyticConverters = Integer.parseInt(command2);
        
        // Prompt user for the number of ozone generators
        String command3 = JOptionPane.showInputDialog("How many pollution control objects ozone generators of will you create? (Max: 50)");
        int otherDevices = Integer.parseInt(command3);
        
        // Create planting devices
        for(int i = 0; i < plantingDevices; i++) {
            control[i] = new PollutionControl("plant");
            ControlPanel.add(control[i]);
        }
        
        // Create catalytic converters
        for(int i = 0; i < catalyticConverters; i++) {
            control[plantingDevices + i] = new PollutionControl("catlytic converter");
            ControlPanel.add(control[plantingDevices + i]);
        }
        
        // Create other pollution control devices
        for(int i = 0; i < otherDevices; i++) {
            control[plantingDevices + catalyticConverters + i] = new PollutionControl("ozone generator");
            ControlPanel.add(control[plantingDevices + catalyticConverters + i]);
        }
    }

    

	  public static void main(String[] args) {
		  new GUIEcosystem();

}
	  /**
	   * Adds mouse and keyboard listeners to the given panel.
	   * @param panel The panel to which listeners are added.
	   */
	  public void addMouseandKeyboard(JPanel panel) {
	      // Add mouse listener to handle mouse clicks
	      panel.addMouseListener(new MouseAdapter() {
	          @Override
	          public void mouseClicked(MouseEvent e) {
	              Component[] components = panel.getComponents(); // Get all components on the panel
	              for (Component component : components) {
	                  // Check if the mouse click event occurred within the bounds of any component
	                  if (component.getBounds().contains(e.getPoint())) {
	                      selectedObject = (JLabel) component; // Set the selected object
	                      break; // Exit loop after finding the first component clicked
	                  }
	              }
	          }
	      });
	      
	      // Add keyboard listener to handle movement
	      panel.addKeyListener(new KeyAdapter() {
	          @Override
	          public void keyPressed(KeyEvent e) {
	              if (selectedObject != null) {
	                  int x = selectedObject.getX();
	                  int y = selectedObject.getY();
	                  int moveAmount = 5; // Adjust movement amount as needed

	                  // Adjust position based on arrow key pressed
	                  switch (e.getKeyCode()) {
	                      case KeyEvent.VK_UP:
	                          y -= moveAmount;
	                          break;
	                      case KeyEvent.VK_DOWN:
	                          y += moveAmount;
	                          break;
	                      case KeyEvent.VK_LEFT:
	                          x -= moveAmount;
	                          break;
	                      case KeyEvent.VK_RIGHT:
	                          x += moveAmount;
	                          break;
	                  }

	                  // Check if the new position is within the bounds of the panel
	                  if (x >= 0 && y >= 0 && x + selectedObject.getWidth() <= panel.getWidth() && y + selectedObject.getHeight() <= panel.getHeight()) {
	                      selectedObject.setLocation(x, y); // Update the location of the selected object
	                      panel.repaint(); // Repaint the panel to reflect the movement
	                  }
	              }
	          }
	      });
	  }

	  /**
	   * PanelMouseListener class handles mouse click events on panels.
	   */
	  class PanelMouseListener extends MouseAdapter {
	      @Override
	      public void mouseClicked(MouseEvent e) {
	          // Check if there is a selected object
	          if (selectedObject != null) {
	              // Get the panel where the mouse click event occurred
	              JPanel destinationPanel = (JPanel) e.getSource();
	              
	              // Add the selected object to the destination panel
	              destinationPanel.add(selectedObject);
	              
	              // Set border of destination panel to indicate selection
	              destinationPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	              
	              // Revalidate the destination panel to reflect changes
	              destinationPanel.revalidate();
	              
	              // Check if the destination panel is a Countries instance
	              if (destinationPanel instanceof Countries) {
	                  Countries destCity = (Countries) destinationPanel;
	                  
	                  // React to pollution in the destination city
	                  destCity.ReacttoPollution(destCity);
	                  
	                  // Set population of the destination city
	                  destCity.setPop(destCity);
	                  
	                  // Check if the selected object is a PollutionSource
	                  if (selectedObject instanceof PollutionSource) {
	                      // Increase pollution level in the destination city
	                      destCity.increasepollutionlevel(destCity);
	                      
	                      // Update color of the destination city based on pollution level
	                      destCity.updateColor();
	                  }
	                  
	                  // Check if the selected object is a PollutionControl
	                  if (selectedObject instanceof PollutionControl) {
	                      // Decrease pollution level in the destination city
	                      destCity.decreasepollutionlevel(destCity);
	                      
	                      // Update color of the destination city based on pollution level
	                      destCity.updateColor();
	                      
	                      // React to pollution in the destination city
	                      destCity.ReacttoPollution(destCity);
	                  }
	              }

	              // Check if there was a previously selected panel and it is not the same as the destination panel
	              if (currentPanel != null && currentPanel != destinationPanel) {
	                  // Check if the previously selected panel is an instance of Countries
	                  if (currentPanel instanceof Countries) {
	                      Countries currentCity = (Countries) currentPanel;
	                      
	                      // Set population of the previously selected city
	                      currentCity.setPop(currentCity);
	                      
	                      // Check if the selected object is a PollutionSource
	                      if (selectedObject instanceof PollutionSource) {
	                          // Increase pollution level in the previously selected city
	                          currentCity.increasepollutionlevel(currentCity);
	                          
	                          // Update color of the previously selected city based on pollution level
	                          currentCity.updateColor();
	                      }
	                      
	                      // Check if the selected object is a PollutionControl
	                      if (selectedObject instanceof PollutionControl) {
	                          // Decrease pollution level in the previously selected city
	                          currentCity.decreasepollutionlevel(currentCity);
	                          
	                          // Update color of the previously selected city based on pollution level
	                          currentCity.updateColor();
	                      }
	                  }
	                  
	                  // Remove border from the previously selected panel
	                  currentPanel.setBorder(null);
	                  
	                  // Revalidate the previously selected panel to reflect changes
	                  currentPanel.revalidate();
	              }
	              
	              // Update currentPanel to the destination panel
	              currentPanel = destinationPanel;
	              
	              // Set border of selected object to indicate selection
	              selectedObject.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	              
	              // Revalidate the selected object to reflect changes
	              selectedObject.revalidate();
	              
	              // Check if there was a placeholder object and it is not the same as the selected object
	              if (placeholder != null && placeholder != selectedObject) {
	                  // Remove border from the placeholder object
	                  placeholder.setBorder(null);
	                  
	                  // Revalidate the placeholder object to reflect changes
	                  placeholder.revalidate();
	              }
	              
	              // Update placeholder to the selected object
	              placeholder = selectedObject;
	              
	              // Clear the selected object to null
	              selectedObject = null;
	          }
	      }
	  }

  }

