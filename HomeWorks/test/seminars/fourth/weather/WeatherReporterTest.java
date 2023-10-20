package seminars.fourth.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class WeatherReporterTest {

    @Test
    void testWeatherServiceGetCurrTemp() {
        int temperature = 25;
        String expected = "Текущая температура: " + temperature + " градусов.";

        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);

        when(weatherService.getCurrentTemperature()).thenReturn(temperature);

        String result = weatherReporter.generateReport();
        verify(weatherService, times(1)).getCurrentTemperature();
        assertThat(result).isEqualTo(expected);

    }

}