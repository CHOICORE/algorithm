import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;               // 총 걸린 시간을 담을 변수
        int totalWeight = 0;          // 현재 다리 위에 있는 트럭의 총 무게를 저장하는 변수
        int onBridgeCount = 0;        // 현재 다리 위에 있는 트럭 수를 저장하는 변수
        Queue<Integer> onBridge = new LinkedList<>();  // 다리 위에 있는 트럭을 저장할 큐

        for (int truck : truck_weights) {
            while (true) {
                if (onBridge.isEmpty()) { // 다리 위에 트럭이 없다면
                    onBridge.offer(truck);   // 트럭을 다리 위에 올림
                    totalWeight += truck;    // 다리 위에 있는 트럭의 총 무게 갱신
                    onBridgeCount++;         // 다리 위에 트럭 추가 시 변수 증가
                    answer++;                // 시간 증가
                    break;                   // 반복문 종료
                } else if (onBridgeCount == bridge_length) { // 다리가 꽉 찼다면
                    totalWeight -= onBridge.poll();   // 다리에서 나가는 트럭의 무게를 감소시키고 큐에서 제거
                    onBridgeCount--;                 // 다리에서 트럭 나갈 때 변수 감소
                } else { // 다리에 트럭이 있고, 다리가 꽉 차지 않았다면
                    if (totalWeight + truck <= weight) { // 다음 트럭을 다리에 올릴 수 있는지 무게 확인
                        onBridge.offer(truck);   // 트럭을 다리 위에 올림
                        totalWeight += truck;    // 다리 위에 있는 트럭의 총 무게 갱신
                        onBridgeCount++;         // 다리 위에 트럭 추가 시 변수 증가
                        answer++;                // 시간 증가
                        break;                   // 반복문 종료
                    } else { // 다음 트럭을 올릴 수 없다면
                        onBridge.offer(0); // 다리 위에 빈 공간으로 표시
                        onBridgeCount++;    // 빈 공간 추가 시 변수 증가
                        answer++;          // 시간 증가
                    }
                }
            }
        }

        return answer + bridge_length; // 마지막 트럭이 다리를 완전히 건너기 위해 추가로 걸리는 시간을 더해 반환
    }
}