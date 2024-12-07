class Process:
    def __init__(self, processID, priority, arrivalTime, burstTime):
        self.processID = processID
        self.priority = priority
        self.arrivalTime = arrivalTime
        self.burstTime = burstTime
        self.tempburstTime = burstTime
        self.responsetime = -1
        self.outtime = 0
        self.intime = -1
        self.completion_time = 0
        self.turnaround_time = 0
        self.waiting_time = 0

def insert(Heap, value, heapsize, currentTime):
    start = heapsize[0]
    Heap[heapsize[0]] = value
    if Heap[heapsize[0]].intime == -1:
        Heap[heapsize[0]].intime = currentTime[0]
    heapsize[0] += 1

    # Ordering the Heap
    while start != 0 and Heap[(start - 1) // 2].priority > Heap[start].priority:
        Heap[(start - 1) // 2], Heap[start] = Heap[start], Heap[(start - 1) // 2]
        start = (start - 1) // 2

def order(Heap, heapsize, start):
    smallest = start
    left = 2 * start + 1
    right = 2 * start + 2
    if left < heapsize[0] and Heap[left].priority < Heap[smallest].priority:
        smallest = left
    if right < heapsize[0] and Heap[right].priority < Heap[smallest].priority:
        smallest = right

    # Ordering the Heap
    if smallest != start:
        Heap[start], Heap[smallest] = Heap[smallest], Heap[start]
        order(Heap, heapsize, smallest)

def extract_minimum(Heap, heapsize, currentTime):
    min_process = Heap[0]
    if min_process.responsetime == -1:
        min_process.responsetime = currentTime[0] - min_process.arrivalTime
    heapsize[0] -= 1
    Heap[0] = Heap[heapsize[0]]
    order(Heap, heapsize, 0)
    return min_process

def scheduling(Heap, array, n, heapsize, currentTime):
    if heapsize[0] == 0:
        return

    min_process = extract_minimum(Heap, heapsize, currentTime)
    min_process.outtime = currentTime[0] + 1
    min_process.burstTime -= 1
    print(f"Process ID = {min_process.processID}, Out Time = {min_process.outtime}, Burst Time Left = {min_process.burstTime}")

    if min_process.burstTime > 0:
        insert(Heap, min_process, heapsize, currentTime)
    else:
        min_process.completion_time = min_process.outtime
        min_process.turnaround_time = min_process.completion_time - min_process.arrivalTime
        min_process.waiting_time = min_process.turnaround_time - min_process.tempburstTime

    currentTime[0] += 1

def priority(array, n):
    Heap = [None] * n
    heapsize = [0]
    currentTime = [0]
    total_response_time = 0
    total_waiting_time = 0
    total_turnaround_time = 0
    total_burst_time = 0

    while True:
        for i in range(n):
            if array[i].arrivalTime == currentTime[0]:
                insert(Heap, array[i], heapsize, currentTime)

        if heapsize[0] == 0:
            break

        scheduling(Heap, array, n, heapsize, currentTime)

    for i in range(n):
        total_response_time += array[i].responsetime
        total_waiting_time += array[i].waiting_time
        total_turnaround_time += array[i].turnaround_time
        total_burst_time += array[i].tempburstTime

    print(f"Average waiting time = {total_waiting_time / n}")
    print(f"Average response time = {total_response_time / n}")
    print(f"Average turn around time = {total_turnaround_time / n}")

    print("\nProcess ID\tPriority\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time\tResponse Time")
    for process in array:
        print(f"{process.processID}\t\t{process.priority}\t\t{process.arrivalTime}\t\t{process.tempburstTime}\t\t{process.completion_time}\t\t{process.turnaround_time}\t\t{process.waiting_time}\t\t{process.responsetime}")

# Driver code
if __name__ == "__main__":
    n = 7
    a = [
    Process(1, 2, 0, 1),
    Process(2, 6, 1, 7),
    Process(3, 3, 2, 3),
    Process(4, 5, 3, 6),
    Process(5, 4, 4, 5),
    Process(6, 10, 5, 15),
    Process(7, 9, 15, 8)
    ]
    priority(a, n)