package grafic;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Liceu.Utilizator;

class InterfataSecretar extends JFrame {

	Utilizator currentUser;
	private JLabel jLabel1;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem4;
	private JPanel jPanel1;

	public InterfataSecretar(Utilizator u) {
		currentUser = u;
		initComponents();
	}

	private void initComponents() {
		JLabel userNameLabel = new JLabel("Nume",JLabel.CENTER);
		userNameLabel.setText(currentUser.getNume() + ' '
				+ currentUser.getPrenume());
		JLabel userRolLabel = new JLabel("Rol", JLabel.RIGHT);
		userRolLabel.setText("Secretar");
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenuItem5 = new JMenuItem();
		jMenuItem6 = new JMenuItem();
		jMenu2 = new JMenu();
		jMenuItem4 = new JMenuItem();

		setMaximumSize(new Dimension(1360, 750));
		setMinimumSize(new Dimension(1360, 750));
		setPreferredSize(new Dimension(1360, 750));
		getContentPane().setLayout(new FlowLayout());

		getContentPane().add(userNameLabel);
		getContentPane().add(userRolLabel);

		jMenu1.setText("Meniu");
		jMenuItem2.setText("Adaugare Clasa");
		jMenu1.add(jMenuItem2);
		jMenuItem3.setText("Stergere Clasa");
		jMenu1.add(jMenuItem3);
		jMenuItem5.setText("Adaugare Materie");
		jMenu1.add(jMenuItem5);
		jMenuItem6.setText("Stergere Materie");
		jMenu1.add(jMenuItem6);
		jMenuBar1.add(jMenu1);
		jMenu2.setText("Edit");
		jMenuItem4.setText("Exit");
		jMenuItem4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				InterfataSecretar.this.dispose();
			}
		});
		jMenu2.add(jMenuItem4);
		jMenuBar1.add(jMenu2);
		setJMenuBar(jMenuBar1);
		pack();
	}

}
