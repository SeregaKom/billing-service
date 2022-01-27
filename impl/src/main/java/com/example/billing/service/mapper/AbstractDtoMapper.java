package com.example.billing.service.mapper;

import java.util.Collection;
import java.util.List;

public interface AbstractDtoMapper <M, D>{
    D toDto(M domainModel);

    List<D> toDto(Collection<M> domainModelList);
}
