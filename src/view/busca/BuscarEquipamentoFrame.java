package view.busca;

import controller.Engine;
import model.Equipamento;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class BuscarEquipamentoFrame {
    private static Engine in;
    static {
        in = new Engine();
    }

    private JTextField id;
    private JFrame frame;

    public BuscarEquipamentoFrame() {
        frame = new JFrame();
        frame.setTitle("Buscar Equipamento");
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
                    in.queryEquipamento(Equipamento.searchById(id.getText()));
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        frame.getContentPane().add(button);

        JLabel lblBuscaEquipamento = new JLabel("Buscar Equipamento");
        lblBuscaEquipamento.setBounds(10, 11, 125, 14);
        frame.getContentPane().add(lblBuscaEquipamento);
    }
}

