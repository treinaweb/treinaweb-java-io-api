package br.com.treinaweb.agenda.servicos.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoContato;

public class BufferedWriterServicoContato implements ServicoContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		// BufferedWriter (Writer) --> FileWriter (apontador --> arquivo no HD
		FileWriter fileWriter = new FileWriter(nomeArquivo);
		try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
			List<String> dadosParaExportar = contatos.stream().map(contato -> String.format("%d;%s;%d;%s\n",
					contato.getId(), contato.getNome(), contato.getIdade(), contato.getTelefone()))
					.collect(Collectors.toList());
			for (String linha : dadosParaExportar) {
				writer.write(linha);
			}
		}
	}

}
