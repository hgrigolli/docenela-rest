package br.com.docenela.produtos.dao;

import br.com.docenela.model.Insumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class InsumoDAO {

    private final DataSource dataSource;

    @Autowired
    public InsumoDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void inserirInsumo(Insumo insumo) {
        String sql = "INSERT INTO insumos (descricao, preco, quantidade, unidade_de_medida) VALUES (?,?,?,(SELECT dominio_id from dominios where cod_grupo = ? and cod_elemento = ?) )";


        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            int i = 0;
            stmt.setString(++i, insumo.getDescricao());
            stmt.setBigDecimal(++i, insumo.getPreco());
            stmt.setBigDecimal(++i, insumo.getQuantidade());
            stmt.setInt(++i, insumo.getUnidadeDeMedida().getCodigoGrupo());
            stmt.setInt(++i, insumo.getUnidadeDeMedida().getCodigoElemento());

            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Insumo> listarTodosInsumos() {
        List<Insumo> listaTodosInsumos = new ArrayList<>();
        String sql = "SELECT I.insumo_id, I.descricao, I.preco, I.quantidade, D.nome_elemento, D.cod_elemento FROM insumos I inner join dominios D on I.unidade_de_medida = D.dominio_id";

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Insumo insumo = new Insumo();
                insumo.setId(rs.getInt("insumo_id"));
                insumo.setDescricao(rs.getString("descricao"));
                insumo.setPreco(rs.getBigDecimal("preco"));
                insumo.setQuantidade(rs.getBigDecimal("quantidade"));
                insumo.getUnidadeDeMedida().setNomeElemento(rs.getString("nome_elemento"));
                insumo.getUnidadeDeMedida().setCodigoElemento(rs.getInt("cod_elemento"));
                listaTodosInsumos.add(insumo);
            }

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaTodosInsumos;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void atualizarInsumo(Insumo insumo) {

        String sql = "UPDATE insumos set descricao = ?, preco = ?, quantidade = ?, " +
                " unidade_de_medida = (select dominio_id from dominios where cod_grupo = ? and cod_elemento = ?)" +
                " where insumo_id = ?";

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            int i = 0;

            stmt.setString(++i, insumo.getDescricao());
            stmt.setBigDecimal(++i, insumo.getPreco());
            stmt.setBigDecimal(++i, insumo.getQuantidade());
            stmt.setInt(++i, insumo.getUnidadeDeMedida().getCodigoGrupo());
            stmt.setInt(++i, insumo.getUnidadeDeMedida().getCodigoElemento());
            stmt.setInt(++i, insumo.getId());

            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            atualizarPrecoInsumoProduto(insumo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void atualizarPrecoInsumoProduto(Insumo insumo) throws SQLException {

        String atualizarPrecoInsumoProdutoQuery = "UPDATE insumos_produtos ip SET preco_insumo_frac = (SELECT SUM( i.preco * ip.quantidade_insumo / i.quantidade) FROM insumos i where i.insumo_id = ?) WHERE ip.insumo_id = ?";

        Connection conn = dataSource.getConnection();
        PreparedStatement stmt = conn.prepareStatement(atualizarPrecoInsumoProdutoQuery);

        int i = 0;

        stmt.setInt(++i, insumo.getId());
        stmt.setInt(++i, insumo.getId());

        stmt.executeUpdate();

        stmt.close();


    }

    public Insumo buscarInsumo(Integer id) {

        Insumo insumo = new Insumo();
        String sql = "SELECT I.descricao, I.preco, I.quantidade, D.nome_elemento FROM insumos I inner join dominios D on I.unidade_de_medida = D.dominio_id WHERE insumo_id = ?";

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                insumo.setDescricao(rs.getString("descricao"));
                insumo.setPreco(rs.getBigDecimal("preco"));
                insumo.setQuantidade(rs.getBigDecimal("quantidade"));
                insumo.getUnidadeDeMedida().setNomeElemento(rs.getString("nome_elemento"));
            }

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return insumo;
    }

    //TODO
    public void cadastrarCompraDeInsumos(List<Insumo> listaDeInsumos) {


    }

    public void deletarInsumo(Integer id) {

        String sql = "DELETE FROM insumos where insumo_id = ?";

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
