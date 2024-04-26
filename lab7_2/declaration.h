#ifndef DECLARATION_H
#define DECLARATION_H

class CircularBufferQueue {
public:
    CircularBufferQueue();
    CircularBufferQueue(const CircularBufferQueue& other);
    virtual ~CircularBufferQueue();

    CircularBufferQueue& operator=(const CircularBufferQueue& other);

    int size() const;
    int& access(int index);
    void enqueue(int number);
    void dequeue();

private:
    static const int MAX_SIZE = 100;
    int buffer[MAX_SIZE];
    int head;
    int tail;
    int count;
};

#endif // DECLARATION_H
