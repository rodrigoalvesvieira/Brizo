package view.busca;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.Funcionario;
import controller.Engine;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class BuscarFuncionarioFrame {

    private static Engine in;
    static {
        in = new Engine();
    }

    private JTextField cpf;
    private JFrame frame;

    public BuscarFuncionarioFrame() {
        frame = new JFrame();
        frame.setTitle("Buscar Funcionário");
        frame.setBounds(100, 100, 400, 200);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        cpf = new JTextField();
        cpf.setText("CPF");
        cpf.setColumns(15);
        cpf.setBounds(10, 64, 178, 20);
        frame.getContentPane().add(cpf);

        JButton button = new JButton("Buscar por CPF");
        button.setBounds(198, 63, 100, 23);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    in.queryFuncionario(Funcionario.searchById(cpf.getText()));
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        frame.getContentPane().add(button);

        JLabel lblBuscarFuncionario = new JLabel("Buscar Funcionário");
        lblBuscarFuncionario.setBounds(10, 11, 125, 14);
        frame.getContentPane().add(lblBuscarFuncionario);
    }
}
