#include "declaration.h"
#include <stdexcept>

DoubleStackQueue::DoubleStackQueue() : head(0), tail(0), count(0) {}

DoubleStackQueue::DoubleStackQueue(const DoubleStackQueue& other) {
    head = other.head;
    tail = other.tail;
    count = other.count;
    for (int i = 0; i < count; ++i) {
        buffer[i] = other.buffer[i];
    }
}

DoubleStackQueue::~DoubleStackQueue() {}

DoubleStackQueue& DoubleStackQueue::operator=(const DoubleStackQueue& other) {
    if (this != &other) {
        head = other.head;
        tail = other.tail;
        count = other.count;
        for (int i = 0; i < count; ++i) {
            buffer[i] = other.buffer[i];
        }
    }
    return *this;
}

int DoubleStackQueue::size() const {
    return count;
}

int& DoubleStackQueue::access(int index) {
    if (index < 0 || index >= count) {
        throw std::out_of_range("Index out of range");
    }
    int actualIndex = (head + index) % MAX_SIZE;
    return buffer[actualIndex];
}

void DoubleStackQueue::enqueue(int number) {
    if (count >= MAX_SIZE) {
        throw std::overflow_error("Queue is full");
    }
    buffer[tail] = number;
    tail = (tail + 1) % MAX_SIZE;
    ++count;
}

void DoubleStackQueue::dequeue() {
    if (count <= 0) {
        throw std::underflow_error("Queue is empty");
    }
    head = (head + 1) % MAX_SIZE;
    --count;
}
