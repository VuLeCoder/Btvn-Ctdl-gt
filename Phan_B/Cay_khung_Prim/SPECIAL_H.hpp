#ifndef SPECIAL_H
#define SPECIAL_H 1

template<typename T1, typename T2>
class Pair{
	private:
		T1 x;
		T2 y;
	public:
		Pair() : x(), y() {}
    	Pair(T1 first, T2 second) : x(first), y(second) {}
    	
		T1 first() { return x; }
		T2 second() { return y; }
};

template<typename T1, typename T2>
class comparePair{
	public:
		bool operator()(Pair<T1, T2>& a1, Pair<T1, T2>& a2){
			return a1.second() >= a2.second();
		}
};


template<class T>
class adjacent{
	private:
		int adj1, adj2;
		T w;
	public:
		adjacent() : adj1(0), adj2(0), w(10000) {}
		adjacent(int a1 , int a2, T weight) : adj1(a1), adj2(a2), w(weight) {}
		
		T getWeight() const { return w; }
};

template<class T>
class compareAdj{
	public:
		bool operator()(const adjacent<T>& a1, const adjacent<T>& a2){
			return a1.getWeight() < a2.getWeight();
		}
};

#endif