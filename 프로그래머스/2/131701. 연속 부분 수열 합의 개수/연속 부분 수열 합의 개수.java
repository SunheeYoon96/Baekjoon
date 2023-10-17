import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] elements) throws IOException {
        int answer = 0;
        int newElements[] = new int[elements.length *2]; //같은 배열을 2번 넣어줘서 순환과 동일하게 만듬
        for(int i=0; i<elements.length; i++){
            newElements[i] = newElements[i+elements.length] = elements[i];
        }
        
        HashSet<Integer> hashSet = new HashSet<>(); //중복제거
        
        //슬라이딩 윈도우?
        for(int i=1; i<=elements.length; i++){
            for(int j=0; j<elements.length; j++) {
                hashSet.add(Arrays.stream(newElements, j, j+i).sum());
            }
        }
        answer = hashSet.size();
        return answer;
    }
}