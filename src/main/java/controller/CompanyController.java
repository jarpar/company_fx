package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Scanner;

public class CompanyController {
    @FXML
    private TableView<Product> tbl_products;
    @FXML
    private TableColumn<Product, String> tc_name;
    @FXML
    private TableColumn<Product, String> tc_category;
    @FXML
    private TableColumn<Product, Double> tc_price;
    @FXML
    private TableColumn<Product, Integer> tc_quantity;
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
    void logoutAction(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent parent = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));
        primaryStage.setTitle("Logowanie");             // tytuł okna
        primaryStage.setResizable(false);               // brak skalowania
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
        // zamknięcie okna logowania na obiekcie typu Stage
        Stage loginStage = (Stage) btn_delete.getScene().getWindow();
        loginStage.close();
    }

    @FXML
    void closeAction(ActionEvent event) {
        Platform.exit();
    }

    private ObservableList<Product> getProductsFromFile() throws FileNotFoundException {
        ObservableList<Product> products = FXCollections.observableArrayList();
        String path = Paths.get("").toAbsolutePath().toString() +
                "src/main/java/utility/products.csv";
        Scanner scanner = new Scanner(new File(path));
        scanner.nextLine();
        while ((scanner.hasNextLine())) {

        }
        return null;
    }

    private void setProductsIntoTable() {

    }

    @FXML
    void addAction(ActionEvent event) {
    }

    @FXML
    void deleteAction(ActionEvent event) {
    }

    @FXML
    void filterAction(ActionEvent event) {
    }

    @FXML
    void selectAction(MouseEvent event) {
    }

    @FXML
    void updateAction(ActionEvent event) {
    }
}