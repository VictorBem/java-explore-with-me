import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import ru.practicum.explorewithme.statisticservice.StatisticClient;
import ru.practicum.explorewithme.statisticservice.StatisticDto;
import ru.practicum.explorewithme.statisticservice.StatisticRepository;
import ru.practicum.explorewithme.statisticservice.StatisticService;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

//@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = StatisticService.class)
//@SpringBootTest(classes = StatisticService.class)
public class ClientTest {
    /*@MockBean
    StatisticService statisticService;
    @Autowired
    private MockMvc mvc;
    private final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    RestTemplateBuilder builder = new RestTemplateBuilder();

    //@InjectMocks
    private final StatisticClient statisticClient = new StatisticClient("http://localhost:9090", builder);


    @Test
    public void testClient_addHit() {
        StatisticDto statisticDto= new StatisticDto("ewm-main-service",
                "/events",
                "127.0.0.1",
                LocalDateTime.of(2023,05,05,21,32,49));

        when(statisticService.addHit(any(StatisticDto.class))).thenReturn(statisticDto);

        ResponseEntity<Object> result = statisticClient.addHit(statisticDto);

        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
        Assertions.assertEquals(result.hasBody(), true);

        LinkedHashMap<String, String> resultStatistic = (LinkedHashMap) result.getBody();

        Assertions.assertEquals(statisticDto.getApp(), resultStatistic.get("app"));
        Assertions.assertEquals(statisticDto.getIp(), resultStatistic.get("ip"));
        Assertions.assertEquals(statisticDto.getUri(), resultStatistic.get("uri"));
        //Assertions.assertEquals(statisticDto.getTimestamp(), resultStatistic.get("timestamp"));
    }*/

}
