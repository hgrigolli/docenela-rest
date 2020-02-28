package br.com.docenela.dao.impl;

import br.com.docenela.dao.UtilDAO;
import br.com.docenela.model.Dominio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UtilDAOImpl implements UtilDAO {

    private final DataSource dataSource;

    @Autowired
    public UtilDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Map<Integer, String> buscaElementosDominio(Dominio dominio) {

        String sql = "SELECT cod_elemento, nome_elemento FROM dominios WHERE cod_grupo = ?";
        Map<Integer, String> mapa = new HashMap<>();

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, dominio.getCodigoGrupo());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                mapa.put(rs.getInt("cod_elemento"), rs.getString("nome_elemento"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mapa;
    }
}
