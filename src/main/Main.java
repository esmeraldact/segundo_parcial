package main;

import views.ViewPeliculas;
import views.ViewPrincipal;
import views.ViewClientes;
import views.ViewRentas;
import controllers.ControllerPeliculas;
import controllers.ControllerPrincipal;
import controllers.ControllerClientes;
import controllers.ControllerRentas;
import models.ModelPeliculas;
import models.ModelPrincipal;
import models.ModelClientes;
import models.ModelRentas;


public class Main {
    
    public static void main(String [] ect ){
        ModelPeliculas model_peliculas = new ModelPeliculas();
        ViewPeliculas view_peliculas = new ViewPeliculas();
        ControllerPeliculas controller_peliculas = new ControllerPeliculas(model_peliculas, view_peliculas);
        
        ModelClientes model_clientes = new ModelClientes();
        ViewClientes view_clientes = new ViewClientes();
        ControllerClientes controller_clientes = new ControllerClientes(model_clientes, view_clientes);
        
        ModelRentas model_rentas = new ModelRentas();
        ViewRentas view_rentas = new ViewRentas();
        ControllerRentas controller_rentas = new ControllerRentas(model_rentas, view_rentas);
        
        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        Object views[] = new Object[4];
        views[0] = view_peliculas;
        views[1] = view_principal;
        views[2] = view_clientes;
        views[3] = view_rentas;
        ControllerPrincipal controller_principal = new ControllerPrincipal(model_principal, views);
     }
}
