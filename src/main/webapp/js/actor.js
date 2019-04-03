/**
 * 
 */

 function findActorByFilm(idFilm){

    $.post("/api/film/" + idFilm + "/by-id", function (film) {
        var tagDivContent = $("#content");
        tagDivContent.html("<div class='col-12'><h1 class='blu row justify-content-center'>Attori</h1>")
        for(fa of film.attori)
       {
        tagDivContent.append("<div class='col-sm-6 col-lg-3 col-md-6 text-center'><div class=' card mb-4 box-shadow'>" +
        "<div class='card-body'>" + "<h5 class='card-title '>" + fa.nome +" "+fa.cognome+ "</h5>"+
        "<a id='" + fa.id + "' class='btn btn-info' onclick=findFilmByActor("+fa.id+")>Visualizza film attore</a>" +
        "</div>" + "</div>"+"</div>");
       }
	});

 }