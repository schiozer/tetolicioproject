
function exibeNome(){

	var elNome = document.getElementById("txtNome");
	
	var elDisplay = document.getElementById("display");
	elDisplay.innerText = elNome.value;

}

function novoContato(){

	var elListaContatos = document.getElementById("listaContatos");

	var inputContato = document.createElement("input");
	var labelContato = document.createElement("label");
	var brContato = document.createElement("br");
	inputContato.setAttribute("name", "txtContato");
	labelContato.innerText = "Contato:";
	var excluirContato = document.createElement("input");
	excluirContato.setAttribute("type", "button");
	excluirContato.setAttribute("value", "-");
	excluirContato.onclick = function() {
		elListaContatos.removeChild(labelContato);
		elListaContatos.removeChild(inputContato);
		elListaContatos.removeChild(excluirContato);
		elListaContatos.removeChild(brContato);
	}

	//excluirContato.onclick = excluir

	elListaContatos.appendChild(labelContato);
	elListaContatos.appendChild(inputContato);
	elListaContatos.appendChild(excluirContato);
	elListaContatos.appendChild(brContato);

}

/*
function excluir(){
	window.alert("clicou no excluinpis");
}
*/

function imprimeDados(){
	
	var txtContatos = document.frmContatos.txtContato;

	for (i = 0; i < txtContatos.length; i++){
		alert(txtContatos[i].value);
	}
}

document.write("Oito");
