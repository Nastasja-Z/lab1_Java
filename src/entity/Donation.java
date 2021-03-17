package entity;

import entity.Needy;
import entity.Option;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Donation {
    private Integer id;
    private Map<Needy, Option> donatMap;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id=id;
    }

    public Map<Needy, Option> getDonatMap() {
        return donatMap;
    }

    public void setDonatMap(Map<Needy, Option> donatMap) {
        this.donatMap=donatMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donation donation = (Donation) o;
        return Objects.equals(id, donation.id) && Objects.equals(donatMap, donation.donatMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, donatMap);
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", donatMap=" + donatMap +
                '}';
    }
}
