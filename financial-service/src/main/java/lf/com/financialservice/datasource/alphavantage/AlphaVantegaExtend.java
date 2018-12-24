package lf.com.financialservice.datasource.alphavantage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.net.URI;

@Component
public class AlphaVantegaExtend {

    @Value("${external.app.alphavantage.api.url}")
    private String urlApi;

    @Autowired
    private WebClient webClient;

    public Mono<?> get(String process, MultiValueMap<String,String> parameters, Class<?> classExpected){
        return webClient
                .get()
                .uri(createUrl(process,parameters).toUri())
                .retrieve().bodyToMono(classExpected);
    }

    private UriComponents createUrl(String process, MultiValueMap<String,String> parameters) {
        String urlServer = null;
        if(!urlApi.endsWith("/")){
            urlServer = urlApi + "/" +process;
        }else{
            urlServer = urlApi +process;
        }
        return UriComponentsBuilder.fromUriString(urlServer).queryParams(parameters).build();
    }

}
