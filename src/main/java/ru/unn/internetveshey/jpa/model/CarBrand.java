package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.unn.internetveshey.dto.enums.Colors;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "car_brand", schema = "internet_veshey")
public class CarBrand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private byte[] brandLogo;
    @Enumerated(EnumType.STRING)
    private Colors color;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "car_brand_to_car_model", schema = "internet_veshey",
            joinColumns = @JoinColumn(name = "car_brand_id"),
            inverseJoinColumns = @JoinColumn(name = "car_model_id"))
    private Set<CarModel> carModels;

    @OneToMany(mappedBy = "carBrand",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Car> cars;
}
