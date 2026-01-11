package ru.netology;

public class Radio {
    private int maxStations;
    private int currentStation;
    private int currentVolume;

    // Конструктор по умолчанию (количество станций = 10)
    public Radio() {
        this.maxStations = 10;
    }

    // Конструктор с желаемым количеством станций
    public Radio(int stationsCount) {
        this.maxStations = stationsCount;
    }

    // --- Работа с радиостанциями ---

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        // Номер станции должен быть от 0 до (количество - 1)
        if (currentStation < 0) {
            return;
        }
        if (currentStation >= maxStations) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void next() {
        // Если текущая станция максимальная (последняя), то переходим на 0
        if (currentStation == maxStations - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        // Если текущая станция 0, то переходим на максимальную (последнюю)
        if (currentStation == 0) {
            currentStation = maxStations - 1;
        } else {
            currentStation--;
        }
    }

    // --- Работа с громкостью (осталась без изменений 0-100) ---

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 100) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}