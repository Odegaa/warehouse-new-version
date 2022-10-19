package com.odegaa.projections;

import com.odegaa.models.Currency;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Currency.class)
public interface CurrencyProjection {
}