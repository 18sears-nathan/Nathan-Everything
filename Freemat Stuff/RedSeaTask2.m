load('Red_Sea_Met_Data.mat');
(Red_Sea_Met_Data);
data = Red_Sea_Met_Data;

means1 = mean(data(1:10,4:11));
means2 = mean(data(1441:1450,4:11));
means3 = mean(data(2881:2890,4:11));
final = [means1;means2;means3]