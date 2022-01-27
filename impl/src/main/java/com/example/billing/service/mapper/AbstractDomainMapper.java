package com.example.billing.service.mapper;

import java.util.Collection;
import java.util.List;

public interface AbstractDomainMapper<M, D> {
    M toDomainModel(D dto);

    List<M> toDomainModel(Collection<D> dtoList);
}
