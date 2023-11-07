package com.unispace.lms.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponse<E> {
  private List<E> response;

  private Long totalElements;

  private Long totalPages;

  private Long currentPage;
}
