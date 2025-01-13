t = int(input())

lst = [0 for i in range(10)] # n은 11보다 작은 양수

lst[0] = 1
lst[1] = 2
lst[2] = 4

for i in range(3,10):
    lst[i]=lst[i-1]+lst[i-2]+lst[i-3]
       
for i in range(t):
    n = int(input())-1
    print(lst[n])