/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package todoApp.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.*;

import todoApp.controller.ProjectController;
import todoApp.controller.TaskController;
import todoApp.model.Project;
import todoApp.model.Task;
import todoApp.util.ButtonColumnRender;
import todoApp.util.DeadlineColumnRender;
import todoApp.util.TaskTableModel;

/**
 *
 * @author italo
 */
public class MainScreen extends javax.swing.JFrame {

    ProjectController projectController;
    TaskController taskController;
    DefaultListModel projectModel;
    TaskTableModel taskModel;

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        initDataController();
        initComponentsModel();
        decorateTasksTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emptyTaskList = new javax.swing.JPanel();
        emptyTaskListIcon = new javax.swing.JLabel();
        emptyTaskListTitle = new javax.swing.JLabel();
        emptyTaskListSubtitle = new javax.swing.JLabel();
        toolBar = new javax.swing.JPanel();
        toolBarTitle = new javax.swing.JLabel();
        toolBarSubtitle = new javax.swing.JLabel();
        projectsPanel = new javax.swing.JPanel();
        projectsTitle = new javax.swing.JLabel();
        projectsAdd = new javax.swing.JLabel();
        tasksPanel = new javax.swing.JPanel();
        tasksTitle = new javax.swing.JLabel();
        tasksAdd = new javax.swing.JLabel();
        projectsList = new javax.swing.JPanel();
        projectsScrollPanel = new javax.swing.JScrollPane();
        projects = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        tasksScrollPanel = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();

        emptyTaskList.setBackground(new java.awt.Color(255, 255, 255));

        emptyTaskListIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emptyTaskListIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        emptyTaskListTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        emptyTaskListTitle.setForeground(new java.awt.Color(0, 152, 102));
        emptyTaskListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emptyTaskListTitle.setText("Não há Tarefas cadastradas");

        emptyTaskListSubtitle.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        emptyTaskListSubtitle.setForeground(java.awt.Color.gray);
        emptyTaskListSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emptyTaskListSubtitle.setText("Clique no botão \"+\" para adicionar novas Tarefas");

        javax.swing.GroupLayout emptyTaskListLayout = new javax.swing.GroupLayout(emptyTaskList);
        emptyTaskList.setLayout(emptyTaskListLayout);
        emptyTaskListLayout.setHorizontalGroup(
            emptyTaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emptyTaskListIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(emptyTaskListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(emptyTaskListSubtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        emptyTaskListLayout.setVerticalGroup(
            emptyTaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emptyTaskListLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(emptyTaskListIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emptyTaskListTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emptyTaskListSubtitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(0, 0));

        toolBar.setBackground(new java.awt.Color(0, 153, 102));

        toolBarTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        toolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
        toolBarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        toolBarTitle.setText(" TO DO App");

        toolBarSubtitle.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        toolBarSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        toolBarSubtitle.setText("                     Define projects and tasks here");

        javax.swing.GroupLayout toolBarLayout = new javax.swing.GroupLayout(toolBar);
        toolBar.setLayout(toolBarLayout);
        toolBarLayout.setHorizontalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolBarTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addComponent(toolBarSubtitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        toolBarLayout.setVerticalGroup(
            toolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(toolBarTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toolBarSubtitle)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        projectsPanel.setBackground(new java.awt.Color(255, 255, 255));

        projectsTitle.setBackground(java.awt.Color.white);
        projectsTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        projectsTitle.setForeground(new java.awt.Color(0, 153, 102));
        projectsTitle.setText("Projetos");

        projectsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        projectsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projectsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout projectsPanelLayout = new javax.swing.GroupLayout(projectsPanel);
        projectsPanel.setLayout(projectsPanelLayout);
        projectsPanelLayout.setHorizontalGroup(
            projectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectsAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        projectsPanelLayout.setVerticalGroup(
            projectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectsAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(projectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tasksPanel.setBackground(new java.awt.Color(255, 255, 255));

        tasksTitle.setBackground(java.awt.Color.white);
        tasksTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        tasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        tasksTitle.setText("Tarefas");

        tasksAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        tasksAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tasksAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tasksPanelLayout = new javax.swing.GroupLayout(tasksPanel);
        tasksPanel.setLayout(tasksPanelLayout);
        tasksPanelLayout.setHorizontalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tasksTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tasksAdd)
                .addContainerGap())
        );
        tasksPanelLayout.setVerticalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tasksAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(tasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        projectsList.setBackground(new java.awt.Color(255, 255, 255));

        projects.setBorder(null);
        projects.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        projects.setForeground(new java.awt.Color(51, 51, 51));
        projects.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        projects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        projects.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        projects.setFixedCellHeight(48);
        projects.setSelectionBackground(new java.awt.Color(0, 153, 102));
        projectsScrollPanel.setViewportView(projects);
        projects.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                projectsMouseClicked(e);
            }
        });

        javax.swing.GroupLayout projectsListLayout = new javax.swing.GroupLayout(projectsList);
        projectsList.setLayout(projectsListLayout);
        projectsListLayout.setHorizontalGroup(
            projectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectsScrollPanel)
                .addContainerGap())
        );
        projectsListLayout.setVerticalGroup(
            projectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectsScrollPanel)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        tasksTable.setFont(new java.awt.Font("DejaVu Sans", 0, 14)); // NOI18N
        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Description", "Deadline", "Is Completed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tasksTable.setRowHeight(48);
        tasksTable.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tasksTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tasksTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tasksTable.setShowGrid(false);
        tasksScrollPanel.setViewportView(tasksTable);
        tasksTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                taskTableMouseClicked(e);
            }
        });

        jPanel5.add(tasksScrollPanel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(projectsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tasksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tasksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void projectsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_projectsAddMouseClicked
        // TODO add your handling code here:
        ProjectCreationDialogScreen projectCreationDialogScreen = new ProjectCreationDialogScreen(this, rootPaneCheckingEnabled);
        projectCreationDialogScreen.setVisible(true);
        projectCreationDialogScreen.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                loadProjects();
            }
        });

    }//GEN-LAST:event_projectsAddMouseClicked

    private void tasksAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tasksAddMouseClicked
        // TODO add your handling code here:
        TaskCreationDialogScreen taskCreationScreen = new TaskCreationDialogScreen(this, rootPaneCheckingEnabled);
        var projectIndex = projects.getSelectedIndex();
        Project project = (Project) projectModel.get(projectIndex);
        taskCreationScreen.setProject(project);
        taskCreationScreen.setVisible(true);

        taskCreationScreen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadTasks(project.getId());
            }
        });
    }//GEN-LAST:event_tasksAddMouseClicked

    private void projectsMouseClicked(MouseEvent event) {
        var projectIndex = projects.getSelectedIndex();
        Project project = (Project) projectModel.get(projectIndex);
        loadTasks(project.getId());
    }

    private void taskTableMouseClicked(MouseEvent event) {
        var rowIndex = tasksTable.rowAtPoint(event.getPoint());
        var columnIndex = tasksTable.columnAtPoint(event.getPoint());
        Task task = taskModel.getTasks().get(rowIndex);
        var projectIndex = projects.getSelectedIndex();
        Project project = (Project) projectModel.get(projectIndex);

        if (columnIndex == 3) {
            taskController.update(task);
        } else if (columnIndex == 5) {
            taskController.removeById(task.getId());
            taskModel.getTasks().remove(task);
            loadTasks(project.getId());
        }
    }

    private void showTasksTable(boolean hasTasks) {
        if (hasTasks) {
            if (emptyTaskList.isVisible()) {
                emptyTaskList.setVisible(false);
                jPanel5.remove(emptyTaskList);
            }
            jPanel5.add(tasksScrollPanel);
            tasksScrollPanel.setVisible(true);
            tasksScrollPanel.setSize(jPanel5.getWidth(), jPanel5.getHeight());
        } else {
            if (tasksScrollPanel.isVisible()) {
                tasksScrollPanel.setVisible(false);
                jPanel5.remove(tasksScrollPanel);
            }
            jPanel5.add(emptyTaskList);
            emptyTaskList.setVisible(true);
            emptyTaskList.setSize(jPanel5.getWidth(), jPanel5.getHeight());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException
                | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel emptyTaskList;
    private javax.swing.JLabel emptyTaskListIcon;
    private javax.swing.JLabel emptyTaskListSubtitle;
    private javax.swing.JLabel emptyTaskListTitle;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JList<String> projects;
    private javax.swing.JLabel projectsAdd;
    private javax.swing.JPanel projectsList;
    private javax.swing.JPanel projectsPanel;
    private javax.swing.JScrollPane projectsScrollPanel;
    private javax.swing.JLabel projectsTitle;
    private javax.swing.JLabel tasksAdd;
    private javax.swing.JPanel tasksPanel;
    private javax.swing.JScrollPane tasksScrollPanel;
    private javax.swing.JTable tasksTable;
    private javax.swing.JLabel tasksTitle;
    private javax.swing.JPanel toolBar;
    private javax.swing.JLabel toolBarSubtitle;
    private javax.swing.JLabel toolBarTitle;
    // End of variables declaration//GEN-END:variables

    public void decorateTasksTable() {
        this.tasksTable.getTableHeader().setFont(new Font("DejaVu Sans", Font.BOLD, 14));
        this.tasksTable.getTableHeader().setBackground(new Color(0, 152, 102));
        this.tasksTable.getTableHeader().setForeground(new Color(255, 255, 255));
        this.tasksTable.getColumnModel().getColumn(2).setCellRenderer(new DeadlineColumnRender());
        this.tasksTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonColumnRender("edit"));
        this.tasksTable.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnRender("delete"));
        //this.tasksTable.setAutoCreateRowSorter(true);

    }

    public void initDataController() {
        this.projectController = new ProjectController();
        this.taskController = new TaskController();
    }

    public void initComponentsModel() {
        projectModel = new DefaultListModel<>();
        loadProjects();
        taskModel = new TaskTableModel();
        tasksTable.setModel(taskModel);
//        tasksTable.setAutoCreateRowSorter(true);

        if (!projectModel.isEmpty()) {
            projects.setSelectedIndex(0);
            Project project = (Project) projectModel.get(0);
            loadTasks(project.getId());
        }
    }

    public void loadTasks(int idProject) {
        List<Task> tasks = taskController.findAll(idProject);
        taskModel.setTasks(tasks);
        showTasksTable(!tasks.isEmpty());
    }

    public void loadProjects() {
        List<Project> projects = projectController.findAll();
        projectModel.clear();
        projects.forEach(projectModel::addElement);
        this.projects.setModel(projectModel);

    }
}
