package offer.presentation;

import offer.businesslogic.CompanyManager;
import offer.domain.Company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CompanyGUI {
    private JTextArea textArea1;
    private JPanel OfferGUI;
    private JButton getCompaniesButton;
    private JButton addNewCompanyButton;

    public static void CompagnyGUI() {
        JFrame frame = new JFrame("CompanyGUI");
        frame.setContentPane(new CompanyGUI().OfferGUI);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
    }

    public CompanyGUI() {
        getCompaniesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getCompagnies();
            }
        });
        addNewCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddCompanyGUI.AddCompanyGUI();
            }
        });
    }
    public void getCompagnies(){
        List<Company> companies = new CompanyManager().ListCompanies();
        AtomicReference<String> text = new AtomicReference<>("");
        companies.forEach((company) -> {
            text.set(text + "Company: " + company.getName() + "\n\n");

        });
        textArea1.setText(text.get());
    }
}
