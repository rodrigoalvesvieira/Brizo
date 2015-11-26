package view.insercao;

import controller.Engine;
import model.Equipamento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class InserirEquipamentoFrame {
    private static Engine in;

    static {
        in = new Engine();
    }

    private JFrame frame;
    private JTextField id, nomeEquipamento, tipo, dataUsoInicio, dataUsoTermino;

    public InserirEquipamentoFrame() {
        this.frame = new JFrame();
        this.frame.setTitle("Conectividade com JDBC");
        this.frame.setBounds(100, 100, 600, 380);
        this.frame.setLocationByPlatform(true);
        this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);

        JLabel lblTitulo = new JLabel("Inserir Equipamento");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTitulo.setBounds(10, 10, 227, 14);
        this.frame.getContentPane().add(lblTitulo);

		/*--------------------LABEL SECTION--------------------*/
        this.id = new JTextField();
        this.id.setText("ID do Equipamento");
        this.id.setColumns(15);
        this.id.setBounds(10, 50, 178, 20);
        this.frame.getContentPane().add(this.id);

        this.nomeEquipamento = new JTextField();
        this.nomeEquipamento.setText("Nome do Equipamento");
        this.nomeEquipamento.setColumns(15);
        this.nomeEquipamento.setBounds(10, 80, 178, 20);
        this.frame.getContentPane().add(this.nomeEquipamento);

        this.tipo = new JTextField();
        this.tipo.setText("Tipo");
        this.tipo.setColumns(15);
        this.tipo.setBounds(10, 110, 178, 20);
        this.frame.getContentPane().add(this.tipo);

        this.dataUsoInicio = new JTextField();
        this.dataUsoInicio.setText("Tipo");
        this.dataUsoInicio.setColumns(15);
        this.dataUsoInicio.setBounds(10, 140, 178, 20);
        this.frame.getContentPane().add(this.dataUsoInicio);

        this.dataUsoTermino = new JTextField();
        this.dataUsoTermino.setText("Tipo");
        this.dataUsoTermino.setColumns(15);
        this.dataUsoTermino.setBounds(10, 170, 178, 20);
        this.frame.getContentPane().add(this.dataUsoTermino);
        /*--------------------END SECTION--------------------*/

        JButton equipamentoBtnInsert = new JButton("Salvar");

        equipamentoBtnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipamento novoEquipamento = new Equipamento(
                        Integer.parseInt(id.getText()),
                        nomeEquipamento.getText(),
                        tipo.getText(),
                        dataUsoInicio.getText(),
                        dataUsoTermino.getText()
                );

                try {
                    in.insert(novoEquipamento);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        equipamentoBtnInsert.setBounds(10, 200, 178, 23);
        frame.getContentPane().add(equipamentoBtnInsert);
    }
}
