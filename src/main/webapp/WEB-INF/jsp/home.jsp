<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta charset="ISO-8859-1">
<script type="text/javascript" src="/js/film.js"></script>
<script type="text/javascript" src="/js/actor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Home</title>
</head>
<body>
 <div class="container">   
<div id="content" class="row">   
</div>
<div id="formRicerca" class="text-center">
    <div class="form-signin offset-lg-4 col-lg-4 col-md-12">
    <p class="badge badge-primary">Inserisci film da ricercare</p>
    <div class="form-inline">
    <select id="menuCategory" class="offset-lg-1 col-lg-4 col-md-12"></select>
    <select id="menuRating" class="offset-lg-2 col-lg-4 col-md-12"></select>
    </div>
    <br>
    <input type="text" id="filmText" class="form-control" placeholder="Inserisci nome film">
    <br>
    <input type="number" id="costoMin" class="form-control" placeholder="Inserisci costo minore">
    <br>
    <input type="number" id="costoMax" class="form-control" placeholder="Inserisci costo maggiore">
    <br>
    <input type="submit" onclick="findFilm()" class="btn btn-success col">
</div>
</div>
</div>
</body>
<script>
getCategoryList();    
getListRatings();
</script>
</html>