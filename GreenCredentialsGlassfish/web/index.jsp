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
    .mySlides {display: none;}

    /* Slideshow container */
    .slideshow-container {
      max-width: 1000px;
      position: relative;
      margin: auto;
    }

    .active {
      background-color: #717171;
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

  <div class="mySlides fade">
    <div id="waste"></div>
  </div>

  <div class="mySlides fade">
    <div id="electricity"></div>
  </div>

</div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
  // Start slideshow at index 0
  var slideIndex = 0;
  showSlides();

  // Load google charts
  google.charts.load('current', {'packages':['corechart']});
  google.charts.setOnLoadCallback(drawChart);

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

  // Draw the chart and set the chart values
  function drawChart() {
    var wasteData = google.visualization.arrayToDataTable([
      ['Task', 'Hours per Day', { role: 'style' }],
      ['Recycled', 149.13, 'color; green'],
      ['Sent to landfill', (165.41 - 149.13), 'color: red']
    ]);
    var wasteOptions = {
      'title':'Where did January\'s waste go?',
      'width':800,
      'height':800
    };
    var wasteChart = new google.visualization.PieChart(document.getElementById('waste'));
    wasteChart.draw(wasteData, wasteOptions);


    var electricityData = google.visualization.arrayToDataTable([
      ['Year', 'Kilowatt hours', { role: 'style' }],
      ['2016', 394931, 'color: orange; opacity: 0.2'],
      ['2017', 381400, 'color: orange; opacity: 0.5'],
      ['2018', 358709, 'color: orange']
    ]);
    var electricityOptions = {
      'title':'How much electricity was used in January compared to previous years?',
      'width':800,
      'height':800,
      hAxis: {
        title: 'KwH',
        format: 'decimal',
        viewWindow: {
          min: [7, 30, 0],
          max: [17, 30, 0]
        }
      },
      vAxis: {
        format: 'string'
      }
    };
    var electricityChart = new google.visualization.ColumnChart(document.getElementById('electricity'));
    electricityChart.draw(electricityData, electricityOptions);
  }
</script>

</body>
</html>
