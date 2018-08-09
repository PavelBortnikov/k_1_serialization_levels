package ru.bortnikov.k_1_serialization_levels.demo;

import java.sql.Connection;
import java.sql.SQLException;

import static ru.bortnikov.k_1_serialization_levels.jdbc.Utils.extractResultSet;
import static ru.bortnikov.k_1_serialization_levels.jdbc.Utils.runScenario;

public class DirtyRead {

    public static void run() throws SQLException {
        //runScenario(Connection.TRANSACTION_READ_UNCOMMITTED, Connection.TRANSACTION_READ_UNCOMMITTED, (connA, connB) -> {
        runScenario(Connection.TRANSACTION_SERIALIZABLE, Connection.TRANSACTION_SERIALIZABLE, (connA, connB) -> {

            System.out.println("Transaction level for A: " + connA.getTransactionIsolation());
            System.out.println("Transaction level for B: " + connB.getTransactionIsolation());

            System.out.println("B: select" +
                    extractResultSet(connB.createStatement().executeQuery("SELECT ID FROM TX_TEST WHERE ID = 1;")));

            System.out.println("A: insert");

            connA.createStatement().execute("INSERT INTO TX_TEST VALUES (1)");

            System.out.println("B: select" +
                    extractResultSet(connB.createStatement().executeQuery("SELECT ID FROM TX_TEST WHERE ID = 1;")));
        });
    }
}
