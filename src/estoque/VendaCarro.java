package estoque;

import javax.swing.JOptionPane;

/**
 * Classe para efetuar o processamento de consulta e inclusao de estoque
 * 
 * @author Diego Munhoz
 * @since 17/02/2021
 */
public class VendaCarro {

	// vetor para armazenar os carros cadastrados
	private Carro estoque[];

	// variavel auxiliar para definir o tamanho do estoque
	private int tamanho = 0;

	// Método construtor da classe
	public VendaCarro() {
		processar();
	}

	// Método principal do programa
	public void processar() {

		// capturando do usuario o tamanho do estoque
		tamanho = Integer.parseInt(JOptionPane.showInputDialog("Informe o tamanho do estoque"));

		// definindo o tamanho do estoque de carros
		estoque = new Carro[tamanho];

		// processamento de looping do programa
		while (true) {
			escolhaUsuario();
		}
	}

	// Método para capturar do usuario a opção
	public void escolhaUsuario() {
		String menu = "Informe a opção desejada:\n\n" + "OPÇÃO 1: Cadastrar Carro\n" + "OPÇÃO 2: Listar Estoque\n"
				+ "OPÇÃO 3: Consultar Carro\n" + "OPÇÃO 4: Pesquisar por Modelo\n"
				+ "OPÇÃO 5: Pesquisar por Combustível\n" + "OPÇÃO 6: Listar carros em promoção\n"
				+ "OPÇÃO 7: Sair do Sistema";

		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		escolhaProcessamento(escolha);
	}

	// Método para seleção das opções do programa
	public void escolhaProcessamento(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarCarro();
			break;

		case 2:
			listarEstoque();
			break;

		case 3:
			consultarCarro();
			break;

		case 4:
			pesquisarPorModelo();
			break;

		case 5:
			pesquisarPorCombustivel();
			break;

		case 6:
			listarCarrosEmPromocao();
			break;

		case 7:
			sairDoSistema();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!", "Cadastro de Estoque", 0);// erro
			break;
		}
	}

	// Método para efetuar o cadastro de um novo carro no estoque
	public void cadastrarCarro() {
		// variável auxiliar para verificar se gravou o carro no estoque
		boolean gravado = false;

		// laço para verificar espaço em estoque
		for (int i = 0; i < estoque.length; i++) {// inicio do for
			if (estoque[i] == null) {
				estoque[i] = criarCarro();
				gravado = true;
				break;
			}
		} // fim do for

		// exibindo o resultado para o usuario
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Veículo gravado com sucesso!", "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Estoque cheio!", "Cadastro de Estoque", 2);
		}

	}// fim do método

	// Método para devolver um carro para cadastro no estoque
	public Carro criarCarro() {
		Marca marca = new Marca();
		Modelo modelo = new Modelo();
		Carro carro = new Carro();

		// recebendo do usuario a marca do carro
		marca.setNome(JOptionPane.showInputDialog("Informe o nome da marca"));

		// recebendo do usuario o nome do modelo do carro
		modelo.setNome(JOptionPane.showInputDialog("Informe o nome do modelo"));

		// atribuindo a marca ao modelo do carro
		modelo.setMarca(marca);

		// recebendo os dados do carro
		carro.setPlaca(JOptionPane.showInputDialog("Informe a placa"));
		carro.setVelocidadeMaxima(Integer.parseInt(JOptionPane.showInputDialog("Informe velocidade máxima")));
		carro.setCombustivel(JOptionPane.showInputDialog("Informe o combustível"));

		int disponivel = Integer.parseInt(JOptionPane.showInputDialog("1 - Disponível\n" + "2 - Não disponível"));
		if (disponivel == 1) {
			carro.setDisponivel(true);
		} else {
			carro.setDisponivel(false);
		}

		int promocao = Integer.parseInt(JOptionPane.showInputDialog("1 - Em promoção\n" + "2 - Não está em promoção"));
		if (promocao == 1) {
			carro.setPromocao(true);
		} else {
			carro.setPromocao(false);
		}

		carro.setValor(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor")));
		carro.setValorPromocao(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor em promoção")));
		carro.setDesconto(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do desconto")));

		// atribuindo o modelo ao carro
		carro.setModelo(modelo);

		return carro;
	}

	// Método para listar o estoque total de veículos cadastrados
	public void listarEstoque() {
		// variavel auxiliar para exibir estoque para o usuario
		String mensagem = "";

		// varrendo o estoque para verificar se existe carros cadastrados
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null) {
				mensagem += (i + 1) + " - " + estoque[i].getModelo().getNome() + "\n";
			}
		} // fim do for

		// exibindo o estoque para o usuario
		JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);

	}

	// Método para consultar um carro específico
	public void consultarCarro() {
		// variavel auxiliar para montar uma mensagem para o usuario
		String mensagem = "Informe o código do veiculo a ser consultado:\n\n";

		// varrendo o estoque para verificar os carros cadastrados
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null) {
				mensagem += "Código " + (i + 1) + " - " + estoque[i].getModelo().getNome() + "\n";
			}
		}

		// capturando o modelo a ser consultado
		int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));

		// inicializando a variavel auxiliar para exibir mensagem
		mensagem = "";
		mensagem += "Modelo.....: " + estoque[codigo - 1].getModelo().getNome() + "\n";
		mensagem += "Marca......: " + estoque[codigo - 1].getModelo().getMarca().getNome() + "\n";
		mensagem += "Placa......: " + estoque[codigo - 1].getPlaca() + "\n";
		mensagem += "Combustível: " + estoque[codigo - 1].getCombustivel() + "\n";
		mensagem += "Vel Máxima.: " + estoque[codigo - 1].getVelocidadeMaxima() + "\n";

		// verificar se está disponivel
		if (estoque[codigo - 1].isDisponivel()) {
			mensagem += "Disponível.: SIM\n";
		} else {
			mensagem += "Disponível.: NÃO\n";
		}

		// verificando se o carro está em promoção
		if (estoque[codigo - 1].isPromocao()) {
			mensagem += "Promoção...: SIM\n";
			mensagem += "Valor......: " + estoque[codigo - 1].getValorPromocao() + "\n";
		} else {
			mensagem += "Promoção...: NÃO\n";
			mensagem += "Valor......: " + estoque[codigo - 1].getValor() + "\n";
		}

		// exibindo o resultado da consulta para o usuario
		JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);

	}

	// Método para retornar todos os carros por modelo escolhido
	public void pesquisarPorModelo() {
		// recebendo do usuario qual modelo a ser pesquisado
		String modelo = JOptionPane.showInputDialog("Informe o modelo para pesquisa");

		// variavel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por modelo:\n\n";

		// variavel auxiliar para verificar se existe o modelo cadastrado
		boolean existe = false;

		// varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].getModelo().getNome().equals(modelo)) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}
		} // fim do for

		// exibindo o resultado da pesquisa para o usuario
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existe o modelo cadastrado", "Cadastro de Estoque", 2);
		}

	}// fim do método

	// Método para retornar todos os carros por combustivel escolhido
	public void pesquisarPorCombustivel() {
		// recebendo do usuario qual modelo a ser pesquisado
		String combustivel = JOptionPane.showInputDialog("Informe o combustivel para pesquisa");

		// variavel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por combustivel:\n\n";

		// variavel auxiliar para verificar se existe o modelo cadastrado
		boolean existe = false;

		// varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].getCombustivel().equals(combustivel)) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}
		} // fim do for

		// exibindo o resultado da pesquisa para o usuario
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existe o modelo cadastrado", "Cadastro de Estoque", 2);
		}

	}

	// Método para retornar todos os carros em promoção
	public void listarCarrosEmPromocao() {
		// recebendo do usuario qual modelo a ser pesquisado
		String promocao = JOptionPane.showInputDialog("Informe a promoção para pesquisa");
		boolean aux = false;
		if (promocao.equals("SIM")) {
			aux = true;
		}

		// variavel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por promoção:\n\n";

		// variavel auxiliar para verificar se existe o modelo cadastrado
		boolean existe = false;

		// varrendo o vetor e verificando o carro cadastrado
		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] != null && estoque[i].isPromocao() == aux) {
				mensagem += mensagem(estoque[i]);
				existe = true;
			}
		} // fim do for

		// exibindo o resultado da pesquisa para o usuario
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro de Estoque", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existe o modelo cadastrado", "Cadastro de Estoque", 2);
		}

	}

	// Método para montar mensagem para o usuario
	public String mensagem(Carro carro) {
		// variavel auxiliar para retonar a mensagem formatada
		String msg = "\n";

		// montando a mensagem de retorno para o usuario
		msg += "Modelo: " + carro.getModelo().getNome() + "\n";
		msg += "Marca: " + carro.getModelo().getMarca().getNome() + "\n";
		msg += "Placa: " + carro.getPlaca() + "\n";
		msg += "Combustível: " + carro.getCombustivel() + "\n";
		msg += "Vel Máxima: " + carro.getVelocidadeMaxima() + "\n";

		// retornando a variavel fomartada
		return msg;
	}

	// Método para sair do sistema
	public void sairDoSistema() {
		System.exit(0);
	}

}
