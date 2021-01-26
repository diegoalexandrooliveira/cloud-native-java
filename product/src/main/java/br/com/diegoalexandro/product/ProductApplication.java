package br.com.diegoalexandro.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }


    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory){
//        return RedisCacheManager
//                .builder()
//                .cacheWriter(RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory))
//                .build();
//    }
}
