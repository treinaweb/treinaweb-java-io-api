package br.com.treinaweb.agenda.servicos.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.stream.Collectors;

import br.com.treinaweb.agenda.entidades.Contato;
import br.com.treinaweb.agenda.servicos.interfaces.ServicoContato;

public class FileChannelServicoContato implements ServicoContato {

	@Override
	public void exportar(List<Contato> contatos, String nomeArquivo) throws IOException {
		try (FileOutputStream fileOutputStream = new FileOutputStream(nomeArquivo)) {
			try (FileChannel fileChannel = fileOutputStream.getChannel()) {
				List<String> dados = contatos.stream().map(contato -> String.format("%d;%s;%d;%s\n", contato.getId(),
						contato.getNome(), contato.getIdade(), contato.getTelefone())).collect(Collectors.toList());
				for (String dado : dados) {
					byte[] dadosEmBytes = dado.getBytes();
					ByteBuffer buffer = ByteBuffer.allocate(dadosEmBytes.length);
					buffer.put(dadosEmBytes);
					buffer.flip();
					fileChannel.write(buffer);
				}
			}
		}
	}

}
