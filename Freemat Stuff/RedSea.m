clear all
clc

load('Red_Sea_Met_Data.mat')
%disp(Red_Sea_Met_Data)

data = Red_Sea_Met_Data(953:60:2392,[6 9 11])
%disp(data)

disp('data: RH@ 5.5m - RH@ 3m - Net Radiation')
disp('max values:')
max(data)
disp('min values:')
min(data)
disp('average values')
mean(data)
disp('standard deviations:')
std(data)