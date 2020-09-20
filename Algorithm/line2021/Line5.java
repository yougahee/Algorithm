package Algorithm.line2021;

public class Line5 {
    public static void main(String[] args) {
        int[] cards = {10, 13, 10, 1, 2, 3, 4, 5, 6, 2};
        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        int answer = 0;
        int playerScore, dealerScore;
        int index=0;

        for(int i=0; i<cards.length; i++) {
            if(cards[i] == 11 || cards[i] == 12 || cards[i] == 13) {
                cards[i] = 10;
            }
        }

        loop:
        while (index + 3 < cards.length) {

            //System.out.println("index 의 값 : " + index + "answer : " + answer);

            int playerCard1 = cards[index++];
            int dealerNonSeeCard1 = cards[index++];
            int playerCard2 = cards[index++];
            int dealerSeeCard2 = cards[index++];

            playerScore = playerCard1 + playerCard2;

            //System.out.println("player 합 :  " + playerScore);
            if(playerCard1 == 1 && playerScore + 10 <= 21) {
                playerScore += 10;
            }
            if (playerCard2 == 1 && playerScore + 10 <= 21) {
                playerScore += 10;
            }

            dealerScore = dealerNonSeeCard1 + dealerSeeCard2;
            if(dealerNonSeeCard1 == 1 && dealerScore + 10 <= 21) {
                dealerScore += 10;
            }
            if (dealerSeeCard2 == 1 && dealerScore + 10 <= 21) {
                dealerScore += 10;
            }

            //player
            if(playerScore == 21) {
                //바로 승패 결정
                //블랙잭임
                if(playerScore != dealerScore)
                    answer += 3;
                continue;

            }else if(playerScore > 21) {
                //무조건 짐 (근데, 궁금한 게 상대방카드도 playerScore이랑 똑같으면 어떻게 됨?
                answer -= 2;
                continue;
            }else {
                if(dealerSeeCard2 == 1 || dealerSeeCard2 >=7) {
                    while (playerScore < 17) {
                        if( index >= cards.length )
                            break loop;

                        if(cards[index] == 1 && playerScore + 11 <= 21)
                            playerScore += cards[index++] + 10;
                        else
                            playerScore += cards[index++];
                    }
                }
                else if( dealerSeeCard2 == 2 || dealerSeeCard2 == 3) {
                    while (playerScore < 12) {
                        if( index >= cards.length )
                            break loop;
                        //## 1인 경우 처리해줘야함, index처리도 해야함
                        if(cards[index] == 1 && playerScore + 11 <= 21)
                            playerScore += cards[index++] + 10;
                        else
                            playerScore += cards[index++];
                    }
                }
            }

            //딜러차례
            while (dealerScore < 17) {
                //System.out.println("index " + index + " dealer 점수 : " + dealerScore + " a ns " + answer);
                if( index >= cards.length )
                    break loop;
                //## 1인 경우 처리. index처리도 해야함
                if(cards[index] == 1 && dealerScore + 11 <= 21)
                    dealerScore += cards[index++] + 10;
                else
                    dealerScore += cards[index++];
            }
            if(dealerScore > 21) {
                answer += 2;
                continue;
            }

            //승패 결정 --> 21이 넘지는 않음
            if(dealerScore > playerScore) {
                answer -=2;
            }else if (playerScore > dealerScore){
                if(playerScore == 21)
                    answer += 1;
                answer += 2;
            }
        }

        return answer;
    }
}
