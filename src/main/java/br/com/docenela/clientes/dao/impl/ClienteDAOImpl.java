package br.com.docenela.clientes.dao.impl;

import br.com.docenela.clientes.dao.ClienteDAO;
import br.com.docenela.model.Cliente;
import br.com.docenela.model.Endereco;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

    private final DataSource dataSource;

    @Autowired
    public ClienteDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int inserir(Cliente cliente) {
        String sql = "insert into clientes (primeiro_nome, ultimo_nome, numero_telefone, email, observacoes, cpf) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            int i = 0;
            stmt.setString(++i, cliente.getPrimeiroNome());
            stmt.setString(++i, cliente.getUltimoNome());
            stmt.setString(++i, cliente.getNumeroTelefone());
            stmt.setString(++i, cliente.getEmail());
            stmt.setString(++i, cliente.getObservacoes());
            stmt.setString(++i, cliente.getCpf());


            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return buscarUltimoClienteInserido();
    }

    private int buscarUltimoClienteInserido(){
        String sql = "select cliente_id from clientes order by cliente_id desc limit 1";
        int ultimoCliente = 0;

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                ultimoCliente = rs.getInt("cliente_id");
            }

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ultimoCliente;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int inserir(Endereco endereco) {
        String sql = "insert into endereco (linha_1, linha_2, numero, cep, cidade, estado, pais, bairro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            int i = 0;
            stmt.setString(++i, endereco.getLinha1());
            stmt.setString(++i, endereco.getLinha2());
            stmt.setString(++i, endereco.getNumero());
            stmt.setString(++i, endereco.getCEP());
            stmt.setString(++i, endereco.getCidade());
            stmt.setString(++i, endereco.getEstado());
            stmt.setString(++i, endereco.getPais());
            stmt.setString(++i, endereco.getBairro());

            stmt.executeUpdate();

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return buscarUltimoEnderecoInserido();
    }

    private int buscarUltimoEnderecoInserido(){
        String sql = "select endereco_id from endereco order by endereco_id desc limit 1";
        int ultimoEndereco = 0;

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                ultimoEndereco = rs.getInt("endereco_id");
            }

            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return ultimoEndereco;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void inserir(Cliente cliente, Endereco endereco) {

        String sql = "insert into endereco_cliente (cliente_id, endereco_id) VALUES (?,?)";

        try(Connection conn = dataSource.getConnection()){

            PreparedStatement stmt = conn.prepareStatement(sql);
            int i = 0;
            stmt.setLong(++i, cliente.getId());
            stmt.setLong(++i, endereco.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Cliente> listarTodosClientes() {
        String sql = "select primeiro_nome, ultimo_nome, numero_telefone, email, observacoes from clientes";

        List<Cliente> listaTodosClientes = new ArrayList<>();

        try(Connection conn = dataSource.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setPrimeiroNome(rs.getString("primeiro_nome"));
                cliente.setUltimoNome(rs.getString("ultimo_nome"));
                cliente.setNumeroTelefone(rs.getString("numero_telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setObservacoes(rs.getString("observacoes"));

                listaTodosClientes.add(cliente);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTodosClientes;
    }


}
