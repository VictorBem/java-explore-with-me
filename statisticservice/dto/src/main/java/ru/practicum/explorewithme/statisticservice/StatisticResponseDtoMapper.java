package ru.practicum.explorewithme.statisticservice;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StatisticResponseDtoMapper {
    //Метод из объекта модели создает DTO-объект
    /*public static StatisticResponseDto toDto(Statistic statistic) {
        return new StatisticResponseDto(
                statistic.getId(),
                statistic.getServiceName(),
                statistic.getUri(),
                statistic.getIp(),
                statistic.getRequest_date()
        );
    }

    //Метод из DTO-объекта создает объекта модели
    public static Statistic toStatistic(StatisticResponseDto dto) {
        Statistic statistic = new Statistic();
        statistic.setId(dto.getId());
        statistic.setServiceName(dto.getServiceName());
        statistic.setUri(dto.getUri());
        statistic.setIp(dto.getIp());
        statistic.setRequest_date(dto.getRequest_date());
        return statistic;
    }*/
}
