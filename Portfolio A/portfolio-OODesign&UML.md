OO Design & UML
========================
![alt text](https://github.com/kamenPB/Green-Credentials/blob/master/Portfolio%20A/PNG/architecture.png "Green Credentials architecture diagram")

This architecture diagram shows how the standalone web app will interact with the existing spreadsheet file used by Cabot Circus. The HTML web page, which will run on a Cabot Circus server, is the way in which the customers will be able to view the display. It will be ran on a Smart TV in public display at the shopping centre.

The HTML web page will receive the raw data from the spreadsheet, as uploaded by the Cabot staff, and store it in hidden <span> tags. These tags will be accessed by the JavaScript file, which will use this data to create the charts, slideshow, and other pictorial visual aids from which the display can be constructed. This will then be dynamically implemented into the web page, at which point the Cabot staff can refresh (or load, on the first time) the web browser of the Smart TV.
  
![alt text](https://github.com/kamenPB/Green-Credentials/blob/master/Portfolio%20A/PNG/uml-activity.png "Green Credentials activity diagram")

The above is an activity diagram for an exceptional flow of the sustainability officer for Cabot Circus, the stakeholder responsible for maintaining the system by updating the spreadsheet with more recent consumption data and adding comments where necessary. This is a somewhat common case, in which the consumption data for the most recent month reflects negatively on Cabot Circus's green credentials.

This use case was selected as it demonstrates a scenario in which the comment section's usage is important, and can show the tools available to the user to help explain to their customers what the data shows. The client emphasised an importance on their ability to be transparent. Initially, this was modelled in a way such that data which reflects negatively on Cabot Circus's green credentials was simply not displayed. However, after further clarification, this was adjusted to instead give their staff the ability to justify in a transparent way the reasons behind an increase, as in this example, in usage.
