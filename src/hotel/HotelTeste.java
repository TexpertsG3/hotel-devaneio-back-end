package hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import exception.AlojamentoInexistenteException;
import exception.DadosInvalidosException;
import exception.DataInvalidaException;
import exception.ServicoInexistenteException;

public class HotelTeste {

	public static void main(String[] args) {

		final String ALOJAMENTO1 = "Quarto C#";
		final String ALOJAMENTO2 = "Quarto C++";
		final String ALOJAMENTO3 = "Quarto C";
		
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Hotel hotel = new Hotel();
		Alojamento alojamento1 = new Alojamento(ALOJAMENTO1, new BigDecimal("399.00"));
		Alojamento alojamento2 = new Alojamento(ALOJAMENTO2, new BigDecimal("299.00"));
		Alojamento alojamento3 = new Alojamento(ALOJAMENTO3, new BigDecimal("199.00"));

		System.out.println("Hotel aberto com sucesso! \n");
		System.out.println(hotel);
		System.out.println("\n");

		Scanner sc = new Scanner(System.in);

		Usuario admin = new Usuario("ADMIN", "admin@admin.com", "admin", TipoUsuario.ADMIN);

		List<Alojamento> listaDeAlojamentos = new ArrayList<>();
		listaDeAlojamentos.add(alojamento1);
		listaDeAlojamentos.add(alojamento2);
		listaDeAlojamentos.add(alojamento3);

		List<ServicoAdicional> listaDeServicos = new ArrayList<>();
		listaDeServicos.add(ServicoAdicional.AUTITORIO_DE_EVENTOS);
		listaDeServicos.add(ServicoAdicional.ESPACO_KIDS);
		listaDeServicos.add(ServicoAdicional.GUIA_TURISTICO);
		listaDeServicos.add(ServicoAdicional.PASSEIO_NAS_DUNAS);
		listaDeServicos.add(ServicoAdicional.TRATAMENTO_SPA);

		int contador;
		Integer opcaoMenu;
		String nomeUsuario;
		String emailUsuario;
		String senhaUsuario;
		Integer numeroAlojamento;
		Usuario usuario = null;

		do {

			System.out.println("Escolha uma opção:\n");
			System.out.println("1 - Cadastro de novo cliente");
			System.out.println("2 - Cadastro de nova reserva");
			System.out.println("3 - Consultar alojamentos disponíveis");
			System.out.println("4 - Consultar serviços adicionais");
			System.out.println("5 - Acesso Administrativo\n");
			System.out.println("0 - Sair do sistema");

			opcaoMenu = sc.nextInt();
			sc.nextLine();

			switch (opcaoMenu) {
			case 0:
				break;
			case 1:
				System.out.println("\nDigite os dados do novo cliente:");

				System.out.print("Nome: ");
				try {

					nomeUsuario = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Nome inválido.");
				}

				System.out.print("Email: ");
				try {

					emailUsuario = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Email inválido.");
				}

				System.out.print("Senha: ");
				try {

					senhaUsuario = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Senha inválida.");
				}

				usuario = new Usuario(nomeUsuario, emailUsuario, senhaUsuario, TipoUsuario.CLIENTE);

				System.out.printf("\nCliente %s, cadastrado com sucesso. \n\n\n", usuario.getNome());

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;

			case 2:

				System.out.print("Escolha seu alojamento (1, 2 ou 3): ");
				numeroAlojamento = sc.nextInt();
				sc.nextLine();
				Alojamento alojamentoEscolhido;

				switch (numeroAlojamento) {
				case 1:
					alojamentoEscolhido = alojamento1;
					break;
				case 2:
					alojamentoEscolhido = alojamento2;
					break;
				case 3:
					alojamentoEscolhido = alojamento3;
					break;
				default:
					throw new AlojamentoInexistenteException("Alojamento inexistente no hotel.");
				}

				LocalDate checkIn;
				try {
					System.out.print("\nData checkIn (formato exemplo 01/01/2023): ");
					String dataCheckin = sc.nextLine();
					checkIn = LocalDate.parse(dataCheckin, dataFormatada);
					if (checkIn.isBefore(LocalDate.now())) {
						throw new DataInvalidaException("A data de checkin deve ser superior ou igual a data atual.");
					}
				} catch (DateTimeParseException e) {
					throw new DataInvalidaException("Formato de data inválido.");
				}

				LocalDate checkOut;
				try {
					System.out.print("Data checkOut (formato exemplo 02/01/2023): ");
					String dataCheckout = sc.nextLine();
					checkOut = LocalDate.parse(dataCheckout, dataFormatada);
					if (checkOut.isBefore(checkIn) || checkOut.isEqual(checkIn)) {
						throw new DataInvalidaException(
								"Data Inválida. A data de checkout deve ser superior a data de checkin.");
					}
				} catch (DateTimeParseException e) {
					throw new DataInvalidaException("Formato de data inválido.");
				}

				System.out.print("Quantidade de adultos: ");
				Integer quantidaDeAdultos = sc.nextInt();
				sc.nextLine();

				System.out.print("Quantidade de crianças: ");
				Integer quantidaDeCriancas = sc.nextInt();
				sc.nextLine();

				System.out.println("\nTemos os seguintes serviços adicionais disponíveis: \n");
				
				contador = 0;
				for (ServicoAdicional servico : listaDeServicos) {

					System.out.print(++contador + " - ");
					System.out.println(servico);
					System.out.println();
				}
					
				Set<ServicoAdicional> servicosSelecionados = new HashSet<>();
				System.out.println("Selecione os serviços adicionais (Ex. 1 3 5 ou 0 para nenhum): \n");
				Integer valor;

				do {

					valor = sc.nextInt();

					switch (valor) {
					case 0:
						break;
					case 1:
						servicosSelecionados.add(listaDeServicos.get(0));
						break;
					case 2:
						servicosSelecionados.add(listaDeServicos.get(1));
						break;
					case 3:
						servicosSelecionados.add(listaDeServicos.get(2));
						break;
					case 4:
						servicosSelecionados.add(listaDeServicos.get(3));
						break;
					case 5:
						servicosSelecionados.add(listaDeServicos.get(4));
						break;
					default:
						throw new ServicoInexistenteException(
								"Serviço não existe no catálogo. Favor selecionar um dos serviços disponíveis");

					}

				} while (!valor.equals(0));

				if (usuario != null) {
					Reserva reserva = new Reserva(alojamentoEscolhido, checkIn, checkOut, usuario, quantidaDeAdultos,
							quantidaDeCriancas, servicosSelecionados);
					System.out.println();
					System.out.println(reserva);
					System.out.println();
					System.out.println("Valor dos serviços: R$" + reserva.calculaValorServico(servicosSelecionados));
					System.out.println("Valor da diária: R$" + reserva.calculaValorDiaria(reserva));
					System.out.println();
					System.out.printf("\nValor total dos serviços e diárias: R$%.2f\n", reserva.calculaTotal(servicosSelecionados, reserva));
				}

				

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("\nTemos os seguintes alojamentos disponíveis: \n");

				contador = 0;
				for (Alojamento alojamento : listaDeAlojamentos) {

					System.out.print(++contador + " - ");
					System.out.println(alojamento);
					System.out.println();
				}

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;

			case 4:
				System.out.println("\nTemos os seguintes serviços adicionais disponíveis: \n");

				contador = 0;
				for (ServicoAdicional servico : listaDeServicos) {

					System.out.print(++contador + " - ");
					System.out.println(servico);
					System.out.println();
				}

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;

			case 5:

				break;

			default:

				break;
			}

		} while (!opcaoMenu.equals(0));

		sc.close();

	}

}
