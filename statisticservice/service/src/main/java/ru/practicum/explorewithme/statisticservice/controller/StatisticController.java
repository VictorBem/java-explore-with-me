package ru.practicum.explorewithme.statisticservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.explorewithme.statisticservice.StatisticDto;
import ru.practicum.explorewithme.statisticservice.StatisticResponseDto;
import ru.practicum.explorewithme.statisticservice.service.StatisticService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class StatisticController {
    private final StatisticService statisticService;

    //Получение статистики запросов к сервису
    @GetMapping("/stats")
    private List<StatisticResponseDto> getStatistics(@RequestParam(value = "start", required = true) String start,
                                                     @RequestParam(value = "end", required = true) String end,
                                                     @RequestParam(value = "uris", required = false) List<String> uris,
                                                     @RequestParam(value = "unique", required = false, defaultValue = "false") boolean unique) {
        log.info("Get statistic start {}, end {}, uris {}, unique {} ", start, end, uris, unique);
        return statisticService.getStatistics(start, end, uris, unique);
    }

    //Сохранение информации об использовании сервиса
    @PostMapping("/hit")
    private StatisticDto addHit(@Valid @RequestBody StatisticDto statisticDto) {
        log.info("Save statistic for service {}, uri {}, ip {}, timestamp {}",
                statisticDto.getApp(), statisticDto.getUri(), statisticDto.getIp(), statisticDto.getTimestamp());
        return statisticService.addHit(statisticDto);
    }
}
