package Utopia.Airlines.Models;

import javax.persistence.*;

@Entity
@Table(name = "airplane_type")
public class AirplaneType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "max_capacity_economy")
    private Integer maxCapacityEconomy;

    @Column(name = "max_capacity_business")
    private Integer maxCapacityBusiness;

    @Column(name = "max_capacity_first")
    private Integer maxCapacityFirst;

    public AirplaneType() { }

    public AirplaneType(Integer maxCapacityEconomy, Integer maxCapacityBusiness, Integer maxCapacityFirst) {
        this.maxCapacityEconomy = maxCapacityEconomy;
        this.maxCapacityBusiness = maxCapacityBusiness;
        this.maxCapacityFirst = maxCapacityFirst;
    }

    public Integer getMaxCapacityEconomy() {
        return maxCapacityEconomy;
    }

    public void setMaxCapacityEconomy(Integer maxCapacityEconomy) {
        this.maxCapacityEconomy = maxCapacityEconomy;
    }

    public Integer getMaxCapacityBusiness() {
        return maxCapacityBusiness;
    }

    public void setMaxCapacityBusiness(Integer maxCapacityBusiness) {
        this.maxCapacityBusiness = maxCapacityBusiness;
    }

    public Integer getMaxCapacityFirst() {
        return maxCapacityFirst;
    }

    public void setMaxCapacityFirst(Integer maxCapacityFirst) {
        this.maxCapacityFirst = maxCapacityFirst;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}