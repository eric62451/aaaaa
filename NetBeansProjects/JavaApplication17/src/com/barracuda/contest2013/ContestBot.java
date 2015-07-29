/**
 * sample Java implementation for 2013 Barracuda Networks Programming Contest
 *
 */
package com.barracuda.contest2013;

import java.io.IOException;

public class ContestBot {

    private static final int RECONNECT_TIMEOUT = 15; // seconds
    private final String host;
    private final int port;
    private int game_id = -1;
    private boolean newGame = true;
    private int[] deck = new int[13];
    int hands;
    boolean first;
    double avg;
    int remaining, totalUnknown, total, min, max;
    double unknownAvg, handAvg;
    double enemyAvg;

    public ContestBot(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void run() {
        while (true) {
            // just reconnect upon any failure
            try {
                JsonSocket sock = new JsonSocket(host, port);
                try {
                    sock.connect();
                } catch (IOException e) {
                    throw new Exception("Error establishing connection to server: " + e.toString());
                }

                while (true) {
                    Message message = sock.getMessage();

                    PlayerMessage response = handleMessage(message);

                    if (response != null) {
                        sock.sendMessage(response);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.toString());
                System.err.println("Reconnecting in " + RECONNECT_TIMEOUT + "s");
                try {
                    Thread.sleep(RECONNECT_TIMEOUT * 1000);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    private void handAverage(MoveMessage m) {
        handAvg = 0;
        int temp;
        min = 0;
        max = 0;
        for (int i = 0; m.state.hand.length > i; i++) {
            handAvg = m.state.hand[i];
            temp = m.state.hand[i];
            if (m.state.hand[min] > temp) {
                min = i;
            }
            if (m.state.hand[max] < temp) {
                max = i;
            }
        }
        handAvg = handAvg / m.state.hand.length;
    }

    public PlayerMessage handleMessage(Message message) {
        if (message.type.equals("request")) {
            MoveMessage m = (MoveMessage) message;
            if (game_id != m.state.game_id) {
                game_id = m.state.game_id;
                System.out.println("new game " + game_id);
                if (newGame) {
                    if (m.state.player_number == 0 && m.state.hand_id % 2 == 1) {
                        first = true;
                    } else {
                        first = false;
                    }
                    newGame = false;
                    hands = 0;
                    for (int i = 0; i < 13; i++) {
                        deck[i] = 8;
                    }
                    unknownAvg = 0;
                    totalUnknown = 0;
                    enemyAvg = 7;
                    avg = 7;
                }
                for (int i = 0; i < 5; i++) {
                    deck[m.state.hand[i]]--;
                }
                remaining = 5;
                enemyAvg = avg;
            }

            if (m.request.equals("request_card")) {
                if (first) {
                    handAverage(m);
                    if (m.state.in_challenge) {
                        return new PlayCardMessage(m.request_id, m.state.hand[max]);
                    }
                    if (handAvg > (enemyAvg * 1.2) && m.state.can_challenge) {
                        deck[m.state.hand[min]]--;
                        return new PlayCardMessage(m.request_id, m.state.hand[min]);
                    }
                    if (Math.random() * 100 >= 50) {
                        deck[m.state.hand[max]]--;
                        return new PlayCardMessage(m.request_id, m.state.hand[max]);
                    } else {
                        deck[m.state.hand[min]]--;
                        return new PlayCardMessage(m.request_id, m.state.hand[min]);
                    }
                    //int i = (int) (Math.random() * m.state.hand.length);
                    //return new PlayCardMessage(m.request_id, m.state.hand[i]);
                } else {
                    handAverage(m);
                    int answer = -1;
                    deck[m.state.card]--;
                    if (m.state.in_challenge) {
                        for (int i = m.state.hand.length - 1; i >= 0; i++) {
                            if (m.state.hand[i] >= m.state.card) {
                                answer = i;
                            }
                        }
                        if (answer != -1) {
                            if (answer == 0) {
                                return new PlayCardMessage(m.request_id, m.state.hand[answer]);
                            } else if (m.state.hand[answer - 1] - m.state.card == 1) {
                                return new PlayCardMessage(m.request_id, m.state.hand[answer - 1]);
                            }
                        } else {
                            return new PlayCardMessage(m.request_id, m.state.hand[m.state.hand.length - 1]);
                        }
                    } else {
                        double temp = (enemyAvg * remaining) - m.state.card;
                        if ((handAvg * remaining) - m.state.hand[min] > enemyAvg * 1.25) {
                            return new OfferChallengeMessage(m.request_id);
                        } else {
                            if (m.state.hand[min] <= 6 && m.state.card >= 11) {
                                return new PlayCardMessage(m.request_id, m.state.hand[min]);
                            } else{
                                for (int i = m.state.hand.length - 1; i >= 0; i++) {
                                    if (m.state.hand[i] >= m.state.card) {
                                        answer = i;
                                    }
                                }
                                if (answer != -1) {
                                    if (answer == 0) {
                                        return new PlayCardMessage(m.request_id, m.state.hand[answer]);
                                    } else if (m.state.hand[answer - 1] - m.state.card == 1) {
                                        return new PlayCardMessage(m.request_id, m.state.hand[answer - 1]);
                                    }
                                } else {
                                    return new PlayCardMessage(m.request_id, m.state.hand[m.state.hand.length - 1]);
                                }
                            }
                        }
                    }
                    //return new OfferChallengeMessage(m.request_id);
                }
            } else if (m.request.equals("challenge_offered")) {
                return (Math.random() < 0.5)
                        ? new AcceptChallengeMessage(m.request_id)
                        : new RejectChallengeMessage(m.request_id);
            }
        } else if (message.type.equals("result")) {
            ResultMessage r = (ResultMessage) message;
            if (r.result.type.equals("game_won")) {
                newGame = true;
                return null;
            } else if (r.result.type.equals("trick_won") && r.result.by.intValue() == ((MoveMessage) message).state.player_number) {
                first = true;
            } else if (r.result.type.equals("trick_won")) {
                first = false;
            } else if (r.result.type.equals("hand_done")) {
                hands++;
                unknownAvg = ((unknownAvg * totalUnknown) + (remaining * enemyAvg)) / (totalUnknown + remaining);
                totalUnknown += remaining;
                if (hands == 10) {
                    newGame = true;
                    return null;
                }
            }
            int opCard = r.result.card;
            deck[opCard]--;
            remaining--;
            avg = deckAverage() - (unknownAvg * (totalUnknown / total));
        } else if (message.type.equals("error")) {
            ErrorMessage e = (ErrorMessage) message;
            System.err.println("Error: " + e.message);

            // need to register IP address on the contest server
            if (e.seen_host != null) {
                System.exit(1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java -jar ContestBot.jar <HOST> <PORT>");
            System.exit(1);
        }

        String host = args[0];
        Integer port = Integer.parseInt(args[1]);

        ContestBot cb = new ContestBot(host, port);
        cb.run();
    }

    private int deckAverage() {
        int average = 0;
        total = 0;

        for (int i = 0; i < 13; i++) {
            average += deck[i] * (i + 1);
            total += deck[i];
        }

        average = average / total;
        return average;
    }
}
