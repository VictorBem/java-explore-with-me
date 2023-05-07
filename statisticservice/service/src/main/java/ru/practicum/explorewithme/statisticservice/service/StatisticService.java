package ru.practicum.explorewithme.statisticservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.explorewithme.statisticservice.*;
import ru.practicum.explorewithme.statisticservice.exception.BadRequestException;
import ru.practicum.explorewithme.statisticservice.repository.StatisticRepository;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StatisticService {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final StatisticRepository statisticRepository;

    //Сохранение данных об использовании сервиса
    public StatisticDto addHit(StatisticDto statisticDto) {
        Statistic saveStatistic = statisticRepository.save(StatisticDtoMapper.toStatistic(statisticDto));
        return StatisticDtoMapper.toDto(saveStatistic);
    }

    //Получение информации по статистике
    public List<StatisticResponseDto> getStatistics(String start, String end, List<String> uris, boolean unique) {
        //Декодируем даты старта и окончания периода для статистики
        LocalDateTime startDate = LocalDateTime.parse(URLDecoder.decode(start, StandardCharsets.UTF_8),
                                                      DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));

        LocalDateTime endDate = LocalDateTime.parse(URLDecoder.decode(end, StandardCharsets.UTF_8),
                                                    DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));

        if (startDate.isAfter(endDate)) {
            log.info("Дата начала периода {} не может быть после даты окончания периода {}", startDate, endDate);
            throw new BadRequestException("Дата начала периода " + startDate + " не может быть после даты окончания периода " + endDate);
        }

        if (uris == null && !unique) {
            return statisticRepository.getStatisticsSummary(startDate, endDate);
        } else if (uris == null) {
            return statisticRepository.getStatisticsSummaryUniqueIp(startDate, endDate);
        } else if (!unique) {
            return statisticRepository.getStatisticsSummary(startDate, endDate, uris);
        } else {
            return statisticRepository.getStatisticsSummaryUniqueIp(startDate, endDate, uris);
        }
    }
}
