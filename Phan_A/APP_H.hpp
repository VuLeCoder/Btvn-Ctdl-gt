#ifndef APP_H
#define APP_H 1

#include "LIST_BOOK_H.hpp"

class APP : public LIST_BOOK{
	public:
		void showMenu()
		{
			cout << "------------------------------BookStoreApp------------------------------\n";
			cout << "------------------------------------------------------------------------\n";
			cout << "#####     Menu:                                                    #####\n" 
					"#####       1. Them sach                                           #####\n" 
					"#####       2. Hien thi danh sach                                  #####\n" 
					"#####       3. Sap xep theo gia tien                               #####\n"
					"#####       4. Xoa sach theo Id                                    #####\n" 
					"#####       5. Cap nhat thong tin sach theo Id                     #####\n"
					"#####       6. Tim sach theo khoang gia                            #####\n" 
					"#####       7. Tim sach theo ten                                   #####\n"
					"#####       8. Tim cac sach theo tac gia                           #####\n"
					"#####       9. Hien thi Menu                                       #####\n"
                    "#####       0. Thoat                                               #####\n";
        	cout << "------------------------------------------------------------------------\n";
        	cout << "------------------------------------------------------------------------\n";
		}
		
		void Add()
		{
			cout << "          ---------------------THEM SACH----------------------          \n";
			cout << "Nhap so sach muon them : ";
			int n; cin >> n;
			addBook(n);
			cout << "Da them " << n << " quyen sach\n";
		}
		
		void Show()
		{
			cout << "          ----------------HIEN THI DANH SACH------------------          \n";
			showListBook();
		}
		
		int Sort()
		{
			cout << "          -------------SAP XEP THEO GIA TIEN------------------          \n";
			if(getSize() == 0)
			{
				cout << "Danh sach dang trong\n";
				return 0;
			}
			
			int value = 2;
			while(value < 0 || value > 1)
			{
				cout << "Sap xep theo gia tang(1) hoac giam (0) : ";
				cin >> value;
			}
			if(value == 1) sortBook(true);
			else sortBook(false);
			value = 2;
			while(value < 0 || value > 1)
			{
				cout << "Ban co muon hien danh sach khong (1. Co), (0. Khong) : ";
				cin >> value;
			}
			return value;
		}
		
		void Delete()
		{
			cout << "          ----------------------XOA SACH----------------------          \n";
			cout << "Nhap id sach : ";
			string id; cin>>id;
			int index = findId(id);
			if(index == -1) cout << "Khong co quyen sach nay\n";
			else
			{
				deleteBook(index);
				cout << "Xoa thanh cong\n";
			}
		}
		
		void Update()
		{
			cout << "          -----------------CAP NHAT THONG TIN-----------------          \n";
			cout << "Nhap id sach : ";
			string id; cin>>id;
			int index = findId(id);
			if(index == -1) cout << "Khong co quyen sach nay\n";
			else
			{
				updateBook(index);
				cout << "Cap nhat thanh cong";
			}
		}
		
		void FindPrice()
		{
			cout << "          ---------------TIM SACH THEO GIA TIEN---------------          \n";
			cout << "Nhap khoang gia [Min Max]: ";
			double Min, Max; cin >> Min >> Max;
			cout << "Cac quyen sach trong khoang ["<< Min << ", " << Max << "] : \n";
			bool check = findPrice(Min, Max);
			if(!check) cout << "Khong co quyen nao\n";
		}
		
		void FindBookName()
		{
			cout << "          -----------------TIM SACH THEO TEN------------------          \n";
			cin.ignore();
			cout << "Nhap ten sach can tim : ";
			string _name; getline(cin, _name);
			
			_name = DelBlank_and_ToLowercase(_name);
			bool check = findBookName(_name);
			if(!check) cout << "Khong co quyen nao co ten nhu vay\n";
		}
		
		void FindBookSameAuthor()
		{
			cout << "          ---------------TIM SACH CUA TAC GIA-----------------          \n";
			cin.ignore();
			cout << "Nhap ten tac gia : ";
			string _name; getline(cin, _name);
			string _author = DelBlank_and_ToLowercase(_name);
			bool check = findBookSameAuthor(_author);
			if(!check) cout << "Khong co tac gia nay\n";
		}
		
		
		void run()
		{
			showMenu();
			while(true)
			{
				int value = -1, cnt = 0;
				while(value < 0 || value > 9){
					if(cnt == 1) cout << "Lenh khong hop le\n";
					cout << "Nhap lua chon : ";
					cin >> value;
					cnt = 1;
				}
				if(value == 0) 
				{
					cout << "Cam on ban da su dung";
					break;
				}
				
				switch(value)
				{
					case 1:
						Add();
						break;
					case 2:
						Show();
						break;
					case 3:
						if(Sort() == 1) showListBook();
						break;
					case 4:
						Delete();
						break;
					case 5:
						Update();
						break;
					case 6:
						FindPrice();
						break;
					case 7:
						FindBookName();
						break;
					case 8:
						FindBookSameAuthor();
						break;
					case 9:
						showMenu();
						break;
				}
				cout << "\n";
			}
		}
};

#endif