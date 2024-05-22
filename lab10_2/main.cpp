#include <iostream>
#include "WordContainer.h"

int main() {
    std::string input_string = "Hello, how are you today?";
    WordContainer container(input_string);

    char symbol = container[8]; // Получаем символ с индексом 5 из строки
    std::cout << "Symbol at index 5: " << symbol << std::endl;

    // Выводим каждое слово из строки
    for (auto it = container.begin(); it != container.end(); ++it) {
        std::cout << *it << std::endl;
    }

    return 0;
}
