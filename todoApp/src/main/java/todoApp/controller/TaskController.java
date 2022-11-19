package todoApp.controller;

import todoApp.model.Task;
import todoApp.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskController {

    public void save(Task task){
        String sql = "INSERT INTO Tasks (name," +
                "description," +
                "remarks," +
                "is_completed," +
                "deadline," +
                "creation_date," +
                "last_update," +
                "project_id) VALUES (?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getRemarks());
            preparedStatement.setInt(4, task.isCompleted());
            preparedStatement.setDate(5, Date.valueOf(task.getDeadline()));
            preparedStatement.setDate(6, Date.valueOf (task.getCreationDate()));
            preparedStatement.setDate(7, Date.valueOf (task.getUpdateDate()));
            preparedStatement.setInt(8, task.getIdProject());
            preparedStatement.execute();

        } catch (Exception e){
            throw new RuntimeException("ERROR saving a task " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, preparedStatement);
        }

    }

    public void update(Task task){
        String sql = "UPDATE Tasks SET " +
                "name = ?," +
                "description = ?," +
                "remarks = ?," +
                "is_completed = ?," +
                "deadline = ?," +
                "last_update = ?," +
                "project_id = ? " +
                "WHERE id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            //Estabelecendo conexão com o BD
            connection = ConnectionFactory.getConnection();
            //Preparando a Query
            preparedStatement = connection.prepareStatement(sql);
            //Adicionando os valores dos campos
            preparedStatement.setString(1, task.getName());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.setString(3, task.getRemarks());
            preparedStatement.setInt(4, task.isCompleted());
            preparedStatement.setDate(5, Date.valueOf (task.getDeadline()));
            preparedStatement.setDate(6, Date.valueOf (task.getUpdateDate()));
            preparedStatement.setInt(7, task.getIdProject());
            preparedStatement.setInt(8, task.getId());
            //Executando a Query
            preparedStatement.execute();


        } catch (Exception e){
            throw new RuntimeException("ERROR updating a task " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, preparedStatement);
        }
    }

    public void removeById(int taskId) {
        String sql = "DELETE FROM Tasks WHERE id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = ConnectionFactory.getConnection();
            //Objeto que ajuda a preparar o comando SQL que vai ser executado no banco de dados.
            //Metodologia utilizada para evitar SQL Injections.
            preparedStatement = connection.prepareStatement(sql);
            //Substitui a "?" em sql pelo ID passado em taskId.
            preparedStatement.setInt(1, taskId);
            preparedStatement.execute();

        } catch (Exception e){
            throw new RuntimeException("ERROR removing a task " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, preparedStatement);
        }

    }

    public List<Task> findAll(int idProject){
        String sql = "SELECT * FROM Tasks WHERE id_project = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProject);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setRemarks(resultSet.getString("remarks"));
                task.setCompleted(resultSet.getInt("is_completed"));
                task.setDeadline(resultSet.getDate("deadline").toLocalDate());
                task.setCreationDate(resultSet.getDate("creation_date").toLocalDate());
                task.setUpdateDate(resultSet.getDate("last_update").toLocalDate());
                task.setIdProject(resultSet.getInt("project_id"));

                tasks.add(task);
            }


        } catch (Exception e){
            throw new RuntimeException("ERROR removing a task " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, preparedStatement, resultSet);
        }

        return tasks;
    }
}
