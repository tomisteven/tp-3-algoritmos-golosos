package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FramePrincipal {

	private JFrame frame;
	private JTextField inputArista;
	private JTextField inputAristaDerecha;
	private JTextField inputExtremoIzquierdo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal window = new FramePrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FramePrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 959, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Algoritmos Golosos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(359, 11, 243, 33);
		frame.getContentPane().add(lblNewLabel);

		// *********** PANEL AGREGAR VERTICES **************

		JPanel panelAgregarVertices = new JPanel();
		panelAgregarVertices.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelAgregarVertices.setBounds(108, 87, 308, 322);
		frame.getContentPane().add(panelAgregarVertices);
		panelAgregarVertices.setLayout(null);

				JLabel lblAgregarVertices = new JLabel("Agregar Vertices");
		lblAgregarVertices.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		lblAgregarVertices.setBounds(161, 54, 207, 33);
		frame.getContentPane().add(lblAgregarVertices);

		//--------

		JLabel lblNewLabel_1 = new JLabel("Arista Principal");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(96, 45, 139, 23);
		panelAgregarVertices.add(lblNewLabel_1);

		inputArista = new JTextField();
		inputArista.setBounds(21, 79, 253, 29);
		panelAgregarVertices.add(inputArista);
		inputArista.setColumns(10);

		//--------

		JLabel lblNewLabel_1_2 = new JLabel("Extremo Derecho");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1_2.setBounds(103, 131, 100, 14);
		panelAgregarVertices.add(lblNewLabel_1_2);

		inputAristaDerecha = new JTextField();
		inputAristaDerecha.setBounds(21, 156, 253, 29);
		panelAgregarVertices.add(inputAristaDerecha);
		inputAristaDerecha.setColumns(10);

		//--------

		inputExtremoIzquierdo = new JTextField();
		inputExtremoIzquierdo.setBounds(21, 221, 253, 29);
		panelAgregarVertices.add(inputExtremoIzquierdo);
		inputExtremoIzquierdo.setColumns(10);


		JLabel lblNewLabel_1_2_1 = new JLabel("Extremo Izquierdo");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1_2_1.setBounds(103, 196, 120, 14);
		panelAgregarVertices.add(lblNewLabel_1_2_1);

		//--------


		JButton btnAgregarAlGrafo = new JButton("Agregar al Grafo");
		btnAgregarAlGrafo.setBackground(new Color(0, 255, 64));
		btnAgregarAlGrafo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAgregarAlGrafo.setBounds(84, 288, 151, 23);
		btnAgregarAlGrafo.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String arista = inputArista.getText();
				String aristaDerecha = inputAristaDerecha.getText();
				String aristaIzquierda = inputExtremoIzquierdo.getText();
				if(arista != null && aristaDerecha != null && aristaIzquierda != null) {
					System.out.println("Arista: " + arista);
				}
			}
		});



		panelAgregarVertices.add(btnAgregarAlGrafo);





		//***************** FIN PANEL AGREGAR VERTICES *************

		//***************** PANEL CONJUNTO MINIMO DOMINANTE *************

		JPanel panelConjuntoMinimoDominante = new JPanel();
		panelConjuntoMinimoDominante.setBackground(new Color(255, 234, 159));
		panelConjuntoMinimoDominante.setBorder(new LineBorder(new Color(255, 128, 64)));
		panelConjuntoMinimoDominante.setBounds(557, 87, 316, 322);
		frame.getContentPane().add(panelConjuntoMinimoDominante);

		JLabel lblNewLabel_2 = new JLabel("New label");
		panelConjuntoMinimoDominante.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Conjunto Dominante Minimo");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel_1_1.setBounds(557, 55, 316, 33);
		frame.getContentPane().add(lblNewLabel_1_1);

		//*************** FIN PANEL CONJUNTO MINIMO DOMINANTE *************




	}
}
