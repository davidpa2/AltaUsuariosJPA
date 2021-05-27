package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.controllers.ControladorAltaUsuarios;
import model.entities.Acuerdo;
import model.entities.Idioma;
import model.entities.Pai;
import model.entities.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelAltaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField jtfEmail;
	private JTextField jtfUsuario;
	private JTextField jtfPassword;
	private JTextField jtfRepetirPassword;
	private JComboBox<Idioma> jcbIdioma;
	private JComboBox<Pai> jcbPais;
	private JCheckBox cbxAcepta;
	JButton btnGuardar;
	private Usuario usuario = new Usuario();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAltaUsuarios frame = new PanelAltaUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelAltaUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 0;
		contentPane.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 1;
		contentPane.add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfPassword = new JTextField();
		GridBagConstraints gbc_jtfPassword = new GridBagConstraints();
		gbc_jtfPassword.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPassword.gridx = 1;
		gbc_jtfPassword.gridy = 2;
		contentPane.add(jtfPassword, gbc_jtfPassword);
		jtfPassword.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Repetición password:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfRepetirPassword = new JTextField();
		GridBagConstraints gbc_jtfRepetirPassword = new GridBagConstraints();
		gbc_jtfRepetirPassword.insets = new Insets(0, 0, 5, 0);
		gbc_jtfRepetirPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfRepetirPassword.gridx = 1;
		gbc_jtfRepetirPassword.gridy = 3;
		contentPane.add(jtfRepetirPassword, gbc_jtfRepetirPassword);
		jtfRepetirPassword.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("País:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcbPais = new JComboBox<Pai>();
		jcbPais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarIdiomas();
			}
		});
		GridBagConstraints gbc_jcbPais = new GridBagConstraints();
		gbc_jcbPais.insets = new Insets(0, 0, 5, 0);
		gbc_jcbPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbPais.gridx = 1;
		gbc_jcbPais.gridy = 4;
		contentPane.add(jcbPais, gbc_jcbPais);
		
		JLabel lblNewLabel_5 = new JLabel("Idioma:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jcbIdioma = new JComboBox<Idioma>();
		jcbIdioma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idiomaSeleccionado();
			}
		});
		GridBagConstraints gbc_jcbIdioma = new GridBagConstraints();
		gbc_jcbIdioma.insets = new Insets(0, 0, 5, 0);
		gbc_jcbIdioma.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbIdioma.gridx = 1;
		gbc_jcbIdioma.gridy = 5;
		contentPane.add(jcbIdioma, gbc_jcbIdioma);
		
		cbxAcepta = new JCheckBox("Acepta los términos de alta del usuario");
		cbxAcepta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarTerminos();
			}
		});
		GridBagConstraints gbc_cbxAcepta = new GridBagConstraints();
		gbc_cbxAcepta.insets = new Insets(0, 0, 5, 0);
		gbc_cbxAcepta.gridwidth = 2;
		gbc_cbxAcepta.gridx = 0;
		gbc_cbxAcepta.gridy = 6;
		contentPane.add(cbxAcepta, gbc_cbxAcepta);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 7;
		contentPane.add(btnGuardar, gbc_btnGuardar);
		
		cargarPaises();
	}
	
	/**
	 * Método utilizado para cargar todos las materias en una lista para trabajarla en esta clase
	 */
	private void cargarPaises() {
		List<Pai> paises = ControladorAltaUsuarios.getInstance().findAllPaises();
		
		for (Pai p: paises) {
			this.jcbPais.addItem(p);
		}
	}
	
	/**
	 * Método utilizado para cargar todos las materias en una lista para trabajarla en esta clase
	 */
	private void cargarIdiomas() {
		jcbIdioma.removeAllItems();
		
		Pai paisSeleccionado = (Pai) jcbPais.getSelectedItem();
		
		List<Idioma> idiomas = ControladorAltaUsuarios.getInstance().findAllIdiomas(paisSeleccionado);
		
		for (Idioma i: idiomas) {
			this.jcbIdioma.addItem(i);
		}
	}
	
	private void obtenerTodosLosCampos() {
		if (this.usuario != null) {
			this.usuario.setEmail(jtfEmail.getText());
			this.usuario.setUsuario(jtfUsuario.getText());
			this.usuario.setPassword(jtfPassword.getText());
			this.usuario.setIdioma((Idioma) jcbIdioma.getSelectedItem());		
		}
	}
	
	/**
	 * Método utilizado para dos situaciones, guardar un registro modificado o guardar uno nuevo
	 */
	private void guardar() {
		if (validarEmail()) {
			if (longitudUsuario()) {
				if (comprobarPassword()) {
					if (repeticionPassword()) {	
						if(buscarUsuarioIgual()) {		
							
							obtenerTodosLosCampos();
							
							//Comprobar que el registro se ha guardado correctamente
							boolean resultado = ControladorAltaUsuarios.getInstance().guardar(this.usuario);
							if (resultado == true && this.usuario != null && this.usuario.getId() > 0) {
								JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
							}
							else {
								JOptionPane.showMessageDialog(null, "Error al guardar");
							}
							
							this.usuario = new Usuario();
						}
							
					}
					
				}
				
			}
			
		}
			
	}

	/**
	 * 
	 * @return
	 */
	private boolean validarEmail() {
//		String str = jtfEmail.getText();
//		boolean hayArroba = false;
//		for (int i = 0; i < str.length(); i++) {
//			String letra = "" + str.lastIndexOf(i);
//			if (letra == "@") {
//	        	hayArroba = true;
//	            if (letra == "." && hayArroba) {
//	            	return true;
//	            }    	
//	        }
//		}
//		JOptionPane.showMessageDialog(null, "El email no es valido");
//		return false;   
		
		String str = jtfEmail.getText();
		if ((str.lastIndexOf('.') < str.lastIndexOf('@')) ||
				str.lastIndexOf('.') == -1 || str.lastIndexOf('@') == -1) {
			JOptionPane.showMessageDialog(null, "El email no es valido");
			return false;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean longitudUsuario() {
		StringBuffer str = new StringBuffer(jtfUsuario.getText());
		if (str.length() >= 8) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "El nombre de usuario debe tener al menos 8 caracteres");
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean comprobarPassword() {
		
		boolean hayMayuscula = false, hayMinuscula = false, hayDigito = false;
		String str = jtfPassword.getText();
		
		for (int i = 0; i < str.length(); i++) {
			if (!hayMayuscula) {	
				hayMayuscula = Character.isUpperCase(str.charAt(i));
			}
			if (!hayMinuscula) {
				hayMinuscula = Character.isLowerCase(str.charAt(i));
			}
			if (!hayDigito) {
				hayDigito = Character.isDigit(str.charAt(i));
			}
		}
		
		if (hayDigito && hayMayuscula && hayMinuscula) {
			return true;
		}
		JOptionPane.showMessageDialog(null, "La contraseña debe contener almenos una mayúscula,"
				+ " una minúscula y un dígito");
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean repeticionPassword() {
		String pass = jtfPassword.getText();
		String pass2 = jtfRepetirPassword.getText();
		
		if (pass.equals(pass2)) {
			return true;
		}
		
		JOptionPane.showMessageDialog(null, "La contraseña y su repetición no coinciden");
		return false;
	}
	
	/**
	 * 
	 */
	private void idiomaSeleccionado() {
		Idioma i = (Idioma) jcbIdioma.getSelectedItem();
		
		Acuerdo a = ControladorAltaUsuarios.getInstance().mostrarIdioma(i);
		if (a != null) {
			cbxAcepta.setText(a.getDescripcion());
		}			
	}
	
	/**
	 * 
	 */
	private void comprobarTerminos() {
//		if (cbxAcepta.isEnabled()) {
//			btnGuardar.setEnabled(true);
//		} else {
//			btnGuardar.setEnabled(false);
//		}
		btnGuardar.setEnabled(cbxAcepta.isSelected());
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean buscarUsuarioIgual() {
		List<Usuario> usuarios = ControladorAltaUsuarios.getInstance().findAllUsuarios();
		
		for (Usuario u: usuarios) {
			String usuario = u.getUsuario();
			if (jtfUsuario.getText().equals(usuario)) {
				JOptionPane.showMessageDialog(null, "El nombre de usuario está siendo utilizado, elija otro");
				return false;
			}
		}
		return true;
	}
}
