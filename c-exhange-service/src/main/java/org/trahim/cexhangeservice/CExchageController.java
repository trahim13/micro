package org.trahim.cexhangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CExchageController {

    @Autowired
    private Environment environment;

    @Autowired
    private CExchangeRepository repository;

    @GetMapping("/c-exchange/from/{from}/to/{to}")
    public ResponseEntity<?> retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {


        ExchangeValue value = null;
        try {
            value = repository.getByFromAndTo(from.toUpperCase(), to.toUpperCase()).orElseThrow(
                    () ->
                            new RuntimeException("Not found")

            );
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        value.setPort(Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port"))));

        return new ResponseEntity<>(value, HttpStatus.OK);
    }

}
