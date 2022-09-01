/**
 * Confirmação de exclusão de um contato/ Autor@HigorRenan
 */
 
 function confirmar (id_contato){
	let resposta = confirm("Deseja exlcuir este contato?")
	if(resposta ===true){
		//alert(id_contato)
		window.location.href="delete?id_contato="+id_contato
	}
	
} 