# Operations Manual

1. Data.xlsx structure explained

    1. In the file there are 6 spreadsheets - Waste, Water, Landlord Water, Electricity, Carpark Electricity and Gas, respectively. 

    1. Data from Landlord water and Carpark electricity do not have particular slide in the presentation; could be used for further comments and/or statistics.

    1. Each spreadsheet has specific structure(set of rows and columns) that should be strictly kept as created. Changes of structure WILL affect presentation (possibly crash). Changes in titles are allowed, though.

    1. Editable are: Monthly data (January to December in specific years), the title and the comments section (strictly CELLS N1 and N2!). Comments are being directly displayed, and data as well after required calculations.

    1. Ideas of comments could be included below the comments section. However, they are not affecting overall presentation. 

    1. No formatting in the cells affects the presentation, so it is not suggested. All formatting is done internally in the code.

    1. Filename should not be changed. Format should be kept .xlsx, that is, save the file using Excel version 2007 or later. 

1. Changes of year

    1. Notice the presentation is only comparing the 3 most recent years, that is, we only need/use data of 3 years (3 specific columns) in the spreadsheets. Hence, to add a new year, we need to remove one too.

    1. Remove the oldest data, assuming that is the year furthest from the actual, should be the first column after the months. To remove it, right click on the column letter and delete the whole column. Make sure you shift the rest of the data to the left, if not done automatically. 

    1. To start a new year then, you need to add a new column on a specific position, so that the initial structure is kept unchanged and calculations are done correctly. Simply, find the latest filled year, right click the column letter and insert 1 column to the right. Fill the title and the data. Re-calculations and presentation are then done automatic after a refresh.

1. Errors

    1. Type error in the spreadsheets (i.e Cannot get a numeric value from a text cell). A page that hihgly likely says "WHITELABEL ERROR PAGE" will be displayed and that means you have a mismatch. You then will have to review the data.xmls file and the mistake should be more or less visible to fix (look for letters in strictly numeric cells).
    
    1. Date error. These are likely to involve a wrong date on the local machine (mosly year as the screen displays the last month that has data on it). Check that. If that is not the issue, check if all the data for the particular month you want to display is filled in the correct cells. 
