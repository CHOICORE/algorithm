import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 대기 큐에 있는 프로세스의 정보를 저장할 Queue 생성
        Queue<Integer> queue = new LinkedList<>();
        for (int priority : priorities) {
            queue.offer(priority);
        }

        // 우선순위가 높은 프로세스가 실행될 때까지 반복
        while (!queue.isEmpty()) {
            int current = queue.poll(); // 대기 큐에서 프로세스 추출

            // 현재 프로세스가 가장 우선순위가 높은지 여부를 저장할 변수
            boolean isMax = queue
                    .stream()
                    .mapToInt(priority -> priority)
                    .noneMatch(priority -> current < priority);

            // 우선순위가 더 높은 프로세스가 존재하므로 isMax를 false로 설정
            if (isMax) { // 현재 프로세스가 가장 우선순위가 높은 경우
                answer++; // 실행된 프로세스의 개수 증가
                if (location == 0) break; // 반복문 종료

            } else { // 현재 프로세스가 가장 우선순위가 높지 않은 경우
                queue.offer(current); // 대기 큐의 맨 뒤에 현재 프로세스 추가
            }

            // location 값 업데이트
            if (location == 0) {
                location = queue.size() - 1;
            } else {
                location--;
            }
        }
        
        return answer;
    }
}