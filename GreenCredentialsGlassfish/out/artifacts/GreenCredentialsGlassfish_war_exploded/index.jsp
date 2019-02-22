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
<<<<<<< HEAD
<head>
  <title>Cabot Circus's Green Credentials</title>
</head>
<style>
  * {
    box-sizing: border-box;
  }

  /* Create two equal columns that floats next to each other */
  .column {
    float: left;
    width: 50%;
    padding: 10px;
    height: 50%;
    /* Should be removed. Only for demonstration */
  }

  /* Clear floats after the columns */
  .row:after {
    content: "";
    display: table;
    clear: both;
  }

  /* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
  @media screen and (max-width: 600px) {
    .column {
      width: 100%;
    }
  }

  #water {
    z-index: 99;
    top: -800px;
    right: 800px;
  }

  .scene-container {
    background-color: transparent;
    max-height: 100vh;
    max-width: 90vw;
    display: grid;
    grid-template-columns: repeat(11, [col] 50px);
    grid-template-rows: repeat(11, [row] 50px);
    overflow: hidden;
  }

  .scene-container>*:not(.drip) {
    background-color: #e1e1e1;
  }

  .leftmost-centre-col-thin,
  .tap-base-connection {
    grid-column: 4/5;
  }

  .leftmost-centre-col-wide,
  .tap-base-bottom {
    grid-column: 3/6;
  }

  .scene-container {
  .tap-base-bottom,
  .tap-base-connection {
    background-color: #00aeef;
    z-index: 1;
  }
  }

  .tap-base-bottom {
    height: 25px;
    grid-row-end: 12;
    align-self: end;
    border-radius: 15px 15px 0 0;
  }

  .tap-base-middle {
    height: 50px;
    grid-row-end: 12;
    align-self: end;
  }

  .tap-base-connection {
    grid-row-start: 10;
    align-self: center;
    justify-self: center;
    background-color: #00aeef;
    border-radius: 50%;
    height: 75px;
    width: 75px;
    margin-right: 2px;
    position: relative;
  }

  .scene-container .tap-base-connection:after {
    content: '';
    display: block;
    height: 20px;
    width: 20px;
    border-radius: 50%;
    margin-top: 10px;
    margin-left: 40px;
  }

  .neck-up {
    grid-row: 4/11;
    border-top-left-radius: 30px;
  }

  .neck-across,
  .neck-down {
    grid-row: 4/5;
  }

  .neck-across {
    grid-column: 5/8;
  }

  .neck-down {
    height: 60px;
    grid-column-start: 8;
    border-top-right-radius: 30px;
    z-index: 1;
  }

  .drip {
    background-color: #00aeef;
    grid-row-start: 4;
    grid-column-start: 8;
    justify-self: center;
    align-self: end;
    z-index: 0;
    height: 25px;
    width: 22px;
    margin-top: 50px;
    border-radius: 0 50% 50% 50%;
    transform: rotate3d(0, 0, 1, 31deg) skewY(25deg);
    animation: drop infinite 1.5s;
  }

  .scene-container .tap-base-connection:after,
  .drip {
    background-color: #00aeef;
  }

  @keyframes drop {
    0% {
      transform: rotate3d(0, 0, 1, 31deg) skewY(25deg) translate3d(0, 0vh, 0);
    }
    100% {
      transform: rotate3d(0, 0, 1, 31deg) skewY(25deg) translate3d(33vh, 40vh, 0);
    }
  }

  h2 {
    -moz-animation-duration: 3s;
    -webkit-animation-duration: 3s;
    -moz-animation-name: slidein-left;
    -webkit-animation-name: slidein-left;
  }

  @-moz-keyframes slidein-left {
    from {
      margin-left: 100%;
      width: 300%
    }
    to {
      margin-left: 0%;
      width: 100%;
    }
  }

  @-webkit-keyframes slidein-left {
    from {
      margin-left: 100%;
      width: 300%
    }
    to {
      margin-left: 0%;
      width: 100%;
    }
  }
</style>

<body>
<div class="row">
  <div class="column">
    <h2>Waste</h2>
    <div id="waste"></div>
  </div>
  <div class="column">
    <h2>Water</h2>
    <!--<div class="scene-container">
      <div class="tap-base-bottom"></div>
      <div class="tap-base-middle leftmost-centre-col-thin"></div>
      <div class="tap-base-connection"></div>
      <div class="neck-up leftmost-centre-col-thin"></div>
      <div class="neck-across"></div>
      <div class="neck-down"></div>
      <div class="drip"></div>
    </div>-->
    <div id="water"></div>
  </div>
</div>

<div class="column">
  <h2>Electricity</h2>
  <div id="electricity"></div>
</div>

<div class="column">
  <h2>Energy</h2>
  <div id="gas"></div>
</div>

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
  google.charts.setOnLoadCallback(drawChart);

  // Define the chart parameters for each data category
  // TODO: Replace hardcoded months/years with the current month, and years relative to the current year
  function getChartData(category) {
    switch (category) {
      case 'waste':
        return google.visualization.arrayToDataTable([
          ['Use of waste', 'Tons'],
          ['Recycled', getWasteRecycled('January', '2018')],
          ['Incinerated', getWasteIncinerated('January', '2018')]
        ]);
      case 'water':
        return google.visualization.arrayToDataTable([
          ['Year', 'Cubic metres', {
            role: 'style'
          }],
          ['2016', getWaterConsumed('January', '2016'), 'opacity: 0.2'],
          ['2017', getWaterConsumed('January', '2017'), 'opacity: 0.5'],
          ['2018', getWaterConsumed('January', '2018'), 'opacity: 1']
        ]);
      case 'electricity':
        return google.visualization.arrayToDataTable([
          ['Year', 'Kilowatt hours', {
            role: 'style'
          }],
          ['2016', getElectricityConsumed('January', '2016'), 'opacity: 0.2'],
          ['2017', getElectricityConsumed('January', '2017'), 'opacity: 0.5'],
          ['2018', getElectricityConsumed('January', '2018'), 'opacity: 1']
        ]);
      case 'gas':
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

  // Draw the chart and set the chart values
  function drawChart() {
    var wasteChart = new google.visualization.PieChart(document.getElementById('waste'));
    wasteChart.draw(getChartData('waste'), {
      'title': 'Where did January\'s waste go?',
      colors: ['green', 'red'],
      'width': 400,
      'height': 400
    });

    var waterChart = new google.visualization.ColumnChart(document.getElementById('water'));
    waterChart.draw(getChartData('water'), {
      'title': ' How much water was used in January compared to previous years?',
      colors: ['blue'],
      'width': 400,
      'height': 400
    });

    var electricityChart = new google.visualization.ColumnChart(document.getElementById('electricity'));
    electricityChart.draw(getChartData('electricity'), {
      'title': 'How much electricity was used in January compared to previous years?',
      colors: ['orange'],
      'width': 400,
      'height': 400
    });

    var gasChart = new google.visualization.ColumnChart(document.getElementById('gas'));
    gasChart.draw(getChartData('gas'), {
      'title': 'How much gas was used in January compared to previous years?',
      colors: ['green'],
      'width': 400,
      'height': 400
    });
  }
</script>
</body>
=======
    <head>
        <title>Cabot Circus's Green Credentials</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript" src="content.js"></script>
    </head>
    <body>
        <div id="logo"><img src="logos/cabotcircus.png" alt="Cabot Circus logo" /></div>
        <div id="container">
            <div class="slides" id="waste"></div>
            <div class="slides" id="water"></div>
            <div class="slides" id="electricity"></div>
            <div class="slides" id="gas"></div>
        </div>
        <div id="annotation"></div>
    </body>
>>>>>>> 0b45e6c5d95fa32e113b7873fc689656d2a1f1c9
</html>
