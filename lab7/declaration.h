#ifndef DECLARATION_H
#define DECLARATION_H

class DoubleStackQueue {
public:
    DoubleStackQueue();
    DoubleStackQueue(const DoubleStackQueue& other);
    virtual ~DoubleStackQueue();

    DoubleStackQueue& operator=(const DoubleStackQueue& other);

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
