package br.com.smartOdonto.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.MaskFormatter;

import br.com.smartOdonto.DAO.AgendamentoDAO;
import br.com.smartOdonto.DAO.PacienteDAO;
import br.com.smartOdonto.DAO.TratamentoDAO;
import br.com.smartOdonto.model.Agendamento;
import br.com.smartOdonto.model.Paciente;
import br.com.smartOdonto.model.Tratamento;
import br.com.smartOdonto.util.CommonUtil;
import javax.swing.Icon;
import javax.swing.SwingConstants;

public class SmartMenu extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenu mnPaciente;
	private JMenu mnTratamento;
	private JMenu mnAgendamento;
	private JMenuItem mntmSair;
	private JMenu mnAjuda;
	private JMenuItem mntmSobre;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmAlterar;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmExcluir;
	private JSeparator separator;
	private JMenuItem menuSavarTratamento;
	private JMenuItem menuAlterarTratamento;
	private JMenuItem menuConsultarTratamento;
	private JMenuItem menuExcluirTratamento;
	private JSeparator separator_1;
	private JMenuItem menuSalvarAgendamento;
	private JMenuItem menuAlterarAgendamento;
	private JMenuItem menuConsultarAgendamento;
	private JMenuItem menuExcluirAgendamento;
	private JSeparator separator_2;
	private JTabbedPane tabbedPane;
	private JPanel panelPaciente;
	private JLabel lblCpf;
	private JLabel lblNome;
	private JLabel lblSexo;
	private JLabel lblDataDeNascimento;
	private JLabel lblTelefone;
	private JLabel lblConvenio;
	private JLabel lblEmail;
	private JLabel lblEndereo;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JFormattedTextField txtCpf;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JFormattedTextField txtNascimento;
	private JFormattedTextField txtTel;
	private JComboBox cmbConvenio;
	private JComboBox cmbEstado;
	private JTextField txtNome;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnOutro;
	private final ButtonGroup rbgSexo = new ButtonGroup();
	private JButton btnSalvar;
	private JButton btnAlterar;
	private JButton btnConsultar;
	private JButton btnExcluir;
	private JButton btnLimpar;
	private JPanel panelTratamento;
	private JLabel lblCdigoDoTratamento;
	private JLabel lblTratamento;
	private JLabel lblTipo;
	private JLabel lblValor;
	private JButton btnSalvarTratamento;
	private JButton btnAlterarTratamento;
	private JButton btnExcluirTratamento;
	private JButton btnLimparTratamento;
	private JButton btnConsultarTratamento;
	private JComboBox cmbTipo;
	private JComboBox cmbTratamento;
	private JFormattedTextField txtCodTratamento;
	private JPanel panelAgendamento;
	private JLabel lblCpf_1;
	private JLabel lblData;
	private JLabel lblHorrio;
	private JLabel lblTratamento_1;
	private JFormattedTextField txtData;
	private JFormattedTextField txtCpfAgenda;
	private JFormattedTextField txtHorario;
	private JButton btnSalvarAgemdamento;
	private JButton btnAlterarAgendamento;
	private JButton btnConsultaAgendamento;
	private JButton btnExcluirAgendamento;
	private JButton btnLimparAgendamento;
	private JLabel lblMsgTratamento;
	private JLabel lblMsgPaciente;
	private JPanel panelListagem;
	private TextArea txtLisagem;
	private JButton btnListarPacientes;
	private JButton btnListarTratamentos;
	private JButton btnListarAgenda;
	private JLabel lblMsgAgendamento;
	private JButton btnLimpar_2;
	private JLabel lblListagem;
	private Paciente paciente;
	private PacienteDAO dao;
	private CommonUtil data;
	private String nascimento;
	private String dataAgendamento;
	private Tratamento tratamento;
	private TratamentoDAO tdao;
	private DecimalFormat df = new DecimalFormat("#,000.00");
	private JTextField txtValor;
	private JFormattedTextField txtTratamentoAgenda;
	private Agendamento agendamento;
	private AgendamentoDAO adao;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartMenu frame = new SmartMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SmartMenu() throws Exception {
		setFont(new Font("Verdana", Font.ITALIC, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\gulbo\\eclipse-workspace\\SmartOdonto\\Icones para botoes\\Smart Odonto.jpg"));
		setTitle("SmartOdonto -Eexcel\u00EAncia em Odontologia");
		setForeground(Color.CYAN);
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 469);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.CYAN);
		menuBar.setForeground(Color.CYAN);
		menuBar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		setJMenuBar(menuBar);
		
		mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//=======================================================
			JOptionPane.showMessageDialog(null, "Encerrando!");
			System.exit(0);
			//=======================================================
			}
		});
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK));
		mnArquivo.add(mntmSair);
		
		mnPaciente = new JMenu("Paciente");
		menuBar.add(mnPaciente);
		
		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================================================
				try {
					Paciente paciente = new Paciente();
					paciente.setCpf(txtCpf.getText());
					paciente.setNome(txtNome.getText());
					paciente.setNascimento(txtNascimento.getText());
					paciente.setTel(txtTel.getText());
					paciente.setConvenio((String)cmbConvenio.getSelectedItem());
					paciente.setEmail(txtEmail.getText());
					paciente.setEndereco(txtEndereco.getText());
					paciente.setCidade(txtCidade.getText());
					paciente.setEstado((String)cmbEstado.getSelectedItem());
					if(rdbtnMasculino.isSelected()== true){
						paciente.setSexo("Masculino");
					} else if(rdbtnFeminino.isSelected()== true) {
						paciente.setSexo("Feminino");
					} else if(rdbtnOutro.isSelected()== true) {
						paciente.setSexo("Outro");
					}
					
					PacienteDAO dao = new PacienteDAO();
					dao.salvar(paciente);
					lblMsgPaciente.setText("Paciente salvo com sucesso !");
					} catch (Exception e1) {
					lblMsgPaciente.setText("Erro ao Salvar paciente !");
					e1.printStackTrace();
					}
				//====================================================
			}
		});
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnPaciente.add(mntmSalvar);
		
		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================================================
				try {
					Paciente paciente = new Paciente();
					paciente.setCpf(txtCpf.getText());
					paciente.setNome(txtNome.getText());
					paciente.setNascimento(txtNascimento.getText());
					paciente.setTel(txtTel.getText());
					paciente.setConvenio((String)cmbConvenio.getSelectedItem());
					paciente.setEmail(txtEmail.getText());
					paciente.setEndereco(txtEndereco.getText());
					paciente.setCidade(txtCidade.getText());
					paciente.setEstado((String)cmbEstado.getSelectedItem());
					if(rdbtnMasculino.isSelected()== true){
						paciente.setSexo("Masculino");
					} else if(rdbtnFeminino.isSelected()== true) {
						paciente.setSexo("Feminino");
					} else if(rdbtnOutro.isSelected()== true) {
						paciente.setSexo("Outro");
					}
					
					PacienteDAO dao = new PacienteDAO();
					dao.alterar(paciente);
					lblMsgPaciente.setText("Paciente alterado com sucesso !");
					} catch (Exception e1) {
					lblMsgPaciente.setText("Erro ao alterar paciente !");
					e1.printStackTrace();
					}
				//====================================================
				
				}
		});
		mntmAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnPaciente.add(mntmAlterar);
		
		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===================================================
				String cpf = txtCpf.getText();
				try {
					dao = new PacienteDAO();
					paciente = dao.consultar(cpf);
					txtNome.setText(paciente.getNome());
					//preenchendo radio button de acordo com o valor registrado no BD
					if(paciente.getSexo().equals("Masculino")){
						rdbtnMasculino.setSelected(true);
					} else if(paciente.getSexo().equals("Feminino")) {
						rdbtnFeminino.setSelected(true);
					} else if(paciente.getSexo().equals("Outro")) {
						rdbtnOutro.setSelected(true);;
					}
					//convertendo data MySql em data formato brasileiro----
					String nascimento = data.mysqlBrasilianDate(paciente.getNascimento());
					
					//preenchendo componente data de nascimento convertido
					txtNascimento.setText(nascimento);
					
					txtTel.setText(paciente.getTel());
					//------consultando combobox convenio------
					if(paciente.getConvenio().equals("Particular")) {
						cmbConvenio.setSelectedIndex(0);
					}else if(paciente.getConvenio().equals("OdontoPrev")) {
						cmbConvenio.setSelectedIndex(1);
					}else if(paciente.getConvenio().equals("Amil Dental")) {
						cmbConvenio.setSelectedIndex(2);
					}else if(paciente.getConvenio().equals("InterOdonto")) {
						cmbConvenio.setSelectedIndex(3);
					}else {
						cmbConvenio.setSelectedIndex(4);
					}
					txtEmail.setText(paciente.getEmail());
					txtEndereco.setText(paciente.getEndereco());
					txtCidade.setText(paciente.getCidade());
					//-------consultando combobox estado----------
					if(paciente.getEstado().equals("SP")) {
						cmbEstado.setSelectedIndex(0);
					}else if(paciente.getEstado().equals("MG")) {
						cmbEstado.setSelectedIndex(1);
					}else if(paciente.getEstado().equals("RJ")) {
						cmbEstado.setSelectedIndex(2);;
					}else if(paciente.getEstado().equals("BA")) {
						cmbEstado.setSelectedIndex(3);
					}else 
						cmbEstado.setSelectedIndex(4);										
					}catch(Exception e1){
					lblMsgPaciente.setText(e1.getMessage());
				}
				//===================================================
			}
		});
		mntmConsultar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnPaciente.add(mntmConsultar);
		
		separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		mnPaciente.add(separator);
		
		mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=====================================================
				try {
					dao = new PacienteDAO();
					String cpf = txtCpf.getText();
					dao.excluir(cpf);
					lblMsgPaciente.setText("Paciente excluido com Sucesso!");
				} catch (Exception e1) {
					lblMsgPaciente.setText("Erro ao excluir paciente" + e1.getMessage());
				}
				//=====================================================
			}
		});
		mntmExcluir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnPaciente.add(mntmExcluir);
		
		mnTratamento = new JMenu("Tratamento");
		menuBar.add(mnTratamento);
		
		menuSavarTratamento = new JMenuItem("Salvar");
		menuSavarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//====================================================
				try {
					Tratamento tratamento = new Tratamento();
					tratamento.setCodTratamento(Integer.parseInt(txtCodTratamento.getText()));
					tratamento.setTratamento((String)cmbTratamento.getSelectedItem());
					tratamento.setTipo((String)cmbTipo.getSelectedItem());
					tratamento.setValor(Double.parseDouble(txtValor.getText()));
					TratamentoDAO tdao = new TratamentoDAO();
					tdao.salvar(tratamento);
					lblMsgTratamento.setText("Tratamento salvo com sucesso!");
					}catch(Exception e1) {
					lblMsgTratamento.setText("Erro ao salvar tratamento!");
					e1.printStackTrace();
				}
				//====================================================
			}
		});
		menuSavarTratamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.ALT_MASK));
		mnTratamento.add(menuSavarTratamento);
		
		menuAlterarTratamento = new JMenuItem("Alterar");
		menuAlterarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//================alterar====================================
				try {
					Tratamento tratamento =  new Tratamento();
					tratamento.setCodTratamento(Integer.parseInt(txtCodTratamento.getText()));
					tratamento.setTratamento((String)cmbTratamento.getSelectedItem());
					tratamento.setTipo((String)cmbTipo.getSelectedItem());
					tratamento.setValor(Double.parseDouble(txtValor.getText()));
					TratamentoDAO tdao = new TratamentoDAO();
					tdao.alterar(tratamento);
					lblMsgTratamento.setText("Tratamento alterado com sucesso!");
				}catch(Exception e1) {
					lblMsgTratamento.setText("Erro ao alterar tratamento!");
					e1.printStackTrace();
				}
				//====================================================
			}
		});
		menuAlterarTratamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnTratamento.add(menuAlterarTratamento);
		
		menuConsultarTratamento = new JMenuItem("Consultar");
		menuConsultarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===============consultar tratamento=======================
				int codTratamento = Integer.parseInt(txtCodTratamento.getText());
				try {
					tdao = new TratamentoDAO();
					tratamento = tdao.consultar(codTratamento);
					
					if(tratamento.getTratamento().equals("Tratamento")) {
						cmbTratamento.setSelectedIndex(0);
					}else if(tratamento.getTratamento().equals("Canal")) {
						cmbTratamento.setSelectedIndex(1);
					}else if(tratamento.getTratamento().equals("Abturação")) {
						cmbTratamento.setSelectedIndex(2);
					}else if(tratamento.getTratamento().equals("Implante")) {
						cmbTratamento.setSelectedIndex(3);
					}else if(tratamento.getTratamento().equals("Limpeza")) {
						cmbTratamento.setSelectedIndex(4);
					}else {
						cmbTratamento.setSelectedIndex(5);
					}
					
					if(tratamento.getTipo().equals("Procedimento")) {
						cmbTipo.setSelectedIndex(0);
					}else if(tratamento.getTipo().equals("Clínico")) {
						cmbTipo.setSelectedIndex(1);
					}else if(tratamento.getTipo().equals("Cirúrgico")) {
						cmbTipo.setSelectedIndex(2);
					}else  {
						cmbTipo.setSelectedIndex(3);
					}
					txtValor.setText(df.format(tratamento.getValor()));
					}catch(Exception e1) {
					lblMsgTratamento.setText("Erro ao consultar tratamento");
					e1.printStackTrace();
				}
				//===============================================
			}
		});
		menuConsultarTratamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnTratamento.add(menuConsultarTratamento);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		mnTratamento.add(separator_1);
		
		menuExcluirTratamento = new JMenuItem("Excluir");
		menuExcluirTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//================excluir tratamento==================
				try {
					tdao = new TratamentoDAO();
					int codTratamento = Integer.parseInt(txtCodTratamento.getText());
					tdao.excluir(codTratamento);
					lblMsgTratamento.setText("Tratamento excluido com sucesso!");
				}catch(Exception e1) {
					lblMsgTratamento.setText("Erro ao excluir tratamento!");
					e1.printStackTrace();
				}
				//====================================================
			}
		});
		menuExcluirTratamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.ALT_MASK));
		mnTratamento.add(menuExcluirTratamento);
		
		mnAgendamento = new JMenu("Agendamento");
		menuBar.add(mnAgendamento);
		
		menuSalvarAgendamento = new JMenuItem("Salvar");
		menuSalvarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===============salvar agendamento======================
				try {
					Agendamento agendamento = new Agendamento();
					agendamento.setData(txtData.getText());
					agendamento.setHorario(txtHorario.getText());
					agendamento.setTratamentoAgenda(Integer.parseInt(txtTratamentoAgenda.getText()));
					agendamento.setCpfAgenda(txtCpfAgenda.getText());
					adao = new AgendamentoDAO();
					adao.salvar(agendamento);
					lblMsgAgendamento.setText("Agendado com sucesso!");
					
				}catch(Exception e1) {
					lblMsgAgendamento.setText("Erro ao gravar agendamento!");
					e1.printStackTrace();
				}
			//======================================================
			}
		});
		menuSalvarAgendamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAgendamento.add(menuSalvarAgendamento);
		
		menuAlterarAgendamento = new JMenuItem("Alterar");
		menuAlterarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==============alterar agendamento======================
				try {
				Agendamento agendamento = new Agendamento();
				agendamento.setData(txtData.getText());
				agendamento.setHorario(txtHorario.getText());
				agendamento.setTratamentoAgenda(Integer.parseInt(txtTratamentoAgenda.getText()));
				agendamento.setCpfAgenda(txtCpfAgenda.getText());
				adao = new AgendamentoDAO();
				adao.alterar(agendamento);
				lblMsgAgendamento.setText("Agendamento alterado!");
				}catch(Exception e1) {
					lblMsgAgendamento.setText("Erro ao alterar agendamento!");
					e1.printStackTrace();
				}
				
				//====================================================
			}
		});
		menuAlterarAgendamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAgendamento.add(menuAlterarAgendamento);
		
		menuConsultarAgendamento = new JMenuItem("Consultar");
		menuConsultarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==============consultar agendamanento=================
				String cpf = txtCpfAgenda.getText();
				try {
					adao = new AgendamentoDAO();
					agendamento = adao.consultar(cpf);
				//--convertendo data no formato MySql yyyy/mm/dd para formato dia/mes/ano--
					dataAgendamento = data.mysqlBrasilianDate(agendamento.getData());
					txtData.setText(dataAgendamento);
				    txtHorario.setText(agendamento.getHorario());
				    txtTratamentoAgenda.setText(Integer.toString(agendamento.getTratamentoAgenda()));
										
				}catch(Exception e1) {
					lblMsgAgendamento.setText("Erro ao alterar agendamento!");
					e1.printStackTrace();
				}
				//=====================================================
			}
		});
		menuConsultarAgendamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAgendamento.add(menuConsultarAgendamento);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 0, 0));
		mnAgendamento.add(separator_2);
		
		menuExcluirAgendamento = new JMenuItem("Excluir");
		menuExcluirAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==================excluir agendamento==================
				try {
					adao = new AgendamentoDAO();
					String cpf = txtCpfAgenda.getText();
					adao.excluir(cpf);
					lblMsgAgendamento.setText("agendamento excuido!");
					
				}catch(Exception e1) {
					lblMsgAgendamento.setText("Erro ao alterar agendamento!");
					e1.printStackTrace();
				}
				//======================================================
			}
		});
		menuExcluirAgendamento.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnAgendamento.add(menuExcluirAgendamento);
		
		mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//=============================================
				JOptionPane.showMessageDialog(null, "System Developed by AugustoSouza");
				//=============================================
			}
		});
		mntmSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.ALT_MASK));
		mnAjuda.add(mntmSobre);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabbedPane.setForeground(Color.CYAN);
		tabbedPane.setToolTipText("");
		tabbedPane.setBounds(0, 0, 636, 409);
		tabbedPane.setBackground(Color.CYAN);
		contentPane.add(tabbedPane);
		
		panelPaciente = new JPanel();
		panelPaciente.setForeground(Color.CYAN);
		panelPaciente.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPaciente.setBackground(Color.CYAN);
		tabbedPane.addTab("Paciente", null, panelPaciente, null);
		tabbedPane.setBackgroundAt(0, Color.CYAN);
		tabbedPane.setForegroundAt(0, Color.GRAY);
		panelPaciente.setLayout(null);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setIcon(new ImageIcon("C:\\Users\\gulbo\\eclipse-workspace\\SmartOdonto\\Icones para botoes\\Listar.png"));
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCpf.setForeground(Color.BLUE);
		lblCpf.setBounds(10, 11, 55, 24);
		panelPaciente.add(lblCpf);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 46, 46, 14);
		panelPaciente.add(lblNome);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 81, 46, 14);
		panelPaciente.add(lblSexo);
		
		lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(10, 119, 95, 14);
		panelPaciente.add(lblDataDeNascimento);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 159, 46, 14);
		panelPaciente.add(lblTelefone);
		
		lblConvenio = new JLabel("Conv\u00EAnio");
		lblConvenio.setBounds(10, 194, 46, 14);
		panelPaciente.add(lblConvenio);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 228, 46, 14);
		panelPaciente.add(lblEmail);
		
		lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(10, 263, 46, 14);
		panelPaciente.add(lblEndereo);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 297, 46, 14);
		panelPaciente.add(lblCidade);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(332, 297, 46, 14);
		panelPaciente.add(lblEstado);
		
		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(89, 10, 380, 31);
		panelPaciente.add(txtCpf);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(89, 289, 190, 31);
		panelPaciente.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(89, 220, 380, 31);
		panelPaciente.add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(89, 255, 380, 31);
		panelPaciente.add(txtEndereco);
		
		txtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtNascimento.setOpaque(false);
		txtNascimento.setText("");
		txtNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		txtNascimento.setForeground(Color.CYAN);
		txtNascimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNascimento.setBounds(172, 111, 297, 31);
		panelPaciente.add(txtNascimento);
		
		txtTel = new JFormattedTextField(new MaskFormatter("(##) #-#### ####"));
		txtTel.setBounds(89, 151, 380, 31);
		panelPaciente.add(txtTel);
		
		cmbConvenio = new JComboBox();
		cmbConvenio.setModel(new DefaultComboBoxModel(new String[] {"Particular", "OdontoPrev", "Amil Dental", "InterOdonto", "Hapvida"}));
		cmbConvenio.setBounds(89, 189, 380, 25);
		panelPaciente.add(cmbConvenio);
		
		cmbEstado = new JComboBox();
		cmbEstado.setModel(new DefaultComboBoxModel(new String[] {"SP", "MG", "RJ", "BA", "SC"}));
		cmbEstado.setBounds(388, 292, 81, 25);
		panelPaciente.add(cmbEstado);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(89, 43, 380, 31);
		panelPaciente.add(txtNome);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rbgSexo.add(rdbtnMasculino);
		rdbtnMasculino.setBackground(Color.CYAN);
		rdbtnMasculino.setBounds(89, 77, 109, 23);
		panelPaciente.add(rdbtnMasculino);
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rbgSexo.add(rdbtnFeminino);
		rdbtnFeminino.setBackground(Color.CYAN);
		rdbtnFeminino.setBounds(223, 77, 109, 23);
		panelPaciente.add(rdbtnFeminino);
		
		rdbtnOutro = new JRadioButton("Outro");
		rbgSexo.add(rdbtnOutro);
		rdbtnOutro.setBackground(Color.CYAN);
		rdbtnOutro.setBounds(360, 77, 109, 23);
		panelPaciente.add(rdbtnOutro);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Paciente paciente = new Paciente();
					paciente.setCpf(txtCpf.getText());
					paciente.setNome(txtNome.getText());
					paciente.setNascimento(txtNascimento.getText());
					paciente.setTel(txtTel.getText());
					paciente.setConvenio((String)cmbConvenio.getSelectedItem());
					paciente.setEmail(txtEmail.getText());
					paciente.setEndereco(txtEndereco.getText());
					paciente.setCidade(txtCidade.getText());
					paciente.setEstado((String)cmbEstado.getSelectedItem());
					if(rdbtnMasculino.isSelected()== true){
						paciente.setSexo("Masculino");
					} else if(rdbtnFeminino.isSelected()== true) {
						paciente.setSexo("Feminino");
					} else if(rdbtnOutro.isSelected()== true) {
						paciente.setSexo("Outro");
					}
					
					PacienteDAO dao = new PacienteDAO();
					dao.salvar(paciente);
					lblMsgPaciente.setText("Paciente salvo com sucesso !");
					} catch (Exception e1) {
					lblMsgPaciente.setText("Erro ao Salvar paciente !");
					e1.printStackTrace();
					}		
				//================================================
			}
		});
		btnSalvar.setBounds(515, 14, 89, 23);
		panelPaciente.add(btnSalvar);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//================================================
				try {
					Paciente paciente = new Paciente();
					paciente.setCpf(txtCpf.getText());
					paciente.setNome(txtNome.getText());
					paciente.setNascimento(txtNascimento.getText());
					paciente.setTel(txtTel.getText());
					paciente.setConvenio((String)cmbConvenio.getSelectedItem());
					paciente.setEmail(txtEmail.getText());
					paciente.setEndereco(txtEndereco.getText());
					paciente.setCidade(txtCidade.getText());
					paciente.setEstado((String)cmbEstado.getSelectedItem());
					if(rdbtnMasculino.isSelected()== true){
						paciente.setSexo("Masculino");
					} else if(rdbtnFeminino.isSelected()== true) {
						paciente.setSexo("Feminino");
					} else if(rdbtnOutro.isSelected()== true) {
						paciente.setSexo("Outro");
					}
					
					PacienteDAO dao = new PacienteDAO();
					dao.alterar(paciente);
					lblMsgPaciente.setText("Paciente alterado com sucesso !");
					} catch (Exception e1) {
					lblMsgPaciente.setText("Erro ao alterar paciente !");
					e1.printStackTrace();
					}	
				//================================================
			}
		});
		btnAlterar.setBounds(515, 45, 89, 23);
		panelPaciente.add(btnAlterar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===============================================
				String cpf = txtCpf.getText();
				try {
					dao = new PacienteDAO();
					paciente = dao.consultar(cpf);
					txtNome.setText(paciente.getNome());
					//preenchendo radio button de acordo com o valor registrado no BD
					if(paciente.getSexo().equals("Masculino")){
						rdbtnMasculino.setSelected(true);
					} else if(paciente.getSexo().equals("Feminino")) {
						rdbtnFeminino.setSelected(true);
					} else if(paciente.getSexo().equals("Outro")) {
						rdbtnOutro.setSelected(true);;
					}
					//convertendo data MySql em data formato brasileiro----
					nascimento = data.mysqlBrasilianDate(paciente.getNascimento());
					
					//preenchendo componente data de nascimento convertido
					txtNascimento.setText(nascimento);
					
					txtTel.setText(paciente.getTel());
					//------consultando combobox convenio------
					if(paciente.getConvenio().equals("Particular")) {
						cmbConvenio.setSelectedIndex(0);
					}else if(paciente.getConvenio().equals("OdontoPrev")) {
						cmbConvenio.setSelectedIndex(1);
					}else if(paciente.getConvenio().equals("Amil Dental")) {
						cmbConvenio.setSelectedIndex(2);
					}else if(paciente.getConvenio().equals("InterOdonto")) {
						cmbConvenio.setSelectedIndex(3);
					}else {
						cmbConvenio.setSelectedIndex(4);
					}
					txtEmail.setText(paciente.getEmail());
					txtEndereco.setText(paciente.getEndereco());
					txtCidade.setText(paciente.getCidade());
					//-------consultando combobox estado----------
					if(paciente.getEstado().equals("SP")) {
						cmbEstado.setSelectedIndex(0);
					}else if(paciente.getEstado().equals("MG")) {
						cmbEstado.setSelectedIndex(1);
					}else if(paciente.getEstado().equals("RJ")) {
						cmbEstado.setSelectedIndex(2);;
					}else if(paciente.getEstado().equals("BA")) {
						cmbEstado.setSelectedIndex(3);
					}else 
						cmbEstado.setSelectedIndex(4);										
					}catch(Exception e1){
					lblMsgPaciente.setText(e1.getMessage());
				}
				//===============================================
			}
		});
		btnConsultar.setBounds(515, 77, 89, 23);
		panelPaciente.add(btnConsultar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//==============excluir==========================
				try {
					dao = new PacienteDAO();
					String cpf = txtCpf.getText();
					dao.excluir(cpf);
					lblMsgPaciente.setText("Paciente excluido com Sucesso!");
				} catch (Exception e1) {
					lblMsgPaciente.setText("Erro ao excluir paciente" + e1.getMessage());
				}
				//=============================================
			}
		});
		btnExcluir.setBounds(515, 145, 89, 23);
		panelPaciente.add(btnExcluir);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===============================================
				txtCpf.setText(null);
				txtNome.setText(null);
				rbgSexo.clearSelection();
				txtNascimento.setText(null);
				txtTel.setText(null);
				cmbConvenio.setSelectedIndex(0);
				txtEmail.setText(null);
				txtEndereco.setText(null);
				txtCidade.setText(null);
				cmbEstado.setSelectedIndex(0);
				lblMsgPaciente.setText(null);
				//===============================================
			}
		});
		btnLimpar.setBounds(515, 179, 89, 23);
		panelPaciente.add(btnLimpar);
		
		lblMsgPaciente = new JLabel("");
		lblMsgPaciente.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblMsgPaciente.setBounds(10, 331, 607, 23);
		panelPaciente.add(lblMsgPaciente);
		
		panelTratamento = new JPanel();
		tabbedPane.addTab("Tratamento", (Icon) null, panelTratamento, null);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		tabbedPane.setForegroundAt(1, Color.BLUE);
		panelTratamento.setLayout(null);
		
		lblCdigoDoTratamento = new JLabel("C\u00F3digo do Tratamento");
		lblCdigoDoTratamento.setBounds(10, 36, 107, 14);
		panelTratamento.add(lblCdigoDoTratamento);
		
		lblTratamento = new JLabel("Tratamento");
		lblTratamento.setBounds(10, 78, 56, 14);
		panelTratamento.add(lblTratamento);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 120, 20, 14);
		panelTratamento.add(lblTipo);
		
		lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 159, 24, 14);
		panelTratamento.add(lblValor);
		
		btnSalvarTratamento = new JButton("Salvar");
		btnSalvarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//====================================================
				try {
					Tratamento tratamento = new Tratamento();
					tratamento.setCodTratamento(Integer.parseInt(txtCodTratamento.getText()));
					tratamento.setTratamento((String)cmbTratamento.getSelectedItem());
					tratamento.setTipo((String)cmbTipo.getSelectedItem());
					tratamento.setValor(Double.parseDouble(txtValor.getText()));
					TratamentoDAO tdao = new TratamentoDAO();
					tdao.salvar(tratamento);
					lblMsgTratamento.setText("Tratamento salvo com sucesso!");
					}catch(Exception e1) {
					lblMsgTratamento.setText("Erro ao salvar tratamento!");
					e1.printStackTrace();
				}
				//====================================================
			}
		});
		btnSalvarTratamento.setBounds(528, 11, 89, 23);
		panelTratamento.add(btnSalvarTratamento);
		
		btnAlterarTratamento = new JButton("Alterar");
		btnAlterarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//================alterar====================================
				try {
					Tratamento tratamento =  new Tratamento();
					tratamento.setCodTratamento(Integer.parseInt(txtCodTratamento.getText()));
					tratamento.setTratamento((String)cmbTratamento.getSelectedItem());
					tratamento.setTipo((String)cmbTipo.getSelectedItem());
					tratamento.setValor(Double.parseDouble(txtValor.getText()));
					TratamentoDAO tdao = new TratamentoDAO();
					tdao.alterar(tratamento);
					lblMsgTratamento.setText("Tratamento alterado com sucesso!");
				}catch(Exception e1) {
					lblMsgTratamento.setText("Erro ao alterar tratamento!");
					e1.printStackTrace();
				}
				//====================================================
			}
		});
		btnAlterarTratamento.setBounds(528, 45, 89, 23);
		panelTratamento.add(btnAlterarTratamento);
		
		btnExcluirTratamento = new JButton("Excluir");
		btnExcluirTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//================excluir tratamento==================
				try {
					tdao = new TratamentoDAO();
					int codTratamento = Integer.parseInt(txtCodTratamento.getText());
					tdao.excluir(codTratamento);
					lblMsgTratamento.setText("Tratamento excluido com sucesso!");
				}catch(Exception e1) {
					lblMsgTratamento.setText("Erro ao excluir tratamento!");
					e1.printStackTrace();
				}
				//====================================================
			}
		});
		btnExcluirTratamento.setBounds(528, 116, 89, 23);
		panelTratamento.add(btnExcluirTratamento);
		
		btnLimparTratamento = new JButton("Limpar");
		btnLimparTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//==================================================
				txtCodTratamento.setText(null);
				cmbTratamento.setSelectedIndex(0);
				cmbTipo.setSelectedIndex(0);
				txtValor.setText(null);
				lblMsgTratamento.setText(null);
			//==================================================
			}
		});
		btnLimparTratamento.setBounds(528, 155, 89, 23);
		panelTratamento.add(btnLimparTratamento);
		
		btnConsultarTratamento = new JButton("Consultar");
		btnConsultarTratamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===============consultar===============================
				int codTratamento = Integer.parseInt(txtCodTratamento.getText());
				try {
					tdao = new TratamentoDAO();
					tratamento = tdao.consultar(codTratamento);
					
					if(tratamento.getTratamento().equals("Tratamento")) {
						cmbTratamento.setSelectedIndex(0);
					}else if(tratamento.getTratamento().equals("Canal")) {
						cmbTratamento.setSelectedIndex(1);
					}else if(tratamento.getTratamento().equals("Abturação")) {
						cmbTratamento.setSelectedIndex(2);
					}else if(tratamento.getTratamento().equals("Implante")) {
						cmbTratamento.setSelectedIndex(3);
					}else if(tratamento.getTratamento().equals("Limpeza")) {
						cmbTratamento.setSelectedIndex(4);
					}else {
						cmbTratamento.setSelectedIndex(5);
					}
					
					if(tratamento.getTipo().equals("Procedimento")) {
						cmbTipo.setSelectedIndex(0);
					}else if(tratamento.getTipo().equals("Clínico")) {
						cmbTipo.setSelectedIndex(1);
					}else if(tratamento.getTipo().equals("Cirúrgico")) {
						cmbTipo.setSelectedIndex(2);
					}else  {
						cmbTipo.setSelectedIndex(3);
					}
					txtValor.setText("R$ " + df.format(tratamento.getValor()));
					}catch(Exception e1) {
					lblMsgTratamento.setText("Erro ao consultar tratamento");
					e1.printStackTrace();
				}
				//===============================================
			}
		});
		btnConsultarTratamento.setBounds(528, 82, 89, 23);
		panelTratamento.add(btnConsultarTratamento);
		
		cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"Procedimento", "Cl\u00EDnico", "Cir\u00FArgico", "Est\u00E9tico"}));
		cmbTipo.setBounds(177, 117, 304, 20);
		panelTratamento.add(cmbTipo);
		
		cmbTratamento = new JComboBox();
		cmbTratamento.setOpaque(false);
		cmbTratamento.setModel(new DefaultComboBoxModel(new String[] {"Tratamento", "Canal", "Abtura\u00E7\u00E3o", "Implante", "Limpeza", "Clareamento"}));
		cmbTratamento.setBounds(177, 75, 304, 20);
		panelTratamento.add(cmbTratamento);
		
		txtCodTratamento = new JFormattedTextField(new MaskFormatter("####"));
		txtCodTratamento.setSelectedTextColor(Color.GREEN);
		txtCodTratamento.setSelectionColor(Color.RED);
		txtCodTratamento.setOpaque(false);
		txtCodTratamento.setBounds(177, 33, 304, 20);
		panelTratamento.add(txtCodTratamento);
		
		lblMsgTratamento = new JLabel("");
		lblMsgTratamento.setForeground(Color.BLACK);
		lblMsgTratamento.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblMsgTratamento.setBounds(10, 343, 607, 23);
		panelTratamento.add(lblMsgTratamento);
		
		txtValor = new JTextField();
		txtValor.setOpaque(false);
		txtValor.setBounds(177, 156, 304, 20);
		panelTratamento.add(txtValor);
		txtValor.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\gulbo\\eclipse-workspace\\SmartOdonto\\Icones para botoes\\Smart Odonto.jpg"));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(0, 0, 627, 377);
		panelTratamento.add(lblNewLabel_1);
		
		panelAgendamento = new JPanel();
		tabbedPane.addTab("Agendamento", null, panelAgendamento, null);
		tabbedPane.setForegroundAt(2, Color.GRAY);
		panelAgendamento.setLayout(null);
		
		lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setBounds(10, 21, 46, 14);
		panelAgendamento.add(lblCpf_1);
		
		lblData = new JLabel("Data");
		lblData.setBounds(10, 69, 46, 14);
		panelAgendamento.add(lblData);
		
		lblHorrio = new JLabel("Hor\u00E1rio");
		lblHorrio.setBounds(10, 117, 46, 14);
		panelAgendamento.add(lblHorrio);
		
		lblTratamento_1 = new JLabel("Tratamento");
		lblTratamento_1.setBounds(10, 165, 56, 14);
		panelAgendamento.add(lblTratamento_1);
		
		txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtData.setBounds(114, 59, 322, 35);
		panelAgendamento.add(txtData);
		
		txtCpfAgenda = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpfAgenda.setBounds(114, 11, 322, 35);
		panelAgendamento.add(txtCpfAgenda);
		
		txtHorario = new JFormattedTextField(new MaskFormatter("##:##:##"));
		txtHorario.setBounds(114, 107, 322, 35);
		panelAgendamento.add(txtHorario);
		
		btnSalvarAgemdamento = new JButton("Salvar");
		btnSalvarAgemdamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//===============salvar agendamento======================
				try {
					Agendamento agendamento = new Agendamento();
					agendamento.setData(txtData.getText());
					agendamento.setHorario(txtHorario.getText());
					agendamento.setTratamentoAgenda(Integer.parseInt(txtTratamentoAgenda.getText()));
					agendamento.setCpfAgenda(txtCpfAgenda.getText());
					adao = new AgendamentoDAO();
					adao.salvar(agendamento);
					lblMsgAgendamento.setText("Agendado com sucesso!");
					
				}catch(Exception e) {
					lblMsgAgendamento.setText("Erro ao gravar agendamento!");
					e.printStackTrace();
				}
			//======================================================
			}
		});
		btnSalvarAgemdamento.setBounds(517, 20, 89, 23);
		panelAgendamento.add(btnSalvarAgemdamento);
		
		btnAlterarAgendamento = new JButton("Alterar");
		btnAlterarAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==============alterar agendamento======================
				try {
				Agendamento agendamento = new Agendamento();
				agendamento.setData(txtData.getText());
				agendamento.setHorario(txtHorario.getText());
				agendamento.setTratamentoAgenda(Integer.parseInt(txtTratamentoAgenda.getText()));
				agendamento.setCpfAgenda(txtCpfAgenda.getText());
				adao = new AgendamentoDAO();
				adao.alterar(agendamento);
				lblMsgAgendamento.setText("Agendamento alterado!");
				}catch(Exception e1) {
					lblMsgAgendamento.setText("Erro ao alterar agendamento!");
					e1.printStackTrace();
				}
				
				//====================================================
			}
		});
		btnAlterarAgendamento.setBounds(517, 56, 89, 23);
		panelAgendamento.add(btnAlterarAgendamento);
		
		btnConsultaAgendamento = new JButton("Consultar");
		btnConsultaAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==============consultar agendamaneto=================
				String cpf = txtCpfAgenda.getText();
				try {
					adao = new AgendamentoDAO();
					agendamento = adao.consultar(cpf);
				//--convertendo data no formato MySql yyyy/mm/dd para formato dia/mes/ano--
					dataAgendamento = data.mysqlBrasilianDate(agendamento.getData());
					txtData.setText(dataAgendamento);
				    txtHorario.setText(agendamento.getHorario());
				    txtTratamentoAgenda.setText(Integer.toString(agendamento.getTratamentoAgenda()));
										
				}catch(Exception e1) {
					lblMsgAgendamento.setText("Erro ao alterar agendamento!");
					e1.printStackTrace();
				}
				//=====================================================
			}
		});
		btnConsultaAgendamento.setBounds(517, 90, 89, 23);
		panelAgendamento.add(btnConsultaAgendamento);
		
		btnExcluirAgendamento = new JButton("Excluir");
		btnExcluirAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==================excluir agendamento====================================
				try {
					adao = new AgendamentoDAO();
					String cpf = txtCpfAgenda.getText();
					adao.excluir(cpf);
					lblMsgAgendamento.setText("agendamento excuido!");
					
				}catch(Exception e1) {
					lblMsgAgendamento.setText("Erro ao alterar agendamento!");
					e1.printStackTrace();
				}
				//======================================================
			}
		});
		btnExcluirAgendamento.setBounds(517, 124, 89, 23);
		panelAgendamento.add(btnExcluirAgendamento);
		
		btnLimparAgendamento = new JButton("Limpar");
		btnLimparAgendamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//================================================
				txtCpfAgenda.setText(null);
				txtData.setText(null);
				txtHorario.setText(null);
				txtTratamentoAgenda.setText(null);
				lblMsgAgendamento.setText(null);
				//================================================
			}
		});
		btnLimparAgendamento.setBounds(517, 166, 89, 23);
		panelAgendamento.add(btnLimparAgendamento);
		
		lblMsgAgendamento = new JLabel("");
		lblMsgAgendamento.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblMsgAgendamento.setBounds(10, 200, 596, 23);
		panelAgendamento.add(lblMsgAgendamento);
		
		txtTratamentoAgenda = new JFormattedTextField(new MaskFormatter("####"));
		txtTratamentoAgenda.setBounds(114, 153, 322, 29);
		panelAgendamento.add(txtTratamentoAgenda);
		
		panelListagem = new JPanel();
		panelListagem.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new LineBorder(new Color(0, 139, 139), 5, true)));
		panelListagem.setBackground(new Color(0, 255, 255));
		tabbedPane.addTab("Listagem", null, panelListagem, null);
		tabbedPane.setBackgroundAt(3, SystemColor.textHighlight);
		tabbedPane.setForegroundAt(3, SystemColor.text);
		panelListagem.setLayout(null);
		
		txtLisagem = new TextArea();
		txtLisagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLisagem.setForeground(Color.DARK_GRAY);
		txtLisagem.setBackground(Color.CYAN);
		txtLisagem.setBounds(10, 50, 607, 288);
		panelListagem.add(txtLisagem);
		
		btnListarPacientes = new JButton("Listar Pacientes");
		btnListarPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========================================================
				try {
					List<Paciente> lista = new ArrayList<Paciente>();
					dao = new PacienteDAO();
					lista = dao.listarTodos();
					for(Paciente paciente : lista) {
						txtLisagem.append("\n\t\t\b P A C I E N T E: \b"+ paciente.getNome()+"\n");
						txtLisagem.append("Cpf do Paciente: " + paciente.getCpf() + "\n");
						txtLisagem.append("Sexo :"+ paciente.getSexo()+"\n");
						nascimento = data.mysqlBrasilianDate(paciente.getNascimento());
						txtLisagem.append("Data de Nascimento: "+ nascimento + "\n");
						txtLisagem.append("Telefone: " + paciente.getTel() + "\n");
						txtLisagem.append("Convênio..." + paciente.getConvenio() + "\n");
						txtLisagem.append("Email: " + paciente.getEmail() + "\n");
						txtLisagem.append("Esndereço: " + paciente.getEstado() + "\n");
						txtLisagem.append("Cidade: " + paciente.getCidade() + "\n");
						txtLisagem.append("Estado: " + paciente.getEstado() + "\n");
											}
				}catch(Exception e1) {
					lblListagem.setText("Erro ao Listar");
					e1.printStackTrace();
				}
				//==========================================================
			}
		});
		btnListarPacientes.setBounds(10, 11, 142, 33);
		panelListagem.add(btnListarPacientes);
		
		btnListarTratamentos = new JButton("Listar Tratamentos");
		btnListarTratamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========================================================
				try {
					List<Tratamento> lista = new ArrayList<Tratamento>();//estanciando array list do tipo Tratamento...
					tdao = new TratamentoDAO();
					lista = tdao.listarTodos();
					for(Tratamento tratamento : lista) {
						txtLisagem.append("\n\t\t\b T R A T A M E N T O: \b" + tratamento.getTratamento() + "\n");
						txtLisagem.append("Código do tratamento: " + tratamento.getCodTratamento() + "\n");
						txtLisagem.append("Tipo do tratamento: " + tratamento.getTipo() + "\n");
						txtLisagem.append("Valor do tratamento: " + tratamento.getValor() + "\n");
						txtLisagem.append("====================================================");
					}
					
				}catch(Exception e1) {
					lblListagem.setText("Erro ao listar tratamentos!");
					e1.printStackTrace();
				}
				//==========================================================
			}
		});
		btnListarTratamentos.setBounds(162, 11, 147, 33);
		panelListagem.add(btnListarTratamentos);
		
		btnListarAgenda = new JButton("Listar Agenda");
		btnListarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//==========================================================
				try {
					List<Agendamento> lista = new ArrayList<Agendamento>();
					adao = new AgendamentoDAO();
					lista = adao.listarTodos();
					for(Agendamento agendamento : lista) {
						txtLisagem.append("\n\t\t\b A G E N D A M E N T O: Nº " + agendamento.getCodAgendamento() + " \b\n");
						dataAgendamento = data.mysqlBrasilianDate(agendamento.getData());
						txtLisagem.append("Data da consulta: " + dataAgendamento + "\n");
						txtLisagem.append("horario: " + agendamento.getHorario() + "\n");
						txtLisagem.append("CPF do paciente: " + agendamento.getCpfAgenda() + "\n");
						txtLisagem.append("====================================================");	
					}
					
				}catch(Exception e1) {
					lblListagem.setText("Erro ao listar tratamentos!");
					e1.printStackTrace();
				}
				//==========================================================
			}
		});
		btnListarAgenda.setBounds(319, 11, 160, 33);
		panelListagem.add(btnListarAgenda);
		
		btnLimpar_2 = new JButton("Limpar");
		btnLimpar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//===================================================
				txtLisagem.setText(null);
				//===================================================
			}
		});
		btnLimpar_2.setBounds(489, 11, 128, 33);
		panelListagem.add(btnLimpar_2);
		
		lblListagem = new JLabel("");
		lblListagem.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblListagem.setBounds(10, 344, 607, 23);
		panelListagem.add(lblListagem);
	}
}
