/**
 * validaçaõ de formulário
 *@author Higor Renan
 */ 
 
 function validar (){
	
	let nome = frmContato.nome_contato.value
	let fone = frmContato.fone_contato.value
	let email = frmContato.email_contato.value
	
	if(nome ===""){
		alert('Preencha o campo nome')
		frmContato.nome_contato.focus()
		return false
		
	}else if(fone ===""){
		alert('Preencha o campo fone')
		frmContato.fone_contato.focus()
		return false
		
	}else if(email ==="") {
		alert('Preencha o campo email')
		frmContato.email_contato.focus()
		return false
		
	}else {
		document.forms["frmContato"].submit()
	}
}
 