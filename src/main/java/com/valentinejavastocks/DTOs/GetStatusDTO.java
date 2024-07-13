package com.valentinejavastocks.DTOs;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class GetStatusDTO {
    private String stock;
    private Date startDate;
    private Date endDate;
}
