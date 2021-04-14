package com.pluralsight.springdataoverview;

import com.pluralsight.springdataoverview.entity.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringDataOverviewApplicationTests {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void verifyFlightCanBeSaved() {
        final Flight flight = new Flight();
        flight.setOrigin("Amsterdam");
        flight.setDestination("New York");
        flight.setScheduledAt(LocalDateTime.parse("2011-12-13T12:12:00"));

        entityManager.persist(flight);

        final TypedQuery<Flight> results = entityManager.createQuery("select f from Flight f", Flight.class);

        final List<Flight> resultList = results.getResultList();

        assertThat(resultList).hasSize(1).first().isEqualTo(flight);


    }
}
