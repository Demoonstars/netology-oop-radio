package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    // --- Тесты для конструктора по умолчанию (10 станций) ---

    @Test
    public void shouldSetStationDefault() {
        Radio radio = new Radio(); // По умолчанию 10 станций (0-9)
        radio.setCurrentStation(9);

        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMaxDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(10); // Максимум 9

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNextAfterLastStationDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next(); // Должно стать 0

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevAfterFirstStationDefault() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev(); // Должно стать 9

        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    // --- Тесты для конструктора с параметром (Свой размер) ---

    @Test
    public void shouldSetStationCustom() {
        Radio radio = new Radio(20); // 20 станций (0-19)
        radio.setCurrentStation(15);

        Assertions.assertEquals(15, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMaxCustom() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(20); // Максимум 19

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldNextAfterLastStationCustom() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(19); // Последняя станция
        radio.next();

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevAfterFirstStationCustom() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(0);
        radio.prev();

        Assertions.assertEquals(19, radio.getCurrentStation()); // Последняя 19
    }

    @Test
    public void shouldNextStationCustom() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(10);
        radio.next();

        Assertions.assertEquals(11, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevStationCustom() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(10);
        radio.prev();

        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    // --- Тесты громкости (без изменений) ---

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(99);
        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(1);
        radio.decreaseVolume();

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetVolumeValues() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        Assertions.assertEquals(50, radio.getCurrentVolume());

        radio.setCurrentVolume(-1);
        Assertions.assertEquals(50, radio.getCurrentVolume());

        radio.setCurrentVolume(101);
        Assertions.assertEquals(50, radio.getCurrentVolume());
    }
}