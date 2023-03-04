package hotel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import exception.AlojamentoInexistenteException;
import exception.DadosInvalidosException;
import exception.DataInvalidaException;
import exception.ServicoInexistenteException;
import exception.UsuarioNaoCadastradoException;
import exception.UsuarioSemAcessoAdministrativoException;

public class HotelTeste {

	public static void main(String[] args) throws SQLException {
		
	
		ServicoAdicionalDAO servicoadd = new ServicoAdicionalDAO();
		
			try {
				servicoadd.insere("Auditório de eventos", new BigDecimal("150.0"), 1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
		
		
		
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		
		Endereco endereco = new Endereco("Rua Fictícia", "Jd. Indefinido", "999", "13874-888", "Neverland", "Terra média");
		
		DadosHotel dadosHotel = new DadosHotel("Hotel DEVaneio", endereco , "01.001.002/0001-85", "devaneio@hotel.com", "(99)9999-9999");
		
		Hotel hotel = new Hotel(dadosHotel);

		System.out.println("Hotel aberto com sucesso! \n");
		System.out.println(hotel);
		System.out.println("\n");

//		Admin admin = new Admin("ADMIN", "admin@admin.com", "admin");
//		
//		hotel.cadastrarQuarto("Quarto Java", new BigDecimal("399.00"));
//		hotel.cadastrarQuarto("Quarto C#", new BigDecimal("299.00"));
//		hotel.cadastrarQuarto("Quarto C++", new BigDecimal("199.00"));


//		hotel.cadastrarServico("Auditório de Eventos", new BigDecimal("150.00"));
//		hotel.cadastrarServico("Espaço Kids", new BigDecimal("230.00"));
//		hotel.cadastrarServico("Passeio nas Dunas", new BigDecimal("180.00"));
//		hotel.cadastrarServico("Tratamento de Spa", new BigDecimal("300.00"));
//		hotel.cadastrarServico("Guia Turístico", new BigDecimal("100.00"));
		
		System.out.println(servicoadd.listagem());


		int contador;
		Integer opcaoMenu;
		String nomeHospede;
		String sobrenomeHospede;
		String cpfHospede;
		String emailHospede;
		String senhaHospede;
		Integer numeroAlojamento;
		Hospede hospede = null;

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

					nomeHospede = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Nome inválido.");
				}
				
				System.out.print("Sobrenome: ");
				try {

					sobrenomeHospede = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Sobrenome inválido.");
				}
				
				System.out.print("CPF: ");
				try {

					cpfHospede = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("CPF inválido.");
				}

				System.out.print("Email: ");
				try {

					emailHospede = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Email inválido.");
				}

				System.out.print("Senha: ");
				try {

					senhaHospede = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Senha inválida.");
				}

//				hospede = new Hospede(nomeHospede, sobrenomeHospede, cpfHospede, emailHospede, senhaHospede);
//
//				System.out.printf("\nCliente %s, cadastrado com sucesso. \n\n\n", hospede.getNome());

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				if(hospede == null) {
					throw new UsuarioNaoCadastradoException("Não existe um usuário cadastrado para realizar a reserva.");
				}
				
				System.out.println("\nTemos os seguintes alojamentos disponíveis: \n");

				contador = 0;
				for (Alojamento alojamento : hotel.getListaDeAlojamentos()) {

					System.out.print(++contador + " - ");
					System.out.println(alojamento);
					System.out.println();
				}
				
				System.out.print("Escolha seu alojamento (1, 2 ou 3): ");
				numeroAlojamento = sc.nextInt();
				sc.nextLine();
				
				Alojamento alojamentoEscolhido;

				switch (numeroAlojamento) {
				case 1:
					alojamentoEscolhido = hotel.getListaDeAlojamentos().get(0);
					break;
				case 2:
					alojamentoEscolhido = hotel.getListaDeAlojamentos().get(1);
					break;
				case 3:
					alojamentoEscolhido = hotel.getListaDeAlojamentos().get(2);
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
								"Data inválida. A data de checkout deve ser superior a data de checkin.");
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

//				System.out.println("\nTemos os seguintes serviços adicionais disponíveis: \n");
//				
//				contador = 0;
//				for (ServicoAdicional servico : hotel.getListaDeServicos()) {
//
//					System.out.print(++contador + " - ");
//					System.out.println(servico);
//					System.out.println();
//				}
					
//				Set<ServicoAdicional> servicosSelecionados = new HashSet<>();
//				System.out.println("Selecione os serviços adicionais (Ex. 1 3 5 ou (0 para nenhum ou para sair da seleção)): \n");
//				Integer valor;
//
//				do {
//
//					valor = sc.nextInt();
//
//					switch (valor) {
//					case 0:
//						break;
//					case 1:
//						servicosSelecionados.add(hotel.getListaDeServicos().get(0));
//						break;
//					case 2:
//						servicosSelecionados.add(hotel.getListaDeServicos().get(1));
//						break;
//					case 3:
//						servicosSelecionados.add(hotel.getListaDeServicos().get(2));
//						break;
//					case 4:
//						servicosSelecionados.add(hotel.getListaDeServicos().get(3));
//						break;
//					case 5:
//						servicosSelecionados.add(hotel.getListaDeServicos().get(4));
//						break;
//					default:
//						throw new ServicoInexistenteException(
//								"Serviço não existente no catálogo. Favor selecionar um dos serviços disponíveis");
//
//					}
//
//				} while (!valor.equals(0));

//				Reserva reserva = new Reserva(alojamentoEscolhido, checkIn, checkOut, hospede, quantidaDeAdultos,
//							quantidaDeCriancas, servicosSelecionados);
//				hotel.setReserva(reserva);
//				
//				System.out.println();
//				System.out.println(hotel.getReserva());
//				System.out.println();
//				System.out.println("Valor dos serviços: R$" + hotel.calculaValorServico(servicosSelecionados));
//				System.out.println("Valor da diária: R$" + hotel.calculaValorDiaria(reserva));
//				System.out.println();
//				System.out.printf("\nValor total dos serviços e diárias: R$%.2f\n", hotel.calculaTotalReserva(servicosSelecionados, reserva));

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("\nTemos os seguintes alojamentos disponíveis: \n");

				contador = 0;
				for (Alojamento alojamento : hotel.getListaDeAlojamentos()) {

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
//				System.out.println("\nTemos os seguintes serviços adicionais disponíveis: \n");
//
//				contador = 0;
//				for (ServicoAdicional servico : hotel.getListaDeServicos()) {
//
//					System.out.print(++contador + " - ");
//					System.out.println(servico);
//					System.out.println();
//				}
//
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				break;

			case 5:
				
//				System.out.println("\nLogin administrativo:");
//				System.out.print("Email: ");
//				
//				String admEmail;
//				try {
//					admEmail = sc.nextLine();
//					if (!admEmail.equals(admin.getEmail()))
//						throw new UsuarioSemAcessoAdministrativoException("Email incorreto.");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				
//				System.out.print("Senha: ");
//				String admSenha;
//				try {
//					admSenha = sc.nextLine();
//					if (!admSenha.equals(admin.getSenha()))
//						throw new UsuarioSemAcessoAdministrativoException("Senha incorreta.");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				
				Integer menuAdm;
				do {
					
//					System.out.printf("\n\n%s, seja bem vindo ao sistema administrativo. Escolha uma opção: \n\n", admin.getNome());
					System.out.println("1 - Cadastro de funcionários");
					System.out.println("2 - Consulta de funcionários");
					System.out.println("3 - Sistema para cadastro de novos administradores");
					System.out.println("4 - Sistema para quitação de reservas");
					System.out.println("0 - Sair do sistema administrativo");
					
					menuAdm = sc.nextInt();
					sc.nextLine();
					
					switch (menuAdm) {						
					case 1: 
						System.out.print("\nDigite o nome do funcionário: ");
						String nomeFuncionario = sc.nextLine();
						System.out.print("\nDigite o sobrenome do funcionário: ");
						String sobrenomeFuncionario = sc.nextLine();
						System.out.print("\nDigite o cargo do funcionário: ");
						String cargoDoFuncionario = sc.nextLine();
						System.out.print("\nDigite o salário do funcionário: ");
						String salarioDoFuncionario = sc.nextLine();
						
//						Funcionario funcionario = new Funcionario(nomeFuncionario, sobrenomeFuncionario, new Cargo(cargoDoFuncionario), new BigDecimal(salarioDoFuncionario));
//						System.out.printf("\nO funcionário %s foi cadastrado com sucesso!\n", funcionario.getNome());
//						System.out.println(funcionario);
//						hotel.getListaDeFuncionarios().add(funcionario);
						
						break;
					case 2: 
						System.out.printf("\nFuncionários do hotel %s:\n", hotel.getDadosHotel().getNome());
						for (Funcionario funcionarioCadastrado : hotel.getListaDeFuncionarios()) {
							System.out.println(funcionarioCadastrado);
							}
						break;
					default:
						break;
					}
					
				} while (!menuAdm.equals(0));

				break;

			default:

				break;
			}

		} while (!opcaoMenu.equals(0));

		sc.close();

	}

}
