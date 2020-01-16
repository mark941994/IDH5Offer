package offer.presentation;

import offer.businesslogic.OfferManager;
import offer.domain.Offer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OfferGUI {
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton getOffersButton;
    private JButton addANewOfferButton;


    public static void OfferGUI(List<Offer> offers) {
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
                getOffers();
            }
        });
        addANewOfferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddOfferGUI.AddOfferGUI();
            }
        });
    }

    public void getOffers(){
        List<Offer> offers = new OfferManager().ListOffers();
        AtomicReference<String> text = new AtomicReference<>("");
        offers.forEach((offer) -> {
            text.set(text + "Company: " +offer.getCompany() + "\n"
                    + "Recruiter: " + offer.getRecruiter() + "\n"
                    + "Monthly: " + offer.getMonthly() + "\n"
                    + "Extra month: " + booleanToString(offer.getExtraMonth()) + "\n"
                    + "Lease budget: " + offer.getLeaseBudget() + "\n"
                    + "Total offer: " + offer.getTotal() + "\n\n");
        });
        textArea1.setText(text.get());
    }
    public String booleanToString(Boolean input){
        if (input ==  true) {return "Yes";}
        else {return "No";}
    }
}
