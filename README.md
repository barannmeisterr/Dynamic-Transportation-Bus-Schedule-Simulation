# 🚇 Dynamic Transportation Bus Schedule Simulation

There are N bus stations and M buses provide service in Ankara Kızılay. Each bus s has a schedule consisting of t stations. At the beginning, each bus at their first station and each minute it travels to the next station. When it reaches the end, it goes back to the beginning and starts again. At the beginning, you are at station 1. If at any moment you and a bus are at the same station, you can get on it and travel with it. You can get off the bus at any station. The same station can appear multiple times in the itinerary of the bus, but not adjacent to each other (in particular the last station is adjacent to the first one). You are interested in finding the minimum amount of time you need to reach to each station, or state that it is impossible.
You can only travel in one bus at a time, but you can use multiple buses to reach your destination. Do not forget that you can only travel by bus. There can be multiple buses at the same station at the same time. Getting on and off a bus is instantaneous.
In the input, the first line contains 2 space separated integers, N, M. N denotes the number of stations, M denotes the number of buses respectively. Each of the next M lines contain an integer t followed by t integers which demonstrate the schedule of each bus.
In the given sample input, it is given that we have 8 stations, and 4 buses work between them in the first line. The next lines give the schedule of each bus with the number of stations it visits and which stations it visits. For example, the second bus has 3 stations 6, 1 and 2. Buses visit the stations according to the given order, so the second bus is in the 6th station at the beginning, then it goes to the 1st station and then 2nd station and returns to the 6th station. And, traveling between each station takes 1 minute, so it takes 2 minute for the second bus to go from 6th station to 2nd station.
In the output, print N-1 space separated integers denoting the minimum amount of time needed to reach each station except the 1st station because you are at the first station at the beginning. If any of the stations is not reachable with the given schedule of the buses, you need to print -1 for that station. You need to print the output in numerical order which means you need to give the amount of time for 2nd station first, then 3rd, then 4th and goes on.

Sample Input:

8 4

2 5 4

3 6 1 2

4 4 2 1 3

2 7 8

Sample Output:

2 3 4 6 3 -1 -1

## Author

- Arda Baran

## 🔧 Features
- ✅ Directed graph representation of bus transportation systems
- ✅ Dynamic station wait time and line-switching support
- ✅ Edge weights and traversal simulation
- ✅ In-degree and out-degree calculation for each station
- ✅ Line assignment and station relationship mapping
- ✅ Extendable for real-time simulation and shortest-path logic with unique Dijkstra algorithm implementation

## 🧱 Core Components

### `Station`
Represents a node in the graph:
- `stationID`: Unique identifier
- `waitingTime`: Time before next bus arrives
- `canSwitchLine`: Indicates if this is a transfer station
- Line relationships and traversal metadata

### `Line`
A circular bus line consisting of ordered stations:
- `lineID`: Unique line ID
- `stations[]`: Ordered array of stations on the route


### `Edge`
Directed connection between two stations:
- From, To stations
- Line ID and weight

### `DirectedGraph`
The main structure representing the bus transportation system:
- Adjacency list of stations and connections
- Initialization functions to set up degrees, lines, and connectivity
- Utilities to retrieve neighbors, edge weights, and all stations

### `Pair`
- Represents elements of direct connection between two stations (source,destination) within a line.
- Converts line layout to directed edges (e.g., S1 → S2 → ... → S1)

### `Dijkstra`
-Applies Dijkstra Algorithm.

### `FileHelper`
-Retrieves Stations from txt file.

## Technologies And Data Structures Used
- Java
- Directed Graph 
- HashMap supported Adjacency List
- Singly Linked List
- Dijkstra's Algorithm
- Object Oriented Programming
- Stack Singly Linked List Implementation
- BFS Traversal
- HashSet
- Priority Queue


## 🚀 Usage

You can use this project to:
- Simulate real bus transportation systems
- Analyze route structures
- Build the base for shortest path / trip planning algorithms
- Create dynamic animations of bus flows

## 📁 File Structure 
- src/: Contains the Java source code
- src/resources: Contains txt files
