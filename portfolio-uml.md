OO Design & UML
========================
![alt text](https://github.com/kamenPB/Green-Credentials/blob/master/SPE-UML.png "Green Credentials UML diagram")

We have modelled the use-case of Beth, our point of contact at Cabot Circus, who is in charge of creating the existing, print posters which display the shopping centre's environmental achievements. This model shows the expected system flow for our software, which is to replace the existing system of a manually printed poster display.

This model was chosen as it is the primary flow of input to output, and representing it graphically helped to elucidate aspects of the system where clarification or additional steps are required. For example, we initially modelled the decision-making aspect of which data categories should be displayed as a completely internal, automated event. However, this contradicted our specification, and so we then added a mechanism through which Beta can veto the decision made by the software and choose to display rejected data anyway. Modelling this graphically made it clear that it would save time if Beth decided what is to be shown at the same time that she inputs the Excel spreadsheet, and so we adjusted the system flow to accommodate this change. This helped make our model of the software's system flow be more accurate the specification provided by our client.

![alt text](https://github.com/kamenPB/Green-Credentials/blob/master/example-classes.png "Green Credentials Example Classes")

Here we have what we believe the structure of our data classes will look like upon completion, using water as an example as the rest will be of a similar style.
