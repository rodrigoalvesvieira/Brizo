package view.busca;

import controller.Engine;
import model.RepresentanteCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class BuscarRepresentanteClienteFrame {
    private static Engine in;
    static {
        in = new Engine();
    }

    private JTextField cpfRepresentante;
    private JFrame frame;

    public BuscarRepresentanteClienteFrame() {
        frame = new JFrame();
        frame.setTitle("Buscar Representante de Cliente");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        cpfRepresentante = new JTextField();
        cpfRepresentante.setText("CPF do Representante");
        cpfRepresentante.setColumns(15);
        cpfRepresentante.setBounds(10, 64, 178, 20);
        frame.getContentPane().add(cpfRepresentante);

        JButton button = new JButton("Buscar por CPF");
        button.setBounds(198, 63, 100, 23);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    in.queryRepresentanteCliente(RepresentanteCliente.searchById(cpfRepresentante.getText()));
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        frame.getContentPane().add(button);

        JLabel lblBuscaRepresentanteCliente = new JLabel("Buscar Representante");
        lblBuscaRepresentanteCliente.setBounds(10, 11, 125, 14);
        frame.getContentPane().add(lblBuscaRepresentanteCliente);
    }
}
