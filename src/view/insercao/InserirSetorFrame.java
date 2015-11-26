package view.insercao;

import controller.Engine;
import model.Setor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class InserirSetorFrame {
    private static Engine in;

    static {
        in = new Engine();
    }

    private JFrame frame;
    private JTextField id, nomeSetor, descricao;

    public InserirSetorFrame() {
        this.frame = new JFrame();
        this.frame.setTitle("Conectividade com JDBC");
        this.frame.setBounds(100, 100, 600, 380);
        this.frame.setLocationByPlatform(true);
        this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);

        JLabel lblTitulo = new JLabel("Inserir Setor");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTitulo.setBounds(10, 10, 227, 14);
        this.frame.getContentPane().add(lblTitulo);

		/*--------------------LABEL SECTION--------------------*/
        this.id = new JTextField();
        this.id.setText("ID do Setor");
        this.id.setColumns(15);
        this.id.setBounds(10, 50, 178, 20);
        this.frame.getContentPane().add(this.id);

        this.nomeSetor = new JTextField();
        this.nomeSetor.setText("Nome do Setor");
        this.nomeSetor.setColumns(15);
        this.nomeSetor.setBounds(10, 80, 178, 20);
        this.frame.getContentPane().add(this.nomeSetor);

        this.descricao = new JTextField();
        this.descricao.setText("Descrição");
        this.descricao.setColumns(15);
        this.descricao.setBounds(10, 110, 178, 20);
        this.frame.getContentPane().add(this.descricao);
        /*--------------------END SECTION--------------------*/

        JButton setorBtnInsert = new JButton("Salvar");

        setorBtnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Setor novoSetor = new Setor(
                        Integer.parseInt(id.getText()),
                        nomeSetor.getText(),
                        descricao.getText()
                );

                try {
                    in.insert(novoSetor);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        setorBtnInsert.setBounds(10, 140, 178, 23);
        frame.getContentPane().add(setorBtnInsert);

    }
}
