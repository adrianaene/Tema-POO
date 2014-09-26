package grafic;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import Liceu.Centralizator;
import Liceu.Utilizator;

class Login {

	private JFrame loginFereastra;
	private JPanel loginPanel;

	public Login() {
		loginFereastra = new JFrame();
		loginFereastra.setBounds(200, 200, 450, 300);
		loginFereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout());
		loginFereastra.add(loginPanel);
		loginFereastra.setVisible(true);
	}

	private void show() {
		JLabel numelabel = new JLabel("User ID: ", JLabel.RIGHT);
		JLabel parolaLabel = new JLabel("Parola: ", JLabel.CENTER);
		final JTextField userText = new JTextField(8);
		final JPasswordField parolaText = new JPasswordField(8);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userNumeString = userText.getText();
				String parolaString = new String(parolaText.getPassword());

				for (Utilizator u : Centralizator.getInstance()
						.getUtilizatori()) {
					if (u.getNumeUtilizator().equals(userNumeString)
							&& u.getParola().equals(parolaString)
							&& u.getNumeUtilizator().contains("Elev")) {
						InterfataElev window = new InterfataElev(u);
						window.setVisible(true);
					} 
					if (u.getNumeUtilizator().equals(userNumeString)
							&& u.getParola().equals(parolaString)
							&& u.getNumeUtilizator().contains("Secretar")) {
						InterfataSecretar window = new InterfataSecretar(u);
						window.setVisible(true);
					}
					if (u.getNumeUtilizator().equals(userNumeString)
							&& u.getParola().equals(parolaString)
							&& u.getNumeUtilizator().startsWith("Administrator")) {
						InterfataAdministrator window = new InterfataAdministrator(u);
						window.setVisible(true);
					}
					 if(u.getNumeUtilizator().equals(userNumeString)
							&& u.getParola().equals(parolaString)&& u.getNumeUtilizator().startsWith("Profesor")){
						InterfataProfesor window = new InterfataProfesor(u);
						window.setVisible(true);
					}
				}

			}
		});

		loginPanel.add(numelabel);
		loginPanel.add(userText);
		loginPanel.add(parolaLabel);
		loginPanel.add(parolaText);
		loginPanel.add(loginButton);
		loginFereastra.setVisible(true);
	}

	public static void main(String[] args) {
		Login login = new Login();
		login.show();
	}
}
