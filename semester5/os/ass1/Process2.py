from queue import PriorityQueue

class Process:
    def __init__(self, pid, priority, arrival_time, burst_time):
        self.pid = pid
        self.priority = priority
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.remaining_time = burst_time
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0

def preemptive_priority_scheduling(processes):
    time = 0
    pq = PriorityQueue()
    n = len(processes)
    completed = 0
    current_index = 0

    while completed < n:
        while current_index < n and processes[current_index].arrival_time <= time:
            pq.put((processes[current_index].priority, current_index, processes[current_index]))
            current_index += 1

        if not pq.empty():
            current_process = pq.get()[2]
            print(f"Time {time}: Processing {current_process.pid}")
            time += 1
            current_process.remaining_time -= 1

            if current_process.remaining_time == 0:
                current_process.completion_time = time
                current_process.turnaround_time = current_process.completion_time - current_process.arrival_time
                current_process.waiting_time = current_process.turnaround_time - current_process.burst_time
                completed += 1
                print(f"Process {current_process.pid} completed at time {time}")
        else:
            if current_index >= n:
                break  # Break the loop if no more processes to add and queue is empty
            print(f"Time {time}: No process in queue, incrementing time")
            time += 1

    return processes

def print_processes(processes):
    print("Process ID\tPriority\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time")
    for process in processes:
        print(f"{process.pid}\t\t{process.priority}\t\t{process.arrival_time}\t\t{process.burst_time}\t\t{process.completion_time}\t\t{process.turnaround_time}\t\t{process.waiting_time}")

# Example usage
processes = [
    Process(1, 2, 0, 3),
    Process(2, 1, 1, 4),
    Process(3, 3, 2, 2),
    Process(4, 2, 3, 1)
]

scheduled_processes = preemptive_priority_scheduling(processes)
print_processes(scheduled_processes)