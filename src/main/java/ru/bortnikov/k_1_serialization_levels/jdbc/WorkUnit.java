package ru.bortnikov.k_1_serialization_levels.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface WorkUnit {

    void run(Connection connA, Connection connB) throws SQLException;

}
