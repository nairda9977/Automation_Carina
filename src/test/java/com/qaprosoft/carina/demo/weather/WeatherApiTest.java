package com.qaprosoft.carina.demo.weather;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.demo.api.weather.GetWeatherMethod;
import org.testng.annotations.Test;

public class WeatherApiTest extends AbstractTest {

@Test
    public void getCurrentWeather () {
    GetWeatherMethod getWeatherMethod = new GetWeatherMethod();
    getWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
    getWeatherMethod.callAPI();
    getWeatherMethod.validateResponse();
}

}
