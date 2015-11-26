package view.insercao;

import controller.Engine;
import model.Embarcacao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class InserirEmbarcacaoFrame {

    private static Engine in;
    static {
        in = new Engine();
    }

    private JFrame frame;
    private JTextField certificado, tipo, dataFabricacao;

    String tipoSelecionado;

    public InserirEmbarcacaoFrame() {
        this.frame = new JFrame();
        this.frame.setTitle("Conectividade com JDBC");
        this.frame.setBounds(100, 100, 600, 380);
        this.frame.setLocationByPlatform(true);
        this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);

        JLabel lblTitulo = new JLabel("Inserir Embarcação");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblTitulo.setBounds(10, 10, 227, 14);
        this.frame.getContentPane().add(lblTitulo);

		/*--------------------LABEL SECTION--------------------*/
        this.certificado = new JTextField();
        this.certificado.setText("Certificado da Embarcação");
        this.certificado.setColumns(15);
        this.certificado.setBounds(10, 50, 178, 20);
        this.frame.getContentPane().add(this.certificado);

        JList jlst = new JList(Embarcacao.TIPOS);

        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlst.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = jlst.getSelectedIndex();
                if (idx != -1) {
                    tipoSelecionado = Embarcacao.TIPOS[idx].toUpperCase();
                    System.out.println("Current selection: " + tipoSelecionado);
                } else {
                    System.out.println("Escolha um tipo de embarcação.");
                }
            }
        });

        this.frame.add(new JScrollPane(jlst));

//        this.tipo = new JTextField();
//        this.tipo.setText("Tipo da Embarcação");
//        this.tipo.setColumns(15);
//        this.tipo.setBounds(10, 80, 178, 20);
//        this.frame.getContentPane().add(this.tipo);

        this.dataFabricacao = new JTextField();
        this.dataFabricacao.setText("CNPJ da Empresa");
        this.dataFabricacao.setColumns(15);
        this.dataFabricacao.setBounds(10, 110, 178, 20);
        this.frame.getContentPane().add(this.dataFabricacao);
        /*--------------------END SECTION--------------------*/

        JButton embarcacaoBtnInsert = new JButton("Salvar");

        embarcacaoBtnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Embarcacao novaEmbarcacao = new Embarcacao(
                        certificado.getText(),
                        tipoSelecionado,
                        dataFabricacao.getText()
                );

                try {
                    in.insert(novaEmbarcacao);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        embarcacaoBtnInsert.setBounds(10, 140, 178, 23);
        frame.getContentPane().add(embarcacaoBtnInsert);
    }
}
