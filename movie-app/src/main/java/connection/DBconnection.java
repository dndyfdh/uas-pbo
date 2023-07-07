package connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBconnection {
    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/uas_pbo?serverTimezone=Asia/Jakarta");

        // Setup database pooling
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);

        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }
}
