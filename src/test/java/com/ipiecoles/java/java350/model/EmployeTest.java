package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    void getNombreAnneeAncienneteWithDataEmbaucheNow() {
        //Given
        Employe employe = new Employe("Doe", "John", "T12345", LocalDate.now().plusYears(6), 2500.0, 1, 1.0);

        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(0);
    }

    @Test
    void getNombreAnneeAncienneteWithPastDateEmbauche(){
        //Given
        Employe employe = new Employe("Doe", "John", "T12345", LocalDate.now().minusYears(6), 2500.0, 1, 1.0);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isEqualTo(6);
    }

    @Test
    void getNombreAncienneteWithDateEmbaucheNull() {
        //Given
        Employe employe = new Employe("Doe", "John", "T12345", null, 2500.0, 1, 1.0);
        //When
        Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then
        Assertions.assertThat(nbAnnees).isNull();
    }

}