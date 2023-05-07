package ru.practicum.explorewithme.statisticservice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    //Метод возвращает текущие бронирования пользователя
    @Query("select new ru.practicum.explorewithme.statisticservice.StatisticResponseDto(s.serviceName, s.uri, count(s.id)) from Statistic s " +
           "where s.requestDate between ?1 and ?2 " +
           "  and s.uri IN ?3 " +
           "group by s.serviceName, s.uri " +
           "order by count(s.id) DESC ")
    List<StatisticResponseDto> getStatisticsSummary(LocalDateTime start, LocalDateTime end, List<String> uris);

    //Метод возвращает текущие бронирования пользователя по уникальным ip
    @Query("select new ru.practicum.explorewithme.statisticservice.StatisticResponseDto(s.serviceName, s.uri, count(DISTINCT s.ip)) from Statistic s " +
            "where s.requestDate between ?1 and ?2 " +
            "  and s.uri IN ?3 " +
            "group by s.serviceName, s.uri " +
            "order by count(DISTINCT s.ip) DESC ")
    List<StatisticResponseDto> getStatisticsSummaryUniqueIp(LocalDateTime start, LocalDateTime end, List<String> uris);

    //Метод возвращает текущие бронирования пользователя без учета uris
    @Query("select new ru.practicum.explorewithme.statisticservice.StatisticResponseDto(s.serviceName, s.uri, count(s.id)) from Statistic s " +
            "where s.requestDate between ?1 and ?2 " +
            "group by s.serviceName, s.uri " +
            "order by count(s.id) DESC ")
    List<StatisticResponseDto> getStatisticsSummary(LocalDateTime start, LocalDateTime end);

    //Метод возвращает текущие бронирования пользователя по уникальным ip без учета uris
    @Query("select new ru.practicum.explorewithme.statisticservice.StatisticResponseDto(s.serviceName, s.uri, count(DISTINCT s.ip)) from Statistic s " +
            "where s.requestDate between ?1 and ?2 " +
            "group by s.serviceName, s.uri " +
            "order by count(DISTINCT s.ip) DESC ")
    List<StatisticResponseDto> getStatisticsSummaryUniqueIp(LocalDateTime start, LocalDateTime end);


    //Метод возвращает текущие бронирования пользователя при этом происходит агрегация по сервису
    @Query("select new ru.practicum.explorewithme.statisticservice.StatisticResponseDto(s.serviceName, s.uri, count(s.id)) from Statistic s " +
            "where s.requestDate between ?1 and ?2 " +
            "  and SUBSTRING (s.uri, 1, CASE WHEN (LOCATE('/', s.uri, 2) - 1) = 0 THEN LENGTH(s.uri) ELSE (LOCATE('/', s.uri, 2) - 1) END) IN ?3 " +
            "group by s.serviceName, s.uri " +
            "order by count(s.id) DESC ")
    List<StatisticResponseDto> getStatisticsSummaryMainUri(LocalDateTime start, LocalDateTime end, List<String> uris);


    //Метод возвращает текущие бронирования пользователя по уникальным ip при этом происходит агрегация по сервису
    @Query("select new ru.practicum.explorewithme.statisticservice.StatisticResponseDto(s.serviceName, s.uri, count(DISTINCT s.ip)) from Statistic s " +
            "where s.requestDate between ?1 and ?2 " +
            "  and SUBSTRING (s.uri, 1, CASE WHEN (LOCATE('/', s.uri, 2) - 1) = 0 THEN LENGTH(s.uri) ELSE (LOCATE('/', s.uri, 2) - 1) END) IN ?3 " +
            "group by s.serviceName, s.uri " +
            "order by count(DISTINCT s.ip) DESC ")
    List<StatisticResponseDto> getStatisticsSummaryUniqueIpMainUri(LocalDateTime start, LocalDateTime end, List<String> uris);
}
