package controllers;

import java.sql.SQLException;
import models.ModelRentas;
import views.ViewRentas;

public class ControllerRentas {

    private ModelRentas model_rentas;
    private ViewRentas view_rentas;

    public ControllerRentas(ModelRentas model_rentas, ViewRentas view_rentas) {
        this.model_rentas = model_rentas;
        this.view_rentas = view_rentas;
        this.view_rentas.jb_primero.addActionListener(e -> jb_primero_clic());
        this.view_rentas.jb_siguiente.addActionListener(e -> jb_siguiente_clic());
        this.view_rentas.jb_anterior.addActionListener(e -> jb_anterior_clic());
        this.view_rentas.jb_ultimo.addActionListener(e -> jb_ultimo_clic());
        this.view_rentas.jb_nuevo.addActionListener(e -> jb_agregar_clic());
        this.view_rentas.jb_borrar.addActionListener(e -> jb_borrar_clic());
        this.view_rentas.jb_actualizar.addActionListener(e -> jb_actualizar_clic());
        initView();
    }

    public void getValores() {

        view_rentas.jtf_id_renta.setText(" " + model_rentas.getId_renta());
        view_rentas.jtf_id_cliente.setText(" " + model_rentas.getId_cliente());
        view_rentas.jtf_id_pelicula.setText(" " + model_rentas.getId_pelicula());
        view_rentas.jtf_formato.setText(model_rentas.getFormato());
        view_rentas.jtf_costo.setText(model_rentas.getCosto());
        view_rentas.jtf_numero_dias.setText(model_rentas.getNumero_dias());
        view_rentas.jtf_costo_renta.setText(model_rentas.getCosto_renta());
    }

    public void setValores() {
        model_rentas.setId_renta(Integer.parseInt(view_rentas.jtf_id_renta.getText()));
        model_rentas.setId_cliente(Integer.parseInt(view_rentas.jtf_id_cliente.getText()));
        model_rentas.setId_pelicula(Integer.parseInt(view_rentas.jtf_id_pelicula.getText()));
        model_rentas.setFormato(view_rentas.jtf_formato.getText());
        model_rentas.setCosto(view_rentas.jtf_costo.getText());
        model_rentas.setNumero_dias(view_rentas.jtf_numero_dias.getText());
        model_rentas.setCosto_renta(view_rentas.jtf_costo_renta.getText());

    }

    public void jb_nuevo_clic() {
        view_rentas.jtf_id_renta.setText(" ");
        view_rentas.jtf_id_cliente.setText(" ");
        view_rentas.jtf_id_pelicula.setText(" ");
        view_rentas.jtf_formato.setText(" ");
        view_rentas.jtf_costo.setText(" ");
        view_rentas.jtf_numero_dias.setText(" ");
        view_rentas.jtf_costo_renta.setText(" ");

    }

    public void jb_agregar_clic() {
        setValores();
        model_rentas.insertar();
        getValores();

    }

    public void jb_actualizar_clic() {
        setValores();
        model_rentas.actualizar();
        getValores();

    }

    public void jb_borrar_clic() {
        setValores();
        model_rentas.borrar();
        getValores();
    }

    public void jb_primero_clic() {
        model_rentas.moverPrimero();
        getValores();
    }

    public void jb_ultimo_clic() {
        model_rentas.moverUltimo();
        getValores();
    }

    public void jb_siguiente_clic() {
        model_rentas.moverSiguiente();
        getValores();
    }

    public void jb_anterior_clic() {
        model_rentas.moverAnterior();
        getValores();
    }

    public void initView() {
        view_rentas.setVisible(true);
        model_rentas.Conectar();
        model_rentas.moverPrimero();
        getValores();
    }
}

