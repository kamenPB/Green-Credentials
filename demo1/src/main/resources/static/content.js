//
// GLOBAL VARIABLES
//
var charts = []; // Store all charts in a global array to avoid memory leak
var chartViews = []; // Store all chart views in a global array to avoid memory leak
var slideIndex = 0; // Keep track of the current slide being displayed

//
// DATA CATEGORY FUNCTIONS
//
// TODO: Make these actually read the correct data from the spreadsheet via Java / Thymeleaf

// The Thymeleaf will populate hidden variable <span>s with the values we need
function parseHTML(elementId) {
    return parseFloat(document.getElementById(elementId.toLowerCase()).innerText);
}

// Waste functions
function getWasteTotal(month, year) {
    return parseHTML("waste_total" + "_" + month + "_" + year);
}

function getWasteRecycled(month, year) {
    return parseHTML("waste_recycled" + "_" + month + "_" + year);
}

function getWasteIncinerated(month, year) {
    return getWasteTotal(month, year) - getWasteRecycled(month, year);
}

// Water functions
function getWaterConsumed(month, year) {
    return parseHTML("water_consumed" + "_" + month + "_" + year);
}

// Electricity functions
function getElectricityConsumed(month, year) {
    return parseHTML("electricity_consumed" + "_" + month + "_" + year);
}

// Gas functions
function getGasConsumed(month, year) {
    return parseHTML('gas_consumed' + '_' + month + '_' + year);
}

//
// SLIDESHOW FUNCTIONS
//

// Function which controls the slideshow
function slideshow() {
    // Find all slides
    var slides = document.getElementsByClassName("slides");

    // Hide them
    for (var currentSlide = 0; currentSlide < slides.length; currentSlide++) {
        slides[currentSlide].style.display = "none";
    }

    // Increment the slide index
    slideIndex++;

    // Loop back around after the final slide
    if (slideIndex > slides.length) {
        slideIndex = 1
    }

    // Data category identifier, used to unify slides, charts and their data category:
    // 0 = Waste
    // 1 = Water
    // 2 = Electricity
    // 3 = Gas
    var id = slideIndex - 1;

    // Set the delay between slide changes, in seconds
    var delay = 4;

    if (slideShouldDisplay(id)) {
        slides[id].style.display = "block";
        drawChart(id);
        updateAnnotation(id);
    } else {
        // Skip this slide if it is not suitable to display
        delay = 0;
    }

    // Callback after delay has elapsed
    setTimeout(slideshow, delay * 1000);
}

// Evaluate whether the slide is suitable to display
function slideShouldDisplay(id) {
    // Get the relevant date information
    var currentMonth = getCurrentMonth();
    var currentYear = getCurrentYear();
    var lastYear = getLastYear();

    // Decide based on the data category ID
    switch (id) {
        case 0: { // Waste
            // Only display if we recycled more than we incinerated
            if (getWasteRecycled(currentMonth, currentYear) > getWasteIncinerated(currentMonth, currentYear)) {
                return true;
            }
            break;
        }
        case 1: { // Water
            // Only display if we consumed less than last year in the same month
            if ((getWaterConsumed(currentMonth, lastYear) - getWaterConsumed(currentMonth, currentYear)) > 0) {
                return true;
            }
            break;
        }
        case 2: { // Electricity
            // Only display if we consumed less than last year in the same month
            if ((getElectricityConsumed(currentMonth, lastYear) - getElectricityConsumed(currentMonth, currentYear)) > 0) {
                return true;
            }
            break;
        }
        case 3: { // Gas
            // Only display if we consumed less than last year in the same month
            if ((getGasConsumed(currentMonth, lastYear) - getGasConsumed(currentMonth, currentYear)) > 0) {
                return true;
            }
            break;
        }
    }

    return false;
}

//
// DATE FUNCTIONS
//
// TODO: Replace hardcoded months/years with actual current months/years

// Return the string value of the current month
function getCurrentMonth() {
    return "jan";
}

// Return the string value of the current year
function getCurrentYear() {
    return "2018";
}

// Return the string value of the year 1 year before the current year
function getLastYear() {
    return (parseInt(getCurrentYear()) - 1).toFixed(0);
}

// Return the string value of the year 2 years before the current year
function getTwoYearsAgo() {
    return (parseInt(getLastYear()) - 1).toFixed(0);
}

//
// CHART FUNCTIONS
//

// Pair charts with their HTML <div>
function createChart(id) {
    switch (id) {
        case 0: { // Waste
            charts[id] = new google.visualization.PieChart(document.getElementById('waste'));
            break;
        }
        case 1: { // Water
            charts[id] = new google.visualization.ColumnChart(document.getElementById('water'));
            break;
        }
        case 2: { // Electricity
            charts[id] = new google.visualization.ColumnChart(document.getElementById('electricity'));
            break;
        }
        case 3: { // Gas
            charts[id] = new google.visualization.ColumnChart(document.getElementById('gas'));
            break;
        }
    }
}

// Populate the chart's data for the given data category ID
function getChartData(id) {
    var data;
    var format;

    // Get date values
    var currentMonth = getCurrentMonth();
    var currentYear = getCurrentYear();
    var lastYear = getLastYear();
    var twoYearsAgo = getTwoYearsAgo();

    switch (id) {
        case 0: // Waste
            data = google.visualization.arrayToDataTable([
                ['Use of waste', 'Tons'],
                ['Recycled', getWasteRecycled(currentMonth, currentYear)],
                ['Incinerated', getWasteIncinerated(currentMonth, currentYear)]
            ]);
            format = new google.visualization.NumberFormat({
                pattern: '#.# tons'
            });
            format.format(data, 1);
            return data;
        case 1: { // Water
            data = google.visualization.arrayToDataTable([
                ['Year', 'Cubic metres', { role: 'style' }],
                ['2016', getWaterConsumed(currentMonth, twoYearsAgo), 'opacity: 0.2'],
                ['2017', getWaterConsumed(currentMonth, lastYear), 'opacity: 0.5'],
                ['2018', getWaterConsumed(currentMonth, currentYear), 'opacity: 0.9']
            ]);
            format = new google.visualization.NumberFormat({
                pattern: '#,### m³'
            });
            format.format(data, 1);
            break;
        }
        case 2: // Electricity
            data = google.visualization.arrayToDataTable([
                ['Year', 'Kilowatt hours', { role: 'style' }],
                ['2016', getElectricityConsumed(currentMonth, twoYearsAgo), 'opacity: 0.2'],
                ['2017', getElectricityConsumed(currentMonth, lastYear), 'opacity: 0.5'],
                ['2018', getElectricityConsumed(currentMonth, currentYear), 'opacity: 0.9']
            ]);
            format = new google.visualization.NumberFormat({
                pattern: '#,### kWh'
            });
            format.format(data, 1);
            break;
        case 3: // Gas
            data = google.visualization.arrayToDataTable([
                ['Year', 'Kilowatt hours', { role: 'style' }],
                ['2016', getGasConsumed(currentMonth, twoYearsAgo), 'opacity: 0.2'],
                ['2017', getGasConsumed(currentMonth, lastYear), 'opacity: 0.5'],
                ['2018', getGasConsumed(currentMonth, currentYear), 'opacity: 0.9']
            ]);
            format = new google.visualization.NumberFormat({
                pattern: '#,### kWh'
            });
            format.format(data, 1);
            break;
    }

    chartViews[id] = new google.visualization.DataView(data);
    chartViews[id].setColumns([0, 1, { calc: "stringify",
        sourceColumn: 1,
        type: "string",
        role: "annotation" },
        2]);
    return chartViews[id];
}

// Populate the chart's options for the given data category ID
function getChartOptions(id) {
    // Share common chart options
    var chartOptions = {
        width: 1050, // px
        height: 720, // px
        animation: {
            duration: 1000, // ms
            easing: 'out',
            startup: true
        },
        annotations: {
            alwaysOutside: true,
            textStyle: {
                fontSize: 18,
                bold: true,
                color: 'black'
            }
        },
        backgroundColor: { fill:'transparent' },
        tooltip: { trigger: 'none' },
        titleTextStyle: {
            fontSize: 24, // px
            bold: true,
        }
    };

    // Charts show comparisons of consumption between different years for the same month
    var currentMonth = getCurrentMonth();

    switch (id) {
        case 0: { // Waste
            chartOptions.title = "How we dealt with our waste in " + currentMonth + ":";
            chartOptions.colors = ['green', 'red'];
            chartOptions.legend = 'labeled';
            chartOptions.pieSliceText = 'value';
            chartOptions.pieSliceTextStyle = {
                fontSize: 18,
                bold: true,
                color: 'white'
            };
            break;
        }
        case 1: { // Water
            chartOptions.title = "Our water consumption in " + currentMonth + ", compared to previous years:";
            chartOptions.colors = ['blue'];
            chartOptions.legend = { position: "none" };
            chartOptions.vAxis = {
                minValue: 5000,
                maxValue: 10000,
                format: "#,### m³"
            };
            break;
        }
        case 2: { // Electricity
            chartOptions.title = "Our electricity consumption in " + currentMonth + ", compared to previous years:";
            chartOptions.colors = ['orange'];
            chartOptions.legend = { position: "none" };
            chartOptions.vAxis = {
                minValue: 300000,
                maxValue: 450000,
                format: "#,### kWh"
            };
            break;
        }
        case 3: { // Gas
            chartOptions.title = "Our gas consumption in " + currentMonth + ", compared to previous years:";
            chartOptions.colors = ['green'];
            chartOptions.legend = { position: "none" };
            chartOptions.vAxis = {
                minValue: 20000,
                maxValue: 45000,
                format: "#,### kWh"
            };
            break;
        }
    }
    return chartOptions;
}

// Verify the chart for the given data category ID has been created already
function chartExists(id) {
    return (!(charts[id] === undefined || charts[id] === null));
}

// Chart drawing callback function
function drawChart(id) {
    if (chartExists(id)) {
        charts[id].clearChart(); // Clear to avoid memory leak
    }

    // Create correct type of chart in given ID's div
    createChart(id);

    charts[id].draw(getChartData(id), getChartOptions(id));
}

//
// ANNOTATION FUNCTIONS
//
// TODO: Replace hardcoded months/years with the current month, and years relative to the current year

// Create an annotation for the waste category's chart
// Display the waste recycled in terms of elephants
function createWasteAnnotation(){
    var html = "";

    var currentMonth = getCurrentMonth();
    var currentYear = getCurrentYear();

    var recycledTons = getWasteRecycled(currentMonth, currentYear);

    var elephants = (recycledTons / 7).toFixed(0);

    html += "In " + currentMonth + " " + currentYear + ", we recycled ";
    html += recycledTons.toFixed(0);
    html += " tons of waste!";
    html += "<br/><br/>";

    // Only brag if it's an impressive number
    if (elephants >= 2) {
        html += "That's roughly the weight of <b>";
        html += elephants;
        html += " elephants</b>!";
        html += "<br/>";
        for (var i = 0; i < elephants; i++) {
            if (i === 24) i = parseInt(elephants); // Limit the amount added
            html += "<img src='icons/elephant.svg' class='icons' alt='icon' /> ";
        }
    }

    return html;
}

// Create an annotation for the water category's chart
// Display the water saved in terms of Olympic swimming pools
// If there isn't enough, then display in terms of normal swimming pools
// If there isn't enough, then display in terms of bath tubs
function createWaterAnnotation(){
    var html = "";

    var currentMonth = getCurrentMonth();
    var currentYear = getCurrentYear();
    var lastYear = getLastYear();

    var waterSaved = getWaterConsumed(currentMonth, lastYear) - getWaterConsumed(currentMonth, currentYear);

    var olympicSwimmingPools = (waterSaved / 2500).toFixed(0);
    var swimmingPools = (waterSaved / 900).toFixed(0);
    var baths = (waterSaved / 0.08).toFixed(0);

    // Prefer the most impressive stat
    var comparisonPoint = baths;
    if (swimmingPools >= 2) {
        comparisonPoint = swimmingPools;
        if (olympicSwimmingPools >= 2) {
            comparisonPoint = olympicSwimmingPools;
        }
    }

    html += "In " + currentMonth + " " + currentYear + ", we consumed ";
    html += addCommas(waterSaved.toFixed(0));
    html += " m³ less water than last year.";
    html += "<br/><br/>";

    var src = '';
    // Only brag if it's an impressive number
    if (comparisonPoint >= 2) {
        html += "That's enough to fill roughly <b>";
        html += comparisonPoint;
        if (olympicSwimmingPools >= 2) html += " Olympic-sized";
        if (swimmingPools >= 2) {
            html += " swimming pools";
            src = 'icons/pool.svg';
        } else {
            html += " bath tubs";
            src = 'icons/bathtub.svg';
        }
        html += "</b>!<br/>";
        for (var i = 0; i < comparisonPoint; i++) {
            if (i === 24) i = comparisonPoint; // Limit the amount added
            html += "<img src='" + src + "' class='icons' alt='icon' /> ";
        }
    }

    return html;
}

// Create an annotation for the electricity category's chart
// Display the electricity saved in terms of homes it could power
function createElectricityAnnotation(){
    var html = "";

    var currentMonth = getCurrentMonth();
    var currentYear = getCurrentYear();
    var lastYear = getLastYear();

    var electricitySaved = getElectricityConsumed(currentMonth, lastYear) - getElectricityConsumed(currentMonth, currentYear);

    var homes = (electricitySaved / 4150).toFixed(0);

    html += "In " + currentMonth + " " + currentYear + ", we consumed ";
    html += addCommas(electricitySaved.toFixed(0));
    html += " kWhs less electricity than last year.";
    html += "<br/><br/>";

    // Only brag if it's an impressive number
    if (homes >= 2) {
        html += "That's enough to power <b>";
        html += homes;
        html += " homes</b>!";
        html += "<br/>";
        for (var i = 0; i < homes; i++) {
            if (i === 24) i = comparisonPoint; // Limit the amount added
            html += "<img src='icons/home.svg' class='icons' /> ";
        }
    }

    return html;
}

// Create an annotation for the gas category's chart
function createGasAnnotation(){
    var html = "";

    var currentMonth = getCurrentMonth();
    var currentYear = getCurrentYear();
    var lastYear = getLastYear();

    var gasSaved = getGasConsumed(currentMonth, lastYear) - getGasConsumed(currentMonth, currentYear);

    var homes = (gasSaved / 12500).toFixed(0);

    html += "In " + currentMonth + " " + currentYear + ", we consumed ";
    html += addCommas(gasSaved.toFixed(0));
    html += " kWhs less gas than last year.";
    html += "<br/><br/>";

    // Only brag if it's an impressive number
    if (homes >= 2) {
        html += "That's enough to power <b>";
        html += homes;
        html += " homes</b>!";
        html += "<br/>";
        for (var i = 0; i < homes; i++) {
            if (i === 24) i = comparisonPoint; // Limit the amount added
            html += "<img src='icons/home.svg' class='icons' /> ";
        }
    }

    return html;
}

// Update the annotation to match the chart changes
function updateAnnotation(id) {
    var annotationHTML = "";
    switch (id) {
        default:
        case 0: // Waste
            annotationHTML = createWasteAnnotation();
            break;
        case 1: // Water
            annotationHTML = createWaterAnnotation();
            break;
        case 2: // Electricity
            annotationHTML = createElectricityAnnotation();
            break;
        case 3: // Gas
            annotationHTML = createGasAnnotation();
            break;
    }
    document.getElementById('annotation').innerHTML = annotationHTML;
}

//
// MISC FUNCTIONS
//

// Add commas to a number string
function addCommas(string) {
    // Function taken from Stack Overflow answer:
    // https://stackoverflow.com/questions/2901102/how-to-print-a-number-with-commas-as-thousands-separators-in-javascript
    // Written by Elias Zamaria
    // Accessed 2019-02-15

    var parts = string.toString().split(".");
    parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return parts.join(".");
}

//
// MAIN
//
google.charts.load('current', { 'packages': ['corechart'] });
google.charts.setOnLoadCallback(slideshow);
