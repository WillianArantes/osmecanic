
package com.mycompany.osmecanicc.views;

import javax.swing.*;
import java.awt.*;

public class OrdemServicoFrame extends JFrame {

    public OrdemServicoFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Ordem de Serviço");
        setSize(600, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));

        JTextField nomeCliente = new JTextField(), contato = new JTextField(), endereco = new JTextField();
        panel.add(new JLabel("Nome do Cliente:")); panel.add(nomeCliente);
        panel.add(new JLabel("Contato:")); panel.add(contato);
        panel.add(new JLabel("Endereço:")); panel.add(endereco);

        JTextField marca = new JTextField(), modelo = new JTextField(), ano = new JTextField(), placa = new JTextField();
        panel.add(new JLabel("Marca:")); panel.add(marca);
        panel.add(new JLabel("Modelo:")); panel.add(modelo);
        panel.add(new JLabel("Ano:")); panel.add(ano);
        panel.add(new JLabel("Placa:")); panel.add(placa);

        JTextArea sintomas = new JTextArea(3, 20);
        panel.add(new JLabel("Sintomas:")); panel.add(new JScrollPane(sintomas));

        JTextArea servicos = new JTextArea(3, 20);
        panel.add(new JLabel("Serviços (desc - custo):")); panel.add(new JScrollPane(servicos));

        JTextArea pecas = new JTextArea(3, 20);
        panel.add(new JLabel("Peças (nome - qtd - preço):")); panel.add(new JScrollPane(pecas));

        JTextArea resultado = new JTextArea(10, 40);
        resultado.setEditable(false);
        JButton gerarButton = new JButton("Gerar OS");

        gerarButton.addActionListener(e -> {
            try {
                double total = 0;

                for (String linha : servicos.getText().split("\n")) {
                    if (!linha.trim().isEmpty()) {
                        String[] p = linha.split("-");
                        total += Double.parseDouble(p[1].trim());
                    }
                }

                for (String linha : pecas.getText().split("\n")) {
                    if (!linha.trim().isEmpty()) {
                        String[] p = linha.split("-");
                        int qtd = Integer.parseInt(p[1].trim());
                        double preco = Double.parseDouble(p[2].trim());
                        total += qtd * preco;
                    }
                }

                resultado.setText("=== ORDEM DE SERVIÇO ===\n");
                resultado.append("Cliente: " + nomeCliente.getText() + "\n");
                resultado.append("Contato: " + contato.getText() + "\n");
                resultado.append("Endereço: " + endereco.getText() + "\n");
                resultado.append("Veículo: " + marca.getText() + " " + modelo.getText() + " " +
                                 ano.getText() + " - " + placa.getText() + "\n");
                resultado.append("Sintomas: " + sintomas.getText() + "\n");
                resultado.append("Serviços:\n" + servicos.getText() + "\n");
                resultado.append("Peças:\n" + pecas.getText() + "\n");
                resultado.append("TOTAL: R$ " + total + "\n");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(panel);
        container.add(gerarButton);
        container.add(new JScrollPane(resultado));

        add(container);
    }
}
