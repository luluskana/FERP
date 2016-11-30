<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<spring:url value="/" var="home" />
<%@page session="true"%>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <h2 align="center">FA Summary</h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th></th>
                    <th>January</th>
                    <th>February</th>
                    <th>March</th>
                    <th>April</th>
                    <th>May</th>
                    <th>June</th>
                    <th>July</th>
                    <th>August</th>
                    <th>September</th>
                    <th>October</th>
                    <th>November</th>
                    <th>December</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>FA Request</th>
                    <td>${january}</td>
                    <td>${february}</td>
                    <td>${March}</td>
                    <td>${april}</td>
                    <td>${may}</td>
                    <td>${june}</td>
                    <td>${july}</td>
                    <td>${august}</td>
                    <td>${september}</td>
                    <td>${october}</td>
                    <td>${november}</td>
                    <td>${december}</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12" role="alert">
            <canvas id="summary" height="60"></canvas>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-sm-7 well">
            <form class="form-inline">
                <legend>Excel Report</legend>
                <div class="form-group">
                    <label for="inputStartDate">Start Date: </label>
                    <input type="text" class="form-control" id="inputStartDate" placeholder="dd/MM/yyyy">
                </div>
                <div class="form-group">
                    <label for="inputEndDate">End Date: </label>
                    <input type="text" class="form-control" id="inputEndDate" placeholder="dd/MM/yyyy">
                </div>
                <button id="btnDownload" class="btn btn-default" type="button">Download</button>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $("#inputStartDate").datepicker({ dateFormat: 'dd/mm/yy' });
        $("#inputEndDate").datepicker({ dateFormat: 'dd/mm/yy' });

        var d = new Date();
        var currMonth = d.getMonth();
        var currYear = d.getFullYear();
        var startDate = new Date(currYear, currMonth, 1);
        var endDate = new Date(currYear, currMonth + 1, 1) - 1;

        $("#inputStartDate").datepicker().datepicker('setDate', startDate);
        $("#inputEndDate").datepicker().datepicker('setDate', endDate);

        var dataFree = {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
            datasets: [
                {
                    label: "FA Request",
                    backgroundColor: "#2ecc71",
                    borderColor: "rgba(255,99,132,1)",
                    borderWidth: 1,
                    hoverBackgroundColor: "rgba(255,99,132,0.4)",
                    hoverBorderColor: "rgba(255,99,132,1)",
                    data: [${january}, ${february}, ${march}, ${april}, ${may}, ${june}, ${july}, ${august}, ${september}, ${october}, ${november}, ${december}]
                }
            ]
        };

        var ctxFree = document.getElementById("summary");
        var myChartFree = new Chart(ctxFree, {
            type: 'bar',
            data: dataFree,
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero:true
                        }
                    }]
                }
            }
        });

        $("#btnDownload").click(function() {
            window.open('${home}fams/excelReport?startDate=' + $("#inputStartDate").val() + '&endDate=' + $("#inputEndDate").val() ,'_blank');
        });
    });
</script>