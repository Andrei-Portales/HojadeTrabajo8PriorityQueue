import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Main {

	private JFrame frame;
	private Control control;
	private JRadioButton rbVector, rdPriority;
	private JPanel Menu, Factory;
	private JButton btnNewButton_1;
	private JScrollPane spPacientes,spPacienteAtendido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 888, 777);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setLocationRelativeTo(null);
		
		Factory = new JPanel();
		Factory.setBackground(Color.WHITE);
		frame.getContentPane().add(Factory, "name_278371428419300");
		Factory.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(147, 117, 570, 428);
		Factory.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Que desea utilizar?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setBounds(103, 13, 407, 85);
		panel.add(lblNewLabel);
		
		rbVector = new JRadioButton("VectorHeap");
		rbVector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (rbVector.isSelected()) {
					rdPriority.setSelected(false);
				}
			}
		});
		rbVector.setBackground(SystemColor.controlHighlight);
		rbVector.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rbVector.setBounds(193, 200, 153, 33);
		panel.add(rbVector);
		
		rdPriority = new JRadioButton("PriorityQueue");
		rdPriority.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (rdPriority.isSelected()) {
					rbVector.setSelected(false);
				}
			}
		});
		rdPriority.setBackground(SystemColor.controlHighlight);
		rdPriority.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdPriority.setBounds(193, 251, 165, 33);
		panel.add(rdPriority);
		
		JButton btnNewButton = new JButton("Elegir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rbVector.isSelected() || rdPriority.isSelected()) {
					if (rbVector.isSelected()) {
						control = new Control("VectorHeap");
					}else if (rdPriority.isSelected()) {
						control = new Control("PriorityQueue");
					}
					Menu.setVisible(true);
					Factory.setVisible(false);
					setTablaPacientes();
					setTablaPacienteActual();
				}else {
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguno");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBackground(SystemColor.window);
		btnNewButton.setBounds(219, 354, 127, 41);
		panel.add(btnNewButton);
		
		Menu = new JPanel();
		Menu.setBackground(Color.WHITE);
		frame.getContentPane().add(Menu, "name_278373296829000");
		Menu.setLayout(null);
		
		btnNewButton_1 = new JButton("Agregar Pacientes");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.addPacientes();
				setTablaPacientes();
			}
		});
		btnNewButton_1.setBounds(31, 40, 157, 42);
		Menu.add(btnNewButton_1);
		
		spPacientes = new JScrollPane();
		spPacientes.setBounds(31, 232, 348, 465);
		spPacientes.setBackground(Color.WHITE);
		Menu.add(spPacientes);
		
		spPacienteAtendido = new JScrollPane();
		spPacienteAtendido.setBounds(500, 232, 348, 465);
		spPacienteAtendido.setBackground(Color.WHITE);
		Menu.add(spPacienteAtendido);
		
		JLabel lblNewLabel_1 = new JLabel("Pacientes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(31, 189, 157, 30);
		Menu.add(lblNewLabel_1);
		
		JButton btnTransferir = new JButton("<html>Transferir Paciente<html>");
		btnTransferir.setBackground(Color.LIGHT_GRAY);
		btnTransferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (control.getPaciente() == null) {
					try {
					control.transferir();
					setTablaPacienteActual();
					setTablaPacientes();
					}catch(Exception ex) {}
				}else {
					JOptionPane.showMessageDialog(null, "No puedes transferir otro paciente hasta atender el existente");
				}
			}
		});
		btnTransferir.setBounds(391, 279, 97, 62);
		Menu.add(btnTransferir);
		
		JLabel lblPacienteAAtender = new JLabel("Paciente a atender");
		lblPacienteAAtender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPacienteAAtender.setBounds(500, 189, 199, 30);
		Menu.add(lblPacienteAAtender);
		
		JButton btnNewButton_2 = new JButton("Atender");
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(control.getPaciente() != null) {
					control.atender();
					setTablaPacienteActual();
					setTablaPacientes();
					JOptionPane.showMessageDialog(null, "Se atendio el paciente con exito");
				}else {
					JOptionPane.showMessageDialog(null, "No hay paciente para atender");
				}
			}
		});
		btnNewButton_2.setBounds(751, 170, 97, 49);
		Menu.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("--->>");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(414, 354, 67, 30);
		Menu.add(lblNewLabel_2);
		
		
	}
	
	private void setTablaPacientes() {
		PriorityQueue<Paciente> data = control.getPacientes();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(3);
		model.setColumnIdentifiers(new String[] {"Codigo", "Nombre", "Sintoma"});
		model.setRowCount(control.size());
		int c = control.size();
		
		for (int i = 0; i < c;i++) {
			Paciente pa = data.remove();
			model.setValueAt(pa.getCodigo(), i, 0);
			model.setValueAt(pa.getNombre(), i, 1);
			model.setValueAt(pa.getSintoma(), i, 2);
		}
		spPacientes.setViewportView(new JTable(model));
	}
	
	private void setTablaPacienteActual() {
		Paciente p = control.getPaciente();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(3);
		model.setColumnIdentifiers(new String[] {"Codigo", "Nombre", "Sintoma"});
		model.setRowCount(0);
		if (control.getPaciente() != null) {
			model.setRowCount(1);
			model.setValueAt(p.getCodigo(), 0, 0);
			model.setValueAt(p.getNombre(), 0, 1);
			model.setValueAt(p.getSintoma(), 0, 2);
		}
		spPacienteAtendido.setViewportView(new JTable(model));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
