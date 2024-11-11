#ifndef PRIORITY_QUEUE
#define PRIORITY_QUEUE 1

#include <iostream>
#include "VECTOR_H.hpp"
#include "COMPARE_H.hpp"

template <typename T, typename compare = Less<T>>
class PriorityQueue
{
	private:
	    Vector<T> heap;
	    compare cmp;
	    
	    void heap_push(int index)
	    {
	        while(index > 0)
	        {
	            int parent = (index - 1) / 2;
	            if(cmp(heap[parent], heap[index]))
	            {
	                T tmp = heap[index];
	                heap[index] = heap[parent];
	                heap[parent] = tmp;
	                
	                index = parent;
	            }
	            else break;
	        }
	    }
	
	    void heap_pop(int index)
	    {
	        int size = heap.size();
	        while(true)
	        {
	            int left = 2*index + 1;
	            int right = 2*index + 2;
	            int M_index = index;
	
	            if(left < size && cmp(heap[M_index], heap[left])) M_index = left;
	
	            if(right < size && cmp(heap[M_index], heap[right])) M_index = right;
	
	            if(index != M_index)
	            {
	                T tmp = heap[index];
	                heap[index] = heap[M_index];
	                heap[M_index] = tmp;
	                
	                index = M_index;
	            }
	            else break;
	        }
	    }
	
	public:
		bool empty() const { return heap.empty(); }
	    int size() const { return heap.size(); }
	    
	    void push(T value)
	    {
	        heap.push_back(value);
	        heap_push(heap.size() - 1);
	    }
	
	    void pop()
	    {
	    	if(heap.empty()) { std::cout << "PriorityQueue khong co phan tu nao\n"; return; }
	    	
		    heap[0] = heap.back();
		    heap.pop_back();
		    heap_pop(0);
	    }
	
	    T top()
	    {
	        if(heap.empty()) { std::cout << "PriorityQueue khong co phan tu nao "; return T(); }
	        return heap[0];
	    }
};

#endif