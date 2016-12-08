<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:url value="/" var="home" />
<nav class="navbar navbar-inverse navbar-fixed-top">
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">FAMS <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${home}fams">Status</a></li>
                        <li><a href="${home}fams/search">FA Search</a></li>
                        <li><a href="${home}fams/approveList">FA Approve</a></li>
                        <li><a href="${home}fams/report">FA Summary</a></li>
                        <c:if test="${roleName eq 'admin' or roleName eq 'saleCo' or roleName eq 'saleOut' or roleName eq 'user'}">
                            <li><a href="${home}fams/request">Request FA</a></li>
                            <li><a href="${home}fams/listSale">List For Update</a></li>
                            <li><a href="${home}fams/listSaleCoFollow">List Sale Co Follow</a></li>
                        </c:if>
                        <c:if test="${roleName eq 'admin' or roleName eq 'saleOut' or roleName eq 'user'}">
                            <li><a href="${home}fams/listSaleOutFollow">List Sale Out Follow</a></li>
                        </c:if>
                        <c:if test="${roleName eq 'admin' or roleName eq 'engineer' or roleName eq 'user'}">
                            <li><a href="${home}fams/engineerView">Engineer View</a></li>
                        </c:if>
                        <c:if test="${roleName eq 'admin' or roleName eq 'qa' or roleName eq 'qaEngineer'}">
                            <li><a href="${home}fams/qaView">QA View</a></li>
                        </c:if>
                        <c:if test="${roleName eq 'admin' or roleName eq 'qaEngineer'}">
                            <li><a href="${home}fams/qaEngineerView">Review Document</a></li>
                        </c:if>
                    </ul>
                </li>
                <li><a href="${home}mtms">MTMS</a></li>
                <li><a href="${home}customer">Customer</a></li>
                <li><a href="#">Blog</a></li>
                <li><a href="#">Download</a></li>
                <li><a href="#">Contract</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						<span id="username">
							<c:if test="${not empty name}" >
                                ${name}
                            </c:if>
						</span>
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <c:if test="${not empty login}">
                            <li id="login"><a href="${home}login">Login</a></li>
                        </c:if>
                        <c:if test="${roleName eq 'admin' or roleName eq 'user'}">
                            <li id="createUser"><a href="${home}appuser?form">Create User</a></li>
                            <li id="listUser"><a href="${home}appuser?list">List User</a></li>
                        </c:if>
                        <c:if test="${not empty logout}">
                            <li id="logout"><a href="${home}resources/j_spring_security_logout">Logout</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>