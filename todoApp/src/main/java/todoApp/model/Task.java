package todoApp.model;

import java.time.LocalDate;

public class Task {

    private int id;
    private int idProject;
    private String name;
    private String description;
    private String remarks;
    private boolean isCompleted;
    private LocalDate deadline;
    private LocalDate creationDate;
    private LocalDate updateDate;

    public Task(int idProject, String name, boolean isCompleted, LocalDate deadline) {
        this.idProject = idProject;
        this.name = name;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.creationDate = LocalDate.now();
        this.updateDate = LocalDate.now();
    }

    public Task(){
        this.creationDate = LocalDate.now();
        this.updateDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", idProject=" + idProject +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", remarks='" + remarks + '\'' +
                ", isCompleted=" + isCompleted +
                ", deadline=" + deadline +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                '}';
    }

    
}
