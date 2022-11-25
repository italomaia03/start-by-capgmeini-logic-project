package todoApp.util;

import todoApp.model.Task;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TaskTableModel extends AbstractTableModel {

    private final String[] columns = {"Name", "Description", "Deadline", "Is Completed", "Edit", "Delete"};
    private List<Task>tasks = new ArrayList<>();

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (tasks.isEmpty())
            return Object.class;

        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        tasks.get(rowIndex).setIsCompleted((boolean) aValue);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return tasks.get(rowIndex).getName();
        else if (columnIndex == 1)
            return tasks.get(rowIndex).getDescription();
        else if (columnIndex == 2)
            return tasks.get(rowIndex).getDeadline();
        else if (columnIndex == 3)
            return tasks.get(rowIndex).isCompleted();
        else if (columnIndex == 4)
            return "";
        else if (columnIndex == 5)
            return "";
        else
            return "Data Not Found";
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
