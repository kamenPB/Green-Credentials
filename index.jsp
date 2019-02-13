<%--
  Created by IntelliJ IDEA.
  User: janhe
  Date: 01/02/2019
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <style>
    p {
      color:green;
    }
    * {
      box-sizing: border-box;
    }
    /* Create two equal columns that floats next to each other */
    .column {
      float: left;
      width: 50%;
      padding: 10px;
      height: 50%; /* Should be removed. Only for demonstration */
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

    .scene-container {
      background-color: transparent;
      max-height: 100vh;
      max-width: 90vw;
      display: grid;
      grid-template-columns: repeat(11, [col] 50px);
      grid-template-rows: repeat(11, [row] 50px);
      overflow: hidden;
    }

    .scene-container > *:not(.drip) {
      background-color: #e1e1e1;
    }

    .leftmost-centre-col-thin, .tap-base-connection {
      grid-column:4/5;
    }

    .leftmost-centre-col-wide, .tap-base-bottom {
      grid-column:3/6;
    }

    .scene-container {
    .tap-base-bottom, .tap-base-connection {
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
      grid-row-start:10;
      align-self: center;
      justify-self: center;
      background-color: #00aeef;
      border-radius: 50%;
      height: 75px;
      width: 75px;
      margin-right:2px;
      position: relative;
    }

    .scene-container .tap-base-connection:after {
      content: '';
      display: block;
      height: 20px;
      width: 20px;
      border-radius: 50%;
      margin-top:10px;
      margin-left: 40px;
    }

    .neck-up {
      grid-row: 4/11;
      border-top-left-radius: 30px;
    }

    .neck-across, .neck-down {
      grid-row: 4/5;
    }

    .neck-across {
      grid-column: 5/8;
    }

    .neck-down {
      height: 60px;
      grid-column-start: 8;
      border-top-right-radius: 30px;
      z-index:1;
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
      transform: rotate3d(0,0,1,31deg) skewY(25deg);
      animation: drop infinite 1.5s;
    }

    .scene-container .tap-base-connection:after, .drip {
      background-color: #00aeef;
    }

    @keyframes drop {
      0% {
        transform: rotate3d(0,0,1,31deg) skewY(25deg) translate3d(0,0vh,0);
      }

      100% {
        transform: rotate3d(0,0,1,31deg) skewY(25deg) translate3d(33vh,40vh,0);
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
        margin-left:100%;
        width:300%
      }
      to {
        margin-left:0%;
        width:100%;
      }
    }
    @-webkit-keyframes slidein-left {
      from {
        margin-left:100%;
        width:300%
      }
      to {
        margin-left:0%;
        width:100%;
      }
    }

  </style>
  <body>
  <div class="row">
    <div class="column" style="background-color: chocolate">
      <h2>Waste</h2>
      <div id="piechart"></div>

      <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

      <script type="text/javascript">
        // Load google charts
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        // Draw the chart and set the chart values
        function drawChart() {

          <%
          int m = 89 + 1;
          %>

          var data = google.visualization.arrayToDataTable([
            ['Task', 'Hours per Day'],
            ['Recycled', <%=m%>],
            ['Sent to landfill', 10]
          ]);


          // Optional; add a title and set the width and height of the chart
          var options = {'title':'Where did January\'s Waste go?', 'width':550, 'height':400, 'backgroundColor': 'transparent'};

          // Display the chart inside the <div> element with id="piechart"
          var chart = new google.visualization.PieChart(document.getElementById('piechart'));
          chart.draw(data, options);
        }
      </script>
    </div>
    <div class="column" style="background-color:lightblue" >
      <h2>Water</h2>
      <div class="scene-container">
        <div class="tap-base-bottom"></div>
        <div class="tap-base-middle leftmost-centre-col-thin"></div>
        <div class="tap-base-connection"></div>
        <div class="neck-up leftmost-centre-col-thin"></div>
        <div class="neck-across"></div>
        <div class="neck-down"></div>
        <div class="drip"></div>
      </div>
      </div>

      <p>Some text..</p>
    </div>
    <div class="column" style="background-color:yellow">
      <h2>Electricity</h2>
      <p>Some text..</p>
    </div>
    <div class="column" style="background-color:grey;">
      <h2>Energy</h2>
      <p>Some text..</p>
    </div>
  </div>
  </body>
</html>
