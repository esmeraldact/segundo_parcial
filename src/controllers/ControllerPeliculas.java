package controllers;

import java.sql.SQLException;
import models.ModelPeliculas;
import views.ViewPeliculas;

public class ControllerPeliculas {

    private ModelPeliculas model_peliculas;
    private ViewPeliculas view_peliculas;

    public ControllerPeliculas(ModelPeliculas model_peliculas, ViewPeliculas view_peliculas) {
        this.model_peliculas = model_peliculas;
        this.view_peliculas = view_peliculas;
        this.view_peliculas.jb_primero.addActionListener(e -> jb_primero_clic());
        this.view_peliculas.jb_siguiente.addActionListener(e -> jb_siguiente_clic());
        this.view_peliculas.jb_anterior.addActionListener(e -> jb_anterior_clic());
        this.view_peliculas.jb_ultimo.addActionListener(e -> jb_ultimo_clic());
        this.view_peliculas.jb_nuevo.addActionListener(e -> jb_agregar_clic());
        this.view_peliculas.jb_borrar.addActionListener(e -> jb_borrar_clic());
        this.view_peliculas.jb_actualizar.addActionListener(e -> jb_actualizar_clic());
        initView();
    }

    public void getValores() {

        view_peliculas.jtf_id_pelicula.setText(" " + model_peliculas.getId_pelicula());
        view_peliculas.jtf_nombre.setText(model_peliculas.getNombre());
        view_peliculas.jtf_formato.setText(model_peliculas.getFormato());
        view_peliculas.jtf_duracion.setText(model_peliculas.getDuracion());
    }

    public void setValores() {
        model_peliculas.setId_pelicula(Integer.parseInt(view_peliculas.jtf_id_pelicula.getText()));
        model_peliculas.setNombre(view_peliculas.jtf_nombre.getText());
        model_peliculas.setFormato(view_peliculas.jtf_formato.getText());
        model_peliculas.setDuracion(view_peliculas.jtf_duracion.getText());

    }

    public void jb_nuevo_clic() {
        view_peliculas.jtf_id_pelicula.setText(" ");
        view_peliculas.jtf_nombre.setText(" ");
        view_peliculas.jtf_formato.setText(" ");
        view_peliculas.jtf_duracion.setText(" ");

    }

    public void jb_agregar_clic() {
        setValores();
        model_peliculas.insertar();
        getValores();

    }

    public void jb_actualizar_clic() {
        setValores();
        model_peliculas.actualizar();
        getValores();

    }

    public void jb_borrar_clic() {
        setValores();
        model_peliculas.borrar();
        getValores();
    }

    public void jb_primero_clic() {
        model_peliculas.moverPrimero();
        getValores();
    }

    public void jb_ultimo_clic() {
        model_peliculas.moverUltimo();
        getValores();
    }

    public void jb_siguiente_clic() {
        model_peliculas.moverSiguiente();
        getValores();
    }

    public void jb_anterior_clic() {
        model_peliculas.moverAnterior();
        getValores();
    }

    public void initView() {
        view_peliculas.setVisible(true);
        model_peliculas.Conectar();
        model_peliculas.moverPrimero();
        getValores();
    }
}
