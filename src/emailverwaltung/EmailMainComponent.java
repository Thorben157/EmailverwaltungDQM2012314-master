package emailverwaltung;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailMainComponent {
    private JPanel rootPanel;
    private JTextField textFieldId;
    private JTextField textFieldVorname;
    private JTextField textFieldNachname;
    private JTextField textFieldEmail;
    private JButton suchenButton;
    private JButton buttonFirst;
    private JButton buttonBack;
    private JButton neuButton;
    private JButton sichernButton;
    private JButton löschenButton;
    private JButton buttonLast;
    private JButton buttonNext;

    String emailKontaktAktiv = null;

    public EmailMainComponent() {
        suchenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nr = Integer.parseInt(textFieldId.getText());
                emailKontaktAktiv = EmailKontaktDAO.select(nr);
                textFieldVorname.setText(emailKontaktAktiv.getVorname());
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
