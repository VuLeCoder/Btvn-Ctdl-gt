#include <functional>
#include <vector>
using namespace std;

#ifndef PRIORITY_QUEUE
#define PRIORITY_QUEUE 1

template <typename T, typename Comparator = less<T>>
class PriorityQueue
{
private:
    vector<T> heap;
    Comparator comp;

    void heapifyUp(int index)
    {
        while (index > 0)
        {
            int parent = (index - 1) / 2;
            if (comp(heap[parent], heap[index]))
            {
                swap(heap[index], heap[parent]);
                index = parent;
            }
            else
                break;
        }
    }

    void heapifyDown(int index)
    {
        int size = heap.size();
        while (true)
        {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && comp(heap[largest], heap[leftChild]))
                largest = leftChild;

            if (rightChild < size && comp(heap[largest], heap[rightChild]))
                largest = rightChild;

            if (largest != index)
            {
                swap(heap[index], heap[largest]);
                index = largest;
            }
            else
                break;
        }
    }

public:
    void push(T value)
    {
        heap.push_back(value);
        heapifyUp(heap.size() - 1);
    }

    void pop()
    {
        if (heap.empty())
            throw out_of_range("Heap is empty");

        heap[0] = heap.back();
        heap.pop_back();
        heapifyDown(0);
    }

    T top() const
    {
        if (heap.empty())
            throw out_of_range("Heap is empty");
        return heap[0];
    }

    bool empty() const { return heap.empty(); }

    int size() const { return heap.size(); }
};

#endif