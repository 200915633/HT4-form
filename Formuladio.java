/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.formuladio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author emilia
 */
public class Formuladio  {
    private static String n;
    private static int cant;
    private static String L;
    private static String fecha;
    static JTextField text1 = new JTextField(20);
    static   JTextField text2 = new JTextField(20);
    static JTextField text3 = new JTextField(20);
    static  JTextField text5 = new JTextField(20);
  public static void miformulario(){
  
  JFrame miframe = new JFrame();
  miframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  miframe.setBounds(100, 100,250, 300);
  miframe.setVisible(true);
  miframe.setLocationRelativeTo(null);
      JPanel mipanel =new JPanel();
  	JLabel label1 = new JLabel("nombre");
		label1.setBounds(10, 10, 80, 25);
		mipanel.add(label1);

	
		text1.setBounds(100, 10, 160, 25);
		mipanel.add(text1);

		JLabel label2 = new JLabel("cantidad");
		 label2.setBounds(10, 200, 80, 25);
		mipanel.add(label2);
              
		text2.setBounds(100, 100, 160, 25);
		mipanel.add(text2);
                JLabel label3 = new JLabel("lugar de frabricacion");
 
		label3.setBounds(200, 400, 80, 25);
		mipanel.add(label3 );
		
		text3.setBounds(300,200, 160, 25);
		mipanel.add(text3);
                
                JLabel label4 = new JLabel("fecha");
		 label2.setBounds(20, 600, 80, 25);
		mipanel.add(label4);
               
               
		text5.setBounds(200, 700, 160, 25);
                
		mipanel.add(text5);
                   JButton miboton = new JButton("Enviar");
                   mipanel.add(miboton);

                  miframe.add(mipanel);
                
                         
                  
                  miboton.addActionListener(new ActionListener() {
      @Override
      
      public void actionPerformed(ActionEvent e) {
          PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    
     String sql = "insert into procuto(nombre,cantidad, lugarfabricacion) values (?,?,?)";
      try {
            con = conectar.Conectar();
           ps = con.prepareStatement(sql);
           
             cant=0;
                   n=text1.getText();
                   if(text2.getText().length()>0)
                 cant= Integer.parseInt(text2.getText());
                   L=text3.getText();
                   fecha="2/2/0000";
            ps.setString(1,n );
            ps.setInt(2, cant);
            ps.setString(3, L);
         //   ps.setString(4,"");
            
                        ps.executeUpdate();
            System.out.println("Insetado correctamente");
            
        } catch (Exception ee) {
            System.out.println(" Error al enviar ");
        }
    
    
       }
                  });
      
  }
 

    public static void main(String[] args) {
        
       miformulario();
        
    }
}
