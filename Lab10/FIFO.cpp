#include<bits/stdc++.h>
using namespace std ;


int main()
{
    int numberOfPage, numberOfPageReference, numberOfFrame ;

    cout << "Number of pages :";
    cin >> numberOfPage;
    cout << "Number of page References :";
    cin >> numberOfPageReference;
    cout << "Number of Frames :";
    cin >> numberOfFrame;


    cout << "enter the reference String :" << endl ;

    vector<int>RS;
    int temp,nPageFault = 0;
    bool found = false;

    while(numberOfPageReference--)
    {
        ///FIFO

        found = false ;
        cin >>temp ;
        for(int i = 0 ; i < RS.size() ; i++)
        {
            if(RS[i] == temp)
            {
                found = true;
                break;
            }
        }
        if(found == false)
        {
            if(RS.size() >= numberOfFrame)
            {
                //shift left
                for(int i = 0 ; i <= RS.size()-1 ; i++)
                {
                    RS[i] = RS[i+1];
                }
                RS.resize(numberOfFrame -1);
            }
            RS.push_back(temp);
            nPageFault++;
        }

    }


    cout <<"Number of page fault using FIFO Page replacement Algorithm :"<< nPageFault << endl ;
    cout << "Page Fault Rate : " <<(int)(nPageFault/numberOfPageReference)*100<<"%";

    return 0 ;


}
