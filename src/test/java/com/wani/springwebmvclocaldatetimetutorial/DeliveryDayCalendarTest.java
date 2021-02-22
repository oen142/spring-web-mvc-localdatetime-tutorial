package com.wani.springwebmvclocaldatetimetutorial;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DeliveryDayCalendarTest {

    @Test
    void 배송도착일자_계산_공유일은_제외한다_now() {

        LocalDate date = LocalDate.of(2019, 5, 7);

        List<DeliveryDay> days = Arrays.asList(
                new DeliveryDay(date.plusDays(1), false),
                new DeliveryDay(date.plusDays(2), false),
                new DeliveryDay(date.plusDays(3), false)
        );

        DeliveryDayCalendar calendar = new DeliveryDayCalendar(days);

        DeliveryDay expectedArriveDate = calendar.getExpectedArriveDate(date);

        assertThat(expectedArriveDate.getDate()).isEqualTo(date.plusDays(3));

    }


    @Test
    void 배송도착일자_계산_공유일은_제외한다_now2() {

        LocalDate date = LocalDate.of(2019, 5, 10);

        List<DeliveryDay> days = Arrays.asList(
                new DeliveryDay(date.plusDays(1), false),
                new DeliveryDay(date.plusDays(2), false),
                new DeliveryDay(date.plusDays(3), false)
        );

        DeliveryDayCalendar calendar = new DeliveryDayCalendar(days);

        DeliveryDay expectedArriveDate = calendar.getExpectedArriveDate(date);

        assertThat(expectedArriveDate.getDate()).isEqualTo(date.plusDays(3));

    }


}