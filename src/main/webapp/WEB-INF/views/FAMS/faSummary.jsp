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
                    <tr class="alert-danger">
                        <th>First Shot Reject</th>
                        <td>${qaRejectFirstShotJanuary}</td>
                        <td>${qaRejectFirstShotFebruary}</td>
                        <td>${qaRejectFirstShotMarch}</td>
                        <td>${qaRejectFirstShotApril}</td>
                        <td>${qaRejectFirstShotMay}</td>
                        <td>${qaRejectFirstShotJune}</td>
                        <td>${qaRejectFirstShotJuly}</td>
                        <td>${qaRejectFirstShotAugust}</td>
                        <td>${qaRejectFirstShotSeptember}</td>
                        <td>${qaRejectFirstShotOctober}</td>
                        <td>${qaRejectFirstShotNovember}</td>
                        <td>${qaRejectFirstShotDecember}</td>
                    </tr>
                    <tr class="alert-success">
                        <th>First Shot Approve</th>
                        <td>${qaApproveFirstShotJanuary}</td>
                        <td>${qaApproveFirstShotFebruary}</td>
                        <td>${qaApproveFirstShotMarch}</td>
                        <td>${qaApproveFirstShotApril}</td>
                        <td>${qaApproveFirstShotMay}</td>
                        <td>${qaApproveFirstShotJune}</td>
                        <td>${qaApproveFirstShotJuly}</td>
                        <td>${qaApproveFirstShotAugust}</td>
                        <td>${qaApproveFirstShotSeptember}</td>
                        <td>${qaApproveFirstShotOctober}</td>
                        <td>${qaApproveFirstShotNovember}</td>
                        <td>${qaApproveFirstShotDecember}</td>
                    </tr>
                    <tr class="alert-danger">
                        <th>Final Reject</th>
                        <td>${qaRejectFinalJanuary}</td>
                        <td>${qaRejectFinalFebruary}</td>
                        <td>${qaRejectFinalMarch}</td>
                        <td>${qaRejectFinalApril}</td>
                        <td>${qaRejectFinalMay}</td>
                        <td>${qaRejectFinalJune}</td>
                        <td>${qaRejectFinalJuly}</td>
                        <td>${qaRejectFinalAugust}</td>
                        <td>${qaRejectFinalSeptember}</td>
                        <td>${qaRejectFinalOctober}</td>
                        <td>${qaRejectFinalNovember}</td>
                        <td>${qaRejectFinalDecember}</td>
                    </tr>
                    <tr class="alert-success">
                        <th>Final Approve</th>
                        <td>${qaApproveFinalJanuary}</td>
                        <td>${qaApproveFinalFebruary}</td>
                        <td>${qaApproveFinalMarch}</td>
                        <td>${qaApproveFinalApril}</td>
                        <td>${qaApproveFinalMay}</td>
                        <td>${qaApproveFinalJune}</td>
                        <td>${qaApproveFinalJuly}</td>
                        <td>${qaApproveFinalAugust}</td>
                        <td>${qaApproveFinalSeptember}</td>
                        <td>${qaApproveFinalOctober}</td>
                        <td>${qaApproveFinalNovember}</td>
                        <td>${qaApproveFinalDecember}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 alert alert-warning" role="alert">
            <canvas id="firstReject" width="70" height="30"></canvas>
        </div>
        <div class="col-sm-6 alert alert-info" role="alert">
            <canvas id="firstApprove" width="70" height="30"></canvas>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 alert alert-warning" role="alert">
            <canvas id="finalReject" width="70" height="30"></canvas>
        </div>
        <div class="col-sm-6 alert alert-info" role="alert">
            <canvas id="finalApprove" width="70" height="30"></canvas>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {

        var dataFirstReject = {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
            datasets: [
                {
                    label: "First Shot Reject",
                    backgroundColor: "#c0392b",
                    borderColor: "rgba(255,99,132,1)",
                    borderWidth: 1,
                    hoverBackgroundColor: "rgba(255,99,132,0.4)",
                    hoverBorderColor: "rgba(255,99,132,1)",
                    data: [${qaRejectFirstShotJanuary}, ${qaRejectFirstShotFebruary}, ${qaRejectFirstShotMarch}, ${qaRejectFirstShotApril}, ${qaRejectFirstShotMay}, ${qaRejectFirstShotJune}, ${qaRejectFirstShotJuly}, ${qaRejectFirstShotAugust}, ${qaRejectFirstShotSeptember}, ${qaRejectFirstShotOctober}, ${qaRejectFirstShotNovember}, ${qaRejectFirstShotDecember}]
                }
            ]
        };

        var ctxFirstReject = document.getElementById("firstReject");
        var myChartFirstReject = new Chart(ctxFirstReject, {
            type: 'bar',
            data: dataFirstReject,
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

        var dataFirstApprove = {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
            datasets: [
                {
                    label: "First Shot Approve",
                    backgroundColor: "#2ecc71",
                    borderColor: "rgba(255,99,132,1)",
                    borderWidth: 1,
                    hoverBackgroundColor: "rgba(255,99,132,0.4)",
                    hoverBorderColor: "rgba(255,99,132,1)",
                    data: [${qaApproveFirstShotJanuary}, ${qaApproveFirstShotFebruary}, ${qaApproveFirstShotMarch}, ${qaApproveFirstShotApril}, ${qaApproveFirstShotMay}, ${qaApproveFirstShotJune}, ${qaApproveFirstShotJuly}, ${qaApproveFirstShotAugust}, ${qaApproveFirstShotSeptember}, ${qaApproveFirstShotOctober}, ${qaApproveFirstShotNovember}, ${qaApproveFirstShotDecember}]
                }
            ]
        };

        var ctxFirstApprove = document.getElementById("firstApprove");
        var myChartFirstApprove = new Chart(ctxFirstApprove, {
            type: 'bar',
            data: dataFirstApprove,
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

        var dataFinalReject = {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
            datasets: [
                {
                    label: "Final Reject",
                    backgroundColor: "#c0392b",
                    borderColor: "rgba(255,99,132,1)",
                    borderWidth: 1,
                    hoverBackgroundColor: "rgba(255,99,132,0.4)",
                    hoverBorderColor: "rgba(255,99,132,1)",
                    data: [${qaRejectFinalJanuary}, ${qaRejectFinalFebruary}, ${qaRejectFinalMarch}, ${qaRejectFinalApril}, ${qaRejectFinalMay}, ${qaRejectFinalJune}, ${qaRejectFinalJuly}, ${qaRejectFinalAugust}, ${qaRejectFinalSeptember}, ${qaRejectFinalOctober}, ${qaRejectFinalNovember}, ${qaRejectFinalDecember}]
                }
            ]
        };

        var ctxFinalReject = document.getElementById("finalReject");
        var myChartFinalReject = new Chart(ctxFinalReject, {
            type: 'bar',
            data: dataFinalReject,
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

        var dataFinalApprove = {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
            datasets: [
                {
                    label: "Final Approve",
                    backgroundColor: "#2ecc71",
                    borderColor: "rgba(255,99,132,1)",
                    borderWidth: 1,
                    hoverBackgroundColor: "rgba(255,99,132,0.4)",
                    hoverBorderColor: "rgba(255,99,132,1)",
                    data: [${qaApproveFinalJanuary}, ${qaApproveFinalFebruary}, ${qaApproveFinalMarch}, ${qaApproveFinalApril}, ${qaApproveFinalMay}, ${qaApproveFinalJune}, ${qaApproveFinalJuly}, ${qaApproveFinalAugust}, ${qaApproveFinalSeptember}, ${qaApproveFinalOctober}, ${qaApproveFinalNovember}, ${qaApproveFinalDecember}]
                }
            ]
        };

        var ctxFinalApprove = document.getElementById("finalApprove");
        var myChartFirstApprove = new Chart(ctxFinalApprove, {
            type: 'bar',
            data: dataFinalApprove,
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
    });
</script>
