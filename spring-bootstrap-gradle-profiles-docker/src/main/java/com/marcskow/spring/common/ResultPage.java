package com.marcskow.spring.common;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class ResultPage<T> {
    private final List<T> results;
    private final long total;

    public ResultPage(Page<T> page) {
        this.results = page.getContent();
        this.total = page.getTotalElements();
    }
}
