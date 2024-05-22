#include <string>

// Определение класса итератора для перебора слов в строке
class WordIterator {
private:
    const std::string& str;
    size_t current_pos;

public:
    WordIterator(const std::string& s, size_t pos = 0) : str(s), current_pos(pos) {}

    // Операторы для перемещения итератора
    WordIterator& operator++() {
        // Переход к началу следующего слова
        while (current_pos < str.size() && str[current_pos] == ' ') {
            ++current_pos;
        }
        // Переход к концу текущего слова
        while (current_pos < str.size() && str[current_pos] != ' ') {
            ++current_pos;
        }
        return *this;
    }

    // Оператор для доступа к текущему слову
    const std::string operator*() const {
        // Находим начало текущего слова
        size_t start_pos = current_pos;
        while (start_pos < str.size() && str[start_pos] == ' ') {
            ++start_pos;
        }
        // Находим конец текущего слова
        size_t end_pos = start_pos;
        while (end_pos < str.size() && str[end_pos] != ' ') {
            ++end_pos;
        }
        // Возвращаем текущее слово
        return str.substr(start_pos, end_pos - start_pos);
    }

    // Операторы сравнения
    bool operator!=(const WordIterator& other) const {
        return current_pos != other.current_pos;
    }

    bool operator==(const WordIterator& other) const {
        return current_pos == other.current_pos;
    }
};

// Определение контейнерного класса
class WordContainer {
private:
    std::string data;

public:
    // Конструктор
    WordContainer(const std::string& str) : data(str) {}

    // Методы для создания итераторов
    WordIterator begin() const {
        return WordIterator(data);
    }

    WordIterator end() const {
        return WordIterator(data, data.size());
    }

    // Оператор [] для доступа к символам строки
    char operator[](size_t index) const {
        return data[index];
    }
};
