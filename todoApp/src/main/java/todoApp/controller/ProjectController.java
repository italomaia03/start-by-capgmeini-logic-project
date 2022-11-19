package todoApp.controller;

import todoApp.model.Project;
import todoApp.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectController {

    public void save(Project project){
        String sql = "INSERT INTO Projects (name," +
                "description," +
                "creation_date," +
                "update_time) VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, Date.valueOf(project.getCreationDate()));
            statement.setDate(4, Date.valueOf((project.getUpdateDate())));
            statement.execute();

        } catch (Exception e){
            throw new RuntimeException("ERROR saving a Project\n"+ Arrays.toString(e.getStackTrace()));
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Project project){
        String sql = "UPDATE Projects SET " +
                "name = ?," +
                "description = ?," +
                "update_time = ? " +
                "WHERE id=?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, Date.valueOf(project.getUpdateDate()));
            statement.setInt(4, project.getId());
            statement.execute();

        } catch(Exception e){
            throw new RuntimeException("ERROR updating a Project"+e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void removeById(int projectId){
        String sql = "DELETE FROM Projects WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionFactory.getConnection();
            statement =  connection.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
        } catch (Exception e){
            throw new RuntimeException("ERROR deleting a Project"+e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Project> findAll(){
        String sql = "SELECT * FROM Projects";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Project> projects = new ArrayList<>();

        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                LocalDate creationDate = resultSet.getDate("creation_date").toLocalDate();
                LocalDate updateTime = resultSet.getDate("update_time").toLocalDate();

                Project project = new Project(id, name, description, creationDate, updateTime);

                projects.add(project);

            }
        } catch (Exception e){
            throw new RuntimeException("ERROR finding projects"+e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return projects;
    }
}
