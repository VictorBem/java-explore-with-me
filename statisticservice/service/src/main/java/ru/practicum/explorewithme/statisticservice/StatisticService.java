package ru.practicum.explorewithme.statisticservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class StatisticService {
    private final StatisticRepository statisticRepository;

    //Сохранение данных об использовании сервиса
    public StatisticDto addHit(StatisticDto statisticDto) {
        Statistic saveStatistic = statisticRepository.save(StatisticDtoMapper.toStatistic(statisticDto));
        return StatisticDtoMapper.toDto(saveStatistic);
    }

    //Получение информации по статистике
    public List<StatisticResponseDto> getStatistics(LocalDateTime start, LocalDateTime end, List<String> uris, boolean unique) {
        if (uris == null && !unique) {
            return statisticRepository.getStatisticsSummary(start, end);
        } else if(uris == null) {
            return statisticRepository.getStatisticsSummaryUniqueIp(start, end);
        } else if (!unique) {
            return statisticRepository.getStatisticsSummary(start, end, uris);
        } else {
            return statisticRepository.getStatisticsSummaryUniqueIp(start, end, uris);
        }
    }
}
