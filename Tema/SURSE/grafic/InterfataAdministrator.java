package grafic;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import Liceu.Administrator;
import Liceu.Centralizator;
import Liceu.Clasa;
import Liceu.Elev;
import Liceu.Secretar;
import Liceu.Utilizator;

class InterfataAdministrator extends JFrame {

	Utilizator currentUser;
	private JLabel jLabel1;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem7;
	private JMenuItem jMenuItem8;
	private JMenuItem jMenuItem9;
	private JMenuItem jMenuItem10;
	private JPanel jPanel1;

	public InterfataAdministrator(Utilizator u) {
		currentUser = u;
		initComponents();
	}

	private void initComponents() {
		JLabel userNameLabel = new JLabel("Nume", JLabel.CENTER);
		userNameLabel.setText(currentUser.getNume() + ' '
				+ currentUser.getPrenume());
		JLabel userRolLabel = new JLabel("Rol", JLabel.RIGHT);
		userRolLabel.setText("Administrator");
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenuItem2 = new JMenuItem();
		jMenuItem5 = new JMenuItem();
		jMenuItem6 = new JMenuItem();
		jMenuItem7 = new JMenuItem();
		jMenuItem8 = new JMenuItem();
		jMenuItem9 = new JMenuItem();
		jMenuItem10 = new JMenuItem();
		jMenu2 = new JMenu();
		jMenuItem4 = new JMenuItem();

		final Administrator admin = (Administrator) currentUser;
		final DefaultListModel model = new DefaultListModel();
		final JList list = new JList(model);
		list.setSize(200, 300);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(10);
		list.setVisible(false);

		setMaximumSize(new Dimension(1360, 750));
		setMinimumSize(new Dimension(1360, 750));
		setPreferredSize(new Dimension(1360, 750));
		getContentPane().setLayout(new FlowLayout());

		getContentPane().add(userNameLabel);
		getContentPane().add(userRolLabel);
		getContentPane().add(list);

		jMenu1.setText("Meniu");
		jMenuItem2.setText("Creare Utilizator");
		jMenu1.add(jMenuItem2);
		jMenuItem3.setText("Listare Utilizatori");
		jMenuItem3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.clear();
				for (Utilizator ut : Centralizator.getInstance()
						.getUtilizatori()) {

					model.addElement(ut);
				}
				list.setVisible(true);
			}
		});

		jMenu1.add(jMenuItem3);

		jMenuItem9.setText("Alege Clasa");
		jMenu1.add(jMenuItem9);
		jMenuItem10.setText("Informatii Elevi");
		jMenu1.add(jMenuItem10);

		jMenuBar1.add(jMenu1);
		jMenuItem4.setText("Exit");
		jMenuItem4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				InterfataAdministrator.this.dispose();
			}
		});
		jMenuItem5.setText("Adaugare Clasa");
		jMenu2.add(jMenuItem5);
		jMenuItem6.setText("Stergere Clasa");
		jMenu2.add(jMenuItem6);
		jMenuItem7.setText("Adaugare Materie");
		jMenu2.add(jMenuItem7);
		jMenuItem8.setText("Stergere Materie");
		jMenu2.add(jMenuItem8);
		jMenu2.add(jMenuItem4);
		jMenu2.setText("Edit");

		jMenuBar1.add(jMenu2);
		setJMenuBar(jMenuBar1);
		pack();
	}

}
