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
import model.Funcionario;

/**
 * @author Rodrigo Alves Vieira <rav2>
 *
 */
public class InserirFuncionarioFrame {

    private static Engine in;
    static {
        in = new Engine();
    }
    private JFrame frame;

    private JTextField nome, cpf, dataAdmissao, dataNascimento, cpfSuper, cep, descricao;
    private JTextField fone1, fone2, fone3;

    public InserirFuncionarioFrame() {
        frame = new JFrame();
        frame.setTitle("Conectividade com JDBC");
        frame.setBounds(100, 100, 600, 380);
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel lblBuscarCliente = new JLabel("Inserir Funcionário");
        lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBuscarCliente.setBounds(10, 10, 227, 14);
        frame.getContentPane().add(lblBuscarCliente);

		/*--------------------LABEL SECTION--------------------*/
        nome = new JTextField();
        nome.setText("Nome");
        nome.setColumns(15);
        nome.setBounds(10, 50, 178, 20);
        frame.getContentPane().add(nome);

        cpf = new JTextField();
        cpf.setText("CPF");
        cpf.setColumns(15);
        cpf.setBounds(10, 80, 178, 20);
        frame.getContentPane().add(cpf);

        dataAdmissao = new JTextField();
        dataAdmissao.setText("Data de Admissão");
        dataAdmissao.setColumns(15);
        dataAdmissao.setBounds(10, 110, 178, 20);
        frame.getContentPane().add(dataAdmissao);

        dataNascimento = new JTextField();
        dataNascimento.setText("Data de Nascimento");
        dataNascimento.setColumns(15);
        dataNascimento.setBounds(10, 140, 178, 20);
        frame.getContentPane().add(dataNascimento);

        fone1 = new JTextField();
        fone1.setText("Telefone 1");
        fone1.setColumns(15);
        fone1.setBounds(10, 170, 178, 20);
        frame.getContentPane().add(fone1);

        fone2 = new JTextField();
        fone2.setText("Telefone 2");
        fone2.setColumns(15);
        fone2.setBounds(10, 200, 178, 20);
        frame.getContentPane().add(fone2);

        fone3 = new JTextField();
        fone3.setText("Telefone 3");
        fone3.setColumns(15);
        fone3.setBounds(10, 230, 178, 20);
        frame.getContentPane().add(fone3);

        cpfSuper = new JTextField();
        cpfSuper.setText("CPF do Supervisor");
        cpfSuper.setColumns(15);
        cpfSuper.setBounds(10, 260, 178, 20);
        frame.getContentPane().add(cpfSuper);

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

        JButton clientBtnInsert = new JButton("Inserir Funcionário");

        clientBtnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] telefones = new String[3];

                telefones[0] = fone1.getText();
                telefones[1] = fone2.getText();
                telefones[2] = fone3.getText();

                Funcionario novoFuncionario = new Funcionario(
                        cpf.getText(),
                        nome.getText(),
                        dataAdmissao.getText(),
                        dataNascimento.getText(),
                        telefones,
                        cpfSuper.getText()
                        );

                try {
                    in.insert(novoFuncionario);

                    novoFuncionario.insertEndereco(cep.getText(), descricao.getText());
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        clientBtnInsert.setBounds(10, 290, 178, 23);
        frame.getContentPane().add(clientBtnInsert);
    }

    public void setVisible(boolean v) {
        this.frame.setVisible(v);
    }
}
