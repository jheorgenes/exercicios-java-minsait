package br.com.exercicios_minsait.exercicio4.domain.model.dto;

import org.springframework.data.domain.Page;
import java.util.List;

public class ResponseDTO<T> {

    private List<T> data;
    private PaginationDTO pagination;

    public ResponseDTO(List<T> data, PaginationDTO pagination) {
        this.data = data;
        this.pagination = pagination;
    }

    public List<T> getData() {
        return data;
    }

    public PaginationDTO getPagination() {
        return pagination;
    }

    public static <T> ResponseDTO<T> fromPage(Page<T> page) {
        var pagination = new PaginationDTO(
                page.getNumber(),
                page.getTotalPages(),
                (int) page.getTotalElements()
        );
        return new ResponseDTO<>(page.getContent(), pagination);
    }
}
