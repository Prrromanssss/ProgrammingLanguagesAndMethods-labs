#include "declaration.h"
#include <stdexcept>

CircularBufferQueue::CircularBufferQueue() : head(0), tail(0), count(0) {}

CircularBufferQueue::CircularBufferQueue(const CircularBufferQueue& other) {
    head = other.head;
    tail = other.tail;
    count = other.count;
    for (int i = 0; i < count; ++i) {
        buffer[i] = other.buffer[i];
    }
}

CircularBufferQueue::~CircularBufferQueue() {}

CircularBufferQueue& CircularBufferQueue::operator=(const CircularBufferQueue& other) {
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

int CircularBufferQueue::size() const {
    return count;
}

int& CircularBufferQueue::access(int index) {
    if (index < 0 || index >= count) {
        throw std::out_of_range("Index out of range");
    }
    int actualIndex = (head + index) % MAX_SIZE;
    return buffer[actualIndex];
}

void CircularBufferQueue::enqueue(int number) {
    if (count >= MAX_SIZE) {
        throw std::overflow_error("Queue is full");
    }
    buffer[tail] = number;
    tail = (tail + 1) % MAX_SIZE;
    ++count;
}

void CircularBufferQueue::dequeue() {
    if (count <= 0) {
        throw std::underflow_error("Queue is empty");
    }
    head = (head + 1) % MAX_SIZE;
    --count;
}
