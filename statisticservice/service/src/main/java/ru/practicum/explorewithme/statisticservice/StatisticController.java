package ru.practicum.explorewithme.statisticservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class StatisticController {
    private final StatisticService statisticService;

    //Получение статистики запросов к сервису
    @GetMapping("/stats")
    private List<StatisticResponseDto> getStatistics(@RequestParam(value = "start", required = true)
                                                     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
                                                     @RequestParam(value = "end", required = true)
                                                     @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end,
                                                     @RequestParam(value = "uris", required = false) List<String> uris,
                                                     @RequestParam(value = "unique", required = false) boolean unique) {
        log.info("Get statistic start {}, end {}, uris {}, unique {} ", start, end, uris, unique);
        return statisticService.getStatistics(start, end, uris, unique);
    }

    //Сохранение информации об использовании сервиса
    @PostMapping("/hit")
    @ResponseStatus(HttpStatus.CREATED)
    private StatisticDto addHit(@Valid @RequestBody StatisticDto statisticDto) {
        log.info("Save statistic for service {}, uri {}, ip {}, timestamp {}",
                statisticDto.getApp(), statisticDto.getUri(), statisticDto.getIp(), statisticDto.getTimestamp());
        return statisticService.addHit(statisticDto);
    }
}
