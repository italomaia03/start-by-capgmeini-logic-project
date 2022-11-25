package todoApp.util;

import todoApp.model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.time.LocalDate;

public class DeadlineColumnRender extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setHorizontalAlignment(CENTER);
        TaskTableModel taskModel = (TaskTableModel) table.getModel();
        Task task = taskModel.getTasks().get(table.convertRowIndexToModel(row));

        if (task.getDeadline().isAfter(LocalDate.now())) {
            label.setBackground(new Color(50, 240, 66));
            label.setForeground(new Color(255, 255, 255));
        } else {
            label.setBackground(new Color(240, 63, 50));
            label.setForeground(new Color(255,255,255));
        }

        return label;
    }
}
