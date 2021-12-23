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

    @Test
    void getAugmentationSalaire(){
        //Given
        Employe employe = new Employe("Doe", "Jane", "C102054", LocalDate.now().minusYears(2), 1200.0, 3, 25.0);

        //When
        Double Augmentation = employe.augmenterSalaire(20);

        //Then
        Assertions.assertThat(Augmentation).isEqualTo(1440.0);
    }

    @Test
    void getAugmenterSalaireNull(){
        //Given
        Employe employe = new Employe("Doe", "Jane", "C102054", LocalDate.now().minusYears(2), 0.0, 1, 25.0);

        //When
        Double Augmentation = employe.augmenterSalaire(23);

        //Then
        Assertions.assertThat(Augmentation).isEqualTo(0);
    }

    @Test
    void getAugmenterSalaireN(){
        //Given
        Employe employe = new Employe("Doe", "Jane", "C102054", LocalDate.now().minusYears(2), -1200.0, 2, 35.0);

        //When
        Double Augmentation = employe.augmenterSalaire(25);

        //Then
        Assertions.assertThat(Augmentation).isEqualTo(-1500);
    }
}