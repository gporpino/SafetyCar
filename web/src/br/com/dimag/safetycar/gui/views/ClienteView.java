package br.com.dimag.safetycar.gui.views;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import br.com.dimag.safetycar.business.Facade;
import br.com.dimag.safetycar.exception.FacadeException;
import br.com.dimag.safetycar.exception.ValidatorException;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.Endereco;
import br.com.dimag.safetycar.model.UF;
import br.com.dimag.safetycar.model.Pessoa.TipoEndereco;
import br.com.dimag.safetycar.model.Pessoa.TipoPessoa;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ClienteView extends BasicView {

	public static final String ID = "SafetyCar.client";
	private Group groupDadosPessoais;
	// ENDERE�O
	private Label labelEndereco;
	private Text textEnderecoLogradouro;

	// ENDERE�O BAIRRO
	private Label labelEnderecoBairro;
	private Text textEnderecoBairro;
	// ENDERE�O MUNICIPIO
	private Label labelEnderecoMunicipio;
	private Text textEnderecoMunicipio;
	// ENDERE�O CEP
	private Label labelEnderecoCep;
	private Text textEnderecoCep;
	// CCOMBO UF
	private CCombo cComboUf;
	private Label labelUf;
	// CCOMBO TIPO ENDERE�O
	private CCombo cComboTipoEndereco;
	private Label labelTipoEndereco;
	// LABEL ERROS
	private Label labelErro;
	private Text textEnderecoNumero;
	private Label labelNumero;
	private Text textEnderecoComplemento;
	private Label labelComplemento;
	// CPF CNPJ
	private Label labelCpfCnpj;
	private Text textCpfCnpj;

	// TELEFONE
	private Text textTelefone;
	private Label labelTelefone;

	// TELEFONE COMERCIAL
	private Text textTelefoneComercial;
	private Label labelTelefoneComercial;

	// TELEFONE CELULAR
	private Text textTelefoneCelular;
	private Label labelTelefoneCelular;

	// BOT�ES DE CONFIRMA E CANCELAR
	private Button buttonCancelar;
	private Button buttonConfirma;

	// CCOMBO TIPOPESSOA
	private CCombo cComboTipoPessoa;
	private Label labelTipoPessoa;

	// NOME - RAZ�O SOCIAL
	private Label labelNomeCliente;
	private Text textNomeCliente;
	// NOME APELIDO - NOME FANTASIA
	private Label labelApelidoFantasia;
	private Text textApelidoFantasia;

	private Cliente cliente;

	private Endereco endereco;

	@Override
	public void createPartControl(Composite composite) {

		{
			composite.setSize(484, 418);
			{
				groupDadosPessoais = new Group(composite, SWT.NONE);
				GridLayout dadosPessoaisLayout = new GridLayout();
				dadosPessoaisLayout.numColumns = 2;
				groupDadosPessoais.setLayout(dadosPessoaisLayout);
				groupDadosPessoais.setText("Dados Pessoais");
				groupDadosPessoais.setSize(243, 215);

				// TIPO PESSOA
				{
					labelTipoPessoa = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelUfLData = new GridData();
					labelUfLData.horizontalAlignment = GridData.FILL;
					labelTipoPessoa.setLayoutData(labelUfLData);
					labelTipoPessoa.setText("Tipo Pessoa:");
				}
				{
					cComboTipoPessoa = new CCombo(groupDadosPessoais, SWT.NONE);
					GridData cComboUfLData = new GridData();
					cComboUfLData.horizontalAlignment = GridData.FILL;
					cComboUfLData.grabExcessHorizontalSpace = true;
					cComboUfLData.widthHint = 155;
					cComboUfLData.heightHint = 16;
					cComboTipoPessoa.setLayoutData(cComboUfLData);
				}

				// NOME CLIENTE - RAZ�O SOCIAL

				{
					labelNomeCliente = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelNomeClienteLData = new GridData();
					labelNomeClienteLData.horizontalAlignment = GridData.FILL;
					labelNomeCliente.setLayoutData(labelNomeClienteLData);
					labelNomeCliente.setText("Nome:");
				}
				{
					textNomeCliente = new Text(groupDadosPessoais, SWT.NONE);
					GridData nomeClienteLData = new GridData();
					nomeClienteLData.heightHint = 13;
					nomeClienteLData.horizontalAlignment = GridData.FILL;
					nomeClienteLData.grabExcessHorizontalSpace = true;
					textNomeCliente.setLayoutData(nomeClienteLData);
				}

				// APELIDO-NOME FANTASIA

				{
					labelApelidoFantasia = new Label(groupDadosPessoais,
							SWT.NONE);
					labelApelidoFantasia.setText("Apelido/Nome Fantasia:");
				}
				{
					textApelidoFantasia = new Text(groupDadosPessoais, SWT.NONE);
					GridData nomeClienteLData = new GridData();
					nomeClienteLData.heightHint = 13;
					nomeClienteLData.horizontalAlignment = GridData.FILL;
					nomeClienteLData.grabExcessHorizontalSpace = true;
					textApelidoFantasia.setLayoutData(nomeClienteLData);
				}

				// CPF CNPJ
				{
					labelCpfCnpj = new Label(groupDadosPessoais, SWT.NONE);
					labelCpfCnpj.setText("CPF/CNPJ:");
				}
				{
					textCpfCnpj = new Text(groupDadosPessoais, SWT.NONE);
					GridData nomeClienteLData = new GridData();
					nomeClienteLData.heightHint = 13;
					nomeClienteLData.horizontalAlignment = GridData.FILL;
					nomeClienteLData.grabExcessHorizontalSpace = true;
					textCpfCnpj.setLayoutData(nomeClienteLData);
				}
				{
					labelEnderecoCep = new Label(groupDadosPessoais, SWT.NONE);
					labelEnderecoCep.setText("Cep:");
				}
				{
					GridData Endere�oLData = new GridData();
					Endere�oLData.heightHint = 13;
					Endere�oLData.horizontalAlignment = GridData.FILL;
					Endere�oLData.grabExcessHorizontalSpace = true;
					textEnderecoCep = new Text(groupDadosPessoais, SWT.NONE);
					textEnderecoCep.setLayoutData(Endere�oLData);
					textEnderecoCep.addFocusListener(new FocusListener() {

						@Override
						public void focusGained(FocusEvent arg0) {
							// TODO Auto-generated method stub
						}

						@Override
						public void focusLost(FocusEvent arg0) {
							checkCep();
						}
					});
				}

				// CCOMBO TIPO ENDERE�O
				{
					labelTipoEndereco = new Label(groupDadosPessoais, SWT.NONE);
					labelTipoEndereco.setText("Tipo Endere�o:");
					GridData labelTipoEnderecoLData = new GridData();
					labelTipoEnderecoLData.horizontalAlignment = GridData.FILL;
					labelTipoEndereco.setLayoutData(labelTipoEnderecoLData);
				}
				{
					cComboTipoEndereco = new CCombo(groupDadosPessoais,
							SWT.NONE);
					GridData cComboTipoEnderecoLData = new GridData();
					cComboTipoEnderecoLData.horizontalAlignment = GridData.FILL;
					cComboTipoEnderecoLData.grabExcessHorizontalSpace = true;
					cComboTipoEnderecoLData.heightHint = 16;
					cComboTipoEnderecoLData.widthHint = 155;
					cComboTipoEndereco.setLayoutData(cComboTipoEnderecoLData);
				}
				// LOGRADOURO
				{
					labelEndereco = new Label(groupDadosPessoais, SWT.NONE);
					labelEndereco.setText("Endere�o:");
				}
				{
					GridData Endere�oLData = new GridData();
					Endere�oLData.horizontalAlignment = GridData.FILL;
					Endere�oLData.widthHint = 149;
					Endere�oLData.heightHint = 13;
					Endere�oLData.grabExcessHorizontalSpace = true;
					textEnderecoLogradouro = new Text(groupDadosPessoais, SWT.NONE);
					textEnderecoLogradouro.setLayoutData(Endere�oLData);
				}

				// BAIRRO
				{
					labelNumero = new Label(groupDadosPessoais, SWT.NONE);
					labelNumero.setText("N�mero:");
				}
				{
					GridData textEnderecoNumeroLData = new GridData();
					textEnderecoNumeroLData.grabExcessHorizontalSpace = true;
					textEnderecoNumeroLData.horizontalAlignment = SWT.FILL;
					textEnderecoNumero = new Text(groupDadosPessoais, SWT.NONE);
					textEnderecoNumero.setLayoutData(textEnderecoNumeroLData);
				}
				{
					labelComplemento = new Label(groupDadosPessoais, SWT.NONE);
					labelComplemento.setText("Complemento:");
				}
				{
					GridData textEnderecoComplementoLData = new GridData();
					textEnderecoComplementoLData.grabExcessHorizontalSpace = true;
					textEnderecoComplementoLData.horizontalAlignment = SWT.FILL;
					textEnderecoComplemento = new Text(groupDadosPessoais,
							SWT.NONE);
					textEnderecoComplemento
							.setLayoutData(textEnderecoComplementoLData);
				}
				{
					labelEnderecoBairro = new Label(groupDadosPessoais,
							SWT.NONE);
					labelEnderecoBairro.setText("Bairro:");
				}
				{
					GridData Endere�oLData = new GridData();
					Endere�oLData.heightHint = 13;
					Endere�oLData.horizontalAlignment = GridData.FILL;
					Endere�oLData.grabExcessHorizontalSpace = true;
					textEnderecoBairro = new Text(groupDadosPessoais, SWT.NONE);
					textEnderecoBairro.setLayoutData(Endere�oLData);
				}

				// MUNICIPIO
				{
					labelEnderecoMunicipio = new Label(groupDadosPessoais,
							SWT.NONE);
					labelEnderecoMunicipio.setText("Cidade:");
				}
				{
					GridData Endere�oLData = new GridData();
					Endere�oLData.heightHint = 13;
					Endere�oLData.horizontalAlignment = GridData.FILL;
					Endere�oLData.grabExcessHorizontalSpace = true;
					textEnderecoMunicipio = new Text(groupDadosPessoais,
							SWT.NONE);
					textEnderecoMunicipio.setLayoutData(Endere�oLData);
				}

				// CEP

				// LABEL UF
				{
					labelUf = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelUfLData = new GridData();
					labelUfLData.horizontalAlignment = GridData.FILL;
					labelUf.setLayoutData(labelUfLData);
					labelUf.setText("UF:");
				}
				// CCOMBO UF
				{
					cComboUf = new CCombo(groupDadosPessoais, SWT.NONE);
					GridData cComboUfLData = new GridData();
					cComboUfLData.horizontalAlignment = GridData.FILL;
					cComboUfLData.grabExcessHorizontalSpace = true;
					cComboUfLData.widthHint = 155;
					cComboUfLData.heightHint = 16;
					cComboUfLData.verticalAlignment = GridData.BEGINNING;
					cComboUf.setLayoutData(cComboUfLData);
				}
				// TELEFONE
				{
					labelTelefone = new Label(groupDadosPessoais, SWT.NONE);
					labelTelefone.setText("Telefone:");
				}
				{
					GridData textTelefoneLData = new GridData();
					textTelefoneLData.grabExcessHorizontalSpace = true;
					textTelefoneLData.horizontalAlignment = GridData.FILL;
					textTelefone = new Text(groupDadosPessoais, SWT.NONE);
					textTelefone.setLayoutData(textTelefoneLData);
				}

				// TELEFONE COMERCIAL
				{
					labelTelefoneComercial = new Label(groupDadosPessoais,
							SWT.NONE);
					labelTelefoneComercial.setText("Telefone Comercial:");
				}
				{
					GridData textTelefoneLData = new GridData();
					textTelefoneLData.grabExcessHorizontalSpace = true;
					textTelefoneLData.horizontalAlignment = GridData.FILL;
					textTelefoneComercial = new Text(groupDadosPessoais,
							SWT.NONE);
					textTelefoneComercial.setLayoutData(textTelefoneLData);
				}

				// TELEFONE CELULAR
				{
					labelTelefoneCelular = new Label(groupDadosPessoais,
							SWT.NONE);
					labelTelefoneCelular.setText("Telefone Celular:");
				}
				{
					GridData textTelefoneLData = new GridData();
					textTelefoneLData.grabExcessHorizontalSpace = true;
					textTelefoneLData.horizontalAlignment = GridData.FILL;
					textTelefoneCelular = new Text(groupDadosPessoais, SWT.NONE);
					textTelefoneCelular.setLayoutData(textTelefoneLData);
				}

				// CCOMBO TIPOPESSOA
				// view BOT�O CONFIRMA
				{
					buttonConfirma = new Button(groupDadosPessoais, SWT.PUSH
							| SWT.CENTER);
					GridData buttonConfirmaLData = new GridData();
					buttonConfirmaLData.verticalAlignment = GridData.BEGINNING;
					buttonConfirmaLData.horizontalAlignment = GridData.BEGINNING;
					buttonConfirma.setLayoutData(buttonConfirmaLData);
					buttonConfirma.setText("Confirmar");

					buttonConfirma
							.addSelectionListener(new SelectionListener() {

								@Override
								public void widgetSelected(SelectionEvent event) {
									performFinish();
								}

								@Override
								public void widgetDefaultSelected(
										SelectionEvent arg0) {
									// TODO Auto-generated method stub
								}

							});
				}
				// view BOT�O CANCELAR
				{
					buttonCancelar = new Button(groupDadosPessoais, SWT.PUSH
							| SWT.CENTER);
					GridData buttonCancelarLData = new GridData();
					buttonCancelarLData.verticalAlignment = GridData.BEGINNING;
					buttonCancelarLData.horizontalAlignment = GridData.BEGINNING;
					buttonCancelar.setLayoutData(buttonCancelarLData);
					buttonCancelar.setText("Cancelar");

					buttonCancelar
							.addSelectionListener(new SelectionListener() {

								@Override
								public void widgetSelected(SelectionEvent event) {
									closeView();
								}

								@Override
								public void widgetDefaultSelected(
										SelectionEvent arg0) {
									// TODO Auto-generated method stub
								}

							});
				}
				// LABEL ERRO
				{
					labelErro = new Label(groupDadosPessoais, SWT.NONE);
					GridData labelErroLData = new GridData();
					labelErroLData.horizontalAlignment = GridData.FILL;
					labelErroLData.horizontalSpan = 2;
					labelErroLData.grabExcessHorizontalSpace = true;
					labelErroLData.widthHint = 319;
					labelErroLData.heightHint = 26;
					labelErro.setLayoutData(labelErroLData);
					labelErro.setText("");
				}
			}
		}
		loadData();
	}

	private void loadData() {
		isUpdate = false;
		// UF
		List<UF> listUFs = Facade.getInstance().listUf();
		cComboUf.removeAll();
		cComboUf.setEditable(false);
		for (UF uf : listUFs) {
			cComboUf.setData(uf.getDescricao(), uf);
			cComboUf.add(uf.getDescricao());
		}
		// TIPO ENDERE�O
		cComboTipoEndereco.removeAll();
		for (TipoEndereco tipo : TipoEndereco.values()) {
			cComboTipoEndereco.setData(tipo.getDescricao(), tipo);
			cComboTipoEndereco.add(tipo.getDescricao());
		}
		// TIPO PESSOA
		cComboTipoPessoa.removeAll();
		for (TipoPessoa tipo : TipoPessoa.values()) {
			cComboTipoPessoa.setData(tipo.getDescricao(), tipo);
			cComboTipoPessoa.add(tipo.getDescricao());
		}
	}

	private void checkCep() {
		endereco = Facade.getInstance().findEnderecoBaseByCep(
				textEnderecoCep.getText());
		if (endereco != null) {
			textEnderecoLogradouro.setText(endereco.getLogradouro());
			textEnderecoBairro.setText(endereco.getBairro());
			textEnderecoMunicipio.setText(endereco.getMunicipio());
			cComboUf.select(cComboUf.indexOf(endereco.getUf().getDescricao()));

			textEnderecoLogradouro.setEditable(false);
			textEnderecoBairro.setEditable(false);
			textEnderecoMunicipio.setEditable(false);
			cComboUf.setEnabled(false);
		} else {
			textEnderecoLogradouro.setEditable(true);
			textEnderecoBairro.setEditable(true);
			textEnderecoMunicipio.setEditable(true);
			cComboUf.setEnabled(true);
		}
	}

	// Obrigat�rio
	@Override
	public void setFocus() {

	}

	private void performFinish() {
		// dados cliente

		try {
			if (cliente == null) {
				cliente = new Cliente();
				fillCliente();
				Facade.getInstance().cadastrarCliente(cliente);
			} else {
				fillCliente();
				Facade.getInstance().atualizarCliente(cliente);
				openView(ClienteListView.ID);
			}
			closeView();
		} catch (FacadeException e) {
			labelErro.setText(e.getMessage());
		} catch (ValidatorException e) {
			labelErro.setText(e.getMessage());
		} finally {
			if (!isUpdate) {
				cliente = null;
				endereco = null;
			}
		}

	}

	private void fillCliente() throws ValidatorException {
		// SET NOME RAZAOSOCIAL
		if (textNomeCliente.getText() == null
				|| textNomeCliente.getText().equals("")) {
			throw new ValidatorException("O Campo Nome Cliente � obrigat�rio!");
		}
		cliente.setNomeRazaoSocial(textNomeCliente.getText());

		// SET APELIDOFANTASIA PODE SER NULO
		cliente.setApelidoFantasia(textApelidoFantasia.getText());

		// SET CPFCNPJ
		if (textCpfCnpj.getText() == null || textCpfCnpj.getText().equals("")) {
			throw new ValidatorException("O Campo Cpf/Cnpj � obrigat�rio!");
		}
		if ((textCpfCnpj.getText().length() == 11)
				|| (textCpfCnpj.getText().length() == 14)) {
			cliente.setCpfCnpj(textCpfCnpj.getText());
		} else {
			throw new ValidatorException(
					"O Campo Cpf/Cnpj deve ser preenchido sem tra�o e com 11 ou 14 d�gitos!");
		}
		// Declara��o de string key para ser usada nos cCombos
		String key;

		if (endereco == null) {
			endereco = new Endereco();
			String cep = textEnderecoCep.getText();
			String lougradouro = textEnderecoLogradouro.getText();
			String bairro = textEnderecoBairro.getText();
			String municipio = textEnderecoMunicipio.getText();
			
			if (!cep.isEmpty() || !lougradouro.isEmpty() || !bairro.isEmpty() || !municipio.isEmpty() || cComboUf.getSelectionIndex() != -1 )
				// Set CEP
				// valida��o de preenchimento de campo
				if (cep.isEmpty()) {
					throw new ValidatorException("O campo CEP deve ser preenchido!");
				}
				// valida��o de formata��o do campo
				if (cep.length() != 8) {
					throw new ValidatorException(
							"O Campo CEP deve ser preenchido conforme exemplo: 51023000");
				}
				endereco.setCep(cep);
				// Set LOGRADOURO
				if (lougradouro.isEmpty()) {
					throw new ValidatorException("O Campo Endere�o deve ser preenchido!");
				}
				endereco.setLogradouro(lougradouro);
	
				// Set BAIRRO
				if (bairro.isEmpty()) {
					throw new ValidatorException("O Campo Bairro deve ser preenchido!");
				}
				endereco.setBairro(bairro);
	
				// Set MUNICIPIO
				if (municipio.isEmpty()) {
					throw new ValidatorException("O Campo Munic�pio deve ser preenchido!");
				}
				endereco.setMunicipio(municipio);
	
				// SET Sele��o cCombo UF
				UF uf = null;
				if (cComboUf.getSelectionIndex() != -1) {
					key = cComboUf.getItem(cComboUf.getSelectionIndex());
					uf = (UF) cComboUf.getData(key);
				} else {
					throw new ValidatorException("O campo UF deve ser preenchido!");
				}
				endereco.setUf(uf);
		}

		// ENDERE�O Instancia objeto endere�o e sets
		cliente.setEndereco(endereco);

		// Set Complemento
		
		cliente.setComplementoEndereco(textEnderecoComplemento.getText());

		// Set Nuumero
		if (textEnderecoNumero.getText() == null
				|| textEnderecoNumero.getText().equals("")) {
			throw new ValidatorException("O Campo N�mero � obrigat�rio!");
		}
		cliente.setNumeroEndereco(textEnderecoNumero.getText());
		
		// tipo Endere�o
		TipoEndereco tipoEndere�o;
		if (cComboTipoEndereco.getSelectionIndex() != -1) {
			key = cComboTipoEndereco.getItem(cComboTipoEndereco
					.getSelectionIndex());
			tipoEndere�o = (TipoEndereco) cComboTipoEndereco.getData(key);
		} else {
			throw new ValidatorException(
					"Selecionar o Tipo Endere�o � obrigat�rio!");
		}

		// Set Tipo Endere�o
		cliente.setTipoEndereco(tipoEndere�o);

		// set Endere�o
		cliente.setEndereco(endereco);

		// tipo Pessoa
		if (cComboTipoPessoa.getSelectionIndex() != -1) {
			key = cComboTipoPessoa
					.getItem(cComboTipoPessoa.getSelectionIndex());
			cliente.setTipoPessoa((TipoPessoa) cComboTipoPessoa.getData(key));
		} else {
			throw new ValidatorException(
					"Selecionar o Tipo Pessoa � obrigat�rio!");
		}
		// TELEFONE n�o � obrigat�rio - Pelo menos um tipo de Telefone deve ser
		// preenchido!
		cliente.setTelefone(textTelefone.getText());

		// TELEFONE COMERCIAL n�o � obrigat�rio - Pelo menos um tipo de Telefone
		// deve ser preenchido!
		cliente.setTelefoneComercial(textTelefoneComercial.getText());

		// TELEFONE CELULAR n�o � obrigat�rio - Pelo menos um tipo de Telefone
		// deve ser preenchido!
		cliente.setTelefoneCelular(textTelefoneCelular.getText());

		// REGRA DE CADASTRO DE PELO MENOS UM NUMERO DE TELEFONE
		if ((textTelefone.getText() == null || textTelefone.getText()
				.equals(""))
				&& (textTelefoneComercial.getText() == null || textTelefoneComercial
						.getText().equals(""))
				&& (textTelefoneCelular.getText() == null || textTelefoneCelular
						.getText().equals(""))) {
			throw new ValidatorException(
					"� obrigat�rio cadastrar pelo menos um tipo Telefone!");
		}
	}

	public void loadCliente(Cliente cliente) {
		isUpdate = true;
		this.cliente = cliente;

		cComboTipoPessoa.setText(this.cliente.getTipoPessoa().getDescricao());
		if (this.cliente.getNomeRazaoSocial() != null) {
			textNomeCliente.setText(this.cliente.getNomeRazaoSocial());
		}
		if (this.cliente.getApelidoFantasia() != null) {
			textApelidoFantasia.setText(this.cliente.getApelidoFantasia());
		}
		if (this.cliente.getCpfCnpj() != null) {
			textCpfCnpj.setText(this.cliente.getCpfCnpj());
		}
		cComboTipoEndereco.setText(this.cliente.getTipoEndereco()
				.getDescricao());
		endereco = cliente.getEndereco();
		textEnderecoCep.setText(endereco.getCep());
		checkCep();

		if (this.cliente.getNumeroEndereco() != null) {
			textEnderecoNumero.setText(this.cliente.getNumeroEndereco());
		}
		if (this.cliente.getComplementoEndereco() != null) {
			textEnderecoComplemento.setText(this.cliente.getComplementoEndereco());
		}

		if (this.cliente.getTelefone() != null) {
			textTelefone.setText(this.cliente.getTelefone());
		}
		if (this.cliente.getTelefoneComercial() != null) {
			textTelefoneComercial.setText(this.cliente.getTelefoneComercial());
		}
		if (this.cliente.getTelefoneCelular() != null) {
			textTelefoneCelular.setText(this.cliente.getTelefoneCelular());
		}
	}
}
