<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="common/css/default.css">
<link rel="stylesheet" href="common/css/header.css">
<link rel="stylesheet" href="common/css/nav.css">
<link rel="stylesheet" href="common/css/section.css">
<link rel="stylesheet" href="common/css/footer.css">
<link rel="stylesheet" href="common/css/sidebar.css">
<link rel="stylesheet" href="guest/css/inquire.css">
<link rel="stylesheet" href="admin/common/css/styles.css">
<script src="https://kit.fontawesome.com/a9dbc227eb.js" crossorigin="anonymous"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script src="admin/common/js/scripts.js"></script>
<script>
	// google chart api 로딩
  google.charts.load('current', {packages: ['corechart']});
  google.charts.setOnLoadCallback(drawChart);
  
  function drawChart() {
      // Define the chart to be drawn.
      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Element');
      data.addColumn('number', 'Percentage');
      data.addRows([
        ['Nitrogen', 0.78],
        ['Oxygen', 0.21],
        ['Other', 0.01]
      ]);

      var options = {'title':'How Much Pizza I Ate Last Night',
              'width':400,
              'height':300};
      
      // Instantiate and draw the chart.
      var chart = new google.visualization.PieChart(document.getElementById('myPieChart'));
      chart.draw(data, options);
    }
  
</script>