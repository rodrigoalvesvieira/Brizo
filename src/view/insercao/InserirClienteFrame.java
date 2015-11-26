package view.insercao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.Engine;
import model.Cliente;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class InserirClienteFrame {
    private static Engine in;
    static {
        in = new Engine();
    }

    private JFrame frame;
    private JTextField cnpj, nomeEmpresa, email, site, cep, descricao;
    private JTextField fone1, fone2, fone3;

    public InserirClienteFrame() {
        this.frame = new JFrame();
        this.frame.setTitle("Conectividade com JDBC");
        this.frame.setBounds(100, 100, 600, 380);
        this.frame.setLocationByPlatform(true);
        this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);

        JLabel lblBuscarCliente = new JLabel("Inserir Cliente");
        lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBuscarCliente.setBounds(10, 10, 227, 14);
        this.frame.getContentPane().add(lblBuscarCliente);

		/*--------------------LABEL SECTION--------------------*/
        this.nomeEmpresa = new JTextField();
        this.nomeEmpresa.setText("Nome da Empresa");
        this.nomeEmpresa.setColumns(15);
        this.nomeEmpresa.setBounds(10, 50, 178, 20);
        this.frame.getContentPane().add(this.nomeEmpresa);

        this.cnpj = new JTextField();
        this.cnpj.setText("CNPJ");
        this.cnpj.setColumns(15);
        this.cnpj.setBounds(10, 80, 178, 20);
        this.frame.getContentPane().add(this.cnpj);

        this.email = new JTextField();
        this.email.setText("Email");
        this.email.setColumns(15);
        this.email.setBounds(10, 110, 178, 20);
        this.frame.getContentPane().add(this.email);

        this.site = new JTextField();
        this.site.setText("Site");
        this.site.setColumns(15);
        this.site.setBounds(10, 140, 178, 20);
        this.frame.getContentPane().add(this.site);

        this.fone1 = new JTextField();
        this.fone1.setText("Fone 1");
        this.fone1.setColumns(15);
        this.fone1.setBounds(10, 170, 178, 20);
        this.frame.getContentPane().add(this.fone1);

        this.fone2 = new JTextField();
        this.fone2.setText("Fone 2");
        this.fone2.setColumns(15);
        this.fone2.setBounds(10, 200, 178, 20);
        this.frame.getContentPane().add(this.fone2);

        this.fone3 = new JTextField();
        this.fone3.setText("Fone 3");
        this.fone3.setColumns(15);
        this.fone3.setBounds(10, 230, 178, 20);
        this.frame.getContentPane().add(this.fone3);

        cep = new JTextField();
        cep.setText("CEP");
        cep.setColumns(15);
        cep.setBounds(200, 50, 178, 20);
        frame.getContentPane().add(cep);

        descricao = new JTextField();
        descricao.setText("Rua");
        descricao.setColumns(15);
        descricao.setBounds(200, 80, 178, 20);
        frame.getContentPane().add(descricao);
        /*--------------------END SECTION--------------------*/

        JButton clienteBtnInsert = new JButton("Salvar");

        clienteBtnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] telefones = new String[3];

                telefones[0] = fone1.getText();
                telefones[1] = fone2.getText();
                telefones[2] = fone2.getText();

                Cliente novoCliente = new Cliente(
                        nomeEmpresa.getText(),
                        email.getText(),
                        site.getText(),
                        cnpj.getText(),
                        telefones
                );

                try {
                    in.insert(novoCliente);
                    novoCliente.insertEndereco(cep.getText(), descricao.getText());
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        clienteBtnInsert.setBounds(10, 260, 178, 23);
        frame.getContentPane().add(clienteBtnInsert);
    }

}
