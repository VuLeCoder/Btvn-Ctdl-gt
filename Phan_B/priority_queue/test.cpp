#include "PRIORITY_QUEUE_H.hpp"
using namespace std;

int main()
{
    PriorityQueue<int> pq;
	
	pq.pop();
	cout << pq.top() << endl;
	
    pq.push(89);	pq.push(1);		pq.push(23);
    pq.push(0);     pq.push(-11);   pq.push(-45);

    cout << pq.top() << endl;
    
    PriorityQueue<int, Greater<int>> pq1;

    pq1.push(89); 	pq1.push(1);     pq1.push(23);
    pq1.push(0);	pq1.push(-11);   pq1.push(-45);

    cout << pq1.top();

    return 0;
}