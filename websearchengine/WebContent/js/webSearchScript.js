var i = 0;
var prefixCollection = [ "ActionScript", "AppleScript", "Asp", "BASIC", "C",
		"C++", "Clojure", "COBOL", "ColdFusion", "Erlang", "Fortran", "Groovy",
		"Haskell", "Java", "JavaScript", "Lisp", "Perl", "PHP", "Python",
		"Ruby", "Scala", "Scheme" ];
$(document).ready(function() {
	$("input").keyup(function() {
		getSuggestion();
	});

});

function getSuggestion() {
	var xhttp;
	console.log("calling!!!!");
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			console.log($.parseJSON(xhttp.responseText));
			prefixCollection = $.parseJSON(xhttp.responseText);
			$('#usr').autocomplete({
				source : prefixCollection
			});
		}
	};
	var str = $('#usr').val();
	xhttp.open("GET", "WebSrcController?act=prefix&prefix=" + str, true);
	xhttp.send();

}

function getTopUrls() {
	var xhttp;
	console.log("Calling get top URl function!!!!");
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log($.parseJSON(xhttp.responseText));
			var createTable = "";

			if ($.parseJSON(xhttp.responseText).length > 0) {
				console.log("insoder");
				$.each($.parseJSON(xhttp.responseText), function(index, value) {
					createTable += "<tr><td><a href = \"" + value
							+ "\">" + value + "</td></tr>";
					console.log(createTable);
				});
				document.getElementById("solutionBar").style.display = "block";
				$("#test").replaceWith("<div id = \"test\"></div>");
				$("#test")
						.append(
								"<table class=\"table table-striped\"><thead><tr><th>Result Found:</th></tr></thead><tbody>"
										+ createTable + "</tbody></table>");
			} else {
				console.log("Returned zero, will call recomended Words!");
				getrecommendedWord();
				
			}
		}
	};
	var str = $('#usr').val();
	xhttp.open("GET", "WebSrcController?act=getTopUrl&prefix=" + str, true);
	xhttp.send();

}

function getrecommendedWord() {
	var xhttp;
	console.log("Calling get getRecommendeWord!!!!");
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log($.parseJSON(xhttp.responseText));
			var createTable = "";

			console.log("Hello ready to present....");
			console.log(xhttp.responseText);
			if ($.parseJSON(xhttp.responseText).length > 0) {
				console.log("insoder");
				$.each($.parseJSON(xhttp.responseText), function(index, value) {
					createTable += "<tr><td>" + value + "</td></tr>";
					console.log(createTable);
				});
				document.getElementById("solutionBar").style.display = "block";
				$("#test").replaceWith("<div id = \"test\"></div>");
				$("#test")
						.append(
								"<table class=\"table table-striped\"><thead><tr><th>No Match Found !!! You may try Below Words:</th></tr></thead><tbody>"
										+ createTable + "</tbody></table>");
			} else {
				document.getElementById("solutionBar").style.display = "block";
				$("#test").replaceWith("<div id = \"test\"></div>");
				$("#test")
						.append(
								"<table class=\"table table-striped\"><thead><tr><th>No Match Found</th></tr></thead></table>");
			}
		}
	};
	var str = $('#usr').val();
	xhttp.open("GET", "WebSrcController?act=getCorWord&prefix=" + str, true);
	xhttp.send();

}
