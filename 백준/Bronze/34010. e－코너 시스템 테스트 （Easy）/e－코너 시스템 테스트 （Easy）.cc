#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, value;
    cin >> N;
    
    for (int i=0; i<N*N; i++) {
        cin >> value;
    }
    
    cout << 2*(N-1) << " " << 2*(N-1)-1 << endl;
}
