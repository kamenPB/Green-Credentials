Stakeholders:
=================================================================================
*   Beth: She is the environmental sustainability supervisor and the source of the information that we will be presenting in our product. The data is all from her sector of cabot circus.
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

**Use-case goals:**
=================================================================================
* Display green credentials of cabot circus on a Smart TV
* Update data in real time
* Filter out negative data
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
* Calculate statistics/pictorial data
* Integrate with app
* Integrate with website

In terms of importance, displaying the green credentials of cabot circus accurately in a pictorial and graphical fashion on a smart TV is at the top, the website and app integration are secondary goals. This main goal can be divided into the following atomic requirements:
1. The TV screen displays all the required data
1. There is a constant input stream of the real time data about some of the applicable topics.
1. The internal data processing filters out negative data
1. There is an accesible and simple interface for any cabot circus staff to alter data in any way they see fit
