package ru.unn.internetveshey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.unn.internetveshey.jpa.model.DeviceModel;
import ru.unn.internetveshey.jpa.repository.DeviceRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceRepository deviceRepository;

    @GetMapping("/all")
    public List<DeviceModel> getAllDevices() {
        return deviceRepository.findAll();
    }
}
