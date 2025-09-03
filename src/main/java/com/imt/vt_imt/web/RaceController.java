package com.imt.vt_imt.web;

import com.imt.vt_imt.dto.RaceDetailDTO;
import com.imt.vt_imt.entity.ResultEntry;
import com.imt.vt_imt.dto.ResultDTO;
import com.imt.vt_imt.entity.Race;
import com.imt.vt_imt.service.RaceService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

record CreateRaceRequest(String title, String date, String location, Integer capacity, String routeUrl) {}

@RestController
@RequestMapping("/api/races")
@CrossOrigin
public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping
    public List<Race> list() {
        return raceService.listUpcoming();
    }

    @PostMapping
    public Race create(@RequestBody CreateRaceRequest req) {
        return raceService.create(
            req.title(),
            LocalDate.parse(req.date()),
            req.location(),
            req.capacity(),
            req.routeUrl()
        );
    }

    @GetMapping("/{id}")
    public RaceDetailDTO detail(@PathVariable Long id) {
        return raceService.detail(id);
    }

    @PostMapping("/{id}/register")
    public void register(@PathVariable Long id, @RequestHeader("X-User-Id") Long userId) {
        raceService.register(id, userId);
    }

    @PostMapping("/{id}/simulate")
    public void simulate(@PathVariable Long id) {
        raceService.simulateResults(id);
    }

    @GetMapping("/{id}/results")
    public List<ResultDTO> results(@PathVariable Long id) {
        return raceService.getResults(id);
    }

}
