#include "declaration.h"
#include <iostream>

void processQueue(DoubleStackQueue q) {
    std::cout << "Size of queue in function: " << q.size() << std::endl;
}

int main() {
    DoubleStackQueue queue1;
    queue1.enqueue(10);
    queue1.enqueue(20);
    queue1.enqueue(30);

    processQueue(queue1);

    DoubleStackQueue queue2 = queue1;

    std::cout << "Size of queue1: " << queue1.size() << std::endl;
    std::cout << "Size of queue2: " << queue2.size() << std::endl;

    return 0;
}
