<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
   <%@ page language="java" contentType="text/html;charset=UTF-8"
	session="false"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru" xml:lang="ru">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Coffee Shop</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/vls.css"/>"/>
	<script
			  src="https://code.jquery.com/jquery-3.2.1.min.js"
			  integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
			  crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.min.js"></script>
	<script src="<c:url value="/resources/js/coffeshop_validate_${localization.language}.js"/>"></script>
	</head>
<body>
	<p class="header">${localization.attributes.shopName}</p>
