<%--
  Created by IntelliJ IDEA.
  User: janhe
  Date: 01/02/2019
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cabot Circus's Green Credentials</title>
    <style>
        #container {
            padding: 25px;
            background: url("https://i.imgur.com/aBfNcoO.png") no-repeat content-box;
        }
        .slides {
            max-width: 1280px;
            max-height: 720px;
            margin: auto;
        }
    </style>
</head>
<body>

<div id="container">
    <div class="slides" id="waste"></div>
    <div class="slides" id="water"></div>
    <div class="slides" id="electricity"></div>
    <div class="slides" id="gas"></div>
</div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">  // Load google charts </script>

<script type="text/javascript">
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

        // Display the new slide
        slides[slideIndex-1].style.display = "block";
        drawChart(slideIndex-1);

        // After the slide's delay has elapsed, recur
        var delay = 3; // Delay between slide changes in seconds
        setTimeout(carousel, delay * 1000);
    }

    // Define the chart parameters for each data category
    // TODO: Replace hardcoded months/years with the current month, and years relative to the current year
    var chartviews = [];
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
                    pattern: '#,### m3'
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

        chartviews[id] = new google.visualization.DataView(data);
        chartviews[id].setColumns([0, 1, { calc: "stringify",
                sourceColumn: 1,
                type: "string",
                role: "annotation" },
            2]);
        return chartviews[id];
    }

    // Draw the chart and set the chart values
    function drawChart(id) {
        // If the chart exists already from a previous loop, clear it to avoid memory leak
        if (!(charts[id] === undefined || charts[id] === null)) {
            charts[id].clearChart();
        }

        // Share common chart options
        let chartOptions = {
            width: 1280, // px
            height: 720, // px
            animation: {
                duration: 1000, // ms
                easing: 'out',
                startup: true
            },
            legend: { position: "none" },
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
                break;
            }
            case 1: { // Water
                charts[id] = new google.visualization.ColumnChart(document.getElementById('water'));
                chartOptions.title = "How much water was used in January compared to previous years?";
                chartOptions.colors = ['blue'];
                chartOptions.vAxis = {
                    minValue: 0,
                    maxValue: 10000,
                    format: "#,### m3"
                };
                break;
            }
            case 2: { // Electricity
                charts[id] = new google.visualization.ColumnChart(document.getElementById('electricity'));
                chartOptions.title = "How much electricity was used in January compared to previous years?";
                chartOptions.colors = ['orange'];
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
</script>
</body>
</html>
