class Process1:
    def __init__(self, pid, priority, arrival_time, burst_time):
        self.pid = pid
        self.priority = priority
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0
        self.response_time = 0

def calculate_times(processes):
    time = 0

    for process in processes:
        if time < process.arrival_time:
            time = process.arrival_time
        
        process.completion_time = time + process.burst_time
        process.turnaround_time = process.completion_time - process.arrival_time
        process.waiting_time = process.turnaround_time - process.burst_time
        process.response_time = process.waiting_time
        time += process.burst_time

    return processes

def print_processes(processes):
    print("Process ID\tPriority\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time\tResponse Time")
    for process in processes:
        print(f"{process.pid}\t\t{process.priority}\t\t{process.arrival_time}\t\t{process.burst_time}\t\t{process.completion_time}\t\t{process.turnaround_time}\t\t{process.waiting_time}\t\t{process.response_time}")

if __name__ == "__main__":
    # List of processes with given values
    processes = [
        Process1(1, 2, 0, 3),
        Process1(2, 6, 2, 5),
        Process1(3, 3, 1, 4),
        Process1(4, 5, 4, 2),
        Process1(5, 7, 6, 9),
        Process1(6, 4, 5, 4),
        Process1(7, 10, 7, 10)
    ]

    processes.sort(key=lambda x: (x.priority, x.arrival_time))

    processes = calculate_times(processes)
    print_processes(processes)
