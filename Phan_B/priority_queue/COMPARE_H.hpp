#ifndef COMPARE_H
#define COMPARE_H 1

template<class T>
class Less{
	public:
		bool operator()(const T &a, const T &b) { return a < b; }
};

template<class T>
class Greater{
	public:
		bool operator()(const T &a, const T &b) { return a >= b; }
};

#endif