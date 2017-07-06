$(function() {
	$(".poi-load").on('click', function(event) {
		event.preventDefault();
		$.ajax({
				url: "https://xy-inc2.herokuapp.com/points-of-interest",
				type: "get",
				success: function(response) {
					desenhaTabela(response);
				}
		});
	})
});

function desenhaTabela(dados) {
	$(".poi-table-body tr").remove();
	for(var i=0; i < dados.length; i++) {
		desenhaLinha(dados[i]);
	}
}

function desenhaLinha(linha) {
	var linhaTabela = $("<tr/>");
	$(".poi-table-body").append(linhaTabela);
	linhaTabela.append("<td>" + linha.id + "</td>");
	linhaTabela.append("<td>" + linha.nome + "</td>");
	linhaTabela.append("<td>" + linha.x + "</td>");
	linhaTabela.append("<td>" + linha.y + "</td>");
}