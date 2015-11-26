package view.insercao;

import controller.Engine;
import model.RepresentanteCliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class InserirRepresentanteClienteFrame {
    private static Engine in;
    static {
        in = new Engine();
    }

    private JFrame frame;
    private JTextField nome, cpfRepresentante, empresaCnpj;

    public InserirRepresentanteClienteFrame() {
        this.frame = new JFrame();
        this.frame.setTitle("Conectividade com JDBC");
        this.frame.setBounds(100, 100, 600, 380);
        this.frame.setLocationByPlatform(true);
        this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);

        JLabel lblTitulo = new JLabel("Inserir Representante de Cliente");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTitulo.setBounds(10, 10, 227, 14);
        this.frame.getContentPane().add(lblTitulo);

		/*--------------------LABEL SECTION--------------------*/
        this.nome = new JTextField();
        this.nome.setText("Nome do Representante");
        this.nome.setColumns(15);
        this.nome.setBounds(10, 50, 178, 20);
        this.frame.getContentPane().add(this.nome);

        this.cpfRepresentante = new JTextField();
        this.cpfRepresentante.setText("CPF do Representante");
        this.cpfRepresentante.setColumns(15);
        this.cpfRepresentante.setBounds(10, 80, 178, 20);
        this.frame.getContentPane().add(this.cpfRepresentante);

        this.empresaCnpj = new JTextField();
        this.empresaCnpj.setText("CNPJ da Empresa");
        this.empresaCnpj.setColumns(15);
        this.empresaCnpj.setBounds(10, 110, 178, 20);
        this.frame.getContentPane().add(this.empresaCnpj);
        /*--------------------END SECTION--------------------*/

        JButton representanteBtnInsert = new JButton("Salvar");

        representanteBtnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RepresentanteCliente novoRepresentante = new RepresentanteCliente(
                        cpfRepresentante.getText(),
                        empresaCnpj.getText(),
                        nome.getText()
                );

                try {
                    in.insert(novoRepresentante);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        representanteBtnInsert.setBounds(10, 140, 178, 23);
        frame.getContentPane().add(representanteBtnInsert);
    }
}
