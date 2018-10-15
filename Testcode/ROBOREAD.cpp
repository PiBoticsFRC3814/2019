#include <iostream>
#include <cstdlib>
#include <iomanip>
#include <string>
#include <fstream>

using namespace std;

int main()
{
	ifstream infile;
    infile.open("ROBOREADin.txt");
    
    //ofstream outfile;
	//outfile.open("");

	string test;

    infile.ignore(100,'=');
    getline(infile,test);

	cout << test << endl;

    infile.close();
	//outfile.close();
	
	system("PAUSE");
	
	return 0;
}
