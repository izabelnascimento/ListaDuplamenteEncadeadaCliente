package listaduplamenteencadeadacliente;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaClientes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JLabel lbNome;
    private JLabel lbCpf;
    private JTextField tfNome;
    private JTextField tfCpf;
    private JButton btCadastrar;
    private JButton btRemover;
    private JScrollPane barraRolagem;
    private JTable tabela;
    private DefaultTableModel modelo = new DefaultTableModel();
    private JLabel lbConsultaExcluirCodigo;
    private JTextField tfConsultaExcluirCodigo;
    private JButton btConsultaCodigo;
    private JButton btExcluirCodigo;
    private JButton btTamanho;

    public TelaClientes() {
	this.setTitle("Tela Clientes");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setSize(650, 600);
	this.setLocationRelativeTo(null);
	this.setLayout(null);

	this.lbNome = new JLabel("Nome");
	this.lbNome.setBounds(20, 20, 150, 20);
	this.lbCpf = new JLabel("CPF");
	this.lbCpf.setBounds(400, 20, 150, 20);
	this.tfNome = new JTextField("");
	this.tfNome.setBounds(20, 50, 350, 25);
	this.tfCpf = new JTextField();
	this.tfCpf.setBounds(400, 50, 200, 25);
	this.btCadastrar = new JButton("Cadastrar");
	this.btCadastrar.setBounds(20, 85, 200, 25);
	this.btRemover = new JButton("Remover Selecionado");
	this.btRemover.setBounds(250, 85, 200, 25);
	criarTabela();
	barraRolagem = new JScrollPane(tabela);
	barraRolagem.setBounds(20, 270, 580, 280);


	this.lbConsultaExcluirCodigo = new JLabel("Index (posição no 'vetor'):");
	this.lbConsultaExcluirCodigo.setBounds(20, 140, 150, 20);
	this.tfConsultaExcluirCodigo = new JTextField("");
	this.tfConsultaExcluirCodigo.setBounds(20, 165, 350, 25);
	this.btConsultaCodigo = new JButton("Consultar");
	this.btConsultaCodigo.setBounds(400, 165, 100, 25);
        this.btExcluirCodigo = new JButton("Excluir");
        this.btExcluirCodigo.setBounds(500, 165, 100, 25);
        this.btTamanho = new JButton("Tamanho da lista");
        this.btTamanho.setBounds(400, 200, 200, 25);

	this.add(lbNome);
	this.add(lbCpf);
	this.add(tfNome);
	this.add(tfCpf);
	this.add(btCadastrar);
	this.add(btRemover);
	this.add(barraRolagem);
	this.add(lbConsultaExcluirCodigo);
	this.add(tfConsultaExcluirCodigo);
        this.add(btConsultaCodigo);
        this.add(btExcluirCodigo);
        this.add(btTamanho);

	setVisible(true);
    }

    public void limparCampos() {
	tfNome.setText("");
	tfCpf.setText("");
    }

    public void exibirAlerta(String mensagem) {
	JOptionPane.showMessageDialog(this, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE);
    }

    private void criarTabela() {
	tabela = new JTable(modelo);
	modelo.addColumn("Código");
	modelo.addColumn("Nome");
	modelo.addColumn("CPF");
	tabela.getColumnModel().getColumn(0).setPreferredWidth(140);
	tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
	tabela.getColumnModel().getColumn(2).setPreferredWidth(140);
    }

    public void adicionarProdutoTabela(Cliente cliente) {
	modelo.addRow(new Object[] { cliente.getCodigo(), cliente.getNome(), cliente.getCpf() });
    }

    public void atualizarTabela(ListaDuplamenteEncadeada clientes) {
	modelo.setRowCount(0);
    	for (int i = 0; i < clientes.size(); i++) {
            modelo.addRow(new Object[] { clientes.get(i).getCodigo(), clientes.get(i).getNome(),
            clientes.get(i).getCpf() });
	}
    }

    public JLabel getLbNome() {
        return lbNome;
    }

    public void setLbNome(JLabel lbNome) {
        this.lbNome = lbNome;
    }

    public JLabel getLbCpf() {
        return lbCpf;
    }

    public void setLbCpf(JLabel lbCpf) {
        this.lbCpf = lbCpf;
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JTextField getTfCpf() {
        return tfCpf;
    }

    public void setTfCpf(JTextField tfCpf) {
        this.tfCpf = tfCpf;
    }

    public JButton getBtCadastrar() {
        return btCadastrar;
    }

    public void setBtCadastrar(JButton btCadastrar) {
        this.btCadastrar = btCadastrar;
    }

    public JButton getBtRemover() {
        return btRemover;
    }

    public void setBtRemover(JButton btRemover) {
        this.btRemover = btRemover;
    }

    public JScrollPane getBarraRolagem() {
        return barraRolagem;
    }

    public void setBarraRolagem(JScrollPane barraRolagem) {
        this.barraRolagem = barraRolagem;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public JLabel getLbConsultaExcluirCodigo() {
        return lbConsultaExcluirCodigo;
    }

    public void setLbConsultaExcluirCodigo(JLabel lbConsultaExcluirCodigo) {
        this.lbConsultaExcluirCodigo = lbConsultaExcluirCodigo;
    }

    public JTextField getTfConsultaExcluirCodigo() {
        return tfConsultaExcluirCodigo;
    }

    public void setTfConsultaExcluirCodigo(JTextField tfConsultaExcluirCodigo) {
        this.tfConsultaExcluirCodigo = tfConsultaExcluirCodigo;
    }

    public JButton getBtConsultaCodigo() {
        return btConsultaCodigo;
    }

    public void setBtConsultaCodigo(JButton btConsultaCodigo) {
        this.btConsultaCodigo = btConsultaCodigo;
    }

    public JButton getBtExcluirCodigo() {
        return btExcluirCodigo;
    }

    public void setBtExcluirCodigo(JButton btExcluirCodigo) {
        this.btExcluirCodigo = btExcluirCodigo;
    }

    public JButton getBtTamanho() {
        return btTamanho;
    }

    public void setBtTamanho(JButton btTamanho) {
        this.btTamanho = btTamanho;
    }
    
}
