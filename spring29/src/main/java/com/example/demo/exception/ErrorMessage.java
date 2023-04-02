package com.example.demo.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString

public class ErrorMessage<T>{
    T body;
    HttpStatus code;
    LocalDateTime timeStamp;
}
