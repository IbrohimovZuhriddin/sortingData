package zuhriddinscode.service;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeratesImpl implements ExchangeRates{


    String baseUrl="https://nbu.uz/uz/exchange-rates/";
    String Post="/json/";
    StringBuilder stringBuilder = new StringBuilder(baseUrl);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Map<String, Object>> getRates() {
        HttpEntity<Void >  httpEntity = new HttpEntity<>(  gethttpheaders() );
        String url =  stringBuilder.append(Post).toString();
        val response =  restTemplate.exchange(url, HttpMethod.GET,httpEntity,List.class );
        return response.getBody();

    }

    private HttpHeaders gethttpheaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON) );
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
