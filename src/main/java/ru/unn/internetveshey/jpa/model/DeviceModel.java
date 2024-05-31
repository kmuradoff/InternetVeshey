package ru.unn.internetveshey.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.unn.internetveshey.dto.enums.DeviceType;

@Entity
@Getter
@Setter
@Table(name = "device", schema = "internet_veshey")
@Inheritance(strategy = InheritanceType.JOINED)
public class DeviceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;
    private boolean status;
    private String location;
}
