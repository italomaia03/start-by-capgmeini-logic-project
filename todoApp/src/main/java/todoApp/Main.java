package todoApp;

import todoApp.controller.ProjectController;
import todoApp.controller.TaskController;
import todoApp.model.Project;
import todoApp.model.Task;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        ProjectController controller = new ProjectController();
//        Project project = new Project();
//
//        project.setName("Projeto Teste");
//        project.setDescription("Testando o controller");
//        controller.save(project);

//        ProjectController controller = new ProjectController();
//        Project project = new Project();
//
//        project.setId(1);
//        project.setName("Projeto Teste");
//        project.setDescription("Testando o método update() trocando Date por LocalDate");
//        controller.update(project);
//
//        List<Project> projects = controller.findAll();
//        System.out.println("Total de projetos = "+projects.size());

        TaskController taskController = new TaskController();
//        Task task = new Task(1, "Test", 0, LocalDate.of(2022, Month.DECEMBER, 1));
//        taskController.save(task);
        Task task = new Task(1, "Test 2", false, LocalDate.of(2022, Month.DECEMBER, 1));

        task.setId(1);
        taskController.update(task);
    }

}
