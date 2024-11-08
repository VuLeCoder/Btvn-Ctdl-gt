#include <iostream>
#include "PRIORITY_QUEUE.cpp"
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    PriorityQueue<int> pq;

    pq.push(89);
    pq.push(1);
    pq.push(23);
    pq.push(0);
    pq.push(-11);
    pq.push(-45);

    cout << pq.top() << endl;

    PriorityQueue<int, greater<int>> pq1;

    pq1.push(89);
    pq1.push(1);
    pq1.push(23);
    pq1.push(0);
    pq1.push(-11);
    pq1.push(-45);

    cout << pq1.top();

    return 0;
}