package view.busca;

import controller.Engine;
import model.Setor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class BuscarSetorFrame {
    private static Engine in;
    static {
        in = new Engine();
    }

    private JTextField id;
    private JFrame frame;

    public BuscarSetorFrame() {
        frame = new JFrame();
        frame.setTitle("Buscar Setor");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        id = new JTextField();
        id.setText("ID");
        id.setColumns(15);
        id.setBounds(10, 64, 178, 20);
        frame.getContentPane().add(id);

        JButton button = new JButton("Buscar por ID");
        button.setBounds(198, 63, 100, 23);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    in.querySetor(Setor.searchById(id.getText()));
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        frame.getContentPane().add(button);

        JLabel lblBuscaSetor = new JLabel("Buscar Setor");
        lblBuscaSetor.setBounds(10, 11, 125, 14);
        frame.getContentPane().add(lblBuscaSetor);
    }
}
