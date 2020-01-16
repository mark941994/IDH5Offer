package offer.presentation;

import offer.businesslogic.RecruiterManager;
import offer.domain.Recruiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class RecruiterGUI {

    private JPanel RecruiterGUI;
    private JButton addRecruiterButton;
    private JTextArea recruiterOverview;
    private JButton getRecruitersButton;


    public RecruiterGUI() {
        addRecruiterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddRecruiterGUI.AddRecruiterGUI();
            }
        });

        getRecruitersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getRecruiters();
            }
        });
    }

    public static void RecruiterGUI() {
        JFrame frame = new JFrame("RecruiterGUI");
        frame.setContentPane(new RecruiterGUI().RecruiterGUI);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);


    }
    public void getRecruiters(){
        List<Recruiter> recruiters = new RecruiterManager().ListRecruiters();
        AtomicReference<String> text = new AtomicReference<>("");
        recruiters.forEach((recruiter) -> {
            text.set(text + "Name: " +recruiter.getName() + "\n"
                    + "Email: " + recruiter.getEmail() + "\n"
                    + "Phone: " + recruiter.getPhone() + "\n\n");

        });
        recruiterOverview.setText(text.get());
    }



}
