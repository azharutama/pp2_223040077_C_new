package controller;

import model.*;
import view.UserView;
import view.UserPdf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;

    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;

        this.view.addAddUserListener(new AddUserListener());
        this.view.addRefreshListener(new RefreshListener());
        this.view.addUpdateUserListener(new UpdateUserListener());
        this.view.addDeleteUserListener(new DeleteUserListener());
        this.view.addExportPdfListener(new ExportPdfListener());

    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();
            String nrp = view.getNrpInput();
            String noTelp = view.getNoTelpInput();

            if (!name.isEmpty() && !email.isEmpty() && !nrp.isEmpty() && !noTelp.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setNrp(nrp);
                user.setNoTelp(noTelp);
                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<User> users = mapper.getAllUsers();
            Object[][] userData = users.stream()
                    .map(u -> new Object[]{u.getId(), u.getName(), u.getEmail(), u.getNrp(), u.getNoTelp()})
                    .toArray(Object[][]::new);
            view.setTableData(userData);
        }
    }

    class UpdateUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = view.getSelectedUserIndex();
            if (selectedIndex != -1) {
                String name = view.getNameInput();
                String email = view.getEmailInput();
                String nrp = view.getNrpInput();
                String noTelp = view.getNoTelpInput();

                if (!name.isEmpty() && !email.isEmpty() && !nrp.isEmpty() && !noTelp.isEmpty()) {
                    User user = new User();
                    user.setId((int) view.getUserTable().getValueAt(selectedIndex, 0));
                    // Ambil ID dari kolom pertama
                    user.setName(name);
                    user.setEmail(email);
                    user.setNrp(nrp);
                    user.setNoTelp(noTelp);
                    mapper.updateUser(user);
                    JOptionPane.showMessageDialog(view, "User updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(view, "Please fill in all fields.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Please select a user to update.");
            }
        }
    }

    class DeleteUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = view.getSelectedUserIndex();
            if (selectedIndex != -1) {
                int response = JOptionPane.showConfirmDialog(view, "Are you sure you want to delete this user?");
                if (response == JOptionPane.YES_OPTION) {
                    int id = (int) view.getUserTable().getValueAt(selectedIndex, 0); // Menggunakan getter
                    mapper.deleteUser(id);
                    JOptionPane.showMessageDialog(view, "User deleted successfully!");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Please select a user to delete.");
            }
        }
    }

    class ExportPdfListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pdf != null) {  // Pastikan objek pdf tidak null
                List<User> users = mapper.getAllUsers();
                pdf.exportPdf(users);
                JOptionPane.showMessageDialog(view, "PDF exported successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "PDF export failed. PDF object is null.");
            }
        }
    }

}