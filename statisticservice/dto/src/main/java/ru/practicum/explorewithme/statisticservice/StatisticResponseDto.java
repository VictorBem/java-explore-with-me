package ru.practicum.explorewithme.statisticservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatisticResponseDto {
    private String app;
    private String uri;
    private long hits;
}
