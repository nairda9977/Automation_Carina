package com.qaprosoft.carina.demo.api.weather;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetWeatherMethod extends AbstractApiMethodV2 {

    public GetWeatherMethod (){
        super(null, "api.weather/_get/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_urls"));
        replaceUrlPlaceholder("city","Kyiv");
        request.param("APPID", "3057685f4807adbcfbbae72092548056");
        request.param("units", "metric");



    }
}
