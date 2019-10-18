#include<bits/stdc++.h>
using namespace std ;

int main()
{
    int n, temp;
    cout << "number of request: " ;
    cin >> n ;
    vector<int>request;

    cout << "the requests: ";
    for(int i = 0 ; i < n ; i++)
    {
        cin >> temp ;
        request.push_back(temp);
    }

    int head, headIndex, totalMovement = 0, finished = 0 ;
    cout << "head: ";
    cin >> head ;
    request.push_back(head);
    int limit ;
    cout << "limit: " ;
    cin >> limit ;

    //Ascending order
    sort(request.begin(), request.end());

    for(int i = 0 ; i < n + 1 ; i++)
    {
        if(request[i] == head)
        {
            headIndex = i;
            break ;
        }

    }


    while(finished <= n)
    {
        for(int i = headIndex ; i < n+1 ; i++)
        {
            cout << request[i] << " ";
            totalMovement += fabs(request[i] - head) ;
            head = request[i];
            finished++;
        }

        totalMovement += fabs(limit - head) ;
        head = limit;
        cout << head << " ";


        totalMovement += fabs(0 - head) ;
        head = 0;
        cout << head << " ";




        for(int i = 0 ; i < headIndex ; i++)
        {
            cout << request[i] << " ";
            totalMovement += fabs(request[i] - head) ;
            head = request[i];
            finished++;

        }

    }

    cout <<endl << totalMovement ;



    return 0;
}
