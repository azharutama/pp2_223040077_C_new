package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserView extends JFrame {
    private JTextField txtName = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JTextField txtNrp = new JTextField(20);
    private JTextField txtNoTelp = new JTextField(20);
    private JButton btnAdd = new JButton("Add User");
    private JButton btnUpdate = new JButton("Update User");
    private JButton btnDelete = new JButton("Delete User");
    private JButton btnRefresh = new JButton("Refresh");
    private  JButton btnExport = new JButton("Export PDF");
    private JTable userTable;
    private DefaultTableModel tableModel;

    public UserView() {
        setTitle("User Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel input
        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(new JLabel("Name:"));
        panel.add(txtName);
        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);
        panel.add(new JLabel("NRP:"));
        panel.add(txtNrp);
        panel.add(new JLabel("No Telepon:"));
        panel.add(txtNoTelp);

        // Panel tombol
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnExport);
        panel.add(buttonPanel);

        // Tabel data pengguna
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Email", "NRP", "No Telp"}, 0);
        userTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(userTable);

        add(panel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);
    }

    // Getter untuk input
    public String getNameInput() {
        return txtName.getText();
    }

    public String getEmailInput() {
        return txtEmail.getText();
    }

    public String getNrpInput() {
        return txtNrp.getText();
    }

    public String getNoTelpInput() {
        return txtNoTelp.getText();
    }

    public void setTableData(Object[][] data) {
        tableModel.setRowCount(0); // Hapus data lama
        for (Object[] row : data) {
            tableModel.addRow(row); // Tambahkan data baru
        }
    }

    public int getSelectedUserIndex() {
        return userTable.getSelectedRow();
    }


    public JTable getUserTable() {
        return userTable;
    }
    public void addAddUserListener(ActionListener listener) {
        btnAdd.addActionListener(listener);
    }

    public void addUpdateUserListener(ActionListener listener) {
        btnUpdate.addActionListener(listener);
    }

    public void addDeleteUserListener(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }

    public void addRefreshListener(ActionListener listener) {
        btnRefresh.addActionListener(listener);
    }

    public void addExportPdfListener(ActionListener listener) {
        btnExport.addActionListener(listener);
    }


}
