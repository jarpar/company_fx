package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CompanyController {

    @FXML
    private TableView<?> tbl_products;

    @FXML
    private TableColumn<?, ?> tc_name;

    @FXML
    private TableColumn<?, ?> tc_category;

    @FXML
    private TableColumn<?, ?> tc_price;

    @FXML
    private TableColumn<?, ?> tc_quantity;

    @FXML
    private TextField tf_search;

    @FXML
    private CheckBox cb_less5;

    @FXML
    private CheckBox cb_medium;

    @FXML
    private CheckBox cb_more10;

    @FXML
    private ComboBox<?> combo_category;

    @FXML
    private Button btn_update;

    @FXML
    private Button btn_delete;

    @FXML
    void addAction(ActionEvent event) {

    }

    @FXML
    void closeAction(ActionEvent event) {

    }

    @FXML
    void deleteAction(ActionEvent event) {

    }

    @FXML
    void filterAction(ActionEvent event) {

    }

    @FXML
    void logoutAction(ActionEvent event) {

    }

    @FXML
    void selectAction(MouseEvent event) {

    }

    @FXML
    void updateAction(ActionEvent event) {

    }

}
