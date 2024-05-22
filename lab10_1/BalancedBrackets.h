#include <iostream>
#include <string>
#include <stack>
#include <unordered_map>

class BalancedBrackets {
private:
    std::string brackets;

public:
    BalancedBrackets(const std::string& str) : brackets(str) {
        if (!isBalanced()) {
            throw std::invalid_argument("Unbalanced brackets");
        }
    }

    bool isBalanced() {
        std::stack<char> stack;
        std::unordered_map<char, char> pairs = {{')', '('}, {']', '['}, {'}', '{'}};

        for (char ch : brackets) {
            if (pairs.count(ch)) {
                if (stack.empty() || stack.top() != pairs[ch]) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.empty();
    }

    class Iterator {
    private:
        std::string::iterator it;
        BalancedBrackets& parent;

    public:
        Iterator(std::string::iterator it, BalancedBrackets& parent) : it(it), parent(parent) {}

        char& operator*() {
            return *it;
        }

        Iterator& operator++() {
            ++it;
            return *this;
        }

        bool operator!=(const Iterator& other) const {
            return it != other.it;
        }

        void changeBracketType() {
            char current = *it;
            char newOpening, newClosing;
            switch (current) {
                case '(': newOpening = '['; newClosing = ']'; break;
                case '[': newOpening = '{'; newClosing = '}'; break;
                case '{': newOpening = '('; newClosing = ')'; break;
                case ')': newOpening = ']'; newClosing = '['; break;
                case ']': newOpening = '}'; newClosing = '{'; break;
                case '}': newOpening = ')'; newClosing = '('; break;
                default: return;
            }

            std::string::iterator pairIt = findPair();
            if (pairIt != parent.brackets.end()) {
                *it = newOpening;
                *pairIt = newClosing;
            }
        }

    private:
        std::string::iterator findPair() {
            std::stack<std::string::iterator> stack;
            std::unordered_map<char, char> openingPairs = {{'(', ')'}, {'[', ']'}, {'{', '}'}};
            std::unordered_map<char, char> closingPairs = {{')', '('}, {']', '['}, {'}', '{'}};

            for (auto iter = parent.brackets.begin(); iter != parent.brackets.end(); ++iter) {
                if (openingPairs.count(*iter)) {
                    stack.push(iter);
                } else if (closingPairs.count(*iter)) {
                    if (!stack.empty() && *stack.top() == closingPairs[*iter]) {
                        auto openingIt = stack.top();
                        stack.pop();
                        if (openingIt == it) {
                            return iter;
                        }
                        if (iter == it) {
                            return openingIt;
                        }
                    }
                }
            }
            return parent.brackets.end();
        }
    };

    Iterator begin() {
        return Iterator(brackets.begin(), *this);
    }

    Iterator end() {
        return Iterator(brackets.end(), *this);
    }
};
