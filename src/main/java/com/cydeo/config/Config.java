package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

    @Bean
    public Currency currencyBean(){

        Currency currency = new Currency();

        currency.setCode("USD");
        currency.setName("Dollar");

        return currency;
    }

    @Bean
    public Current currentBean(){

        Current current = new Current();

        current.setAccountId(UUID.randomUUID());
        current.setAmount(new BigDecimal(200));

        current.setCurrency(currencyBean());

        return current;

    }

    @Bean
    public Saving savingBean(Currency currency){

        Saving saving = new Saving();

        saving.setAccountId(UUID.randomUUID());
        saving.setAmount(new BigDecimal(200));

        saving.setCurrency(currency);

        return saving;

    }


}
