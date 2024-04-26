#include "declaration.h"
#include <iostream>

void processQueue(CircularBufferQueue q) {
    std::cout << "Size of queue in function: " << q.size() << std::endl;
}

int main() {
    CircularBufferQueue queue1;
    queue1.enqueue(10);
    queue1.enqueue(20);
    queue1.enqueue(30);

    processQueue(queue1);

    CircularBufferQueue queue2 = queue1;

    std::cout << "Size of queue1: " << queue1.size() << std::endl;
    std::cout << "Size of queue2: " << queue2.size() << std::endl;

    return 0;
}
