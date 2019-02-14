// Global variables
var charts = []; // Store all charts in a global array to avoid memory leak
var slideIndex = 0;

// Data category functions
// TODO: Make these actually handle months and years properly
// TODO; Make these actually read the correct data from the spreadsheet via Java / Thymeleaf

// Waste functions
function getWasteTotal(month, year) {
    // Fake it til you make it, this only works for January 2018
    // Just get the respective month and year from the Java
    return 165.41;
}

function getWasteRecycled(month, year) {
    // Fake it til you make it, this only works for January 2018
    // Just get the respective month and year from the Java
    return 149.13;
}

function getWasteIncinerated(month, year) {
    return getWasteTotal(month, year) - getWasteRecycled(month, year);
}

// Water functions
function getWaterConsumed(month, year) {
    // Fake it til you make it, this only works for January
    // In reality, we won't need switch statements... just get the respective month and year from the Java
    switch (year) {
        case '2018':
            return 8273;
        case '2017':
            return 6150;
        case '2016':
            return 5476;
    }
}

// Electricity functions
function getElectricityConsumed(month, year) {
    // Fake it til you make it, this only works for January
    // In reality, we won't need switch statements... just get the respective month and year from the Java
    switch (year) {
        case '2018':
            return 358709;
        case '2017':
            return 381400;
        case '2016':
            return 394931;
    }
}

// Gas functions
function getGasConsumed(month, year) {
    // Fake it til you make it, this only works for January
    // In reality, we won't need switch statements... just get the respective month and year from the Java
    switch (year) {
        case '2018':
            return 41888;
        case '2017':
            return 40365;
        case '2016':
            return 24130;
    }
}
// Chart functions
google.charts.load('current', {
    'packages': ['corechart']
});
google.charts.setOnLoadCallback(carousel);

// Slideshow callback
function carousel() {
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
    var id = slideIndex - 1;

    // Display the new slide
    slides[id].style.display = "block";
    drawChart(id);
    updateAnnotations(id);

    // After the slide's delay has elapsed, recur
    var delay = 3; // Delay between slide changes in seconds
    setTimeout(carousel, delay * 1000);
}

// Define the chart parameters for each data category
// TODO: Replace hardcoded months/years with the current month, and years relative to the current year
var chartViews = [];
function getChartData(id) {
    var data;
    var format;
    switch (id) {
        case 0: // Waste
            data = google.visualization.arrayToDataTable([
                ['Use of waste', 'Tons'],
                ['Recycled', getWasteRecycled('January', '2018')],
                ['Incinerated', getWasteIncinerated('January', '2018')]
            ]);
            format = new google.visualization.NumberFormat({
                pattern: '#.# tons'
            });
            format.format(data, 1);
            return data;
        case 1: { // Water
            data = google.visualization.arrayToDataTable([
                ['Year', 'Cubic metres', { role: 'style' }],
                ['2016', getWaterConsumed('January', '2016'), 'opacity: 0.2'],
                ['2017', getWaterConsumed('January', '2017'), 'opacity: 0.5'],
                ['2018', getWaterConsumed('January', '2018'), 'opacity: 1']
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
                ['2016', getElectricityConsumed('January', '2016'), 'opacity: 0.2'],
                ['2017', getElectricityConsumed('January', '2017'), 'opacity: 0.5'],
                ['2018', getElectricityConsumed('January', '2018'), 'opacity: 1']
            ]);
            format = new google.visualization.NumberFormat({
                pattern: '#,### KwH'
            });
            format.format(data, 1);
            break;
        case 3: // Gas
            data = google.visualization.arrayToDataTable([
                ['Year', 'Kilowatt hours', { role: 'style' }],
                ['2016', getGasConsumed('January', '2016'), 'opacity: 0.2'],
                ['2017', getGasConsumed('January', '2017'), 'opacity: 0.5'],
                ['2018', getGasConsumed('January', '2018'), 'opacity: 1']
            ]);
            format = new google.visualization.NumberFormat({
                pattern: '#,### KwH'
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

// Draw the chart and set the chart values
function drawChart(id) {
    // If the chart exists already from a previous loop, clear it to avoid memory leak
    if (!(charts[id] === undefined || charts[id] === null)) {
        charts[id].clearChart();
    }

    // Share common chart options
    let chartOptions = {
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
        backgroundColor: { fill:'transparent' }
    };

    // Set up specifics for current slide
    switch (id) {
        case 0: { // Waste
            charts[id] = new google.visualization.PieChart(document.getElementById('waste'));
            chartOptions.title = "Where did January's waste go?";
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
            charts[id] = new google.visualization.ColumnChart(document.getElementById('water'));
            chartOptions.title = "How much water was used in January compared to previous years?";
            chartOptions.colors = ['blue'];
            chartOptions.legend = { position: "none" };
            chartOptions.vAxis = {
                minValue: 0,
                maxValue: 10000,
                format: "#,### m³"
            };
            break;
        }
        case 2: { // Electricity
            charts[id] = new google.visualization.ColumnChart(document.getElementById('electricity'));
            chartOptions.title = "How much electricity was used in January compared to previous years?";
            chartOptions.colors = ['orange'];
            chartOptions.legend = { position: "none" };
            chartOptions.vAxis = {
                minValue: 0,
                maxValue: 450000,
                format: "#,### KwH"
            };
            break;
        }
        case 3: { // Gas
            charts[id] = new google.visualization.ColumnChart(document.getElementById('gas'));
            chartOptions.title = "How much gas was used in January compared to previous years?";
            chartOptions.colors = ['green'];
            chartOptions.legend = { position: "none" };
            chartOptions.vAxis = {
                minValue: 0,
                maxValue: 45000,
                format: "#,### KwH"
            };
            break;
        }
    }

    // Draw the chart
    charts[id].draw(getChartData(id), chartOptions);
}

// Update the annotations to match the chart changes
// TODO: Actually implement this
function updateAnnotations(id) {
    var annotationString;
    switch (id) {
        case 0: // Waste
            annotationString = "This is an annotation for the waste category.";
            break;
        case 1: // Water
            annotationString = "This is an annotation for the water category.";
            break;
        case 2: // Electricity
            annotationString = "This is an annotation for the electricity category.";
            break;
        case 3: // Gas
            annotationString = "This is an annotation for the gas category.";
            break;
    }
    document.getElementById('annotations').innerText = annotationString;
}
