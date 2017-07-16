package ru.bortnikov.k_1_serialization_levels.jdbc;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static void runScenario(int txA, int txB, WorkUnit workOfUnit) throws SQLException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.hsqldb.jdbc.JDBCDriver.class);
        //dataSource.setDriverClass(org.hsqldb.jdbcDriver.class);
        dataSource.setUsername("UsersDB");
        dataSource.setUrl("jdbc:hsqldb:file:~/testDB//UsersDB");
        dataSource.setPassword("UsersDB");

        try(Connection connectionA = dataSource.getConnection();
            Connection connectionB = dataSource.getConnection()){

            connectionA.setAutoCommit(false);
            connectionB.setAutoCommit(false);

            connectionA.setTransactionIsolation(txA);
            connectionB.setTransactionIsolation(txB);

            workOfUnit.run(connectionA, connectionB);

            connectionA.rollback();
            connectionB.rollback();
        }
    }

    public static List<Integer> extractResultSet(ResultSet resultSet) throws SQLException {
        List<Integer> result = new ArrayList<>();
        while (resultSet.next()){
            result.add(resultSet.getInt("id"));
        }
        return result;
    }
}
