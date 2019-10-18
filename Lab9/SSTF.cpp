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

    int head, totalMovement = 0, finished = 0 , shortest = 0;
    cin >> head ;

    while(finished <= n)
    {
        shortest = 0 ;
        for(int i = 0 ; i < n ; i++)
        {
            if(request[i] == -1)continue;
            if(fabs(request[i] - head) < fabs(request[shortest] - head) )
            {
                shortest = i;
            }
        }

        cout << head << " ";

        totalMovement += fabs(request[shortest] - head) ;
        head = request[shortest] ;

        request[shortest] = -1;
        finished ++ ;

    }

    cout <<endl << totalMovement ;



    return 0;
}
