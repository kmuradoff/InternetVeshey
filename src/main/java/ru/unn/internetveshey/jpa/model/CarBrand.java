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
    private String name;
    private byte[] brandLogo;
}
