#ifndef BOOK_H
#define BOOK_H 1

#include <iostream>
using namespace std;

string DelBlank_and_ToLowercase(string s)
{
	string ans = "";
	for(int i=0; i<s.length(); ++i)
	{
		if(s[i] == ' ') continue;
		if(s[i] >= 'A' && s[i] <= 'Z') ans += (s[i]+32);
		else ans += s[i];
	}
	return ans;
}

class BOOK{
	private:
		string id;
		string name, idName;
		string author, idAuthor;
		double price;
	
	public:
		friend istream& operator>>(istream& in, BOOK& book)
		{
	        cout << "Nhap id sach : "; in >> book.id;
	        
	        in.ignore();
	        cout << "Nhap ten sach : "; getline(in, book.name);
	        book.idName = DelBlank_and_ToLowercase(book.name);
	        
	        cout << "Nhap ten tac gia : "; getline(in, book.author);
	        book.idAuthor = DelBlank_and_ToLowercase(book.author);
	        
	        cout << "Nhap gia tien : "; in >> book.price;
	        return in;
    	}
    	
		friend ostream& operator<<(ostream& out, BOOK& book)
		{
	        cout << "Id sach : "; out << book.id << "\n";
	        cout << "Ten sach : "; out << book.name << "\n";
	        cout << "Ten tac gia : "; out << book.author <<"\n";
	        cout << "Gia tien : "; out << book.price << "\n";
	        return out;
    	}
    	
    	
    	bool operator==(const BOOK& otherBook) const { return this->price == otherBook.price;}
    	bool operator>(const BOOK& otherBook) const { return this->price > otherBook.price;}
    	bool operator<(const BOOK& otherBook) const { return this->price < otherBook.price;}
    	
    	void setName(string s) {name = s;}
    	void setAuthor(string s) {author = s;}
    	void setPrice(double p) {price = p;}
    	
    	string getId() {return	id;}
    	double getPrice() {return price;}
    	string getIdName() {return idName;}
    	string getIdAuthor() {return idAuthor;}
};

#endif