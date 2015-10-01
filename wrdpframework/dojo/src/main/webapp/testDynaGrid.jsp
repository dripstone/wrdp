<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!-- 默认dijit 主题 -->
<style>
	@import "<%=path %>/dijit/themes/claro/claro.css";
</style>
<script src="<%=path %>/dojo/dojo.js" data-dojo-config="parseOnLoad: true, isDebug: true"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	@import "<%=path %>/dojox/grid/resources/claroGrid.css";
	#gridDiv {
	    height: 20em;
	}
</style>
<title>Insert title here</title>
<script type="text/javascript">
require([ 'dojo/_base/lang', 'dojox/grid/DataGrid',
  		'dojo/data/ItemFileWriteStore', 'dojo/dom', 'dojo/domReady!',
  		"dijit/dijit",
  		"dojox/grid/cells/dijit"],
  		function(lang, DataGrid, ItemFileWriteStore, dom) {

  			/* set up data store */
  			var data = {
  				identifier : "id",
  				items : []
  			};
  			var data_list = [ {
  				col1 : "normal",
  				col2 : false,
  				col3 : 'country',
  				col4 : 29.91
  			}, {
  				col1 : "important",
  				col2 : false,
  				col3 : 'country',
  				col4 : 9.33
  			}, {
  				col1 : "important",
  				col2 : false,
  				col3 : 'country',
  				col4 : 19.34
  			} ];
  			var rows = 60;
  			for (var i = 0, l = data_list.length; i < rows; i++) {
  				data.items.push(lang.mixin({
  					id : i + 1
  				}, data_list[i % l]));
  			}
  			var store = new ItemFileWriteStore({
  				data : data
  			});

  			/* set up layout */
  			var layout = [ [ {
  				//'name' : 'Column 1',
  				'field' : 'id',
  				'width' : '100px'
  			}, {
  				//'name' : 'Column 2',
  				'field' : 'col2',
  				'width' : '100px'
  			}, {
  				//'name' : 'Column 3',
  				'field' : 'col3',
  				'width' : '200px',
          	   'cellType':'dojox.grid.cells.ComboBox',
         	   'options':'country,city,continent',
         	   'editable':'true'
  			}, {
  				//'name' : 'Column 4',
  				'field' : 'col4',
  				'width' : '150px'
  			} ] ];

  			/* create a new grid */
  			var grid = new DataGrid({
  				id : 'grid',
  				store : store,
  				structure : layout,
  				rowSelector : '20px'
  			});

  			/* append the new grid to the div */
  			grid.placeAt("gridDiv");

  			/* Call startup() to render the grid */
  			grid.startup();
  		});
</script>
</head>
<body class="claro">

<div id="gridDiv"></div>
</body>
</html>