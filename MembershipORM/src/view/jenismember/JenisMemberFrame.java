package view.jenismember;

import dao.JenisMemberDao;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.JenisMember;

public class JenisMemberFrame extends JFrame {

    private List<JenisMember> jenisMemberList; // Perbaikan tipe List
    private JTextField textFieldNama;
    private JenisMemberTableModel tableModel;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {

        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Jenis Member Management");

        // Label input
        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 20, 350, 20);

        // TextField untuk input nama
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 50, 350, 30);

        // Tombol simpan
        JButton button = new JButton("Simpan");
        button.setBounds(15, 90, 100, 30);

        // Tabel untuk menampilkan data
        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 140, 350, 300);

        // Menyiapkan model tabel
        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);

        // Menambahkan listener ke tombol simpan
        JenisMemberButtonSimpanActionListener actionListener =
                new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);

        button.addActionListener(actionListener);

        // Menambahkan komponen ke frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);

        // Pengaturan ukuran dan layout frame
        this.setSize(400, 500);
        this.setLayout(null);
    }

    /**
     * Mendapatkan teks nama dari textField.
     *
     * @return nama yang diinputkan
     */
    public String getNama() {
        return textFieldNama.getText();
    }

    /**
     * Menambahkan JenisMember baru ke tabel dan mengosongkan input.
     *
     * @param jenisMember objek JenisMember yang akan ditambahkan
     */
    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);
        textFieldNama.setText("");
    }
}
