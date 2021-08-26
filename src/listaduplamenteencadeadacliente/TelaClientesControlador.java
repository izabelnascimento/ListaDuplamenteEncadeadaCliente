package listaduplamenteencadeadacliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TelaClientesControlador {
	
    private TelaClientes telaClientes;
    private int codigoCliente = 1;
    private ListaDuplamenteEncadeada listaClientes = new ListaDuplamenteEncadeada();

	
    public TelaClientesControlador(TelaClientes tela) {
	this.telaClientes = tela;
		
	this.telaClientes.getBtCadastrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = telaClientes.getTfNome().getText();
                String cpfString = telaClientes.getTfCpf().getText();
		if(nome.trim().equals("")) {
                    telaClientes.exibirAlerta("Informe o nome do cliente.");
		}else{
                    int cpf = 0;
                    try {
			cpf = Integer.parseInt(cpfString);
			Cliente cliente = new Cliente();
			cliente.setCodigo(codigoCliente);
			cliente.setNome(nome);
			cliente.setCpf(cpf);
			listaClientes.add(cliente);
                        telaClientes.atualizarTabela(listaClientes);
			codigoCliente++;
			telaClientes.limparCampos();
                    }catch(NumberFormatException err) {
			telaClientes.exibirAlerta("Informe um cpf válido.");
                    }
		}
            }
	});
	this.telaClientes.getBtRemover().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		int linhaSelecionada = telaClientes.getTabela().getSelectedRow();
		if(linhaSelecionada < 0) {
                    telaClientes.exibirAlerta("Selecione um produto para ser removido.");
		}else {
                    Cliente cliente = listaClientes.get(linhaSelecionada);
                    int confirm = JOptionPane.showConfirmDialog(null, "Você deseja remover o produto " + cliente + "?");
                    if(confirm == 0) {
			listaClientes.remove(cliente.getCodigo());
			telaClientes.atualizarTabela(listaClientes);
                    }
		}
            }
	});
	this.telaClientes.getBtConsultaCodigo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		String codigoString = telaClientes.getTfConsultaExcluirCodigo().getText();
                try {
                    int codigo = Integer.parseInt(codigoString);
                    Cliente cliente = listaClientes.get(codigo);
                    if(cliente == null) {
			JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }else{
			JOptionPane.showMessageDialog(null, cliente);
                    }
		}catch(NumberFormatException err) {
                    telaClientes.exibirAlerta("Código inválido");
		}
            }
	});
        this.telaClientes.getBtExcluirCodigo().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String codigoString = telaClientes.getTfConsultaExcluirCodigo().getText();
                try{
                    int codigo = Integer.parseInt(codigoString);
                    Cliente cliente = listaClientes.get(codigo);
                    if(cliente == null){
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                    }else{
                        int confirm = JOptionPane.showConfirmDialog(null, "Você deseja remover o produto " + cliente + "?");
                        if(confirm == 0) {
                            listaClientes.remove(codigo);
                            telaClientes.atualizarTabela(listaClientes);
                        }
                    }
                }catch(NumberFormatException err){
                    telaClientes.exibirAlerta("Código inválido");
                }
            }
        });
        this.telaClientes.getBtTamanho().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                int tamanho = listaClientes.size();
                JOptionPane.showMessageDialog(null, "Essa lista contem " + tamanho + " cliente(s)");
            }
        });
    }
}
