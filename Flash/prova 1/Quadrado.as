package {
	import flash.display.*;
	import flash.events.*;
	
	public class Quadrado extends MovieClip {
		public function Quadrado()
		{
		this.x = 40;
		this.y = 10;

		var ix:int;
		var iy:int;
	
		ix = 10;
iy = 10;

this.addEventListener(Event.ENTER_FRAME,qualquer);
function qualquer(event:Event){
var tamX=530;
var tamY=380;
this.x = this.x + ix;
this.y = this.y + iy;
if (this.y>tamY)iy = iy*(-1);
if (this.y<=0)iy = iy*(-1);
if (this.x>tamX)ix = ix*(-1);
if (this.x<=0)ix = ix*(-1);
}
		}
	}
	}