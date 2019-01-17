package br.com.treinaweb.agenda.servicos.interfaces;

import java.util.List;

import br.com.treinaweb.agenda.entidades.Contato;

public interface ServicoContato {

	void exportar(List<Contato> contatos, String nomeArquivo);

}
