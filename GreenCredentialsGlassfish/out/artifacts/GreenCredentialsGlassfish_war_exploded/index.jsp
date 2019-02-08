<%--
  Created by IntelliJ IDEA.
  User: janhe
  Date: 01/02/2019
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
  <head>
    <title>$Title$</title>
  </head>
  <style>
    p {
      color:green;
    }
  </style>
  <body>
  <p>Credentials</p>
  <div id="piechart"></div>

  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

  <div> th:with="recycled=80" </div>

  <script type="text/javascript">
      // Load google charts
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      // Draw the chart and set the chart values
      function drawChart() {

          var data = google.visualization.arrayToDataTable([
              ['Task', 'Hours per Day'],
              ['Recycled', recycled],
              ['Sent to landfill', 10]
          ]);

          // Optional; add a title and set the width and height of the chart
          var options = {'title':'Where did January\'s Waste go?', 'width':550, 'height':400};

          // Display the chart inside the <div> element with id="piechart"
          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
          chart.draw(data, options);
      }
  </script>
  </body>