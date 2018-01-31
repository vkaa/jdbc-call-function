package ca.intelliware.ag.blueconsoledb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.Properties;

@RestController
@RequestMapping("/api/blue-results")
public class BlueResults {

    private static Logger logger = LoggerFactory.getLogger(BlueResults.class);

    @GetMapping("/calculate/{ranksetId}")
    public void calculate(@PathVariable Integer ranksetId) {
        logger.debug(String.format("[calculate] ranksetId: %s", ranksetId));
        Optional<Connection> conn = connect();

        conn.map(c -> {
            try {
                c.close();
                return true;
            } catch (Exception e) {
                logger.debug("JDBC close exception: {}", e);
                return false;
            }
        });
    }

    @Value("${spring.datasource.url}")
    String dbUrl;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    private Optional<Connection> connect() {
        Properties props = new Properties();
        props.setProperty("user", username);
        props.setProperty("password", password);
        try {
            logger.debug("Connecting... url: {}, user: {}, password: '{}'", dbUrl, username, password);
            Connection conn = DriverManager.getConnection(dbUrl, props);
            logger.debug("Connected.");
            conn.setAutoCommit(false);
            return Optional.of(conn);
        } catch (Exception e) {
            logger.debug("JDBC getConnection exception: {}", e);
            return Optional.empty();
        }
    }
}
