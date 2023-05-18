package listviewsp;

public class Product {
    String name;
    String gia;
    String sl;
    String moTa;

    public Product(String name, String gia, String sl, String moTa) {
        this.name = name;
        this.gia = gia;
        this.sl = sl;
        this.moTa = moTa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    public String toString() {
        return "Name : "+ name + "\n"  + "Giá : " + gia+"\n" + "Số lượng : " + sl+"\n" + "Mô tả : "+ moTa;
     }

}
