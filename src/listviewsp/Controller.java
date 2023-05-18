package listviewsp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Observable;

public class Controller {
    public TextField txtName;
    public TextField txtGia;
    public TextField txtSoLuong;
    public ListView<Product> listview;
    public TextArea txtMoTa;
    public static ObservableList<Product> listProduct = FXCollections.observableArrayList();
    public static Product editProduct;


    public void submit(ActionEvent actionEvent) {
        try {
            String name=txtName.getText();
            String gia=txtGia.getText();
            String soLuong = txtSoLuong.getText();
            String mota= txtMoTa.getText();
            if (editProduct!=null) {
                editProduct.setName(name);
                editProduct.setGia(gia);
                editProduct.setSl(soLuong);
                editProduct.setMoTa(mota);
                listview.setItems(listProduct);
                listview.refresh();
                editProduct=null;
                txtName.clear();
                txtGia.clear();
                txtSoLuong.clear();
                txtMoTa.clear();
            }
            for (Product list : listProduct) {
                if(list.getName().equals(name)){
                    throw new Exception("Tên sản phẩm đã tồn tại");
                }
            }
            Product sp = new Product(name,gia,soLuong,mota);
            listProduct.add(sp);
            listview.setItems(listProduct);
            txtName.clear();
            txtGia.clear();
            txtSoLuong.clear();
            txtMoTa.clear();



        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();

        }
    }
    public void editProduct () {
        editProduct = listview.getSelectionModel().getSelectedItem();
        txtName.setText(editProduct.getName());
        txtGia.setText(editProduct.getGia());
        txtSoLuong.setText(editProduct.getSl());
        txtMoTa.setText(editProduct.getMoTa());


    }


    public void delete(ActionEvent actionEvent) {
        int selectedId= listview.getSelectionModel().getSelectedIndex();
        listview.getItems().remove(selectedId);
        txtName.clear();
        txtSoLuong.clear();
        txtGia.clear();
        txtMoTa.clear();
    }
}
