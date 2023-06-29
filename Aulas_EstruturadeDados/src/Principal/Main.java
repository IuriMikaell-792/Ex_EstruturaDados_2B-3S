package Principal;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.dao.CarroDAO;
import model.dao.PessoaDAO;
import model.entity.Carro;
import model.entity.Pessoa;

public class Main {
	
	public static String leString(String msg) {
		String valor = JOptionPane.showInputDialog(null, msg);
		return valor;
	}

//------------------------------------------------------------------//
//								Menu								//
//------------------------------------------------------------------//
	
	public static int menu() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nMenu Principal:");
		System.out.println("1 - Pessoa");
		System.out.println("2 - Carro");
		System.out.println("0 - Sair");
		System.out.print("Digite: ");
		return in.nextInt();
	}
	
	public static int menuPessoa() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nMenu Pessoa:");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar Todos");
		System.out.println("3 - Listar por ID");
		System.out.println("4 - Deletar por ID");
		System.out.println("5 - Atualizar Nome");
		System.out.println("6 - Atualizar Email");
		System.out.println("0 - Sair");
		System.out.print("Digite: ");
		return in.nextInt();
	}
	
	public static int menuCarro() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nMenu Carro:");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar Todos");
		System.out.println("3 - Listar por ID");
		System.out.println("4 - Deletar por ID");
		System.out.println("5 - Atualizar Informações");
		System.out.println("0 - Sair");
		System.out.print("Digite: ");
		return in.nextInt();
	}
	
	public static int menuAtualizaCarro() {
		Scanner in = new Scanner(System.in);
		System.out.println("\nMenu Atualiza Carro:");
		System.out.println("1 - Atualizar Numero Chassi");
		System.out.println("2 - Atualizar Placa");
		System.out.println("3 - Atualizar Modelo");
		System.out.println("4 - Atualizar Marca");
		System.out.println("5 - Atualizar Valor");
		System.out.println("0 - Sair");
		System.out.print("Digite: ");
		return in.nextInt();
	}
	
//------------------------------------------------------------------//
//							Metodos Pessoa							//
//------------------------------------------------------------------//
	public static void metodoInserir() {
		String nome = leString("Digite nome");
		String email = leString("Digite e-mail");
		Pessoa p1 = new Pessoa(nome, email);
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.inserir(p1);
	}
	
	public static void metodoConsultarTodos() {
		List<Pessoa> listaPessoas = new PessoaDAO().consultarTodos();
		if(!listaPessoas.isEmpty()) {
			for (Pessoa p : listaPessoas) {
				System.out.println("----------------------------------------------");
				System.out.println("id: " + p.getId());
				System.out.println("nome: " + p.getNome());
				System.out.println("email: " + p.getEmail());
			}
		} else {
			System.out.println("Não possui registro!");
		}
	}
	
	public static void metodoConsultarPorID() {
		String idStr = leString("Digite id");
		int idInt = Integer.parseInt(idStr);
		Pessoa p = new PessoaDAO().consultar(idInt);
		if(p != null) {
			System.out.println("\n");
			System.out.println("id: " + p.getId());
			System.out.println("nome: " + p.getNome());
			System.out.println("email: " + p.getEmail());
		} else {
			System.out.println("\n");
			System.out.println("Não possui registro!");
		}
	}
	
	public static void metodoDeletarPorID() {
		String idStr = leString("Digite id");
		int idInt = Integer.parseInt(idStr);
		PessoaDAO pDAO = new PessoaDAO();
		if (pDAO.deletar(idInt)) {
			System.out.println("Registro " + idInt + " excluído!");
		} else {
			System.out.println("Registro " + idInt + " não existe!");
		}
	}
	
	public static void metodoAtualizarNome() {
		String idStr = leString("Digite id");
		int idInt = Integer.parseInt(idStr);
		String novoNome = leString("Digite nome");
		PessoaDAO pDAO = new PessoaDAO();
		if (pDAO.atualizarNome(idInt, novoNome)) {
			System.out.println("Nome atualizado!");
		} else {
			System.out.println("Registro " + idInt + " não existe!");
		}
	}
	
	public static void metodoAtualizarEmail() {
		String idStr = leString("Digite id");
		int idInt = Integer.parseInt(idStr);
		String novoEmail = leString("Digite Email");
		PessoaDAO pDAO = new PessoaDAO();
		if (pDAO.atualizarEmail(idInt, novoEmail)) {
			System.out.println("Email atualizado!");
		} else {
			System.out.println("Registro " + idInt + " não existe!");
		}
	}
	
//------------------------------------------------------------------//
//							Metodos Carro							//
//------------------------------------------------------------------//
	
	public static void metodoInserirCarro() {
		String numeroChassiStr = leString("Digite o numero do chassi");
		int numeroChassiInt = Integer.parseInt(numeroChassiStr);
		String placa = leString("Digite a placa do carro (abc1234)");
		String modelo = leString("Digite o modelo do carro");
		String marca = leString("Digite a marca do carro");
		String valorStr = leString("Digite o valor do carro");
		double valorDouble = Double.parseDouble(valorStr);
		Carro c1 = new Carro(numeroChassiInt, placa, modelo, marca, valorDouble);
		CarroDAO carroDAO = new CarroDAO();
		carroDAO.inserir(c1);
	}
	
	public static void metodoConsultarTodosCarros() {
		List<Carro> listaCarros = new CarroDAO().consultarTodos();
		if(!listaCarros.isEmpty()) {
			for (Carro c : listaCarros) {
				System.out.println("----------------------------------------------");
				System.out.println("Id Carro: " + c.getIdCarro());
				System.out.println("Número Chassi: " + c.getNumeroChassi());
				System.out.println("Placa: " + c.getPlaca());
				System.out.println("Modelo: " + c.getModelo());
				System.out.println("Marca: " + c.getMarca());
				System.out.println("Valor: " + c.getValor());
			}
		} else {
			System.out.println("Não possui registro!");
		}
	}
	
	public static void metodoConsultaPorIdCarro() {
		String idCarroStr = leString("Digite o IdCarro");
		int idCarroInt = Integer.parseInt(idCarroStr);
		Carro c = new CarroDAO().consultar(idCarroInt);
		if(c != null) {
			System.out.println("\n");
			System.out.println("Id Carro: " + c.getIdCarro());
			System.out.println("Número Chassi: " + c.getNumeroChassi());
			System.out.println("Placa: " + c.getPlaca());
			System.out.println("Modelo: " + c.getModelo());
			System.out.println("Marca: " + c.getMarca());
			System.out.println("Valor: " + c.getValor());
		} else {
			System.out.println("\n");
			System.out.println("Não possui registro!");
		}
	}
	
	public static void metodoDeletarPorIdCarro() {
		String idCarroStr = leString("Digite o IdCarro");
		int idCarroInt = Integer.parseInt(idCarroStr);
		CarroDAO cDAO = new CarroDAO();
		if (cDAO.deletar(idCarroInt)) {
			System.out.println("Carro id " + idCarroInt + " excluído!");
		} else {
			System.out.println("Carro id " + idCarroInt + " não existe!");
		}
	}
	
	public static void metodoAtualizarInfoCarro(String opcao) {
		String idCarroStr = leString("Digite o IdCarro");
		int idCarroInt = Integer.parseInt(idCarroStr);
		String novaInfo = leString("Digite a nova informação");
		CarroDAO cDAO = new CarroDAO();
		if (cDAO.atualizar(opcao, idCarroInt, novaInfo)) {
			System.out.println("Carro id " + idCarroInt + " atualizado!");
		} else {
			System.out.println("Carro id " + idCarroInt + " não existe!");
		}
	}

//------------------------------------------------------------------//
//																	//
//------------------------------------------------------------------//

	public static void main(String[] args) {
		int op;
		do {
			op = menu();
			switch (op) {
			case 1: {
				do {
					op = menuPessoa();
					switch (op) {
						case 1: {
							metodoInserir();
							break;
						}
						case 2: {
							metodoConsultarTodos();
							break;
						}
						case 3: {
							metodoConsultarPorID();
							break;
						}
						case 4: {
							metodoDeletarPorID();
							break;
						}
						case 5: {
							metodoAtualizarNome();
							break;
						}
						case 6: {
							metodoAtualizarEmail();
							break;
						}
						case 0: {
							break;
						}
						default:
							System.out.println("Opção Inválida!");
					}
				} while(op != 0);
				break;
			}
			
			case 2: {
				do {
					op = menuCarro();
					switch (op) {
						case 1: {
							metodoInserirCarro();
							break;
						}
						case 2: {
							metodoConsultarTodosCarros();
							break;
						}
						case 3: {
							metodoConsultaPorIdCarro();
							break;
						}
						case 4: {
							metodoDeletarPorIdCarro();
							break;
						}
						case 5: {
							do {
								op = menuAtualizaCarro();
								switch (op) {
									case 1: {
										metodoAtualizarInfoCarro("numeroChassi");
										break;
									}
									case 2: {
										metodoAtualizarInfoCarro("placa");
										break;
									}
									case 3: {
										metodoAtualizarInfoCarro("modelo");
										break;
									}
									case 4: {
										metodoAtualizarInfoCarro("marca");
										break;
									}
									case 5: {
										metodoAtualizarInfoCarro("valor");
										break;
									}
									case 0: {
										break;
									}
									default:
										System.out.println("Opção Inválida!");
								}
							} while(op != 0);
							break;
						}
						case 0: {
							break;
						}
						default:
							System.out.println("Opção Inválida!");
					}
				} while(op != 0);
				break;
			}
			
			case 0: {
				break;
			}
			default:
				System.out.println("Opção Inválida!");
			}
		
		} while(op != 0);
		
	}

}
