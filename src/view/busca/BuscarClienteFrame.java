package view.busca;

import controller.Engine;
import model.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class BuscarClienteFrame {
    private static Engine in;
    static {
        in = new Engine();
    }

    private JTextField cnpj;
    private JFrame frame;

    public BuscarClienteFrame() {
        frame = new JFrame();
        frame.setTitle("Buscar Cliente");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        cnpj = new JTextField();
        cnpj.setText("CNPJ");
        cnpj.setColumns(15);
        cnpj.setBounds(10, 64, 178, 20);
        frame.getContentPane().add(cnpj);

        JButton button = new JButton("Buscar por CNPJ");
        button.setBounds(198, 63, 100, 23);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    in.queryCliente(Cliente.searchById(cnpj.getText()));
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        frame.getContentPane().add(button);

        JLabel lblBuscaCliente = new JLabel("Buscar Cliente");
        lblBuscaCliente.setBounds(10, 11, 400, 14);
        frame.getContentPane().add(lblBuscaCliente);
    }
}
