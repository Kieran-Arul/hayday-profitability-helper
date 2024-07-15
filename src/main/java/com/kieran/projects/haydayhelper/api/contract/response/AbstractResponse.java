package com.kieran.projects.haydayhelper.api.contract.response;

import com.kieran.projects.haydayhelper.api.contract.request.AbstractRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class AbstractResponse {
    private AbstractRequest request;
}
