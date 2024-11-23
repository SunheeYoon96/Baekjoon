#include <iostream>
#include <string>

using namespace std;

int personX = 0, personY = 0;
int cameraX = 0, cameraY = -1;
int cameraDir = 0; //남서북동 0123

void moveOnlyCamera(int dir){
    if(dir==0){
        cameraX = personX;
        cameraY = personY-1;
    }
    else if (dir==1){
        cameraX = personX-1;
        cameraY = personY;
    }
    else if (dir==2){
        cameraX = personX;
        cameraY = personY+1;
    }
    else if (dir==3){
        cameraX = personX+1;
        cameraY = personY;
    }
}

void movePoint(int dx, int dy)
{
    cameraX += dx;
    cameraY += dy;
    personX += dx;
    personY += dy;
}

void move(int dir, string cmd)
{
    if(dir==0){
        if(cmd=="W"){
            movePoint(0, 1);
        }
        else if (cmd=="A"){
            movePoint(-1, 0);
        }
        else if (cmd=="S"){
            movePoint(0, -1);
        }
        else if (cmd=="D"){
            movePoint(1, 0);
        }
    }
    else if (dir==1){
        if(cmd=="W"){
            movePoint(1, 0);
        }
        else if (cmd=="A"){
            movePoint(0, 1);
        }
        else if (cmd=="S"){
            movePoint(-1, 0);
        }
        else if (cmd=="D"){
            movePoint(0, -1);
        }
    }
    else if (dir==2){
        if(cmd=="W"){
            movePoint(0, -1);
        }
        else if (cmd=="A"){
            movePoint(1, 0);
        }
        else if (cmd=="S"){
            movePoint(0, 1);
        }
        else if (cmd=="D"){
            movePoint(-1, 0);
        }
    }
    else if (dir==3){
        if(cmd=="W"){
            movePoint(-1, 0);
        }
        else if (cmd=="A"){
            movePoint(0, -1);
        }
        else if (cmd=="S"){
            movePoint(1, 0);
        }
        else if (cmd=="D"){
            movePoint(0, 1);
        }
    }
}

int main() {
    int N;
    cin >> N;

    for (int i = 0; i < N; ++i) {
        string action;
        cin >> action;
        
        if(action=="MR"){
            cameraDir = (cameraDir+1)%4;
            moveOnlyCamera(cameraDir);
        }
        else if(action=="ML"){
            cameraDir = (cameraDir+3)%4;
            moveOnlyCamera(cameraDir);
        }
        else{
            move(cameraDir, action);
        }

        cout << personX << " " << personY << " " << cameraX << " " << cameraY << endl;
    }

    return 0;
}