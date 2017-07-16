package ru.bortnikov.k_1_serialization_levels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bortnikov.k_1_serialization_levels.demo.DirtyRead;

import java.sql.SQLException;

@SpringBootApplication
public class K1SerializationLevelsApplication {


	public static void main(String[] args) throws SQLException {
        SpringApplication.run(K1SerializationLevelsApplication.class, args);
        DirtyRead.run();
    }
}
