package controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Category;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
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
//        primaryStage.setResizable(false);               // brak skalowania
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
        // zamknięcie okna logowania na obiekcie typu Stage
        Stage companyStage = (Stage) btn_delete.getScene().getWindow();
        companyStage.close();
    }

    @FXML
    void closeAction(ActionEvent event) {
        Platform.exit();
    }

    private ObservableList<Product> products = FXCollections.observableArrayList();

    private void getProductsFromFile() throws FileNotFoundException {
        String path = Paths.get("").toAbsolutePath().toString() +
                "/src/main/java/utility/products.csv";
        Scanner scanner = new Scanner(new File(path));
        scanner.nextLine(); // pominięcie nagłówka w pliku .csv
        while (scanner.hasNextLine()) {
            String line[] = scanner.nextLine().split(";");
            products.add(new Product(
                    Integer.valueOf(line[0]), line[1],
                    Arrays.stream(Category.values())                                        // Category []
                            .filter(category -> category.getCategoryName().equals(line[2])) // filtrowanie po nazwie kategorii
                            .findAny()                                                      // Optional<Category>
                            .get(),                                                          // Category
                    Double.valueOf(line[3]), Integer.valueOf(line[4])));
        }
    }

    private void setProductsIntoTable() {
        // konfiguracja wartości wporwadzanych do tabeli z pól klasy modelu Product
        tc_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_category.setCellValueFactory(new PropertyValueFactory<>("category"));
        tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tc_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        // przekazanie wartości do tabeli z ObservableList
        tbl_products.setItems(products);
    }

    public void initialize() throws FileNotFoundException {
        getProductsFromFile();
        setProductsIntoTable();
    }

    @FXML
    void addAction(ActionEvent event) {
        Dialog<Product> dialog = new Dialog<>();
        dialog.setTitle("Dodaj produkt");
        dialog.setHeaderText("Dodaj produkt");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField tf_productName = new TextField();
        tf_productName.setPromptText("nazwa");
        ComboBox<Category> combo_productCategory = new ComboBox<>();
        combo_productCategory.setItems(FXCollections.observableArrayList(Category.values()));
        combo_productCategory.setPromptText("kategoria");
        TextField tf_productPrice = new TextField();
        tf_productPrice.setPromptText("cena");
        TextField tf_productQuantity = new TextField();
        tf_productQuantity.setPromptText("ilość");

        grid.add(tf_productName, 0, 0);
        grid.add(combo_productCategory, 0, 1);
        grid.add(tf_productPrice, 0, 2);
        grid.add(tf_productQuantity, 0, 3);
        dialog.getDialogPane().setContent(grid);

        ButtonType btn_ok = new ButtonType("Dodaj", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(btn_ok);
        Optional<Product> productOpt = dialog.showAndWait();
        if (productOpt.isPresent()) {
            if (!tf_productPrice.getText().matches("[0-9]+\\.[0-9]{0,2}") ||
                    !tf_productQuantity.getText().matches("[0-9]+")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Błąd danych");
                alert.setHeaderText("Błąd danych. Produkt nie został dodany!");
                alert.showAndWait();
            } else {
                products.add(new Product(products.stream().mapToInt(p -> p.getId()).max().getAsInt() + 1,
                        tf_productName.getText(), combo_productCategory.getValue(),
                        Double.valueOf(tf_productPrice.getText()), Integer.valueOf(tf_productQuantity.getText())));
            }
        }

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