package br.com.movie.DAO;

import br.com.movie.connection.ConnectionDB;
import br.com.movie.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class MovieDAO {

    // aqui iremos criar as funcionalidades do nosso sistema
    /*
     * - inserir filme
     * - remover filme
     * - atualizar filme
     * - listar filmes
     */

    // cadastro de filmes no banco de dados
    public void inserirFilme(Movie movie) {

        String sql = "INSERT INTO movies (titulo, anolancamento, genero, duracao) VALUES (?, ?, ?, ?)";

        try (Connection con = ConnectionDB.conectar();
             PreparedStatement pstm = con.prepareStatement(sql)) {
            // passando os atributos para a inserção

            pstm.setString(1, movie.getTitulo());
            pstm.setInt(2, movie.getAnoLancamento());
            pstm.setString(3, movie.getGenero());
            pstm.setInt(4, movie.getDuracao());

            // executar o comando
            pstm.execute();
            // mensagem para saber se a inserção no banco foi bem sucedida.
            System.out.println("Filme cadastrado no banco de dados com sucesso!!");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // Seleção dos filmes cadastrados no banco de dados
    public void listarFilmes(){

        String sql  = "SELECT * FROM movies";

        try (Connection con = ConnectionDB.conectar();
        PreparedStatement pstm = con.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery()){

            System.out.println("FILMES CADASTRADOS");


            while (rs.next()){
                System.out.println("---------------------------");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Ano de lançamento: " + rs.getInt("anolancamento"));
                System.out.println("Gênero: " + rs.getString("genero"));
                System.out.println("Duração: " + rs.getInt("duracao") + " min");
                System.out.println("---------------------------");
            }

        } catch (Exception e){
            e.printStackTrace();

        }
    }

    /*
     * criar melhoria nas buscas e inserções para mostrar mensagem caso esteja vazio ou casos semelhantes
     * melhorias a fazer, adicionar uma busca por um genero especifico e busca pelo ano de lancamento do filme
     */

    public void listarPorGenero(String genero){
        String sql  = "SELECT * FROM movies WHERE genero = ?";


        try (Connection con = ConnectionDB.conectar();
        PreparedStatement pstm = con.prepareStatement(sql)){

            pstm.setString(1, genero.toLowerCase());

            try (ResultSet rs = pstm.executeQuery()){
                boolean temFilmes = false;

                while (rs.next()){
                    temFilmes = true;

                    System.out.println("---------------------------");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Título: " + rs.getString("titulo"));
                    System.out.println("Ano de lançamento: " + rs.getInt("anolancamento"));
                    System.out.println("Gênero: " + rs.getString("genero"));
                    System.out.println("Duração: " + rs.getInt("duracao") + " min");
                    System.out.println("---------------------------");

                }


                if(!temFilmes){
                    System.out.println("Nenhum filme encontrado com esse genero!!");
                }

            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void listarPorAno(int ano){

        String sql = "SELECT * FROM movies WHERE anolancamento = ? ";

        try (Connection con = ConnectionDB.conectar();
        PreparedStatement pstm = con.prepareStatement(sql)){

            pstm.setInt(1, ano);

            try(ResultSet rs = pstm.executeQuery()) {

                boolean temFilmes = false;

                while (rs.next()) {
                    temFilmes = true;

                    System.out.println("----------------------------");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("TÍTULO: " + rs.getString("titulo"));
                    System.out.println("ANO DE LANÇAMENTO: " + rs.getInt("anolancamento"));
                    System.out.println("GÊNERO: " + rs.getString("genero"));
                    System.out.println("DURAÇÃO: " + rs.getInt("duracao") + " hr");
                    System.out.println("----------------------------");


                }

                if (!temFilmes) {
                    System.out.println("Nenhum filme encontrado com essa data de lançamento!!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Atualização de filme cadastrado
    public void atualizarFilme(Movie movie){

        String sql = "UPDATE movies set titulo = ?, anolancamento = ?, genero = ?, duracao = ? WHERE id = ?";


        try (Connection con = ConnectionDB.conectar();
        PreparedStatement pstm = con.prepareStatement(sql)){

            pstm.setString(1, movie.getTitulo());
            pstm.setInt(2, movie.getAnoLancamento());
            pstm.setString(3, movie.getGenero());
            pstm.setInt(4, movie.getDuracao());
            pstm.setInt(5, movie.getId());

            pstm.executeUpdate();
            System.out.println("Atualização de filme ja cadastrado realizada com sucesso!!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Delete de filme cadastrado
    public void deleteFilme(int id){

        String sql = "DELETE FROM movies WHERE id = ?";

        try (Connection con = ConnectionDB.conectar();
        PreparedStatement pstm = con.prepareStatement(sql)){

            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Filme deletado com sucesso!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
