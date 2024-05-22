#include <iostream>
#include <vector>
#include <algorithm>

// Определение класса Symbol
class Symbol {
private:
    char value;

public:
    // Конструктор
    Symbol(char val) : value(val) {}

    // Операции сравнения
    bool operator==(const Symbol& other) const {
        return value == other.value;
    }

    bool operator!=(const Symbol& other) const {
        return value != other.value;
    }

    bool operator<(const Symbol& other) const {
        return value < other.value;
    }

    // Операция ~
    Symbol operator~() const {
        return Symbol('~' + value);
    }

    // Вывод в поток
    friend std::ostream& operator<<(std::ostream& os, const Symbol& symbol) {
        os << symbol.value;
        return os;
    }
};

// Определение класса SortedSeq
template<typename Symbol>
class SortedSeq {
private:
    std::vector<Symbol> sequence;

public:
    // Конструкторы
    SortedSeq() = default;
    explicit SortedSeq(const Symbol& symbol) : sequence({symbol}) {}

    // Оператор +=
    SortedSeq<Symbol>& operator+=(const SortedSeq<Symbol>& other) {
        for (const auto& symbol : other.sequence) {
            auto it = std::lower_bound(sequence.begin(), sequence.end(), symbol);
            if (it == sequence.end() || *it != symbol) {
                sequence.insert(it, symbol);
            } else {
                sequence.erase(it);
            }
        }
        return *this;
    }

    // Оператор ~
    SortedSeq<Symbol>& operator~() {
        for (auto& symbol : sequence) {
            symbol = ~symbol;
        }
        return *this;
    }

    // Операторы сравнения
    bool operator<(const SortedSeq<Symbol>& other) const {
        return sequence < other.sequence;
    }

    bool operator<=(const SortedSeq<Symbol>& other) const {
        return sequence <= other.sequence;
    }

    bool operator>(const SortedSeq<Symbol>& other) const {
        return sequence > other.sequence;
    }

    bool operator>=(const SortedSeq<Symbol>& other) const {
        return sequence >= other.sequence;
    }

    bool operator==(const SortedSeq<Symbol>& other) const {
        return sequence == other.sequence;
    }

    bool operator!=(const SortedSeq<Symbol>& other) const {
        return sequence != other.sequence;
    }

    // Вывод последовательности в поток
    friend std::ostream& operator<<(std::ostream& os, const SortedSeq<Symbol>& sortedSeq) {
        for (const auto& symbol : sortedSeq.sequence) {
            os << symbol << ' ';
        }
        return os;
    }
};

int main() {
    // Пример использования класса SortedSeq
    SortedSeq<Symbol> seq1(Symbol('a'));
    SortedSeq<Symbol> seq2(Symbol('b'));
    SortedSeq<Symbol> seq3(Symbol('c'));
    SortedSeq<Symbol> seq4(Symbol('d'));

    seq1 += seq2;
    seq1 += seq3;
    seq1 += seq4;

    std::cout << "Sequence 1: " << seq1 << std::endl;

    ~seq1;
    std::cout << "Inverse of Sequence 1: " << seq1 << std::endl;

    return 0;
}
