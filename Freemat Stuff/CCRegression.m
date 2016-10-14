%CCRegression


data = csvread('CCData.csv');

picTime = data(:,3)+((.01*data(:,4))*(1/.6));
OCCTime = data(:,5)+((.01*data(:,6))*(1/.6));
plot(picTime,OCCTime,'+')
xlabel('Pick time (minutes)')
ylabel('OCC time (minutes)')
lsq(picTime,OCCTime)