package grafic;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
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
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Liceu.Centralizator;
import Liceu.Clasa;
import Liceu.Elev;
import Liceu.Utilizator;

class InterfataElev extends JFrame {

	private Utilizator currentUser;
	private JLabel jLabel1;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem6;
	private JPanel jPanel1;

	public InterfataElev(Utilizator u) {
		currentUser = u;
		initComponents();
	}

	private void initComponents() {
		JLabel userNameLabel = new JLabel("Nume", JLabel.CENTER);
		userNameLabel.setText(currentUser.getNume() + ' '
				+ currentUser.getPrenume());
		JLabel userRolLabel = new JLabel("Rol", JLabel.RIGHT);
		userRolLabel.setText("Elev");

		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenuItem5 = new JMenuItem();
		jMenuItem6 = new JMenuItem();
		jMenu2 = new JMenu();
		jMenuItem4 = new JMenuItem();

		final Elev elev = (Elev) currentUser;
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
		jMenuItem2.setText("Date personale");
		jMenuItem2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.addElement(elev.afisareDatePersonale(elev));
				list.setVisible(true);
			}
		});
		jMenu1.add(jMenuItem2);
		jMenuItem3.setText("Note Biologie");
		jMenuItem3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.clear();
				for (Clasa c : Centralizator.getInstance().getClase()) {
					if (c.getElevi().contains(elev))
						model.addElement(c.getCatalog().getHash().get(elev)
								.get(c.getMaterii().get(0)).noteSemestre());
				}
				list.setVisible(true);
			}

		});
		jMenu1.add(jMenuItem3);
		jMenuItem5.setText("Medie Generala Biologie");
		jMenuItem5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.clear();
				for (Clasa c : Centralizator.getInstance().getClase()) {
					if (c.getElevi().contains(elev))
						model.addElement(c.getCatalog().getHash().get(elev)
								.get(c.getMaterii().get(0)).medieGenerala().toString());
				}
				list.setVisible(true);
			}

		});
		jMenu1.add(jMenuItem5);
		jMenuItem6.setText("Absente Biologie");
		jMenuItem6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.clear();
				for (Clasa c : Centralizator.getInstance().getClase()) {
					if (c.getElevi().contains(elev))
						model.addElement(c.getCatalog().getHash().get(elev)
								.get(c.getMaterii().get(0)).afisareAbsente());
				}
				list.setVisible(true);
			}

		});
		jMenu1.add(jMenuItem6);

		jMenuBar1.add(jMenu1);
		jMenu2.setText("Edit");
		jMenuItem4.setText("Exit");
		jMenuItem4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				InterfataElev.this.dispose();
			}
		});
		jMenu2.add(jMenuItem4);
		jMenuBar1.add(jMenu2);
		setJMenuBar(jMenuBar1);
		pack();
	}

}
