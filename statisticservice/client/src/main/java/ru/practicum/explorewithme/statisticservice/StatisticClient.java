package ru.practicum.explorewithme.statisticservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
@Slf4j
public class StatisticClient extends BaseClient {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    public StatisticClient(@Value("${explore-with-me-server.url}") String serverUrl, RestTemplateBuilder builder) {
        super(
                builder
                        .uriTemplateHandler(new DefaultUriBuilderFactory(serverUrl))
                        .requestFactory(HttpComponentsClientHttpRequestFactory::new)
                        .build()
        );
    }

    //Сохранение информации о вызове сервиса
    public ResponseEntity<Object> addHit(StatisticDto statisticDto) {
        return post("", statisticDto);
    }

    //Получение статистики
    public ResponseEntity<Object> getStatistics(LocalDateTime start, LocalDateTime end, String uris, boolean unique) {
        Map<String, Object> parameters = Map.of(
                "start", URLEncoder.encode(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).format(start), StandardCharsets.UTF_8),
                "end", URLEncoder.encode(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT).format(end), StandardCharsets.UTF_8),
                "uris", uris,
                "unique", unique
        );
        log.info("Получаем статистику по следующим параметрам start {} end {} uris {} unique {}", start, end, uris, unique);
        return get("?start={start}&end={end}&uris={uris}&unique={unique}", parameters);
    }
}


