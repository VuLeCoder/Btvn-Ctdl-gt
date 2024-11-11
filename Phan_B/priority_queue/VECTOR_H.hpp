#ifndef VECTOR_H
#define VECTOR_H 1

template<class T>
class Vector
{
	private:
		T *a;
		int _size;
		int _capacity;
		
	public:
		Vector() : a(nullptr), _size(0), _capacity(0) {};
		Vector(int n) {_size = _capacity = n; a = new T[n];}
		Vector(int n, T val)
		{
			_size = _capacity = n;
			a = new T[n];
			for(int i=0; i<n; ++i) a[i] = val;
		}
		
		int size() const { return _size; }
		bool empty() const { return _size == 0; }
		
		void expand(int new_capacity)
		{
			_capacity = new_capacity;
			T *tmp = new T[_capacity];
			
			for(int i=0; i<_size; ++i) tmp[i] = a[i];
			
			if(a) delete[]a;
			a = tmp;
		}
		
		T& operator[](int index) { return a[index]; }
		T back() { return a[_size-1]; }
		
		void push_back(T val)
		{
			if(_size == _capacity) expand(_capacity*2 + 5);
			
			a[_size] = val;
			_size++;
		}
		void pop_back() { if(_size > 0) _size--;}
};

#endif