package offer.presentation;

import offer.businesslogic.CompanyManager;
import offer.businesslogic.OfferManager;
import offer.domain.Company;
import offer.domain.Offer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OfferGUI {

    private JPanel panel1;
    private JButton getOffersButton;
    private JButton addANewOfferButton;
    private JComboBox SelectOffer;
    private JTextField CompanyField;
    private JTextField RecruiterField;
    private JTextField MonthlyField;
    private JTextField LeasebudgetField;
    private JCheckBox extraMonth;
    private JTextField TotalField;
    private JButton updateButton;
    private JButton calcTotalButton;
    private JTextField IdField;
    public Boolean canUpdate;

    public static void OfferGUI() {
        JFrame frame = new JFrame("OfferGUI");
        frame.setContentPane(new OfferGUI().panel1);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();

        frame.setVisible(true);

    }

    public OfferGUI() {
        getOffersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                canUpdate = false;
                emptyComboBoxOffers();

            }
        });
        addANewOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddOfferGUI.AddOfferGUI();
            }
        });
        SelectOffer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (canUpdate == true) {
                    selectOffer(SelectOffer.getSelectedItem().toString());
                }
            }
        });
        calcTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Offer offer = new Offer( 0,

                        RecruiterField.getText(),
                        CompanyField.getText(),
                        validateInput(MonthlyField.getText()),
                        extraMonth.isSelected(),
                        validateInput(LeasebudgetField.getText()),
                        0
                );
                OfferManager.calculateTotal(offer);
                String TotalFieldString  = Integer.toString(offer.getTotal());
                TotalField.setText(TotalFieldString);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Offer updatedOffer = new Offer(validateInput(IdField.getText()),
                        RecruiterField.getText(),
                        CompanyField.getText(),
                        validateInput(MonthlyField.getText()),
                        extraMonth.isSelected(),
                        validateInput(LeasebudgetField.getText()),
                        validateInput(TotalField.getText())
                );
                OfferManager.updateOffer(updatedOffer);
                //emptyComboBoxOffers();
            }
        });
    }
    public void setComboBoxOffers() {
        List<Offer> offers = new OfferManager().ListOffers();
        offers.forEach((offer) -> {
            SelectOffer.addItem(offer.getCompany());
        });
    }
    public void emptyComboBoxOffers() {

        int count = SelectOffer.getItemCount();
        if(count > 0) {
            SelectOffer.removeAllItems();
        }

        IdField.setText("");
        CompanyField.setText("");
        RecruiterField.setText("");
        MonthlyField.setText("");
        extraMonth.setSelected(false);
        LeasebudgetField.setText("");
        TotalField.setText("");
        canUpdate = true;
        setComboBoxOffers();

    }

    public void selectOffer(String company){

        List<Offer> offers = new OfferManager().ListOffers();

        offers.forEach((offer) -> {
            if (offer.getCompany().equals(company)) {
                IdField.setText(String.valueOf(offer.getOfferId()));
                CompanyField.setText(offer.getCompany());
                RecruiterField.setText(offer.getRecruiter());
                MonthlyField.setText(String.valueOf(offer.getMonthly()));
                LeasebudgetField.setText(String.valueOf(offer.getLeaseBudget()));
                extraMonth.setSelected(offer.getExtraMonth());
                TotalField.setText(String.valueOf(offer.getTotal()));

            }
        });

    }


    public String booleanToString(Boolean input){
        if (input ==  true) {return "Yes";}
        else {return "No";}
    }
    public int validateInput(String input) {
        if (  input.matches("\\d+")) {
            return Integer.parseInt(input);
        } else {
            return 0;
        }
    }
}
