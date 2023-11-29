package model.dao.impl;

import db.Db;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;
    public DepartmentDaoJDBC (Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insert(Department department) {
        PreparedStatement statement =  null;

        try {
            statement = conn.prepareStatement(
                "INSERT INTO department " +
                    "(Name) " +
                    "VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            statement.setString(1, department.getName());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    department.setId(id);
                }
                Db.closeResultSet(resultSet);
            } else {
                throw new DbException("Unexpected Error!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
          Db.closeStatement(statement);
        }
    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        return null;
    }

    @Override
    public List<Department> findAll() {
        return null;
    }
}
