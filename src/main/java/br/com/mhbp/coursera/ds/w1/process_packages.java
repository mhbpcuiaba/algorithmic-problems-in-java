//package br.com.mhbp.coursera.ds.w1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Request {
    public Request(int arrival_time, int process_time) {
        this.arrival_time = arrival_time;
        this.process_time = process_time;
    }

    public int arrival_time;
    public int process_time;
}

class Response {
    public Response(boolean dropped, int start_time) {
        this.dropped = dropped;
        this.start_time = start_time;
    }

    public boolean dropped;
    public int start_time;
}

class Buffer {
    public Buffer(int size) {
        this.size_ = size;
        this.finish_time_ = new LinkedList<Integer>();
        this.processing_start_time = new LinkedList<Integer>();
    }

    /*

    Input:
    12
    01
    11
    Output:
    0
    1




Raushan Jha · 5 days ago
Here in output we've to return the start processing time of that particular packet & if it's dropped then -1.

Input:
2 3
0 2
1 4
5 3

 Your output:

 0

2

 5

 Correct output:

 0

 2

 6



in this case,
Line-1: 2 3: indicate buffer size of 2 and total number of packet 3
Line-2: 0 2: indicate packate-1 reaches at time 0 milli-second(ms) and takes 2 ms to process.
Line-3: 1 4: indicate packate-2 reaches at time 1 ms and takes 4 ms to process.
Line-4: 5 3: indicate packate-3 reaches at time 5 ms and takes 3 ms to process.

So  when packate-1 start processing at time 0, after 1 ms packate-2 get queued. At this time total 2 packates are in buffer, which is the allowed limit, [input line-1, (2 3)].

When packate-1 finish processing at time 2 ms, it will get de-queued from the buffer and packet 2 will start at 3ms. Now in buffer we've only one packet at time 3ms which is packet-2.


At 5ms packet-3 will arrive and get queued. but it will wait until packate-2 finish processing, at 6 ms (=2+4 ms). After 6ms it will dequeue packet-2 from the buffer and packet-3 will start processing.

  So for packet-3, processing start time is 6ms.



     */
    public Response Process(Request request) {
        // write your code here

        while (!finish_time_.isEmpty() && finish_time_.peekFirst() <= request.arrival_time) finish_time_.remove();


        if (finish_time_.isEmpty()) {
            finish_time_.add(request.arrival_time + request.process_time);
            processing_start_time.add(request.arrival_time);
            return new Response(false, request.arrival_time);
        } else if (finish_time_.size() == size_) {
//            finish_time_.add(request.arrival_time + request.process_time);
            return new Response(true, -1);
        } else {
            Integer lastPacketFinishTime = processing_start_time.peekLast();
            Integer startProcessingTimeCurrentRequest = finish_time_.peekLast();
            finish_time_.add(finish_time_.peekLast() + request.process_time);
            processing_start_time.add(startProcessingTimeCurrentRequest);
            return new Response(false, startProcessingTimeCurrentRequest);
        }

    }

    private int size_;
    private LinkedList<Integer> finish_time_;
    private LinkedList<Integer> processing_start_time;
}

class process_packages {
    private static ArrayList<Request> ReadQueries(Scanner scanner) throws IOException {
        int requests_count = scanner.nextInt();
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < requests_count; ++i) {
            int arrival_time = scanner.nextInt();
            int process_time = scanner.nextInt();
            requests.add(new Request(arrival_time, process_time));
        }
        return requests;
    }

    private static ArrayList<Response> ProcessRequests(ArrayList<Request> requests, Buffer buffer) {
        ArrayList<Response> responses = new ArrayList<Response>();
        for (int i = 0; i < requests.size(); ++i) {
            responses.add(buffer.Process(requests.get(i)));
        }
        return responses;
    }

    private static void PrintResponses(ArrayList<Response> responses) {
        for (int i = 0; i < responses.size(); ++i) {
            Response response = responses.get(i);
            if (response.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(response.start_time);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);

        ArrayList<Request> requests = ReadQueries(scanner);
        ArrayList<Response> responses = ProcessRequests(requests, buffer);
        PrintResponses(responses);
    }
}
