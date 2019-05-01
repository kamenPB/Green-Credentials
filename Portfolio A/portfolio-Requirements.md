Stakeholders:
=================================================================================
*   Beth is the environment and community coordinator for Cabot Circus, and is the main point of contact the project. She will provide the consumption data to be used by the software, and will judge our progress and provide feedback, ideas and comments on the development process.
*   Craig, while not directly involved in the development process, is overseeing the project within Cabot Circus’s staff, and will ensure everything goes smoothly.
*   Cabot Circus's customers are the people who will observe the final product on a day to day basis, and are the audience for which the display should be tailored to.
*   The marketing department of Cabot Circus are responsible for the shopping centre’s promotion and advertising. They have a vested interest in how we present our product, and so must ensure consistency with their brand with respect to logos used, colours, fonts, and other visual features.
*   Cabot Circus, Hammerson, and, possibly, other shopping centres Hammerson owns, also have vested corporate interests in the final product. As the project ultimately should positively improve the shopping centre’s brand, it could also be implemented in other Hammerson shopping centres across the country.

Functional requirements:
=================================================================================
From the preliminary meetings with the client, a set of functional requirements were elicited. The first functional requirement of the project is for the software to display and visualise Cabot Circus’s environmental data. This is the core of the project and should be the top priority of development. The software should successfully read in the shopping centre’s consumption data from a provided spreadsheet file and interpret it. This can be verified by comparing the numbers displayed by the software with the raw data of the spreadsheet file, as provided by the client.

The pictorial visual aids should display under all circumstances, including under the case of a weak or absent internet connection. This is necessary as the display will be publicly viewed year-round, and it is likely that there will be eventual internet disconnections. This functional requirement can be verified during development by ensuring to view the display on devices with no internet connection, and can be mitigated by storing the image files locally.

The client should be allowed to add custom comments which display alongside the different data categories. Some months may display environmental data which reflects negatively on the shopping centre, such as if they used more electricity in February 2019 than in the two years prior. This comment section is necessary to allow Cabot Circus’s sustainability team to explain, if not justify, to their customers why this may be the case. This was a problem which was made explicit by the client, as they do not wish to simply obscure or hide their environmental data when it reflects positively on them, and instead believe that a more transparent approach is preferable if they are given the opportunity to justify this to their customers. The comments section should be integrated into the spreadsheet file, and so verification of its functionality should be performed along with the testing of the raw data being displayed by the software. In other words, if the comment provided in the spreadsheet is displayed verbatim on the front-end display by the project, it can be considered a successfully implemented feature. Considerations should also be made during development for formatting, and the decision to include or exclude this feature should be made explicit in the user manual.

The display should automatically transition between the different data categories it is representing. This was decided upon further eliciting of ideas from the client, where it was agreed that displaying all of the statistics at once on a single, static screen could come across as cluttered and disorganised. The software should successfully transition all aspects of the display to accommodate the relevant data category currently being displayed. This includes the comment, the data itself, and the type of chart used. Verification of this functional requirement can be performed by observing the data, comments, and chart types as the slideshow progresses, and confirming they are as intended in the source code.

Non-functional requirements:
=================================================================================
The display should be clear and well-structured; while this cannot be empirically verified, the design should be developed in tandem with the vision of the client, and the feedback they provide should be followed closely. Basic design principles such as colour theory and familiar layouts for comparable posters should be used to ensure the display is clear to understand. This is important due to the public nature of the project; the target audience of this display is Cabot Circus’s customer base, which may range drastically in age, eyesight ability, and in understanding of environmental jargon.

The pictorial visual aids should clearly and simply explain or visualise what the data being shown represents. This applies to both any images used, as well as the charts themselves. Due to the nature of Cabot Circus’s broad customer base, the knowledge of the viewer of environmental jargon and scientific units may vary vastly. To this end, the explanations should be ensured to be as clear as possible by gathering feedback from non-professional viewers. Common, everyday comparisons and analogies should be used when explaining or visualising data. An example provided by the client was to display the weight of waste recycled by Cabot Circus in terms of the weight of elephants. This is a familiar visual which everyone can relate, irrespective of their knowledge of the recycling industry. The client should therefore also be consulted regularly on the phrasing and imagery used in the display, to ensure they agree it is clear and understandable to their customers, as they will be the most familiar with their needs.

Should the rollout to other Hammerson shopping centres be implemented, the necessity for adequate security functionality for staff logins and authorisation should be implemented. This is to ensure no unauthorised staff member, perhaps from a different Hammerson shopping centre, has access to the consumption data of a centre with which they are not employed or authorised access to.

Use-case diagram:
=================================================================================
![alt text](https://github.com/kamenPB/Green-Credentials/blob/master/Portfolio%20A/PNG/use-case_diagram.jpg)

The system receives various consumption data from the inputs the staff, primarily Beth, make to the spreadsheet. This data includes the water consumed, waste recycled, electricity used, and gas used. Once the spreadsheet is finalised by Beth, it can uploaded to the system. The system then interprets and processes this data, taking the values of the cells in the spreadsheet and visualising them using charts and pictorial representations.

**Use-case goals:**
=================================================================================
* Adding last month's consumption data to the spreadsheet

**Flow**

1. A member of Cabot Circus's staff receives consumption data from the previous month for waste, water, electricity and gas data from their respective usage meters, generators and other sources.
1. These values are added to the spreadsheet, alongside historical data for the past two years.
1. As the data reflects positively on the environmental credentials of Cabot Circus, no justifying comments are added.
1. The spreadsheet is uploaded for the system to process and interpret.
1. The system uses data from the most recent month for which data is present to construct visual aids such as charts and pictorial breakdowns of the data.
1. This visual poster is displayed on a TV display at Cabot Circus, and is refreshed if necessary.

**Alternative flow**

1. A member of Cabot Circus's staff receives consumption data from the previous month for waste, water, electricity and gas data from their respective usage meters, generators and other sources, but the data shows an increase in the shopping centre's water usage when compared with the same month one year ago.
1. These values are added to the spreadsheet, alongside historical data for the past two years.
1. Any explanatory comments felt necessary by Beth are added for each slide, to justify to Cabot Circus's customers why their water usage is higher this year.
1. The spreadsheet is uploaded for the system to process and interpret.
1. The system uses data from the most recent month for which data is present to construct visual aids such as charts and pictorial breakdowns of the data.
1. This visual poster is displayed on a TV display at Cabot Circus, and is refreshed if necessary.

**Exceptional flow**

1. A member of staff accidentally forgets to upload the consumption data for the previous month's electricity consumption.
1. The other values are still present in the spreadsheet, which is uploaded for the system to process and interpret.
1. As there is not enough data present for the previous month, the system instead uses data from the month before.
1. The system uses this data to construct visual aids such as charts and pictorial breakdowns of the data.
1. This visual poster is displayed on a TV display at Cabot Circus, and is refreshed if necessary.

* Transitioning to a new year's worth of consumption data

**Flow**

1. As it is a new year, the historical data is updated, and the data from what is now three years ago is deleted, with each of the other years' data moved along one column to the left.
1. The column titles are updated to correctly refer to the year its data is from.
1. A member of Cabot Circus's staff receives consumption data from the previous month for waste, water, electricity and gas data from their respective usage meters, generators and other sources.
1. These values are added to the spreadsheet in the new, empty column for the current year, alongside the newly shifted historical data from the past two years.
1. Any comments are added, as per the usual flows of adding last month's consumption data to a spreadsheet
1. The spreadsheet is uploaded for the system to process and interpret.
1. The system uses data from the most recent month for which data is present to construct visual aids such as charts and pictorial breakdowns of the data.
1. This visual poster is displayed on a TV display at Cabot Circus, and is refreshed if necessary.

**Alternative flow**

1. It is a new year, but no data has been collected yet for any months yet. The historical data is therefore left intact, and the system will continue to refer to the data for the previous year.
1. Any comments are added, as per the usual flows of adding last month's consumption data to a spreadsheet
1. The spreadsheet is uploaded for the system to process and interpret.
1. The system uses data from the most recent month for which data is present to construct visual aids such as charts and pictorial breakdowns of the data.
1. This visual poster is displayed on a TV display at Cabot Circus, and is refreshed if necessary.

**Exceptional flow**

1. As it is a new year, the historical data should be updated, but the staff member responsible forgets.
1. The column titles are not updated to correctly refer to the year its data is from.
1. A member of Cabot Circus's staff receives consumption data from the previous month for waste, water, electricity and gas data from their respective usage meters, generators and other sources.
1. These values are added to the spreadsheet.
1. The spreadsheet is uploaded for the system to process and interpret.
1. The system uses data from the most recent month for which data is present to construct visual aids such as charts and pictorial breakdowns of the data.
1. This visual poster is displayed on a TV display at Cabot Circus, but uses the incorrect year.
1. This is noticed by a member of staff or someone in the public, and the relevant staff member is notified.
1. The spreadsheet is updated to be correct, and re-uploaded.
1. This visual poster is updated and refreshed on the TV display at Cabot Circus, and is now correct.

* Fixing a typing error in a slide's comment section

**Flow**

1. The typing error is noticed by a member of public or staff, and the relevant staff member is made aware.
1. The typing error is fixed in the spreadsheet.
1. The spreadsheet is re-uploaded to the system.
1. This visual poster is updated and refreshed on the TV display at Cabot Circus, and is now correct.

**Alternative flow**

1. The relevant staff member is not made aware of a typing error.
1. When the next month of consumption data is added to the spreadsheet, the typing error is noticed and fixed in the spreadsheet.
1. The spreadsheet is uploaded to the system.
1. This visual poster is updated and refreshed on the TV display at Cabot Circus, and is now correct.

**Exceptional flow**

1. The typing error is never noticed.
1. As specified by the user manual, the comments section must be verified before uploading the spreadsheet.
1. When the next month of consumption data is added to the spreadsheet, the comment is changed.
1. The spreadsheet is uploaded to the system.
1. This visual poster is updated and refreshed on the TV display at Cabot Circus, and is now correct.

* Visualising statistics pictorially

**Flow**

1. The system receives consumption data from the spreadsheet.
1. The relevant data, such as waste recycled in tons, is calculated by the system.
1. Some sort of analogy for the data is calculated by the system, such as how many elephants it would take to reach the tonnage of waste recycled.
1. Images of this number of elephants is present beside the chart, as a pictorial aid which helps visualise the statistic being conveyed.

**Alternative flow**

1. The system receives consumption data from the spreadsheet.
1. The relevant data, such as waste recycled in tons, is calculated by the system.
1. Some sort of analogy for the data is calculated by the system, such as how many elephants it would take to reach the tonnage of waste recycled.
1. The number of elephants is only 1, which is not an impressive statistic.
1. The display does not try and visualise what this tonnage is comparable to, and no pictorial aid is present beside the chart.

**Exceptional flow**

1. The system receives consumption data from the spreadsheet.
1. The relevant data, such as waste recycled in tons, is calculated by the system.
1. For this month, there has been less waste recycled than has not been recycled.
1. The system does not attempt to calculate any analogy for this data.
1. A comment should be added by the Cabot Circus staff to explain why they failed to recycle more for this month.
1. The display does not try and visualise this stat, but the explanatory comment is present beside the chart.

In terms of importance, displaying the green credentials of Cabot Circus accurately, in a pictorial and easily understandable fashion on a smart TV is the main priority. The ability to add comments is an important, secondary goal. Website and app integration are tertiary goals, as is integration with other Hammerson shopping centres. This main goal can be divided into the following atomic requirements:
1. The TV screen displays all the required data
1. There is some sort of chart which visualises this data
1. If needed, there is some sort of additional pictorial visual aid presented which helps explain the stats for a given data category (the number of elephants it would take to make the tonnage of waste recycled, the number of homes which could be powered by the electricity saved this month, the number of bath tubs you could fill with the water saved this month, etc.)
1. There is an accessible and simple interface for any Cabot Circus staff to update the consumption data
1. The Cabot Circus staff are able to add comments which explain or advertise information relevant to a given data category
1. Animations and colours consistent with the Cabot Circus brand are used
