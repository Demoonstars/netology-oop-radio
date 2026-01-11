package ru.netology;

public class Radio {
    private int currentStation;
    private int currentVolume;

    // --- Работа с радиостанциями (0-9) ---

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        // Проверяем, что номер станции в пределах допустимого
        if (currentStation < 0) {
            return;
        }
        if (currentStation > 9) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void next() {
        // Если текущая 9, то следующая будет 0
        if (currentStation == 9) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        // Если текущая 0, то предыдущая будет 9
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation--;
        }
    }

    // --- Работа с громкостью (0-100) ---

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        // Добавил этот сеттер для удобства тестирования,
        // без него сложно выставить начальные условия для тестов громкости.
        if (currentVolume < 0) {
            return;
        }
        if (currentVolume > 100) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        // Если громкость уже максимальная (100), не увеличиваем
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        // Если громкость уже минимальная (0), не уменьшаем
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}