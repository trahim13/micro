package org.trahim.cexhangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CExchangeRepository extends JpaRepository<ExchangeValue, Long> {

    Optional<ExchangeValue> getByFromAndTo(String from, String to);

}
