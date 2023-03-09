package com.hotels.tex;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.hotels.tex.dao.AlojamentoDAO;
import com.hotels.tex.dao.ContatoDAO;
import com.hotels.tex.dao.DadosHotelDAO;
import com.hotels.tex.dao.EnderecoDAO;
import com.hotels.tex.dao.HotelDAO;
import com.hotels.tex.dao.ReservaDAO;
import com.hotels.tex.dao.ServicoAdicionalDAO;
import com.hotels.tex.exception.DadosInvalidosException;
import com.hotels.tex.exception.DataInvalidaException;
import com.hotels.tex.model.Alojamento;
import com.hotels.tex.model.Contato;
import com.hotels.tex.model.DadosHotel;
import com.hotels.tex.model.Endereco;
import com.hotels.tex.model.Hospede;
import com.hotels.tex.model.Hotel;
import com.hotels.tex.model.ServicoAdicional;

public class HotelTeste {

	public static void main(String[] args) {

		DadosHotelDAO dadosHotelDAO = new DadosHotelDAO();
		HotelDAO hotelDAO = new HotelDAO();
		ServicoAdicionalDAO servicoDAO = new ServicoAdicionalDAO();
		ContatoDAO contatoDAO = new ContatoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		ReservaDAO reservaDAO = new ReservaDAO();
		AlojamentoDAO alojamentoDAO = new AlojamentoDAO();
		
//		Hotel hi = new Hotel(1);
//		Alojamento testealoj = new Alojamento("222222222222", "asdasd", new BigDecimal(200.00), hi);
//		alojamentoDAO.insere(testealoj);
		
		System.out.println(reservaDAO.listagem());
		//enderecoDAO.delete(1);
		//contatoDAO.delete(1);
		hotelDAO.delete(1);
		
		
		
		

//		try {
//			contato.insere(contato1);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
//			endereco.insere(endereco1);
//		} catch (SQLException e1) {

//			e1.printStackTrace();
//		}
//		
//		try {
//			dadosHotel.insere(dadosHotel1);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		
//		try {
//			hotel.insere(hotel1);
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		
//			try {
//				servico.insere(servico1);
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}

		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

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

//		System.out.println(servico.listagem());
//		
//		System.out.println(hotel.recuperaInformacao());

		int contador;
		Integer opcaoMenu;
		String nomeHotel;
		String cnpjHotel;
		String emailHotel;
		String telefoneHotel;
		String celularHotel;
		String ruaHotel;
		String bairroHotel;
		Integer numeroHotel;
		String cepHotel;
		String cidadeHotel;
		String ufHotel;
		String complementoHotel;
		Integer numeroAlojamento;
		Hospede hospede = null;

		do {

			System.out.println("Escolha uma opção:\n");
			System.out.println("1 - Cadastro de novo hotel");
			System.out.println("2 - Consultar hotéis cadastrados");
			System.out.println("3 - Cadastrar serviço adicional");
			System.out.println("4 - Consultar serviços adicionais");
			System.out.println("5 - Cadastrar uma nova reserva");
			System.out.println("6 - Acesso Administrativo\n");
			System.out.println("0 - Sair do sistema");

			opcaoMenu = sc.nextInt();
			sc.nextLine();

			switch (opcaoMenu) {
			case 0:
				break;
			case 1:
				System.out.println("\nDigite os dados do novo hotel:");

				System.out.print("Nome: ");
				try {

					nomeHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Nome inválido.");
				}

				System.out.print("CNPJ: ");
				try {

					cnpjHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("CNPJ inválido.");
				}

				System.out.print("Email: ");
				try {

					emailHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Email inválido.");
				}

				System.out.print("Telefone: ");
				try {

					telefoneHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Telefone inválido.");
				}

				System.out.print("Celular: ");
				try {

					celularHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Celular inválido.");
				}

				System.out.print("Rua: ");
				try {

					ruaHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Rua inválida.");
				}

				System.out.print("Bairro: ");
				try {

					bairroHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Bairro inválido.");
				}

				System.out.print("Número: ");
				try {

					numeroHotel = sc.nextInt();

				} catch (Exception e) {
					throw new DadosInvalidosException("Número inválido.");
				}

				System.out.print("CEP: ");
				try {

					sc.nextLine();
					cepHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("CEP inválido.");
				}

				System.out.print("Cidade: ");
				try {

					cidadeHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Cidade inválida.");
				}

				System.out.print("UF: ");
				try {

					ufHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("UF inválido.");
				}

				System.out.print("Complemento: ");
				try {

					complementoHotel = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Complemento inválido.");
				}

				Endereco endereco = new Endereco(ruaHotel, bairroHotel, numeroHotel, cepHotel, cidadeHotel, ufHotel,
						complementoHotel);
				Contato contato = new Contato(emailHotel, telefoneHotel, celularHotel);
				DadosHotel dadosHotel = new DadosHotel(nomeHotel, cnpjHotel, contato, endereco);
				Hotel hotel = new Hotel(dadosHotel);

				enderecoDAO.insere(endereco);

				contatoDAO.insere(contato);

				dadosHotelDAO.insere(dadosHotel);

				hotelDAO.insere(hotel);

				System.out.println("Hotel cadastrado com sucesso! \n");
				System.out.println(hotel);
				System.out.println("\n");

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.println(hotelDAO.listagem());
//				if(hospede == null) {
//					throw new UsuarioNaoCadastradoException("Não existe um usuário cadastrado para realizar a reserva.");
//				}
//				
//				System.out.println("\nTemos os seguintes alojamentos disponíveis: \n");
//
//				contador = 0;
//				for (Alojamento alojamento : hotel.getListaDeAlojamentos()) {
//
//					System.out.print(++contador + " - ");
//					System.out.println(alojamento);
//					System.out.println();
//				}

//				System.out.print("Escolha seu alojamento (1, 2 ou 3): ");
//				numeroAlojamento = sc.nextInt();
//				sc.nextLine();
//				
//				Alojamento alojamentoEscolhido;
//
//				switch (numeroAlojamento) {
//				case 1:
////					alojamentoEscolhido = hotel.getListaDeAlojamentos().get(0);
//					break;
//				case 2:
////					alojamentoEscolhido = hotel.getListaDeAlojamentos().get(1);
//					break;
//				case 3:
////					alojamentoEscolhido = hotel.getListaDeAlojamentos().get(2);
//					break;
//				default:
//					throw new AlojamentoInexistenteException("Alojamento inexistente no hotel.");
//				}
//
//				LocalDate checkIn;
//				try {
//					System.out.print("\nData checkIn (formato exemplo 01/01/2023): ");
//					String dataCheckin = sc.nextLine();
//					checkIn = LocalDate.parse(dataCheckin, dataFormatada);
//					if (checkIn.isBefore(LocalDate.now())) {
//						throw new DataInvalidaException("A data de checkin deve ser superior ou igual a data atual.");
//					}
//				} catch (DateTimeParseException e) {
//					throw new DataInvalidaException("Formato de data inválido.");
//				}
//
//				LocalDate checkOut;
//				try {
//					System.out.print("Data checkOut (formato exemplo 02/01/2023): ");
//					String dataCheckout = sc.nextLine();
//					checkOut = LocalDate.parse(dataCheckout, dataFormatada);
//					if (checkOut.isBefore(checkIn) || checkOut.isEqual(checkIn)) {
//						throw new DataInvalidaException(
//								"Data inválida. A data de checkout deve ser superior a data de checkin.");
//					}
//				} catch (DateTimeParseException e) {
//					throw new DataInvalidaException("Formato de data inválido.");
//				}
//
//				System.out.print("Quantidade de adultos: ");
//				Integer quantidaDeAdultos = sc.nextInt();
//				sc.nextLine();
//
//				System.out.print("Quantidade de crianças: ");
//				Integer quantidaDeCriancas = sc.nextInt();
//				sc.nextLine();

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

				String nomeServico;
				BigDecimal precoServico;
				Integer numeroRegistro;

				System.out.print("\nDigite o nome do serviço: ");

				try {

					nomeServico = sc.nextLine();

				} catch (Exception e) {
					throw new DadosInvalidosException("Nome inválido.");
				}

				System.out.print("Digite o preço: ");

				try {

					precoServico = sc.nextBigDecimal();

				} catch (Exception e) {
					throw new DadosInvalidosException("Preço inválido.");
				}

				System.out.print(
						"Digite o número do registro do hotel para qual deseja cadastrar o serviço (lista abaixo): \n");

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println(hotelDAO.listagem());

				try {

					numeroRegistro = sc.nextInt();

				} catch (Exception e) {
					throw new DadosInvalidosException("Número inválido.");
				}

				ServicoAdicional servico = new ServicoAdicional(nomeServico, precoServico, numeroRegistro);

				servicoDAO.insere(servico);

				break;

//
//				contador = 0;
//				for (Alojamento alojamento : hotel.getListaDeAlojamentos()) {
//
//					System.out.print(++contador + " - ");
//					System.out.println(alojamento);
//					System.out.println();
//				}
//
//				try {
//					Thread.sleep(3000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}

			case 4:
				System.out.println(servicoDAO.listagem());
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
				System.out.println("\nCadastro de nova reserva: ");

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

				System.out.println("\nTemos os seguintes serviços adicionais disponíveis: \n");

				List<ServicoAdicional> listaDisponiveis = servicoDAO.listagem();
				System.out.println(listaDisponiveis);

				Set<ServicoAdicional> listaAdicionados = new HashSet<>();

				Integer valor;

				do {

					valor = sc.nextInt();

					if (valor > 1) {
						listaAdicionados.add(listaDisponiveis.get(valor));
					} else {
						listaAdicionados.add(listaDisponiveis.get(valor-1));
					}

				} while (!valor.equals(0));

				System.out.println(listaAdicionados);

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

//				Integer menuAdm;
//				do {

//					System.out.printf("\n\n%s, seja bem vindo ao sistema administrativo. Escolha uma opção: \n\n", admin.getNome());
//					System.out.println("1 - Cadastro de funcionários");
//					System.out.println("2 - Consulta de funcionários");
//					System.out.println("3 - Sistema para cadastro de novos administradores");
//					System.out.println("4 - Sistema para quitação de reservas");
//					System.out.println("0 - Sair do sistema administrativo");

//					menuAdm = sc.nextInt();
//					sc.nextLine();
//
//					switch (menuAdm) {
//					case 1:
//						System.out.print("\nDigite o nome do funcionário: ");
//						String nomeFuncionario = sc.nextLine();
//						System.out.print("\nDigite o sobrenome do funcionário: ");
//						String sobrenomeFuncionario = sc.nextLine();
//						System.out.print("\nDigite o cargo do funcionário: ");
//						String cargoDoFuncionario = sc.nextLine();
//						System.out.print("\nDigite o salário do funcionário: ");
//						String salarioDoFuncionario = sc.nextLine();

//						Funcionario funcionario = new Funcionario(nomeFuncionario, sobrenomeFuncionario, new Cargo(cargoDoFuncionario), new BigDecimal(salarioDoFuncionario));
//						System.out.printf("\nO funcionário %s foi cadastrado com sucesso!\n", funcionario.getNome());
//						System.out.println(funcionario);
//						hotel.getListaDeFuncionarios().add(funcionario);

//						break;
//					case 2:
//						System.out.printf("\nFuncionários do hotel %s:\n", hotel.getDadosHotel().getNome());
//						for (Funcionario funcionarioCadastrado : hotel.getListaDeFuncionarios()) {
//							System.out.println(funcionarioCadastrado);
//							}
//						break;
//					default:
//						break;
//					}
//
//				} while (!menuAdm.equals(0));
//
//				break;
//
//			default:
//
//				break;
			}

		} while (!opcaoMenu.equals(0));

		sc.close();

	}

}
