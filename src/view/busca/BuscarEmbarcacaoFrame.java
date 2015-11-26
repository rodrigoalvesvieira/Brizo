package view.busca;

import controller.Engine;
import model.Embarcacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class BuscarEmbarcacaoFrame {
    private static Engine in;
    static {
        in = new Engine();
    }

    private JTextField certificado;
    private JFrame frame;

    public BuscarEmbarcacaoFrame() {
        frame = new JFrame();
        frame.setTitle("Buscar Embarcação");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        certificado = new JTextField();
        certificado.setText("ID");
        certificado.setColumns(15);
        certificado.setBounds(10, 64, 178, 20);
        frame.getContentPane().add(certificado);

        JButton button = new JButton("Buscar por ID");
        button.setBounds(198, 63, 100, 23);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    in.queryEmbarcacao(Embarcacao.searchById(certificado.getText()));
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        frame.getContentPane().add(button);

        JLabel lblBuscaEmbarcacao = new JLabel("Buscar Embarcacao");
        lblBuscaEmbarcacao.setBounds(10, 11, 125, 14);
        frame.getContentPane().add(lblBuscaEmbarcacao);
    }
}

