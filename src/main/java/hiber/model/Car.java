package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Model")
    private String model;

    @Column(name = "Series")
    private int series;

    public Car() {
    }

    @OneToOne(mappedBy = "userCar", cascade = CascadeType.ALL)
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
