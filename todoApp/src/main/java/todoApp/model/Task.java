package todoApp.model;

import java.util.Date;

public class Task {

    private int id;
    private int idProject;
    private String name;
    private String description;
    private String remarks;
    private boolean isCompleted;
    private Date deadline;
    private Date creationDate;
    private Date updateDate;

    public Task(int id, int idProject, String name, String description, String remarks, boolean isCompleted, Date deadline, Date creationDate, Date updateDate) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.remarks = remarks;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public Task(){
        this.creationDate = new Date();
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

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
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
