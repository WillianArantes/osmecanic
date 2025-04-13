
package com.mycompany.osmecanicc.views;

import javax.swing.*;

public class MenuPrincipalFrame extends JFrame {

    public MenuPrincipalFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Menu Principal");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton novaOSButton = new JButton("Nova Ordem de Serviço");
        novaOSButton.addActionListener(e -> new OrdemServicoFrame().setVisible(true));

        JPanel panel = new JPanel();
        panel.add(novaOSButton);
        add(panel);
    }
}
