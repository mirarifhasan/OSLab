#include<bits/stdc++.h>
using namespace std ;

int main()
{
    int n ;
    cin >> n ;
    int request[n+2];
    for(int i = 0 ; i < n ; i++)
    {
        cin >> request[i];
    }

    int head, totalMovement = 0, finished = 0;
    cin >> head ;

    for(int i = 0 ; i < n ; i++)
    {
        cout << request[i] << " ";
        totalMovement += fabs(request[i] - head) ;
        head = request[i];

    }

    cout <<endl << totalMovement ;



    return 0;
}
