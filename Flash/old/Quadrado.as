package {
import flash.display.MovieClip;
public class Quadrado extends MovieClip implements IComunicacao {
public function Quadrado() {
var ix:int;
var iy:int;

ix = 10;
iy = 10;

this.addEventListener(Event.ENTER_FRAME,qualquer);

function qualquer(event:Event){
var tamX=530;
var tamY=380;
q.x = q.x + ix;
q.y = q.y + iy;
if (q.y>tamY)iy = iy*(-1);
if (q.y<=0)iy = iy*(-1);
if (q.x>tamX)ix = ix*(-1);
if (q.x<=0)ix = ix*(-1);
}
}