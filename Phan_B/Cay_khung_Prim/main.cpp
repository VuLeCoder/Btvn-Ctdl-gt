#include "../priority_queue/PRIORITY_QUEUE_H.hpp"
#include "SPECIAL_H.hpp"
using namespace std;
#define MAX 1001

Vector<Pair<int, int>> adj[MAX];
Vector<bool> check(MAX, false);

int main()
{
	PriorityQueue<Pair<int, int>, comparePair<int, int>> pq;
	int n, m; cin >> n >> m;
	for(int i=0; i<m; ++i)
	{
		int u, v, w; cin>> u >> v >>w;
		Pair<int, int> p(v, w);
		adj[u].push_back(p);
		
		Pair<int, int> q(u, w);
		adj[v].push_back(q);
	}
	
	check[0] = true;
	for(int i=0; i<adj[0].size(); ++i)
		pq.push(adj[0][i]);
	
	int res = 0;
	while(!pq.empty())
	{
		Pair<int, int> p = pq.top();
		pq.pop();
		
		if(check[p.first()]) continue;
		check[p.first()] = true;

		res += p.second();
		
		int adj1 = p.first();
		for(int i=0; i<adj[adj1].size(); ++i)
			if(!check[adj[adj1][i].first()])
				pq.push(adj[adj1][i]);
	}
	
	cout << res;
	return 0;
}