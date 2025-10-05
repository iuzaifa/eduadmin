package com.education.eduadmin.exceptions.dto;

import lombok.*;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private String errors;
    private int errorCode;
    private long timestamp;
    private String path;




}
