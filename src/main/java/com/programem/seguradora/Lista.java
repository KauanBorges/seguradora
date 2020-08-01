package com.programem.seguradora;

public class Lista {
    
    String listaCliente(Iterable<Cliente> lista){
        String html = "";

        for(Cliente c : lista){
            html = html +
            "<h1>"+c.getNome()+"</h1>"+
            c.getIdade()+"<br>"+
            c.getEndereco()+"<br>"+
            "<br>"
            ;
        }
        return html;
    }

	public String listaDependente(Iterable<Dependente> findAll) {
		return null;
	}
}