package ru.practicum.explorewithme.statisticservice;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StatisticDtoMapper {
    //Метод из объекта модели создает DTO-объект
    public static StatisticDto toDto(Statistic statistic) {
        return new StatisticDto(
                statistic.getServiceName(),
                statistic.getUri(),
                statistic.getIp(),
                statistic.getRequestDate()
        );
    }

    //Метод из DTO-объекта создает объекта модели
    public static Statistic toStatistic(StatisticDto dto) {
        Statistic statistic = new Statistic();
        statistic.setServiceName(dto.getApp());
        statistic.setUri(dto.getUri());
        statistic.setIp(dto.getIp());
        statistic.setRequestDate(dto.getTimestamp());
        return statistic;
    }
}
