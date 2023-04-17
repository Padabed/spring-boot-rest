package com.nicotine.addiction.example.rest.driverRest;

import com.nicotine.addiction.example.entity.Driver;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {

    private List<Driver> drivers;

    @PostConstruct
    public void loadData() {
        drivers = new ArrayList<>();
        drivers.add(new Driver("Marry", "Smith"));
        drivers.add(new Driver("Mario", "Rossi"));
        drivers.add(new Driver("Mario", "Rossi"));
        drivers.add(new Driver("Tricky", "List"));
    }

    @GetMapping("drivers")
    public List<Driver> getDrivers() {
        return drivers;
    }

    @GetMapping("drivers/{idDriver}")
    public Driver getDriversById(@PathVariable int idDriver) {

        if (idDriver >= drivers.size() || idDriver < 0) {
            throw new DriverNotFoundException("Driver id not found - " + idDriver);
        }

        return drivers.get(idDriver);
    }

}
