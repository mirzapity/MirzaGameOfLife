package juegovida;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

@SuppressWarnings("serial")
public class Interfaz {

	public static void main(String[] args){
		
		Game game = new Game();
		
		JFrame frame = new JFrame("GOL");
		frame.setLayout(new BorderLayout());
		JButton btnNext = new JButton("Next");
		JButton btnClear = new JButton("Clear");
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(3, 2));
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	   
	    formatter.setCommitsOnValidEdit(true);
	    JLabel label = new JLabel("Speed");
	    JLabel labelAncho = new JLabel("Filas");
	    JLabel labelAlto = new JLabel("Columns");
	    JFormattedTextField field = new JFormattedTextField();
	    JFormattedTextField alto = new JFormattedTextField(formatter);
	    JFormattedTextField ancho = new JFormattedTextField(formatter);
	    
	    //establezco la velocidad con la que se va a desarrollar.
	    field.setValue(game.getSpeed());
	    
	    //muestra la evolucion de las celdas cada vez que presionas.
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.setSpeed((Integer) field.getValue());
				game.nextIteration();
				
			}
			
		});
		
		//me lleva a un nuevo grid con las filas y columnas que le indico.
		JButton btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.setWidthHeight((Integer)ancho.getValue(), (Integer)alto.getValue());
				
			}
			
		});
		//borra todo lo que esta en la cuadricula
		btnClear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				game.clear();
			}
			
		});
		
		jPanel2.add(btnNext);
		jPanel2.add(btnApply);
		jPanel2.add(field);
		jPanel2.add(ancho);
		jPanel2.add(alto);
		jPanel2.add(btnClear);
		field.add(label);
		Dimension size = label.getPreferredSize();
		label.setBounds(10, 10, size.width, size.height);
		ancho.add(labelAncho);
		labelAncho.setBounds(10, 10, 100, size.height);
		alto.add(labelAlto);
		labelAlto.setBounds(10, 10, 105, size.height);
		
		frame.setSize(800,600);
		frame.setResizable(false);
		
		frame.setVisible(true);
		
		frame.add(game);
		frame.add(jPanel2, BorderLayout.LINE_END);
	}
	
	

}
