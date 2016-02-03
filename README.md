# RESTful API Test
===========
Requirement
===========
- Restful APIs
- Store a transaction ( PUT )
- Return the transaction ( GET )

What is in the transaction:
- Transaction Id
- Amount
- Type
- Parent Id

API 1 - PUT
PUT the transaction to the server

API 2 - GET
GET the transaction from the server

API 3 - GET
Return all of transaction id of the same type

API 4 - GET
Return a sum of all transactions which are linked by parent id to a particular transaction id


==========
Assumption
==========
- The transaction Id is unique. 
Otherwise TreeMap could not be used. 
If transaction Id is not unique, instead of attaching a JSON object as a value of TreeMap, 
they are going to be in a list of JSON objects.

==============
Implementation
==============
Within these RESTful API, TreeMaps were used to store the transactions.

TreeMap - Transaction by Id
-----------
Transaction Id, long ===>> Key
Amount, double  ========>> JSON Object attribute 1
Type, String    ========>> JSON Object attribute 2
Parent Id, long ========>> JSON Object attribute 3

TreeMap - Transaction by Type
-----------
Type, String    ===============>> Key
Transaction Id, long   ========>> JSON Object attribute 1
Amount, double  ===============>> JSON Object attribute 2
Parent Id, long ===============>> JSON Object attribute 3

APIs Specs
----------
API 1 ) 
PUT /transactionservice/transaction/$transaction_id

Parameters example - { "amount":double, "type":String, "parent_id":long }

API 2 )

GET /transactionservice/transaction/$transaction_id

Return: { "amount":double, "type":String, "parent_id":long }

API 3) 

GET /transactionservice/types/$type

Returns:
[ long, long ... ]

API 4)

GET /transactionservice/sum/$transaction_id

Returns: { "sum": double }

==========
Discussion
==========
It is desired to have a more delicate, thorough testing by randomized data. 
However, since the result of API 2 3 4 are changed by the action of API 1. It is more difficult to verify the correctness of each APIs with a large amount of data.
In this situation and such a short available time, JUnit assert test are not useful since we have to know the corret result before hand in order to verify them.


====
Test
====
Test case 1 - PUT - Response {"amount":5050,"parent_id":1001,"type":"cars"}
Test case 1 - PUT - Response {"amount":5100,"parent_id":1002,"type":"house"}
Test case 1 - PUT - Response {"amount":5150,"parent_id":1003,"type":"rent"}
Test case 1 - PUT - Response {"amount":5200,"parent_id":1004,"type":"electricity"}
Test case 1 - PUT - Response {"amount":5250,"parent_id":1005,"type":"food"}
Test case 1 - PUT - Response {"amount":5300,"parent_id":1006,"type":"transportation"}
Test case 1 - PUT - Response {"amount":5350,"parent_id":1001,"type":"clothe"}
Test case 1 - PUT - Response {"amount":5400,"parent_id":1002,"type":"cars"}
Test case 1 - PUT - Response {"amount":5450,"parent_id":1003,"type":"house"}
Test case 1 - PUT - Response {"amount":5500,"parent_id":1004,"type":"rent"}
Test case 1 - PUT - Response {"amount":5550,"parent_id":1005,"type":"electricity"}
Test case 1 - PUT - Response {"amount":5600,"parent_id":1006,"type":"food"}
Test case 1 - PUT - Response {"amount":5650,"parent_id":1001,"type":"transportation"}
Test case 1 - PUT - Response {"amount":5700,"parent_id":1002,"type":"clothe"}
Test case 1 - PUT - Response {"amount":5750,"parent_id":1003,"type":"cars"}
Test case 1 - PUT - Response {"amount":5800,"parent_id":1004,"type":"house"}
Test case 1 - PUT - Response {"amount":5850,"parent_id":1005,"type":"rent"}
Test case 1 - PUT - Response {"amount":5900,"parent_id":1006,"type":"electricity"}
Test case 1 - PUT - Response {"amount":5950,"parent_id":1001,"type":"food"}
Test case 1 - PUT - Response {"amount":6000,"parent_id":1002,"type":"transportation"}
Test case 1 - PUT - Response {"amount":6050,"parent_id":1003,"type":"clothe"}
Test case 1 - PUT - Response {"amount":6100,"parent_id":1004,"type":"cars"}
Test case 1 - PUT - Response {"amount":6150,"parent_id":1005,"type":"house"}
Test case 1 - PUT - Response {"amount":6200,"parent_id":1006,"type":"rent"}
Test case 1 - PUT - Response {"amount":6250,"parent_id":1001,"type":"electricity"}
Test case 1 - PUT - Response {"amount":6300,"parent_id":1002,"type":"food"}
Test case 1 - PUT - Response {"amount":6350,"parent_id":1003,"type":"transportation"}
Test case 1 - PUT - Response {"amount":6400,"parent_id":1004,"type":"clothe"}
Test case 1 - PUT - Response {"amount":6450,"parent_id":1005,"type":"cars"}
Test case 1 - PUT - Response {"amount":6500,"parent_id":1006,"type":"house"}
Test case 1 - PUT - Response {"amount":6550,"parent_id":1001,"type":"rent"}
Test case 1 - PUT - Response {"amount":6600,"parent_id":1002,"type":"electricity"}
Test case 1 - PUT - Response {"amount":6650,"parent_id":1003,"type":"food"}
Test case 1 - PUT - Response {"amount":6700,"parent_id":1004,"type":"transportation"}
Test case 1 - PUT - Response {"amount":6750,"parent_id":1005,"type":"clothe"}
Test case 1 - PUT - Response {"amount":6800,"parent_id":1006,"type":"cars"}
Test case 1 - PUT - Response {"amount":6850,"parent_id":1001,"type":"house"}
Test case 1 - PUT - Response {"amount":6900,"parent_id":1002,"type":"rent"}
Test case 1 - PUT - Response {"amount":6950,"parent_id":1003,"type":"electricity"}
Test case 1 - PUT - Response {"amount":7000,"parent_id":1004,"type":"food"}
Test case 1 - PUT - Response {"amount":7050,"parent_id":1005,"type":"transportation"}
Test case 1 - PUT - Response {"amount":7100,"parent_id":1006,"type":"clothe"}
Test case 1 - PUT - Response {"amount":7150,"parent_id":1001,"type":"cars"}
Test case 1 - PUT - Response {"amount":7200,"parent_id":1002,"type":"house"}
Test case 1 - PUT - Response {"amount":7250,"parent_id":1003,"type":"rent"}
Test case 1 - PUT - Response {"amount":7300,"parent_id":1004,"type":"electricity"}
Test case 1 - PUT - Response {"amount":7350,"parent_id":1005,"type":"food"}
Test case 1 - PUT - Response {"amount":7400,"parent_id":1006,"type":"transportation"}
Test case 1 - PUT - Response {"amount":7450,"parent_id":1001,"type":"clothe"}
Test case 1 - PUT - Response {"amount":7500,"parent_id":1002,"type":"cars"}
Test case 1 - PUT - Response {"amount":7550,"parent_id":1003,"type":"house"}
Test case 1 - PUT - Response {"amount":7600,"parent_id":1004,"type":"rent"}
Test case 1 - PUT - Response {"amount":7650,"parent_id":1005,"type":"electricity"}
Test case 1 - PUT - Response {"amount":7700,"parent_id":1006,"type":"food"}
Test case 1 - PUT - Response {"amount":7750,"parent_id":1001,"type":"transportation"}
Test case 1 - PUT - Response {"amount":7800,"parent_id":1002,"type":"clothe"}
Test case 1 - PUT - Response {"amount":7850,"parent_id":1003,"type":"cars"}
Test case 1 - PUT - Response {"amount":7900,"parent_id":1004,"type":"house"}
Test case 1 - PUT - Response {"amount":7950,"parent_id":1005,"type":"rent"}
Test case 1 - PUT - Response {"amount":8000,"parent_id":1006,"type":"electricity"}
Test case 1 - PUT - Response {"amount":8050,"parent_id":1001,"type":"food"}
Test case 1 - PUT - Response {"amount":8100,"parent_id":1002,"type":"transportation"}
Test case 1 - PUT - Response {"amount":8150,"parent_id":1003,"type":"clothe"}
Test case 1 - PUT - Response {"amount":8200,"parent_id":1004,"type":"cars"}
Test case 1 - PUT - Response {"amount":8250,"parent_id":1005,"type":"house"}
Test case 1 - PUT - Response {"amount":8300,"parent_id":1006,"type":"rent"}
Test case 1 - PUT - Response {"amount":8350,"parent_id":1001,"type":"electricity"}
Test case 1 - PUT - Response {"amount":8400,"parent_id":1002,"type":"food"}
Test case 1 - PUT - Response {"amount":8450,"parent_id":1003,"type":"transportation"}
Test case 1 - PUT - Response {"amount":8500,"parent_id":1004,"type":"clothe"}
Test case 1 - PUT - Response {"amount":8550,"parent_id":1005,"type":"cars"}
Test case 1 - PUT - Response {"amount":8600,"parent_id":1006,"type":"house"}
Test case 1 - PUT - Response {"amount":8650,"parent_id":1001,"type":"rent"}
Test case 1 - PUT - Response {"amount":8700,"parent_id":1002,"type":"electricity"}
Test case 1 - PUT - Response {"amount":8750,"parent_id":1003,"type":"food"}
Test case 1 - PUT - Response {"amount":8800,"parent_id":1004,"type":"transportation"}
Test case 1 - PUT - Response {"amount":8850,"parent_id":1005,"type":"clothe"}
Test case 1 - PUT - Response {"amount":8900,"parent_id":1006,"type":"cars"}
Test case 1 - PUT - Response {"amount":8950,"parent_id":1001,"type":"house"}
Test case 1 - PUT - Response {"amount":9000,"parent_id":1002,"type":"rent"}
Test case 1 - PUT - Response {"amount":9050,"parent_id":1003,"type":"electricity"}
Test case 1 - PUT - Response {"amount":9100,"parent_id":1004,"type":"food"}
Test case 1 - PUT - Response {"amount":9150,"parent_id":1005,"type":"transportation"}
Test case 1 - PUT - Response {"amount":9200,"parent_id":1006,"type":"clothe"}
Test case 1 - PUT - Response {"amount":9250,"parent_id":1001,"type":"cars"}
Test case 1 - PUT - Response {"amount":9300,"parent_id":1002,"type":"house"}
Test case 1 - PUT - Response {"amount":9350,"parent_id":1003,"type":"rent"}
Test case 1 - PUT - Response {"amount":9400,"parent_id":1004,"type":"electricity"}
Test case 1 - PUT - Response {"amount":9450,"parent_id":1005,"type":"food"}
Test case 1 - PUT - Response {"amount":9500,"parent_id":1006,"type":"transportation"}
Test case 1 - PUT - Response {"amount":9550,"parent_id":1001,"type":"clothe"}
Test case 1 - PUT - Response {"amount":9600,"parent_id":1002,"type":"cars"}
Test case 1 - PUT - Response {"amount":9650,"parent_id":1003,"type":"house"}
Test case 1 - PUT - Response {"amount":9700,"parent_id":1004,"type":"rent"}
Test case 1 - PUT - Response {"amount":9750,"parent_id":1005,"type":"electricity"}
Test case 1 - PUT - Response {"amount":9800,"parent_id":1006,"type":"food"}
Test case 1 - PUT - Response {"amount":9850,"parent_id":1001,"type":"transportation"}
Test case 1 - PUT - Response {"amount":9900,"parent_id":1002,"type":"clothe"}
Test case 1 - PUT - Response {"amount":9950,"parent_id":1003,"type":"cars"}
Test case 1 - PUT - Response {"amount":10000,"parent_id":1004,"type":"house"}

Test case 2 - GET - Response {"amount":5050,"parent_id":1001,"type":"cars"}
Test case 2 - GET - Response {"amount":5100,"parent_id":1002,"type":"house"}
Test case 2 - GET - Response {"amount":5150,"parent_id":1003,"type":"rent"}
Test case 2 - GET - Response {"amount":5200,"parent_id":1004,"type":"electricity"}
Test case 2 - GET - Response {"amount":5250,"parent_id":1005,"type":"food"}
Test case 2 - GET - Response {"amount":5300,"parent_id":1006,"type":"transportation"}
Test case 2 - GET - Response {"amount":5350,"parent_id":1001,"type":"clothe"}
Test case 2 - GET - Response {"amount":5400,"parent_id":1002,"type":"cars"}
Test case 2 - GET - Response {"amount":5450,"parent_id":1003,"type":"house"}
Test case 2 - GET - Response {"amount":5500,"parent_id":1004,"type":"rent"}
Test case 2 - GET - Response {"amount":5550,"parent_id":1005,"type":"electricity"}
Test case 2 - GET - Response {"amount":5600,"parent_id":1006,"type":"food"}
Test case 2 - GET - Response {"amount":5650,"parent_id":1001,"type":"transportation"}
Test case 2 - GET - Response {"amount":5700,"parent_id":1002,"type":"clothe"}
Test case 2 - GET - Response {"amount":5750,"parent_id":1003,"type":"cars"}
Test case 2 - GET - Response {"amount":5800,"parent_id":1004,"type":"house"}
Test case 2 - GET - Response {"amount":5850,"parent_id":1005,"type":"rent"}
Test case 2 - GET - Response {"amount":5900,"parent_id":1006,"type":"electricity"}
Test case 2 - GET - Response {"amount":5950,"parent_id":1001,"type":"food"}
Test case 2 - GET - Response {"amount":6000,"parent_id":1002,"type":"transportation"}
Test case 2 - GET - Response {"amount":6050,"parent_id":1003,"type":"clothe"}
Test case 2 - GET - Response {"amount":6100,"parent_id":1004,"type":"cars"}
Test case 2 - GET - Response {"amount":6150,"parent_id":1005,"type":"house"}
Test case 2 - GET - Response {"amount":6200,"parent_id":1006,"type":"rent"}
Test case 2 - GET - Response {"amount":6250,"parent_id":1001,"type":"electricity"}
Test case 2 - GET - Response {"amount":6300,"parent_id":1002,"type":"food"}
Test case 2 - GET - Response {"amount":6350,"parent_id":1003,"type":"transportation"}
Test case 2 - GET - Response {"amount":6400,"parent_id":1004,"type":"clothe"}
Test case 2 - GET - Response {"amount":6450,"parent_id":1005,"type":"cars"}
Test case 2 - GET - Response {"amount":6500,"parent_id":1006,"type":"house"}
Test case 2 - GET - Response {"amount":6550,"parent_id":1001,"type":"rent"}
Test case 2 - GET - Response {"amount":6600,"parent_id":1002,"type":"electricity"}
Test case 2 - GET - Response {"amount":6650,"parent_id":1003,"type":"food"}
Test case 2 - GET - Response {"amount":6700,"parent_id":1004,"type":"transportation"}
Test case 2 - GET - Response {"amount":6750,"parent_id":1005,"type":"clothe"}
Test case 2 - GET - Response {"amount":6800,"parent_id":1006,"type":"cars"}
Test case 2 - GET - Response {"amount":6850,"parent_id":1001,"type":"house"}
Test case 2 - GET - Response {"amount":6900,"parent_id":1002,"type":"rent"}
Test case 2 - GET - Response {"amount":6950,"parent_id":1003,"type":"electricity"}
Test case 2 - GET - Response {"amount":7000,"parent_id":1004,"type":"food"}
Test case 2 - GET - Response {"amount":7050,"parent_id":1005,"type":"transportation"}
Test case 2 - GET - Response {"amount":7100,"parent_id":1006,"type":"clothe"}
Test case 2 - GET - Response {"amount":7150,"parent_id":1001,"type":"cars"}
Test case 2 - GET - Response {"amount":7200,"parent_id":1002,"type":"house"}
Test case 2 - GET - Response {"amount":7250,"parent_id":1003,"type":"rent"}
Test case 2 - GET - Response {"amount":7300,"parent_id":1004,"type":"electricity"}
Test case 2 - GET - Response {"amount":7350,"parent_id":1005,"type":"food"}
Test case 2 - GET - Response {"amount":7400,"parent_id":1006,"type":"transportation"}
Test case 2 - GET - Response {"amount":7450,"parent_id":1001,"type":"clothe"}
Test case 2 - GET - Response {"amount":7500,"parent_id":1002,"type":"cars"}
Test case 2 - GET - Response {"amount":7550,"parent_id":1003,"type":"house"}
Test case 2 - GET - Response {"amount":7600,"parent_id":1004,"type":"rent"}
Test case 2 - GET - Response {"amount":7650,"parent_id":1005,"type":"electricity"}
Test case 2 - GET - Response {"amount":7700,"parent_id":1006,"type":"food"}
Test case 2 - GET - Response {"amount":7750,"parent_id":1001,"type":"transportation"}
Test case 2 - GET - Response {"amount":7800,"parent_id":1002,"type":"clothe"}
Test case 2 - GET - Response {"amount":7850,"parent_id":1003,"type":"cars"}
Test case 2 - GET - Response {"amount":7900,"parent_id":1004,"type":"house"}
Test case 2 - GET - Response {"amount":7950,"parent_id":1005,"type":"rent"}
Test case 2 - GET - Response {"amount":8000,"parent_id":1006,"type":"electricity"}
Test case 2 - GET - Response {"amount":8050,"parent_id":1001,"type":"food"}
Test case 2 - GET - Response {"amount":8100,"parent_id":1002,"type":"transportation"}
Test case 2 - GET - Response {"amount":8150,"parent_id":1003,"type":"clothe"}
Test case 2 - GET - Response {"amount":8200,"parent_id":1004,"type":"cars"}
Test case 2 - GET - Response {"amount":8250,"parent_id":1005,"type":"house"}
Test case 2 - GET - Response {"amount":8300,"parent_id":1006,"type":"rent"}
Test case 2 - GET - Response {"amount":8350,"parent_id":1001,"type":"electricity"}
Test case 2 - GET - Response {"amount":8400,"parent_id":1002,"type":"food"}
Test case 2 - GET - Response {"amount":8450,"parent_id":1003,"type":"transportation"}
Test case 2 - GET - Response {"amount":8500,"parent_id":1004,"type":"clothe"}
Test case 2 - GET - Response {"amount":8550,"parent_id":1005,"type":"cars"}
Test case 2 - GET - Response {"amount":8600,"parent_id":1006,"type":"house"}
Test case 2 - GET - Response {"amount":8650,"parent_id":1001,"type":"rent"}
Test case 2 - GET - Response {"amount":8700,"parent_id":1002,"type":"electricity"}
Test case 2 - GET - Response {"amount":8750,"parent_id":1003,"type":"food"}
Test case 2 - GET - Response {"amount":8800,"parent_id":1004,"type":"transportation"}
Test case 2 - GET - Response {"amount":8850,"parent_id":1005,"type":"clothe"}
Test case 2 - GET - Response {"amount":8900,"parent_id":1006,"type":"cars"}
Test case 2 - GET - Response {"amount":8950,"parent_id":1001,"type":"house"}
Test case 2 - GET - Response {"amount":9000,"parent_id":1002,"type":"rent"}
Test case 2 - GET - Response {"amount":9050,"parent_id":1003,"type":"electricity"}
Test case 2 - GET - Response {"amount":9100,"parent_id":1004,"type":"food"}
Test case 2 - GET - Response {"amount":9150,"parent_id":1005,"type":"transportation"}
Test case 2 - GET - Response {"amount":9200,"parent_id":1006,"type":"clothe"}
Test case 2 - GET - Response {"amount":9250,"parent_id":1001,"type":"cars"}
Test case 2 - GET - Response {"amount":9300,"parent_id":1002,"type":"house"}
Test case 2 - GET - Response {"amount":9350,"parent_id":1003,"type":"rent"}
Test case 2 - GET - Response {"amount":9400,"parent_id":1004,"type":"electricity"}
Test case 2 - GET - Response {"amount":9450,"parent_id":1005,"type":"food"}
Test case 2 - GET - Response {"amount":9500,"parent_id":1006,"type":"transportation"}
Test case 2 - GET - Response {"amount":9550,"parent_id":1001,"type":"clothe"}
Test case 2 - GET - Response {"amount":9600,"parent_id":1002,"type":"cars"}
Test case 2 - GET - Response {"amount":9650,"parent_id":1003,"type":"house"}
Test case 2 - GET - Response {"amount":9700,"parent_id":1004,"type":"rent"}
Test case 2 - GET - Response {"amount":9750,"parent_id":1005,"type":"electricity"}
Test case 2 - GET - Response {"amount":9800,"parent_id":1006,"type":"food"}
Test case 2 - GET - Response {"amount":9850,"parent_id":1001,"type":"transportation"}
Test case 2 - GET - Response {"amount":9900,"parent_id":1002,"type":"clothe"}
Test case 2 - GET - Response {"amount":9950,"parent_id":1003,"type":"cars"}
Test case 2 - GET - Response {"amount":10000,"parent_id":1004,"type":"house"}


Test case 3 - GET Type - Response [1,8,15,22,29,36,43,50,57,64,71,78,85,92,99]
Test case 3 - GET Type - Response [2,9,16,23,30,37,44,51,58,65,72,79,86,93,100]
Test case 3 - GET Type - Response [3,10,17,24,31,38,45,52,59,66,73,80,87,94]
Test case 3 - GET Type - Response [4,11,18,25,32,39,46,53,60,67,74,81,88,95]
Test case 3 - GET Type - Response [5,12,19,26,33,40,47,54,61,68,75,82,89,96]
Test case 3 - GET Type - Response [6,13,20,27,34,41,48,55,62,69,76,83,90,97]
Test case 3 - GET Type - Response [7,14,21,28,35,42,49,56,63,70,77,84,91,98]

Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}
Test case 4 - GET Sum- Response {"sum":120000}
Test case 4 - GET Sum- Response {"sum":120800}
Test case 4 - GET Sum- Response {"sum":126650}
Test case 4 - GET Sum- Response {"sum":127500}
Test case 4 - GET Sum- Response {"sum":128350}
Test case 4 - GET Sum- Response {"sum":129200}

