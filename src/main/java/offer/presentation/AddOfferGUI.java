package offer.presentation;

import offer.businesslogic.CompanyManager;
import offer.businesslogic.OfferManager;
import offer.businesslogic.RecruiterManager;
import offer.domain.Company;
import offer.domain.Offer;
import offer.domain.Recruiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddOfferGUI {

    private JPanel AddOfferGUI;
    private JTextField companyField;
    private JTextField recruiterField;
    private JTextField amountField;
    private JButton sendButton;
    private JComboBox CompanyCombobox;
    private JButton getDataButton;
    private JComboBox RecruiterComboBox;
    private JComboBox ExtraMonthChoice;
    private JTextField LeaseField;
    private JTextField TotalField;
    private JButton CalculateTotal;


    public static void AddOfferGUI() {
        JFrame frame = new JFrame("AddOfferGUI");
        frame.setContentPane(new AddOfferGUI().AddOfferGUI);
        frame.setPreferredSize(new Dimension(420, 300));
        frame.pack();
        frame.setVisible(true);

    }
    public void setComboBoxCompany() {
        List<Company> companies = new CompanyManager().ListCompanies();
        companies.forEach((company) -> {
            CompanyCombobox.addItem(company.getName());
        });
    }
    public void setComboBoxRecruiter() {
        List<Recruiter> recruiters = new RecruiterManager().ListRecruiters();
        recruiters.forEach((recruiter) -> {
            RecruiterComboBox.addItem(recruiter.getName());
        });
    }
    public void ExtraMonthChoice() {
        ExtraMonthChoice.addItem("Yes");
        ExtraMonthChoice.addItem("No");

    }

    public AddOfferGUI() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Offer newOffer = new Offer(0,
                        RecruiterComboBox.getSelectedItem().toString(),
                        CompanyCombobox.getSelectedItem().toString(),
                        Integer.parseInt(amountField.getText()),
                        getExtraMonthChoice(ExtraMonthChoice.getSelectedItem().toString()),
                        Integer.parseInt(LeaseField.getText()),
                        Integer.parseInt(TotalField.getText())
                        );
                OfferManager.createOffer(newOffer);
                amountField.setText("");
                LeaseField .setText("");
                TotalField.setText("");
            }
        });
        getDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setComboBoxRecruiter();
                setComboBoxCompany();
                ExtraMonthChoice();
            }
        });
        CalculateTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Offer offer = new Offer( 0,
                        RecruiterComboBox.getSelectedItem().toString(),
                        CompanyCombobox.getSelectedItem().toString(),
                        validateInput(amountField.getText()),
                        getExtraMonthChoice(ExtraMonthChoice.getSelectedItem().toString()),
                        validateInput(LeaseField.getText()),
                        0
                );
                OfferManager.calculateTotal(offer);
                String TotalFieldString  = Integer.toString(offer.getTotal());
                TotalField.setText(TotalFieldString);
            }
        });

    }
    public Boolean getExtraMonthChoice(String input) {
        if (input == "Yes"){
            return true;
        } else {
            return false;
        }
    }
    public int validateInput(String input) {
        if (  input.matches("\\d+")) {
            return Integer.parseInt(input);
        } else {
            return 0;
        }
    }
}
