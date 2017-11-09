package controllers;

import java.sql.SQLException;
import models.ModelClientes;
import views.ViewClientes;

public class ControllerClientes{

    private ModelClientes model_clientes;
    private ViewClientes view_clientes;

    public ControllerClientes(ModelClientes model_clientes, ViewClientes view_clientes) {
        this.model_clientes = model_clientes;
        this.view_clientes = view_clientes;
        this.view_clientes.jb_primero.addActionListener(e -> jb_primero_clic());
        this.view_clientes.jb_siguiente.addActionListener(e -> jb_siguiente_clic());
        this.view_clientes.jb_anterior.addActionListener(e -> jb_anterior_clic());
        this.view_clientes.jb_ultimo.addActionListener(e -> jb_ultimo_clic());
        this.view_clientes.jb_agregar.addActionListener(e -> jb_agregar_clic());
        this.view_clientes.jb_borrar.addActionListener(e -> jb_borrar_clic());
        this.view_clientes.jb_actualizar.addActionListener(e -> jb_actualizar_clic());
        initView();
    }

    public void getValores() {

        view_clientes.jtf_id_cliente.setText(" " + model_clientes.getId_cliente());
        view_clientes.jtf_nombre.setText(model_clientes.getNombre());
        view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
        view_clientes.jtf_email.setText(model_clientes.getEmail());
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
    }

    public void setValores() {
        model_clientes.setId_cliente(Integer.parseInt(view_clientes.jtf_id_cliente.getText()));
        model_clientes.setNombre(view_clientes.jtf_nombre.getText());
        model_clientes.setTelefono(view_clientes.jtf_telefono.getText());
        model_clientes.setEmail(view_clientes.jtf_email.getText());
        model_clientes.setDireccion(view_clientes.jtf_direccion.getText());

    }

    public void jb_nuevo_clic() {
        view_clientes.jtf_id_cliente.setText(" ");
        view_clientes.jtf_nombre.setText(" ");
        view_clientes.jtf_telefono.setText(" ");
        view_clientes.jtf_email.setText(" ");
        view_clientes.jtf_direccion.setText(" ");


    }

    public void jb_agregar_clic() {
        setValores();
        model_clientes.insertar();
        getValores();

    }

    public void jb_actualizar_clic() {
        setValores();
        model_clientes.actualizar();
        getValores();

    }

    public void jb_borrar_clic() {
        setValores();
        model_clientes.borrar();
        getValores();
    }

    public void jb_primero_clic() {
        model_clientes.moverPrimero();
        getValores();
    }

    public void jb_ultimo_clic() {
        model_clientes.moverUltimo();
        getValores();
    }

    public void jb_siguiente_clic() {
        model_clientes.moverSiguiente();
        getValores();
    }

    public void jb_anterior_clic() {
        model_clientes.moverAnterior();
        getValores();
    }

    public void initView() {
        view_clientes.setVisible(true);
        model_clientes.Conectar();
        model_clientes.moverPrimero();
        getValores();
    }
}
