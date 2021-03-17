package entity;

public class Option {

    private Integer id;
    private String nameOfOption;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public String getNameOfOption() {
        return nameOfOption;
    }

    public void setNameOfOption(String nameOfOption) {
        this.nameOfOption=nameOfOption;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice( Integer price) {
        this.price=price;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", nameOfOption='" + nameOfOption + '\'' +
                ", price=" + price +
                '}';
    }
}

