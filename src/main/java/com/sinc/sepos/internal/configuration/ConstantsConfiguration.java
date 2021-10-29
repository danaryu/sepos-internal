package com.sinc.sepos.internal.configuration;

import com.sinc.sepos.internal.configuration.factory.YamlPropertySourceFactory;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@PropertySource(value= "classpath:constants.yml",
        factory = YamlPropertySourceFactory.class, ignoreResourceNotFound = true)
public class ConstantsConfiguration {

    @Value("${report.create-id.request}")
    private String requestCreateId;

    @Value("${report.send-stat.request}")
    private String requestSendStat;

    @Value("${report.change-id.request}")
    private String requestChangeId;
}


/*

report:
        create-id:
        request: makeRequestReport
        response: makeResponseReport
        send-stat:
        request: N
        response: Y
        error: E
*/
