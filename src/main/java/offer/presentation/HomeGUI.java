package offer.presentation;

import offer.businesslogic.OfferManager;
import offer.domain.Offer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HomeGUI {
    private JPanel HomeGUI;
    private JPanel HomePanelGUI;
    private JButton getOffersButton;
    private JButton addOfferButton;
    private JButton addRecruiterButton;
    private JButton getRecruiterButton;
    private JButton addCompanyButton;
    private JButton getCompaniesButton;

    public HomeGUI() {
        getOffersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                List<Offer> offers = new OfferManager().ListOffers();
                OfferGUI.OfferGUI(offers);
            }
        });
        addOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddOfferGUI.AddOfferGUI();
            }
        });
        addRecruiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddRecruiterGUI.AddRecruiterGUI();
            }
        });
        getRecruiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RecruiterGUI.RecruiterGUI();
            }
        });
        addCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddCompanyGUI.AddCompanyGUI();
            }
        });
        getCompaniesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CompanyGUI.CompagnyGUI();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HomeGUI");
        frame.setContentPane(new HomeGUI().HomeGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
    }
}
