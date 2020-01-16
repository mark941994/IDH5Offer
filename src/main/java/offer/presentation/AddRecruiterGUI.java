package offer.presentation;

import offer.businesslogic.RecruiterManager;
import offer.domain.Recruiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRecruiterGUI {
    private JPanel AddRecruiterGUI;
    private JTextField PhoneField;
    private JTextField NameField;
    private JTextField EmailField;
    private JButton sendButton;

    public AddRecruiterGUI() {
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Recruiter newRecruiter = new Recruiter(0,NameField.getText(),EmailField.getText(),PhoneField.getText() );
                RecruiterManager.createRecruiter(newRecruiter);

                NameField.setText("");
                EmailField.setText("");
                PhoneField.setText("");
            }
        });
    }

    public static void AddRecruiterGUI() {
        JFrame frame = new JFrame("AddRecruiterGUI");
        frame.setContentPane(new AddRecruiterGUI().AddRecruiterGUI);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setVisible(true);
    }
}
