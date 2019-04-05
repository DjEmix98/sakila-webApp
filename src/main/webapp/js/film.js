/**
 * 
 */

function getListRatings() {

  var tendinaRating = $("#menuRating");

  $.get("/api/film/list-all", function (rating, status) {

    for (var rt of rating) {
      tendinaRating.append("<option id='" + rt+ "'>" +
        rt + "</option>");
    }
    tendinaRating.append("<option>Tutti i ratings</option>");
  });
  
}

function getCategoryList(){

  var tendinaCategory = $("#menuCategory");
  $.get("/api/category/find-all", function(category, status){

    for(var categoria of category){
      tendinaCategory.append("<option id='" + categoria.nome+ "'>" +
      categoria.nome + "</option>");
    }
    tendinaCategory.append("<option>Tutte le categorie</option>");
  });
}

function findFilm(){
  var rating= $("#menuRating option:selected").attr("id");
  var category= $("#menuCategory option:selected").attr("id");
  var jsonFilmObject = new Object();
  jsonFilmObject.titolo = $("#filmText").val();
  jsonFilmObject.prezzoMaggiore = $("#costoMax").val();
  jsonFilmObject.prezzoMaggiore = $("#costoMin").val();


  if(rating==undefined){

    jsonFilmObject.rating =null;
  }
  else{

    jsonFilmObject.rating =rating;
  }
  if(category==undefined){

    jsonFilmObject.filmCategory = null;
  }
  else{

    jsonFilmObject.filmCategory=category;
  }
  console.log("json: "+jsonFilmObject);
  var jsonFilm = JSON.stringify(jsonFilmObject);
  $.ajax({
		url: "/api/film/search",
		type: "POST",
		data: jsonFilm,
		contentType: "application/json",
		dataType: "json",
		success: function (films) {
			var tagDivContent = $("#content");
			$("#formRicerca").hide();
			tagDivContent.html("<div class='col-12'><h1 class='blu row justify-content-center'>Film trovati</h1>");
			for (var film of films) {
				tagDivContent.append("<div class='col-sm-6 col-lg-3 col-md-6 text-center'><div class=' card mb-4 box-shadow'>" +
				"<div class='card-body'>" + "<h5 class='card-title '>" + film.titolo + "</h5>" +
        "<p class='card-text'>Descrizione:</p><p class='card-text'>" + film.descrizione +"</P>"
        +"<p class='card-text'>Anno:"+film.annoDiUscita+"</p>"
        +"<p class='card-text'>Prezzo: "+film.prezzo+"</p>"
        +"<button class='btn btn-info col' onclick=findActorByFilm("+film.id+")>Visualizza dettagli</button>"
        +"<a class='btn btn-success col'  href='api/attori/"+film.id+"/attori-csv'>Scarica lista attori</a>"
        +"</div></div></div></div>");
			}
		}
	});

}
function findFilmByActor(idActor){
  
  $.post("/api/film/" + idActor + "/by-actor", function (films){

    var tagDivContent = $("#content");

    tagDivContent.html("<div class='col-12'><h1 class='blu row justify-content-center'>Film trovati</h1>");
    for (var film of films) {

      tagDivContent.append("<div class='col-sm-6 col-lg-3 col-md-6 text-center'><div class=' card mb-4 box-shadow'>" +
				"<div class='card-body'>" + "<h5 class='card-title '>" + film.titolo + "</h5>" +
        "<p class='card-text'>Descrizione:</p><p class='card-text'>" + film.descrizione +"</P>"
        +"<p class='card-text'>Anno:"+film.annoDiUscita+"</p>"
        +"<p class='card-text'>Prezzo: "+film.prezzo+"</p>"
        +"<button class='btn btn-info col' onclick=findActorByFilm("+film.id+")>Visualizza dettagli</button>"
        +"<a class='btn btn-success col' href='api/attori/"+film.id+"/attori-csv' >Scarica lista attori</a>"
        +"</div></div></div></div>");
    }

  });


}
