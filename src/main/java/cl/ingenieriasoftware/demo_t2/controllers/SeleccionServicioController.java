package cl.ingenieriasoftware.demo_t2.controllers;

import cl.ingenieriasoftware.demo_t2.entities.ListaServicio;
import cl.ingenieriasoftware.demo_t2.entities.Servicio;
import cl.ingenieriasoftware.demo_t2.services.ServicioService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.LinkedList;

public class SeleccionServicioController {

    @FXML
    private TableView<Servicio> tablaView;
    @FXML
    private TableColumn<Servicio, String> nombre;
    @FXML
    private TableColumn<Servicio, Double> precio;
    @FXML
    private TableColumn<Servicio, Boolean> seleccion;
    private ObservableList<Servicio> servicios;

    /**
     * Método que crea las columnas del tableView
     */
    @FXML
    public void initialize() {
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        precio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        seleccion.setCellValueFactory(new PropertyValueFactory<>("seleccion"));
        seleccion.setCellFactory(CheckBoxTableCell.forTableColumn(seleccion));
    }

    public void setLinkedList() {
        servicios = FXCollections.observableArrayList(ServicioService.getInstance().getListaServicios());
        tablaView.setItems(servicios);
    }


}
