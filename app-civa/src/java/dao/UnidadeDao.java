package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Endereco;
import model.Pais;
import model.Unidade;

/**
 *
 * @author randel
 */
public class UnidadeDao {

    public static List<Unidade> listUnidadeByGerente(String codigoCivaGerente) {
        Connection connection = ConnectionFactory.getConnection();
        List<Unidade> unidades = null;
        Unidade unidade = null;
        Endereco endereco = null;

        String sql = "SELECT uni.idunidade AS identificador, \n"
                + "       nomeunidade AS nome,\n"
                + "       en.nomesubdivisao1 AS subdivisao3,\n"
                + "       en.codigopostal\n"
                + "FROM unidade uni \n"
                + "LEFT JOIN endereco en  \n"
                + "	ON uni.idendereco = en.idendereco\n"
                + "LEFT JOIN acessogestao_unidade aguni\n"
                + "	ON uni.idunidade = aguni.idunidade \n"
                + "LEFT JOIN acessogestao ag\n"
                + "	ON aguni.idacessogestao = ag.idacessogestao \n"
                + "WHERE ag.codigocivagestao = ?;";

        try {
            Statement stmt = connection.createStatement();
            PreparedStatement ps;
            ResultSet rs = null;
            unidades = new ArrayList<>();

            ps = connection.prepareStatement(sql);
            ps.setString(1, codigoCivaGerente);
            rs = ps.executeQuery();

            while (rs.next()) {
               
                unidade = new Unidade();
                endereco = new Endereco();

                unidade.setIdUnidade(rs.getInt("identificador"));
                unidade.setNome(rs.getString("nome"));

                endereco.setNomesubdivisao3(rs.getString("subdivisao3"));
                endereco.setCodigoPostal(rs.getString("codigopostal"));

                unidade.setEndereco(endereco);

                unidades.add(unidade);

            }

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return unidades;
    }

    public static boolean insert(Pais pais) {
        boolean resultado = false;

        // Insert into Pais values (?, ?, ?, ?);
        if (true) {
            // se conseguiu inserir no banco
            resultado = true;
        }

        return resultado;
    }

    public static Unidade find(Integer idUnidade) {

        for (Unidade unidade : UnidadeDao.list()) {
            if (Objects.equals(unidade.getIdUnidade(), idUnidade)) {
                return unidade;
            }
        }

        return null;
    }

    public static List<Unidade> list() {
        List<Unidade> unidades = new ArrayList<Unidade>();

        Endereco endereco = new Endereco(1, 1, "Brasil", "Rua", "Tatuí", "76542445", "Apto 14", "Vila são marcos", "Niterói", "Rio de Janeiro", "", "", "", "", "23");
        Unidade unidade = new Unidade(1, 23, "07.235.197/0001-97", "Bezerra da Silva", "+55 9985563445", "Fixa", "Privada", "Hospital", true, "2021-01-10", endereco);
        unidades.add(unidade);

        Endereco endereco2 = new Endereco(2, 1, "Brasil", "Rua", "Serrinha", "321232123", "Apto 14", "Montes belos", "Terraria", "Piauí", "", "", "", "", "897");
        Unidade unidade2 = new Unidade(2, 55, "47.408.010/0001-24", "Alfonso Padilha", "21 88545765", "Fixa", "Pública", "Posto", true, "2021-04-15", endereco2);
        unidades.add(unidade2);

        return unidades;
    }

    public static boolean update(Unidade unidadeNova) {
        boolean resultado = false;

        // Update unidade;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

    public static boolean delete(Unidade unidade) {
        boolean resultado = false;

        // Delete unidade;
        if (true) {
            resultado = true;
        }

        return resultado;
    }

}
