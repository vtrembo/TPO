script src=cdnjs.cloudflare.comajaxlibsp5.js0.5.7p5.jsscript
script

let a = [20, 20];
let b = [780, 300];
let c = [20, 580];
let d = [];

function setup() 
{
    createCanvas(800, 600);
    frameRate(25);
}

function draw() 
{
    background(0);
    stroke(255);

    let m = floor(random(0, 4));
    if (m  2) {
        a[0] -= 1;
        a[1] += 1;
        b[0] -= 2;
        b[1] += 2;
        c[0] -= 3;
        c[1] += 3;
        
    } else {
        a[0] += 1;
        a[1] -= 1;
        b[0] += 1;
        b[1] -= 1;
        c[0] += 3;
        c[1] -= 3;
    }
    point(a[0], a[1]);
    point(b[0], b[1]);
    point(c[0], c[1]);
    d = a;
    for (let i = 0; i  30000; i++) 
{
        let r = floor(random(0, 3));
        switch (r) {
            case 0
                d = [(d[0] + a[0])  2, (d[1] + a[1])  2];
                break;
            case 1
                d = [(d[0] + b[0])  2, (d[1] + b[1])  2];
                break;
            default
                d = [(d[0] + c[0])  2, (d[1] + c[1])  2];
                break;
        }
        point(d[0], d[1]);
    }
    updatePixels();
}
script