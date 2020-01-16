package offer.presentation;

import offer.businesslogic.CompanyManager;
import offer.domain.Company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCompanyGUI {
    private JPanel AddCompanyGUI;
    private JTextField CompanyNameField;
    private JButton sendButton;

    public static void AddCompanyGUI() {
        JFrame frame = new JFrame("AddCompanyGUI");
        frame.setContentPane(new AddCompanyGUI().AddCompanyGUI);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
    }

    public AddCompanyGUI() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Company newCompany = new Company(0, CompanyNameField.getText());
                CompanyManager.createCompany(newCompany);
                CompanyNameField.setText("");
            }
        });
    }

}
