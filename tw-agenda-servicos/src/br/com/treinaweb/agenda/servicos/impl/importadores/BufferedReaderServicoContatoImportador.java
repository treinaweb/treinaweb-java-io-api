package br.com.treinaweb.agenda.servicos.impl.importadores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.repositorios.interfaces.AgendaRepositorio;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoImportadorContato;

public class BufferedReaderServicoContatoImportador implements ServicoImportadorContato {

	@Override
	public void importar(String nomeArquivo, AgendaRepositorio<Contato> agendaRepositorio) throws IOException {
		FileReader fileReader = new FileReader(nomeArquivo);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
	}

}
