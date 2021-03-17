package entity;

import java.util.Objects;
import java.util.Set;

public class Needy {

    private Integer id;
    private String nameOfNeedy;
    private String status;
    private Set<Option> options;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getNameOfNeedy() {
        return nameOfNeedy;
    }

    public void setNameOfNeedy( String nameOfNeedy) {
        this.nameOfNeedy=nameOfNeedy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

    public Set<Option> getOptions() {
        return options;
    }

    public void setOptions(Set<Option> options) {
        this.options=options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Needy needy = (Needy) o;
        return Objects.equals(id, needy.id) && Objects.equals(nameOfNeedy, needy.nameOfNeedy) && Objects.equals(status, needy.status) && Objects.equals(options, needy.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameOfNeedy, status, options);
    }

    @Override
    public String toString() {
        return "Needy{" +
                "id=" + id +
                ", nameOfNeedy='" + nameOfNeedy + '\'' +
                ", status='" + status + '\'' +
                ", options=" + options.toString() +
                '}';
    }
}
