class Process1:
    def __init__(self, pid, priority, arrival_time, burst_time):
        self.pid = pid
        self.priority = priority
        self.arrival_time = arrival_time
        self.burst_time = burst_time
        self.remaining_time = burst_time
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0
        self.response_time = 0

def calculate_times(processes):
    # Assuming this function calculates the completion, turnaround, waiting, and response times
    # Add your scheduling algorithm here
    return processes

def print_processes(processes):
    total_waiting_time = 0
    print("Process ID\tPriority\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time\tResponse Time")
    for process in processes:
        total_waiting_time += process.waiting_time
        print(f"{process.pid}\t\t{process.priority}\t\t{process.arrival_time}\t\t{process.burst_time}\t\t{process.completion_time}\t\t{process.turnaround_time}\t\t{process.waiting_time}\t\t{process.response_time}")
    
    avg_waiting_time = total_waiting_time / len(processes)
    print(f"\nAvg Waiting Time = {total_waiting_time}/{len(processes)} = {avg_waiting_time:.2f} units")

if __name__ == "__main__":
    # User input for number of processes
    num_processes = int(input("Enter the number of processes: "))
    processes = []

    for i in range(num_processes):
        pid = i + 1
        priority = int(input(f"Enter priority for process {pid}: "))
        arrival_time = int(input(f"Enter arrival time for process {pid}: "))
        burst_time = int(input(f"Enter burst time for process {pid}: "))
        processes.append(Process1(pid, priority, arrival_time, burst_time))

    processes.sort(key=lambda x: (x.priority, x.arrival_time))

    processes = calculate_times(processes)
    print_processes(processes)