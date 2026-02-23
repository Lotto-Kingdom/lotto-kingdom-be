package com.example.lottokingdombe.global.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Java 8 날짜/시간 모듈 등록
        objectMapper.registerModule(new JavaTimeModule());

        // 날짜를 타임스탬프로 직렬화하지 않고 ISO-8601 형식으로 처리
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 알 수 없는 속성이 있어도 실패하지 않음
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // null 값을 가진 필드는 JSON에 포함하지 않음
        objectMapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);

        // 타임존 설정 (Asia/Seoul)
        objectMapper.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        return objectMapper;
    }
}