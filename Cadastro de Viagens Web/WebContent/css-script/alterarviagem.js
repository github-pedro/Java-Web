/**
 * 
 */
function montaCidade(estado, pais){
	$.ajax({
		type:'GET',
		url:'http://api.londrinaweb.com.br/PUC/Cidades/'+estado+'/'+pais+'/0/10000',
		contentType: "application/json; charset=utf-8",
		dataType: "jsonp",
		async:false
	}).done(function(response){
		cidades='';

		$.each(response, function(c, cidade){

			cidades+='<option value="'+cidade+'">'+cidade+'</option>';

		});

		// PREENCHE AS CIDADES DE ACORDO COM O ESTADO
		
		$('#cidade').html('<option selected disabled value="">Selecione</option>'+cidades);

	});
}

function montaUF(pais){
	$.ajax({
		type:'GET',
		url:'http://api.londrinaweb.com.br/PUC/Estados/'+pais+'/0/10000',
		contentType: "application/json; charset=utf-8",
		dataType: "jsonp",
		async:false
	}).done(function(response){
		estados='';
		$.each(response, function(e, estado){

			estados+='<option value="'+estado.UF+'">'+estado.Estado+'</option>';

		});

		// PREENCHE OS ESTADOS BRASILEIROS
		
		$('#estado').html('<option selected disabled value="">Selecione</option>'+estados);

		// CHAMA A FUNÇÃO QUE PREENCHE AS CIDADES DE ACORDO COM O ESTADO
		
		montaCidade($('#estado').val(), pais);

		// VERIFICA A MUDANÇA NO VALOR DO CAMPO ESTADO E ATUALIZA AS CIDADES
		
		$('#estado').change(function(){
			montaCidade($(this).val(), pais);
		});

	});
}

function montaPais(){
	$.ajax({
		type:	'GET',
		url:	'http://api.londrinaweb.com.br/PUC/Paisesv2/0/1000',
		contentType: "application/json; charset=utf-8",
		dataType: "jsonp",
		async:false
	}).done(function(response){
		
		paises='';

		$.each(response, function(p, pais){

			if(pais.Pais == 'Brasil'){
				paises+='<option value="'+pais.Pais+'">'+pais.Pais+'</option>';
			} else {
				paises+='<option value="'+pais.Pais+'">'+pais.Pais+'</option>';
			}

		});

		// PREENCHE O SELECT DE PAÍSES
		
		$('#pais').html('<option selected disabled value="">Selecione</option>'+paises);

		// PREENCHE O SELECT DE ACORDO COM O VALOR DO PAÍS
		
		montaUF($('#pais').val());

		// VERIFICA A MUDANÇA DO VALOR DO SELECT DE PAÍS
		
		$('#pais').change(function(){
			if($('#pais').val() == 'Brasil'){
			
				// SE O VALOR FOR BR E CONFIRMA OS SELECTS
				
				$('#estado').remove();
				$('#cidade').remove();
				$('#campo_estado').append('<select id="estado" name="estado"></select>');
				$('#campo_cidade').append('<select id="cidade" name="cidade"></select>');

				// CHAMA A FUNÇÃO QUE MONTA OS ESTADOS
				
				montaUF('BR');		
			} else {
			
				// SE NÃO FOR, TROCA OS SELECTS POR INPUTS DE TEXTO
				
				$('#estado').remove();
				$('#cidade').remove();
				$('#campo_estado').append('<input type="text" id="estado" name="estado" required>');
				$('#campo_cidade').append('<input type="text" id="cidade" name="cidade" required>');
			}
		})

	});
}

montaPais();