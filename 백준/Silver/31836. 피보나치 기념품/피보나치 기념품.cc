#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N;
    vector<int> firstFriend, secondFriend;
    cin >> N;
    
    for (int i=N; i>2; i -=3) 
    {
        firstFriend.push_back(i);
        secondFriend.push_back(i-1);
        secondFriend.push_back(i-2);
    }
    
    if(N%3==2)
    {
        firstFriend.push_back(1);
        secondFriend.push_back(2);
    }
    
    cout << firstFriend.size() << endl;
    for(int value : firstFriend)
    {
        cout << value << " ";
    }
    cout << "\n";
    cout << secondFriend.size() << endl;
    for(int value : secondFriend)
    {
        cout << value << " ";
    }
    
}
