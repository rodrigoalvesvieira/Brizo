package view;

import view.busca.*;
import view.insercao.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * @author Rodrigo Alves Vieira <rav2>
 *
 */
public class MainFrame extends JFrame {

    static class ActionBtnInsert implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent arg0) {
            new InserirFuncionarioFrame();
        }
    }

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JPanel panel;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 800, 700);
        setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);
        this.setTitle("Brizo - Interface JDBC para o Estaleiro");

        JLabel timerLabel = new JLabel("Brizo", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 50));

        timerLabel.setForeground(Color.BLUE);
        timerLabel.setBounds(250, 0, 300, 100);

        panel.add(timerLabel);

        /*--------------------INSERTION BUTTONS SECTION--------------------*/

        /* First row */

        JButton insertBtnFuncionario = new JButton("Inserir Funcionário");
        insertBtnFuncionario.addActionListener(new ActionBtnInsert());
        insertBtnFuncionario.setBounds(15, 80, 200, 80);
        panel.add(insertBtnFuncionario);

        JButton insertBtnCliente = new JButton("Inserir Cliente");
        insertBtnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new InserirClienteFrame();
            }
        });
        insertBtnCliente.setBounds(215, 80, 200, 80);
        panel.add(insertBtnCliente);

        JButton insertBtnRepresentanteCliente = new JButton("Inserir Representante de Cliente");
        insertBtnRepresentanteCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new InserirRepresentanteClienteFrame();
            }
        });
        insertBtnRepresentanteCliente.setBounds(415, 80, 300, 80);
        panel.add(insertBtnRepresentanteCliente);

        /* Second row */

        JButton insertBtnSetor = new JButton("Inserir Setor");
        insertBtnSetor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new InserirSetorFrame();
            }
        });
        insertBtnSetor.setBounds(15, 170, 190, 80);
        panel.add(insertBtnSetor);

        JButton insertBtnEmbarcacao = new JButton("Inserir Embarcação");
        insertBtnEmbarcacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new InserirEmbarcacaoFrame();
            }
        });
        insertBtnEmbarcacao.setBounds(215, 170, 200, 80);
        panel.add(insertBtnEmbarcacao);

        JButton insertBtnProjeto = new JButton("Inserir Projeto");
        insertBtnProjeto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new InserirProjetoFrame();
            }
        });
        insertBtnProjeto.setBounds(415, 170, 200, 80);
        panel.add(insertBtnProjeto);

        /* Third row */

        JButton insertBtnEquipamento = new JButton("Inserir Equipamento");
        insertBtnEquipamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new InserirEquipamentoFrame();
            }
        });
        insertBtnEquipamento.setBounds(15, 260, 200, 80);
        panel.add(insertBtnEquipamento);
        /*--------------------END SECTION--------------------*/


        /*--------------------QUERY BUTTONS SECTION--------------------*/

        /* First row */
        JButton searchBtnFuncionario = new JButton("Buscar Funcionário");
        searchBtnFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new BuscarFuncionarioFrame();
            }
        });
        searchBtnFuncionario.setBounds(15, 410, 200, 80);
        panel.add(searchBtnFuncionario);

        JButton searchBtnCliente = new JButton("Buscar Cliente");
        searchBtnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new BuscarClienteFrame();
            }
        });
        searchBtnCliente.setBounds(215, 410, 200, 80);
        panel.add(searchBtnCliente);

        JButton searchBtnRepresentanteCliente = new JButton("Buscar Representante de Cliente");
        searchBtnRepresentanteCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new BuscarRepresentanteClienteFrame();
            }
        });
        searchBtnRepresentanteCliente.setBounds(415, 410, 300, 80);
        panel.add(searchBtnRepresentanteCliente);

        /* Second Row */
        JButton searchBtnSetor = new JButton("Buscar Setor");
        searchBtnRepresentanteCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new BuscarSetorFrame();
            }
        });
        searchBtnSetor.setBounds(15, 500, 200, 80);
        panel.add(searchBtnSetor);

        JButton searchBtnEmbarcacao = new JButton("Buscar Embarcação");
        searchBtnEmbarcacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new BuscarEmbarcacaoFrame();
            }
        });
        searchBtnEmbarcacao.setBounds(215, 500, 200, 80);
        panel.add(searchBtnEmbarcacao);

        JButton searchBtnProjeto = new JButton("Buscar Projeto");
        searchBtnProjeto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new BuscarProjetoFrame();
            }
        });
        searchBtnProjeto.setBounds(415, 500, 200, 80);
        panel.add(searchBtnProjeto);

        /* Third row */
        JButton searchBtnEquipamento = new JButton("Buscar Equipamento");
        searchBtnEquipamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new BuscarEquipamentoFrame();
            }
        });
        searchBtnEquipamento.setBounds(15, 590, 200, 80);
        panel.add(searchBtnEquipamento);

        /*------------------------END SECTION--------------------*/
    }
}
