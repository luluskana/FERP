<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/" var="home" />
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="${home}" class="navbar-brand">FOAMTEC</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">System <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">FA Management</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Material Management</a></li>
                        <li class="divider"></li>
                        <li><a href="${home}barcode">Canon Barcode Compare</a></li>
                    </ul>
                </li>
                <li><a href="#">Help</a></li>
                <li><a href="#">Blog</a></li>
                <li><a href="#">Download</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Contract</a></li>
            </ul>
        </div>
    </div>
</nav>