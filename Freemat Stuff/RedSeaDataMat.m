%RedSeaDataMat

clc;
clear all;
data = csvread('Red_Sea_Met_Data.csv');

for (x = 5:length(data(:, 6)))
    column6(x - 4) = data(x, 6);
end
disp(column6);

hist(real(column6));

