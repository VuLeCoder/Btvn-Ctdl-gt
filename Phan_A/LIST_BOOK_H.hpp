#ifndef LIST_BOOK_H
#define LIST_BOOK_H 1

#include "BOOK_H.hpp"

#include <algorithm>
#include <vector>


class LIST_BOOK : public BOOK{
	private:
		vector<BOOK> books;
	public:
		LIST_BOOK() {books.resize(0);}
		
		int getSize() {return books.size();}
		
		void showListBook()
		{
			if(books.empty()) cout << "Khong co sach\n";
			else
				for(BOOK x : books)
					cout << x << "\n";
		}
				
		bool isValidId(string _id)
		{
			for(BOOK book : books)
				if(_id == book.getId())
					return false;
			return true;
		}
		
		void addBook(int n)
		{
			BOOK book;
			for(int i=0; i<n; ++i){
				cout << "----- Nhap thong tin : \n";
				cin >> book;

				if(book.getName().length() > 0)
				{
					if(book.getAuthor().length() > 0)
					{
						if(isValidId(book.getId())) books.push_back(book);
						else cout << "Id da ton tai\nVui long nhap lai\n", --i;
					}
					else cout << "Ten tac gia khong duoc de trong\nVui long nhap lai\n", --i;
				}
				else cout << "Ten sach khong duoc de trong\nVui long nhap lai\n", --i;
				cout <<"\n";
			}
		}
		
		void deleteBook(int index)
		{
			for(int i=index+1; i<books.size(); ++i)
				swap(books[i-1], books[i]);
			books.pop_back();
		}
		
		void updateBook(int index) 
		{
			cout << "Neu khong muon cap nhat nhan enter voi ten sach va tac gia, nhap -1 voi gia\n";
			string _name;
			cout << "Nhap ten : ";
			cin.ignore();
			getline(cin, _name);
			if(_name.length() != 0) books[index].setName(_name);
			
			string _author;
			cout << "Nhap ten tac gia : ";
			getline(cin, _author);
			if(_author.length() != 0) books[index].setAuthor(_author);
			
			double _price;
			cout << "Nhap gia : ";
			cin >> _price;
			if(_price != -1) books[index].setPrice(_price);
		}
		
		void sortBook(bool status)
		{
			cout << "Sap xep thanh cong\n";
			if(status)
				sort(books.begin(), books.end(), [](const BOOK &a, const BOOK &b){
					return a<b;
				});
			else
				sort(books.begin(), books.end(), [](const BOOK &a, const BOOK &b){
					return a>b;
				});
		}
		
		int findId(string id)
		{
			for(int i=0; i<books.size(); ++i)
				if(books[i].getId() == id)
					return i;
			return -1;
		}
		
		bool findPrice(double p1, double p2)
		{
			bool check = false;
			for(BOOK book : books)
			{
				int p = book.getPrice();
				if(p >= p1 && p <= p2)
				{
					check = true;
					cout << book << "\n";
				}
			}
			return check;
		}
		
		bool findBookName(string _name)
		{
			bool check = false;
			for(BOOK book : books)
			{
				if(book.getIdName().length() < _name.length()) continue;
				
				bool find = true;
				int n = _name.length();
				for(int i=0; i<n; ++i)
					if(book.getIdName()[i] != _name[i])
					{
						find = false;
						break;
					}
					
				if(find) check = true, cout << book << "\n";
			}
			return check;
		}
		
		bool findBookSameAuthor(string _name)
		{
			bool check = false;
			for(BOOK book : books)
			{
				if(book.getIdAuthor().length() < _name.length()) continue;
				
				bool find = true;
				int n = _name.length();
				for(int i=0; i<n; ++i)
					if(book.getIdAuthor()[i] != _name[i])
					{
						find = false;
						break;
					}
					
				if(find) check = true, cout << book << "\n";
			}
			return check;
		}
};

#endif