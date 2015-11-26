package view.insercao;

import controller.Engine;
import model.Cliente;
import model.Projeto;
import model.ProjetoCriacao;
import model.ProjetoRestauracao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author Rodrigo Alves Vieira <rav2>
 */
public class InserirProjetoFrame {
    private static Engine in;
    static {
        in = new Engine();
    }

    private JFrame frame;
    private JTextField id, nome, descricao, orcamento, dataInicio, dataPrevisaoTermino, dataTermino;

    private JTextField modelagem, partesReutilizadas, partesDescartadas;

    public InserirProjetoFrame() {

        this.frame = new JFrame();
        this.frame.setTitle("Conectividade com JDBC");
        this.frame.setBounds(100, 100, 600, 380);
        this.frame.setLocationByPlatform(true);
        this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.frame.getContentPane().setLayout(null);
        this.frame.setVisible(true);

        JLabel lblBuscarCliente = new JLabel("Inserir Projeto");
        lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblBuscarCliente.setBounds(10, 10, 227, 14);
        this.frame.getContentPane().add(lblBuscarCliente);

		/*--------------------LABEL SECTION--------------------*/
        this.id = new JTextField();
        this.id.setText("ID do Projeto");
        this.id.setColumns(15);
        this.id.setBounds(10, 50, 178, 20);
        this.frame.getContentPane().add(this.id);

        this.nome = new JTextField();
        this.nome.setText("Nome do Projeto");
        this.nome.setColumns(15);
        this.nome.setBounds(10, 80, 178, 20);
        this.frame.getContentPane().add(this.nome);

        this.descricao = new JTextField();
        this.descricao.setText("Descrição");
        this.descricao.setColumns(15);
        this.descricao.setBounds(10, 110, 178, 20);
        this.frame.getContentPane().add(this.descricao);

        this.orcamento = new JTextField();
        this.orcamento.setText("Orçamento");
        this.orcamento.setColumns(15);
        this.orcamento.setBounds(10, 140, 178, 20);
        this.frame.getContentPane().add(this.orcamento);

        this.dataInicio = new JTextField();
        this.dataInicio.setText("Data de Início");
        this.dataInicio.setColumns(15);
        this.dataInicio.setBounds(10, 170, 178, 20);
        this.frame.getContentPane().add(this.dataInicio);

        this.dataPrevisaoTermino = new JTextField();
        this.dataPrevisaoTermino.setText("Data de Previsão de Término");
        this.dataPrevisaoTermino.setColumns(15);
        this.dataPrevisaoTermino.setBounds(10, 200, 178, 20);
        this.frame.getContentPane().add(this.dataPrevisaoTermino);

        this.dataTermino = new JTextField();
        this.dataTermino.setText("Data de Término");
        this.dataTermino.setColumns(15);
        this.dataTermino.setBounds(10, 230, 178, 20);
        this.frame.getContentPane().add(this.dataTermino);

        JRadioButton criacao = new JRadioButton("Criação");
        JRadioButton restauracao = new JRadioButton("Restauração");
        ButtonGroup bG = new ButtonGroup();
        bG.add(criacao);
        bG.add(restauracao);
        this.frame.setLayout(new FlowLayout());
        this.frame.add(criacao);
        this.frame.add(restauracao);

        criacao.setSelected(true);

        this.modelagem = new JTextField();
        this.modelagem.setText("Modelagem");
        this.modelagem.setColumns(15);
        this.modelagem.setBounds(10, 260, 178, 20);
        this.frame.getContentPane().add(this.modelagem);

        this.partesReutilizadas = new JTextField();
        this.partesReutilizadas.setText("Partes Reutilizadas");
        this.partesReutilizadas.setColumns(15);
        this.partesReutilizadas.setBounds(10, 260, 178, 20);
        this.frame.getContentPane().add(this.partesReutilizadas);

        this.partesDescartadas = new JTextField();
        this.partesDescartadas.setText("Partes Descartadas");
        this.partesDescartadas.setColumns(15);
        this.partesDescartadas.setBounds(10, 290, 178, 20);
        this.frame.getContentPane().add(this.partesDescartadas);

        JButton projetoBtnInsert = new JButton("Salvar");
            projetoBtnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Projeto projeto;

                if (criacao.isSelected()) {
                    projeto = new ProjetoCriacao(
                            modelagem.getText(),
                            Integer.parseInt(id.getText()),
                            nome.getText(),
                            descricao.getText(),
                            Double.parseDouble(orcamento.getText()),
                            dataInicio.getText(),
                            dataPrevisaoTermino.getText(),
                            dataTermino.getText()
                    );
                } else {
                    projeto = new ProjetoRestauracao(
                            Integer.parseInt(partesReutilizadas.getText()),
                            Integer.parseInt(partesDescartadas.getText()),
                            Integer.parseInt(id.getText()),
                            nome.getText(),
                            descricao.getText(),
                            Double.parseDouble(orcamento.getText()),
                            dataInicio.getText(),
                            dataPrevisaoTermino.getText(),
                            dataTermino.getText()
                    );
                }

                try {
                    in.insert(projeto);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        projetoBtnInsert.setBounds(10, 260, 178, 23);
        frame.getContentPane().add(projetoBtnInsert);
    }
}
