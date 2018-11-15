OO Design & UML
========================
![alt text](Green-Credentials/Portfolio A/PNG/uml_diagram.png  "Green Credentials UML diagram")

All of Cabot's data is passed through Beth who inputs it into an excel file. She also decides what to display on the screen by inputting a true or false into a flag column in order to have better control of the information shown to the public.

Our program will pull from the excel sheet and will store the data into the relevant classes which we have shown in more detail below. This will be updated on a monthly basis for most of the categories, but the total power usage of Cabot Circus will be renewed every 30 minutes. Once we have ensured we are using data that is up to date, we check that showData is True for a class and proceed; otherwise we move on to the next class. 

In the output stage, certain methods from the class are used to generate visual representations of the data that are both informative and eye-catching. An example of this would be a pie chart showing the proportion of waste that is recycled, and also converting the total weight of recycled material into x-amount of elephants. This is useful as it doesn't detract from the accuracy of the information, whilst also showing it in terms more comprehendible to the average person due to the fact we are dealing with very large numbers.

We have modelled the use-case of Beth, our point of contact at Cabot Circus, who is in charge of creating the existing print posters which display the shopping centre's environmental achievements. This model shows the expected system flow for our software, which is to replace the existing system of a manually printed poster display.

This model was chosen as it is the primary flow of input to output, and representing it graphically helped to elucidate aspects of the system where clarification or additional steps are required. For example, we initially modelled the decision-making aspect of which data categories should be displayed as a completely internal, automated event. However, this contradicted our specification, and so we then added a mechanism through which Beta can veto the decision made by the software and choose to display rejected data anyway. Modelling this graphically made it clear that it would save time if Beth decided what is to be shown at the same time that she inputs the Excel spreadsheet, and so we adjusted the system flow to accommodate this change. This helped make our model of the software's system flow be more accurate the specification provided by our client.

![alt text](Green-Credentials/Portfolio A/PNG/example-classes.png  "Green Credentials Example Classes")

Here we have what we believe the structure of our data classes will look like upon completion, using water as an example as the rest will be of a similar style. We will use either an interface or a parent class as all of our subcategories share similar goals with different implementations: 
1. Each class will need a method to calculate the difference between at minimum two sets of data
1. We will need to transform the raw data into a visual form
1. All classes must be kept up to date
