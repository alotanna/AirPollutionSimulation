# AirPollutionSimulation
The essence of this project is to create an interactive simulation that educates users about 
the impact of pollution on the environment and living beings. It aims to raise awareness about 
the importance of pollution control measures and the consequences of unchecked pollution 
sources. By providing a visual representation of an ecosystem and allowing users to manipulate 
various components, the project can potentially solve the issue of lack of understanding or 
awareness regarding environmental pollution. It can serve as a tool for teaching and learning 
about the delicate balance between human activities, pollution, and the well-being of living 
beings. This project could be beneficial in educational settings, such as schools or environmental 
organizations, to help students and individuals understand the real-world implications of 
pollution and the need for sustainable practices.
Overview
The code represents a graphical user interface (GUI) application that simulates an ecosystem 
with cities, humans, birds, plants, pollution sources, and pollution control measures. The main 
class is `GUI Ecosystem,` which creates a JFrame and initializes the various components of the 
ecosystem.
Classes
1. GUI Ecosystem
 - This is the main class that sets up the GUI environment.
 - It creates a JFrame and several JPanels to hold the different components of the ecosystem.
 - It initializes the cities, humans, birds, plants, pollution sources, and pollution control 
measures.
 - It provides methods to create and add these components to the respective JPanels.
 - It also handles mouse and keyboard events to allow interaction with the components.
2. Cities
 - This class extends JPanel and represents a city in the ecosystem.
 - Each city has properties like name, maximum population, current population, and air 
pollution level.
 - Cities can have humans (healthy and sick), plants, birds, pollution sources (cars, factories, 
methane from cows), and pollution control measures (planting, catalytic converters).
 - The `paintComponent` method is overridden to display the city's name, population, and 
pollution level and color-code the town based on the pollution level.
 - Methods are provided to manage the population, pollution level, and the effects of pollution 
on living beings.
3. GUILivingThings 
 - This abstract class serves as the basis for other living beings like humans, birds, and plants.
 - It has properties like a name, the maximum tolerance level for pollution, and an image icon.
 - It provides a method to `die` by changing the image icon when a living being dies due to 
pollution.
4. GUI Human 
 - This class extends `GUILivingThings` and represents a human in the ecosystem.
 - It has an additional property, `immune-system,` to represent the strength of the human 
immune system.
 - Methods are provided to change the human icon based on their health status (sick, healed, 
dead).
5. GUI Plants
 - This class extends `GUILivingThings` and represents a plant in the ecosystem.
 - It has methods to change the plant's icon based on whether it is alive or dead due to pollution.
6. GUI Birds
 - This class extends `GUILivingThings` and represents a bird in the ecosystem.
 - It has a method to change the bird's icon when it dies due to pollution.
7. Pollution Source
 - This class represents a pollution source in the ecosystem, such as cars, factories, or cows 
(methane).
 - It has a property `pollution rate` to represent the amount of pollution it contributes.
 - The icon representing the pollution source is determined based on the type (car, factory, or 
cow).
8. Pollution Control
 - This class represents a pollution control measure in the ecosystem, such as planting or 
catalytic converters.
 - It has a property `reductionrate` to represent the amount of pollution it can reduce.
 - The icon representing the pollution control measure is determined based on the type (planting 
or catalytic converter).
User Interaction
The application provides a graphical user interface that allows the user to interact with the 
simulated ecosystem. Here's how the user should interact with the application:
Initial Setup
When the application starts, the user is prompted with a series of dialog boxes to input the 
desired number of various components in the ecosystem, such as humans, birds, plants, pollution 
sources, and pollution control measures. The user should enter the numbers within the specified 
limits to create the desired ecosystem configuration.
Component Movement
Once the ecosystem is set up, the user can interact with the components using the mouse and 
keyboard. To move a component, the user should click on it to select it. The selected component 
will be highlighted with a white border. Using the arrow keys (up, down, left, right), the user can 
move the selected component within its current panel.
Transferring Components
To transfer a component from one panel to another (e.g., moving a pollution source from the 
pollution sources panel to a city panel), the user should click on the desired panel while the component is selected. The selected component will be transferred to the new panel, and the 
effects of the component on the ecosystem (e.g., increasing or decreasing pollution levels) will 
be reflected.
Observing Effects
As the user interacts with the ecosystem by moving components, they can observe the effects on 
the living beings (humans, plants, birds) and the cities. The population increases based on the 
presence of humans. The pollution levels of cities will change based on the presence of pollution 
sources and pollution control measures. The health status of living beings will be affected by the 
pollution levels, and they may become sick, heal, or die based on the conditions. The color of the 
cities will also change to reflect the pollution level, ranging from green (low pollution) to red 
(high pollution).
