#include <iostream>
#include "cmath"

int main(int argc, const char * argv[]) {
    int H, W;
    std::cin >> H;
    std::cin >> W;
    int r = std::min(H,W)*100/2;
    std::cout << r;
    return 0;
}