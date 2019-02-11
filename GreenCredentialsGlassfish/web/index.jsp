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
    /* Hide slides until they are needed */
    .mySlides {
      display: none;
    }

    /* Centre the slideshow container */
    .slideshow-container {
      max-width: 1000px;
      position: relative;
      margin: auto;
    }

    /* Fading animation */
    .fade {
      -webkit-animation-name: fade;
      -webkit-animation-duration: 1.5s;
      animation-name: fade;
      animation-duration: 1.5s;
    }
    @-webkit-keyframes fade {
      from {opacity: .4}
      to {opacity: 1}
    }
    @keyframes fade {
      from {opacity: .4}
      to {opacity: 1}
    }
  </style>
</head>
<body>

<div class="slideshow-container">
  <div class="mySlides fade" id="waste"></div>
  <div class="mySlides fade" id="water"></div>
  <div class="mySlides fade" id="electricity"></div>
  <div class="mySlides fade" id="gas"></div>
</div>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"> // Load google charts </script>

<script type="text/javascript">
  // Slideshow functions
  var slideIndex = 0;
  showSlides();

  function showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}
    slides[slideIndex-1].style.display = "block";
    setTimeout(showSlides, 5000);
  }

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
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);

  // Define the chart parameters for each data category
  // TODO: Replace hardcoded months/years with the current month, and years relative to the current year
  function getChartData(category) {
    switch (category) {
      case 'waste':
        return google.visualization.arrayToDataTable([
          ['Use of waste', 'Tons', { role: 'style' }],
          ['Recycled', getWasteRecycled('January', '2018'), 'color; green'],
          ['Incinerated', getWasteIncinerated('January', '2018'), 'color: red']
        ]);
      case 'water':
        return google.visualization.arrayToDataTable([
          ['Year', 'Cubic metres', { role: 'style' }],
          ['2016', getWaterConsumed('January', '2016'), 'color: blue; opacity: 0.2'],
          ['2017', getWaterConsumed('January', '2017'), 'color: blue; opacity: 0.5'],
          ['2018', getWaterConsumed('January', '2018'), 'color: blue']
        ]);
      case 'electricity':
        return google.visualization.arrayToDataTable([
          ['Year', 'Kilowatt hours', { role: 'style' }],
          ['2016', getElectricityConsumed('January', '2016'), 'color: orange; opacity: 0.2'],
          ['2017', getElectricityConsumed('January', '2017'), 'color: orange; opacity: 0.5'],
          ['2018', getElectricityConsumed('January', '2018'), 'color: orange']
        ]);
      case 'gas':
        return google.visualization.arrayToDataTable([
          ['Year', 'Kilowatt hours', { role: 'style' }],
          ['2016', getGasConsumed('January', '2016'), 'color: green; opacity: 0.2'],
          ['2017', getGasConsumed('January', '2017'), 'color: green; opacity: 0.5'],
          ['2018', getGasConsumed('January', '2018'), 'color: green']
        ]);
    }
  }

  // Draw the chart and set the chart values
  function drawChart() {
    var wasteChart = new google.visualization.PieChart(document.getElementById('waste'));
    wasteChart.draw(getChartData('waste'), {
      'title': 'Where did January\'s waste go?',
      'width': 800,
      'height': 800,
      vAxis: { format: 'decimal' }
    });

    var waterChart = new google.visualization.ColumnChart(document.getElementById('water'));
    waterChart.draw(getChartData('water'), {
      'title':' How much water was used in January compared to previous years?',
      'width': 800,
      'height': 800,
      vAxis: { format: 'decimal' }
    });

    var electricityChart = new google.visualization.ColumnChart(document.getElementById('electricity'));
    electricityChart.draw(getChartData('electricity'), {
      'title': 'How much electricity was used in January compared to previous years?',
      'width': 800,
      'height': 800,
      vAxis: { format: 'decimal' }
    });

    var gasChart = new google.visualization.ColumnChart(document.getElementById('gas'));
    gasChart.draw(getChartData('gas'), {
      'title': 'How much gas was used in January compared to previous years?',
      'width': 800,
      'height': 800,
      vAxis: { format: 'decimal' }
    });
  }
</script>

</body>
</html>