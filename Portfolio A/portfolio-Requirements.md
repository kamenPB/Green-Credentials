Stakeholders:
=================================================================================
*   Beth: She is the environment and community coordinator and is the source of the information that we will be presenting in our product. The data is all from her sector of the cabot circus business.
*   Craig: project overseer, supervisor
*   Cabot circus customers: These are the people who will observe the final product on a day to day basis.
*   Marketing dept: They are responsible the business promotion and advertising, and thus, they have interest in how we present our product, there must be consistency with the brand they publicize (logos used, colour scheme, etc ).
*   Cabot Circus + its parent company, Hammerson (possibly other centres they own): The final product will be displayed at the cabot circus shopping centre, and if successful, could be implemented in other Hammerson shopping centres across the UK.

Functional requirements:
=================================================================================
1.  Display the green credentials of Cabot Circus in a pictorial fashion
    1.  Consumption vs generation
    1.  Examples of statistics (e.g. elephants for mass of wastage)
    1.  Display monthly change of stats
    1.  Automatic slideshow of different stats (gas, electricity, water, etc.)
1.  Update display with new data in real-time
1.  Prioritise data which reflects positively
    1.  Don't display data which looks bad
    1.  Allow Cabot staff to curate what displays

Non-functional requirements:
=================================================================================
1.  Display on a main Smart TV display on-location
1.  Integration with the Cabot Circus website
    1. Integration with the Plus App
1.  Save carbon footprint of Hammerson by being more environmentally friendly than printing out posters
    1.  Compare the energy usage of the Smart TV vs the printing
1.  Secure logins for different shopping centres (if it's scaled for other Hammerson-owned centres past Cabot)
1.  Perform well enough to update at least every half-hour
1.  Appear eye-catching and vibrant to engage passers-by
1.  Inform passers-by in easy-to-understand visuals how Cabot Circus is environmentally positive

Use-case diagram:
=================================================================================
![alt text](https://github.com/kamenPB/Green-Credentials/blob/master/Portfolio%20A/PNG/use-case_diagram.png)

We have different types of data that is being calculated every month. Electricity generated from the solar panels, gas generated from recycling the food wasteand water harvested from the rain - this is the data that Beth collects and stores in Excel spreadsheets. Later on, another actor - Cabot's staff - is allowed to edit the these if it is required. This is eventually what we are provided with, thus we enter the system we are developing. It can be seen is that a decision needs to be made - whether the data is positive or negative so we need to compare it to the prvious month. In the former case, we go on to the use-case that builds a TV representation whereas in the latter case, the decision to continue or not is up to the actors (Beth and the staff). After a screen has been made, it goes to a preview stage where either Beth or the staff need to approve that the information is correct and looks good enough to be presented. Given the green light, the TV is updated and the Customers are able to view its new stats being displayed. 

**Use-case goals:**
=================================================================================
* Generate 

(scenarios of getting the data from different sort of generators)
**Flow**
TO BE DONE

**Alternative flow**
TO BE DONE

**Exceptional flow**
TO BE DONE

* Update

**Flow**

1. A member of cabot circus rewrites some value on the excel spreadsheet
1. The spreadsheet is directly linked to the program so it will go through a filter and the output of that will go straight to the screen
1. Every 30 minutes, take the current data of the power usage 
1. Filter the data and display the output immediately

**Alternative flow**

1. A member of cabot circus is currently rewriting data on the spreadsheet and another member attempts to edit the same data
1. Lock the file so only one person can access it at a time
1. Unlock once there is nobody on the file

**Exceptional flow**

1. A member of staff accidentally deletes some data and doesn't replace it with anything
1. Continue displaying currently showing data until the spreadsheet is sorted out (store current data somewhere other than the spreadsheet)

* Compare

**Flow**

1. Recieve the new data
1. Compare with currently displayed data and the data of previous months
1. If new data is significantly inferior in terms of being environmentally friendly, do not display
1. Else, update screen data

**Alternative flow**

1. Recieve the new data
1. Compare with currently displayed data and the data of previous months
1. Data is identical to previous data
1. Do not update screen data

**Exceptional flow**

1. New data is not recieved
1. No comparisons made
1. Wait for next batch of data and continue displaying current screen data

* (pre)view TV representation 

**Flow**

1. Once the data has been checked to be positive, take the data that is being displayed pictorially
1. Split them up into each pictorial section (e.g elephants, bath tubs etc)
1. For each section, using the new numerical data, calculate how many of said data presentation picture corresponds to the data
1. Display that many of the pictures on the screen

**Alternative flow**

1. Once the data has been checked to be positive, take the data that is being displayed pictorially
1. Split them up into each pictorial section (e.g elephants, bath tubs etc)
1. For each section, using the new numerical data, calculate how many of said data presentation picture corresponds to the data
1. The data corresponds to and small percentage of a visual representation of that data (e.g 0.0006% of an elephant)
1. Round the percentage to the nearest Integer
1. Display the data on the screen

**Exceptional flow**

1. Once the data has been checked to be positive, take the data that is being displayed pictorially
1. Split them up into each pictorial section (e.g elephants, bath tubs etc)
1. For each section, using the new numerical data, calculate how many of said data presentation picture corresponds to the data
1. The number of pictures to be displayed is way too many to be displayed on the screen/ It is no longer a suitable representation and something of a bigger scale would be better
1. Update the text display and pictures to something more suitable (Something of bigger scale for each picture display will be planned in advance)

* Display green credentials

**Flow**

1. Display all of the data required on the screen
1. Make all the text readable
1. Use eye catching colours and pictures

**Alternative flow**

1. Display all of the data required on the screen
1. Too much data makes the text on the screen to small and thus unreadable
1. Split Display into 2 slides and alternate between them on a timely basis

**Exceptional flow**

1. The screen doesn't turn on or is having problems displaying the data
1. Make sure all the power cables are inserted properly
1. Turn the TV off then back on
1. If there are still problems, consult the IT department

In terms of importance, displaying the green credentials of cabot circus accurately in a pictorial and graphical fashion on a smart TV is at the top, the website and app integration are secondary goals. This main goal can be divided into the following atomic requirements:
1. The TV screen displays all the required data
1. There is a constant input stream of the real time data about some of the applicable topics.
1. The internal data processing filters out negative data
1. There is an accesible and simple interface for any cabot circus staff to alter data in any way they see fit
