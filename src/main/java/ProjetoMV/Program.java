package ProjetoMV;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import dao.SorveteDAO;
import dao.SorveteDAOImpl;
import entidade.Sorvete;

public class Program {

	public static void main(String[] args) {

		SorveteDAO sorveteDAO = new SorveteDAOImpl();
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Sorvete sorvete = new Sorvete();

		int opcao = 0;

		System.out.println("Bem-vindo!");
		System.out.println("=====================================================");
		System.out.println("Sistema de controle de estoque da Sorveteria Igarapé");

		do {
			System.out.println("=====================================================");
			System.out.println("Escolha uma opção: ");
			System.out.println("=====================================================");
			System.out.println("[1] - Adicionar itens");
			System.out.println("[2] - Remover itens");
			System.out.println("[3] - Listar os itens do estoque");
			System.out.println("[4] - Sair");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1: // Adiciona itens ao estoque
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Por favor, digite o sabor: ");
				String sabor = sc2.nextLine();
				System.out.println("Informe o fabricante: ");
				String fabricante = sc2.nextLine();
				System.out.println("Informe os ingredientes: ");
				String igredientes = sc2.nextLine();

				// Sorvete sorvete = new Sorvete();
				sorvete.setNome(sabor);
				sorvete.setFabricante(fabricante);
				sorvete.setIngredientes(igredientes);
				sorveteDAO.inserir(sorvete);
				break;

			case 2: // Remove itens do estoque
				System.out.println("\nDigite o sabor escolhido para ser excluído: \n");
				sc.nextLine();
				String saborSorvete = sc.nextLine();
				sorveteDAO.remover(Sorvete.class, saborSorvete);
				System.out.println("=====================================================");
				break;

			case 3: // Lista os itens cadastrados
				System.out.println();
				List<Sorvete> sorvetes = sorveteDAO.buscarTodos(sorvete);
				System.out.println("\nSorvetes cadastrados: \n");
				for (Sorvete s : sorvetes) {
					System.out.println(s);
					System.out.println("=====================================================");
				}
				break;

			case 4: // Lógica de saída do programa
				System.out.println("FIM!");
				break;

			default:
				System.out.println("Opção inválida, tente novamente!");
			}

		} while (opcao != 4);
	}

}
