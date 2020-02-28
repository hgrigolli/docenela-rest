package br.com.docenela.configs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfiguration {

    //@Value("${spring.datasource.url}")
    private String dbUrl;

    private final String postgresURL = "jdbc:postgresql://localhost:5432/dsv.docenela?user=postgres&password=rfhng1103";

    @Bean
    public DataSource dataSource() throws SQLException {
        if (dbUrl == null || dbUrl.isEmpty()) {
            if(postgresURL != null || !postgresURL.isEmpty()){
                HikariConfig config = new HikariConfig();
                config.setJdbcUrl(postgresURL);
                return new HikariDataSource(config);
            } else {
                return new HikariDataSource();
            }
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            return new HikariDataSource(config);
        }
    }
}
