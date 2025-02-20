package br.com.movie.main;

import br.com.movie.DAO.MovieDAO;
import br.com.movie.connection.ConnectionDB;
import br.com.movie.model.Movie;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Instanciado objeto scanner para receber paramentros do user
        Scanner scanner = new Scanner(System.in);

        // Instanciando o objeto movie para fazer as operações de forma mais dinamica.
        Movie movie = new Movie();

        // Instanciando o objeto que contem as funcionalidades para inserção, alteração no banco de dados
        MovieDAO movieDAO = new MovieDAO();

        String[] menu = {
                "INSERIR FILME",
                "ATUALIZAR FILME",
                "DELETAR FILME",
                "LISTAR TODOS OS FILMES",
                "LISTAR FILMES POR GÊNERO",
                "LISTAR FILMES POR ANO",
                "ENCERRAR O PROGRAMA"
        };

        boolean executando = true;

        while (executando){

            System.out.println("======= DB CINEMA MENU =======");
            for (int i = 0; i < menu.length; i++){
                System.out.println((i+ 1) + " - " + menu[i]);
            }
            System.out.println("===============================");
            System.out.println("Selecione a operação que desena realizar: ");

            int opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    // pegando as informações do filme para adicionar no objeto

                    System.out.println("Título do filme: ");
                    String titulo  = scanner.nextLine();

                    System.out.println("Ano de lançamento: ");
                    int ano = scanner.nextInt();

                    System.out.println("Gênero do filme: ");
                    scanner.nextLine();
                    String genero = scanner.nextLine();

                    System.out.println("Duração do filme: ");
                    int duracao = scanner.nextInt();

                    // adicionando os valores no objeto
                    movie.setTitulo(titulo);
                    movie.setAnoLancamento(ano);
                    movie.setGenero(genero);
                    movie.setDuracao(duracao);

                    // inserindo novo filme no banco de dados
                    movieDAO.inserirFilme(movie);

                    break;

                case 2:
                    // pegando as informações do filme para adicionar no objeto

                    System.out.println("Título do filme: ");
                    String novoTitulo  = scanner.nextLine();

                    System.out.println("Ano de lançamento: ");
                    int novoAno = scanner.nextInt();

                    System.out.println("Gênero do filme: ");
                    scanner.nextLine();
                    String novoGenero = scanner.nextLine();

                    System.out.println("Duração do filme: ");
                    int novaDuracao = scanner.nextInt();

                    System.out.println("Informe o ID do filme que sofrera o UPDATE:");
                    int id  = scanner.nextInt();

                    // adicionando os valores no objeto
                    movie.setTitulo(novoTitulo);
                    movie.setAnoLancamento(novoAno);
                    movie.setGenero(novoGenero);
                    movie.setDuracao(novaDuracao);
                    movie.setId(id);

                    // chamando a função para atualizar as informações
                    movieDAO.atualizarFilme(movie);

                    break;

                case 3:

                    System.out.println("Informe o ID do filme que deseja deletar: ");
                    int idDelete = scanner.nextInt();

                    // chamando a funcionalidade de delete e passsando o id
                    movieDAO.deleteFilme(idDelete);

                    break;

                case 4:
                    // chamando a função de listar todos os filmes
                    movieDAO.listarFilmes();

                    break;

                case 5:

                    System.out.println("Informe o gênero: ");
                    String generoBusca = scanner.nextLine();

                    // chamando a função de listar por genero
                    movieDAO.listarPorGenero(generoBusca);

                    break;

                case 6:

                    System.out.println("Informe o ano: ");
                    int anoBusca = scanner.nextInt();

                    // chamando a função de listar por ano
                    movieDAO.listarPorAno(anoBusca);

                    break;

                case 7:
                    executando = false;
                    System.out.println("Encerrando programa!!");

                    break;

                default:
                    System.out.println("Opção invalida");
                    break;

            }
        }

        scanner.close();

    }
}