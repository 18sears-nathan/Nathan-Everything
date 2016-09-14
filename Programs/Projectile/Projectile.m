%projectile

g=9.81;   % kgm/s
y0=5;     % m
x0=0;     % m
v=20;     % m/s
alpha=30; % degrees

b = v*sin(pi*(alpha/180));
a = -g/2;
c = y0;

t1 = (-b-sqrt(b^2-4*a*c))/(2*a); %in seconds

t = linspace(0,t1,30);

range = v*cos(pi*(alpha/180))*t;

vx = v*cos(pi*(alpha/180));
vy = v*sin(pi*(alpha/180));
x = vx*t+x0;
y = -(g/2)*t.^2+vy*t+y0
plot(x,y)
axis equal
xlabel('Distance (m)')
ylabel('height (m)')





