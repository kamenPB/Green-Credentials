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
</head>
<body>

    <div class="slides" id="waste"></div>
    <div class="slides" id="water"></div>
    <div class="slides" id="electricity"></div>
    <div class="slides" id="gas"></div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">  // Load google charts </script>

<script type="text/javascript">
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

    var slideIndex = 0;
    google.charts.setOnLoadCallback(carousel);
    function carousel() {
        var i;
        var x = document.getElementsByClassName("slides");

        for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
        }
        slideIndex++;

        if (slideIndex > x.length) {
            slideIndex = 1
        }

        x[slideIndex-1].style.display = "block";
        drawChart(slideIndex-1);

        var delay = 3; // Delay between slide changes in seconds
        setTimeout(carousel, delay * 1000);
    }

    // Define the chart parameters for each data category
    // TODO: Replace hardcoded months/years with the current month, and years relative to the current year
    function getChartData(id) {
        switch (id) {
            case 0: // Waste
                return google.visualization.arrayToDataTable([
                    ['Use of waste', 'Tons'],
                    ['Recycled', getWasteRecycled('January', '2018')],
                    ['Incinerated', getWasteIncinerated('January', '2018')]
                ]);
            case 1: // Water
                return google.visualization.arrayToDataTable([
                    ['Year', 'Cubic metres', {
                        role: 'style'
                    }],
                    ['2016', getWaterConsumed('January', '2016'), 'opacity: 0.2'],
                    ['2017', getWaterConsumed('January', '2017'), 'opacity: 0.5'],
                    ['2018', getWaterConsumed('January', '2018'), 'opacity: 1']
                ]);
            case 2: // Electricity
                return google.visualization.arrayToDataTable([
                    ['Year', 'Kilowatt hours', {
                        role: 'style'
                    }],
                    ['2016', getElectricityConsumed('January', '2016'), 'opacity: 0.2'],
                    ['2017', getElectricityConsumed('January', '2017'), 'opacity: 0.5'],
                    ['2018', getElectricityConsumed('January', '2018'), 'opacity: 1']
                ]);
            case 3: // Gas
                return google.visualization.arrayToDataTable([
                    ['Year', 'Kilowatt hours', {
                        role: 'style'
                    }],
                    ['2016', getGasConsumed('January', '2016'), 'opacity: 0.2'],
                    ['2017', getGasConsumed('January', '2017'), 'opacity: 0.5'],
                    ['2018', getGasConsumed('January', '2018'), 'opacity: 1']
                ]);
        }
    }

    //Store all chart objects in a global array to avoid memory leak
    var charts = [];
    var chartOptions =  {
        vAxis: { minValue: 0 },
        width: 1280,
        height: 720,
        animation:{
            duration: 1000,
            easing: 'out',
            startup: true
        }
    };

    // Draw the chart and set the chart values
    function drawChart(id) {
        if (!(charts[id] === undefined || charts[id] === null)) {
            charts[id].clearChart();
        }

        switch (id) {
            case 0: {
                charts[id] = new google.visualization.PieChart(document.getElementById('waste'));
                chartOptions.title = "Where did January's waste go?";
                chartOptions.colors = ['green', 'red'];
                break;
            }
            case 1: {
                charts[id] = new google.visualization.ColumnChart(document.getElementById('water'));
                chartOptions.title = "How much water was used in January compared to previous years?";
                chartOptions.colors = ['blue'];
                break;
            }
            case 2: {
                charts[id] = new google.visualization.ColumnChart(document.getElementById('electricity'));
                chartOptions.title = "How much electricity was used in January compared to previous years?";
                chartOptions.colors = ['orange'];
                break;
            }
            case 3: {
                charts[id] = new google.visualization.ColumnChart(document.getElementById('gas'));
                chartOptions.title = "How much gas was used in January compared to previous years?";
                chartOptions.colors = ['green'];
                break;
            }
        }

        charts[id].draw(getChartData(id), chartOptions);
    }
</script>
</body>
</html>
