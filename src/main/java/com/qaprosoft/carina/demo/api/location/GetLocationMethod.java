package com.qaprosoft.carina.demo.api.location;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import org.apache.log4j.Logger;

public class GetLocationMethod extends AbstractApiMethodV2 {
private static final Logger LOGGER = Logger.getLogger(GetLocationMethod.class);

        public GetLocationMethod (String placeId){
            super(null, "api.location/_post/_get/rs.json");

                replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
                LOGGER.info("api_url USED !");
            addParameterIfNotNull("place_id",placeId);



        }


}
