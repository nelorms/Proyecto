package com.ucreativa.titasshoes.ui;

import com.ucreativa.titasshoes.repositories.FileRepository;
import com.ucreativa.titasshoes.services.Planilla;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrontEnd extends JFrame {

    public FrontEnd(String titulo) { super(titulo); }

    public void build(){
        this.construccionPantalla();
        this.crearComponentes();
        this.setVisible(true);
    }

    private void construccionPantalla(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400,150);
        super.setLayout(new GridLayout(4,2));
    }

    private void agregarComponente(Component componente) { super.getContentPane().add(componente); }

    private void crearComponentes(){

        //Crear Labels
        JLabel lblNombre = new JLabel("Nombre");
        JLabel lblCedula = new JLabel("Cédula");
        JLabel lblEdad = new JLabel("Edad");
        JLabel lblCodigo = new JLabel("Código");
        JLabel lblBodega = new JLabel("Bodega");
        JLabel lblEsvendedor = new JLabel("¿Es Vendedor?");

        //Crear Textos
        JTextField txtNombre = new JTextField();
        JTextField txtCedula = new JTextField();
        JTextField txtEdad = new JTextField();
        JTextField txtCodigo = new JTextField();
        JTextField txtBodega = new JTextField();
        JCheckBox txtEsVendedor = new JCheckBox();
        txtEsVendedor.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblCodigo.setVisible(txtEsVendedor.isSelected());
                txtCodigo.setVisible(txtEsVendedor.isSelected());
                txtCodigo.setText("");
                lblBodega.setVisible(!txtEsVendedor.isSelected());
                txtBodega.setVisible(!txtEsVendedor.isSelected());
                txtBodega.setText("");
            }
        });
        JButton salvar = new JButton("Salvar");
        salvar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Planilla planilla = new Planilla(new FileRepository());
                try{
                    planilla.save(txtNombre.getText(),
                        txtCedula.getText(),
                        txtEdad.getText(),
                        txtCodigo.getText(),
                        txtBodega.getText());
                    txtNombre.setText("");
                    txtCedula.setText("");
                    txtCodigo.setText("");
                    txtBodega.setText("");
                    txtEdad.setText("");
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), "Empleado creado con éxito");
                } catch(ErrorEnEdadException ex) {
                    JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), ex.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        JButton imprimir = new JButton("Imprimir");
        imprimir.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Planilla planilla =new Planilla(new FileRepository());
                String reporte = String.join("\n", planilla.get());
                JOptionPane.showMessageDialog(((JButton) e.getSource()).getParent(), reporte, "Lista de Empleados",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Agregamos al UI
        this.agregarComponente(lblNombre);
        this.agregarComponente(txtNombre);
        this.agregarComponente(lblCedula);
        this.agregarComponente(txtCedula);
        this.agregarComponente(lblEdad);
        this.agregarComponente(txtEdad);
        this.agregarComponente(lblEsvendedor);
        this.agregarComponente(txtEsVendedor);
        this.agregarComponente(lblCodigo);
        this.agregarComponente(txtCodigo);
        this.agregarComponente(lblBodega);
        this.agregarComponente(txtBodega);
        this.agregarComponente(salvar);
        this.agregarComponente(imprimir);
    }

}
