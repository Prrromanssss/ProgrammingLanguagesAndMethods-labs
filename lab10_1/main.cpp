#include "BalancedBrackets.h"

int main() {
    try {
        BalancedBrackets bb("({[])");

        // Выводим исходную строку скобок
        for (auto it = bb.begin(); it != bb.end(); ++it) {
            std::cout << *it;
        }
        std::cout << std::endl;

        auto it = bb.begin();
        ++it; // Указываем на '{'
        it.changeBracketType(); // Меняем '{' на '[' и парную скобку '}' на ']'

        // Выводим строку скобок после изменения
        for (auto it = bb.begin(); it != bb.end(); ++it) {
            std::cout << *it;
        }
        std::cout << std::endl;

    } catch (const std::invalid_argument& e) {
        std::cerr << e.what() << std::endl;
    }

    return 0;
}
