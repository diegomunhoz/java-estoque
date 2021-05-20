package estoque;

import javax.swing.JOptionPane;

/**
 * Classe para executar o projeto estoque
 * 
 * @author Diego Munhoz
 * @since 18/02/2021
 */
public class Main {

	/*
	 * Método principal para executar a classe
	 */
	public static void main(String[] args) {

		Marca marca = new Marca();
		Modelo modelo = new Modelo();
		Carro carro = new Carro();
		Carro estoque[] = new Carro[4];
		

		//CARRO 1
		marca.setNome("CHEVROLET");
		modelo.setNome("ASTRA");
		modelo.setMarca(marca);
		carro.setPlaca("AABC-1234");
		carro.setVelocidadeMaxima(180);
		carro.setCombustivel("GASOLINA");
		carro.setDisponivel(true);
		carro.setPromocao(true);
		carro.setValor(15000);
		carro.setValorPromocao(12500);
		carro.setDesconto(2500);
		carro.setModelo(modelo);
		estoque[0] = carro;
				
		//CARRO 2
		carro = new Carro();
		marca.setNome("CHEVROLET");
		modelo.setNome("ASTRA");
		modelo.setMarca(marca);
		carro.setPlaca("FFC-1234");
		carro.setVelocidadeMaxima(120);
		carro.setCombustivel("GASOLINA");
		carro.setDisponivel(true);
		carro.setPromocao(true);
		carro.setValor(13000);
		carro.setValorPromocao(12000);
		carro.setDesconto(1000);
		carro.setModelo(modelo);
		estoque[1] = carro;
		
		//CARRO 3
		carro = new Carro();
		marca.setNome("CHEVROLET");
		modelo.setNome("OMEGA");
		modelo.setMarca(marca);
		carro.setPlaca("AAB-6594");
		carro.setVelocidadeMaxima(180);
		carro.setCombustivel("FLEX");
		carro.setDisponivel(true);
		carro.setPromocao(true);
		carro.setValor(15000);
		carro.setValorPromocao(12500);
		carro.setDesconto(2500);
		carro.setModelo(modelo);
		estoque[2] = carro;

		//CARRO 4
		carro = new Carro();
		marca.setNome("CHEVROLET");
		modelo.setNome("CORSA");
		modelo.setMarca(marca);
		carro.setPlaca("ARC-6534");
		carro.setVelocidadeMaxima(180);
		carro.setCombustivel("ALCOOL");
		carro.setDisponivel(true);
		carro.setPromocao(true);
		carro.setValor(15000);
		carro.setValorPromocao(12500);
		carro.setDesconto(2500);
		carro.setModelo(modelo);
		estoque[3] = carro;
		
		
		new VendaCarro();

	}

}
