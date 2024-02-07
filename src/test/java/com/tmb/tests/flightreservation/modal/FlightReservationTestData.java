package com.tmb.tests.flightreservation.modal;

public record FlightReservationTestData(String firstName,
                                        String lastName,
                                        String email,
                                        String password,
                                        String street,
                                        String city,
                                        String zip,
                                        String passengersCount,
                                        String expectedPrice) {
}
